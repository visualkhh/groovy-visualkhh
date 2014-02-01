import com.gargoylesoftware.htmlunit.WebClient

def client = new WebClient()
def page   = client.getPage('http://www.google.com')
def input  = page.forms[0].getInputByName('q')
input.valueAttribute = 'Groovy'
page       = page.forms[0].submit()

def hits   = page.anchors.grep { it.classAttribute == 'l' } [0..2]
hits.each  { println it.hrefAttribute.padRight(30) + ' : ' +
             it.asText() }