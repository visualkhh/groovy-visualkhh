import groovy.xml.StreamingMarkupBuilder

class BackPack {
  def account
  def key
  def slurper = new XmlSlurper()
  def builder = new StreamingMarkupBuilder()
  def methods = [
      newPage: { title, description ->
          makeRemoteCall("pages/new",
              { it.page {
                  it.title(title); it.description(description)
      }   }   )   },
      destroyPage: { pageNumber ->
          makeRemoteCall("page/${pageNumber}/destroy", "") },
      updateBody: { pageNumber, description ->
          makeRemoteCall("page/${pageNumber}/update_body",
              { it.page { it.description(description) } }) },
  ]
  def makeRemoteCall(typeOfRequest, body) {
      def url="http://${account}.backpackit.com/ws/$typeOfRequest"
      def httpConnection = new URL(url).openConnection()
      httpConnection.addRequestProperty("X-POST_DATA_FORMAT","xml")
      httpConnection.requestMethod = "POST"
      httpConnection.doOutput = true
      httpConnection.outputStream.withWriter("ASCII") {
          it << builder.bind {
              request { token key; delegate.mkp.yield body }
          }
      }
      if (httpConnection.responseCode == httpConnection.HTTP_OK) {
          return slurper.parse(httpConnection.inputStream)
      }
      def msg = "Operation failed: ${httpConnection.responseCode}"
      throw new GroovyRuntimeException(msg)
  }
  public invokeMethod(String name, params) {
      def method = methods[name]
      if(name == 'request' || name == 'token') return metaClass.invokeMethod(name, params)
      if(method) return method(*params.toList())
      println "no such method $name with params $params"
  }
}
def bp = new BackPack(account:"mittie", key:"db6540393d02583391b349d20036584a07f6e986")

def response = bp.newPage("Page Title", "Page Description")
def pageId = response.page.@id
println "created page $pageId"
response = bp.updateBody(pageId, "new Body")
println "updating body ok: ${response.@success}"
response = bp.destroyPage(pageId)
println "destroying page ok: ${response.@success}"
