import org.cyberneko.html.parsers.SAXParser

def url = 'http://java.sun.com'

def html = new XmlSlurper(new SAXParser()).parse(url)

def bolded = html.'**'.findAll{ it.name() == 'B' }
def out = bolded.A*.text().collect{ it.trim() }
out.removeAll([''])
out[2..5].each{ println it }