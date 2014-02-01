import groovy.text.GStringTemplateEngine
import groovy.xml.StreamingMarkupBuilder

def e = new GStringTemplateEngine()
def t = e.createTemplate ('''
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
  <%=body%>
  $body
</Envelope>
''')

def b = new StreamingMarkupBuilder()
def m = b. bind {
  Body {
    for (i in 1..100) {
      count(i)
    }
  }
}
println m instanceof Writable
println t.make([body:m])


