import groovy.text.SimpleTemplateEngine as STE
import groovy.xml.Namespace

def file     = new File('data/conv.templ.xml')
def template = new STE().createTemplate(file)

def params   = [from:'USD', tofil:'EUR']
def request  = template.make(params).toString().getBytes('UTF-8')

def url  = 'http://www.webservicex.net/CurrencyConvertor.asmx'
def conn = new URL(url).openConnection()
def reqProps = [
    'Content-Type': 'text/xml; charset=UTF-8',
    'SOAPAction'  : 'http://www.webserviceX.NET/ConversionRate',
    'Accept'      : 'application/soap+xml, text/*'
]
reqProps.each { key,value -> conn.addRequestProperty(key,value) }

conn.requestMethod = 'POST'
conn.doOutput      = true
conn.outputStream << new ByteArrayInputStream(request)
if (conn.responseCode != conn.HTTP_OK) {
   println "Error - HTTP:${conn.responseCode}"
   return
}

def resp   = new XmlParser().parse(conn.inputStream)

def serv   = new Namespace('http://www.webserviceX.NET/')
def result = serv.ConversionRateResult

print   "Current USD to EUR conversion rate: "
println resp.depthFirst().find{result == it.name()}.text()