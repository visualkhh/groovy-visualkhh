import javax.xml.parsers.SAXParserFactory
import org.xml.sax.*
import org.xml.sax.helpers.DefaultHandler

class PlanHandler extends DefaultHandler {                  //#1
    def underway = []
    def upcoming = []
    void startElement(String namespace, String localName,
            String qName, Attributes atts) {                //#2
        if (qName != 'task') return                         //#3
        def title = atts.getValue('title')
        def total = atts.getValue('total')
        switch (atts.getValue('done')) {
            case '0'             : upcoming << title ; break
            case { it != total } : underway << title ; break
        }
    }
}

def handler = new PlanHandler()
def reader = SAXParserFactory.newInstance()
      .newSAXParser().xMLReader                              //#4
reader.setContentHandler(handler)
def inputStream = new FileInputStream('data/plan.xml')
reader.parse(new InputSource(inputStream))
inputStream.close()

assert handler.underway == [
    'use in current project'
]
assert handler.upcoming == [
    're-read DB chapter',
    'use DB/XML combination'
]