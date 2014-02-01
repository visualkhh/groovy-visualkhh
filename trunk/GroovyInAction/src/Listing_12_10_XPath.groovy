// requires xalan.jar, xml-apis.jar
import org.apache.xpath.XPathAPI
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

def doc  = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement

def out = new StringBuffer()
use(DOMCategory) {                                                //#1
    XPathAPI.selectNodeList(plan, 'week').eachWithIndex{ week, i -> //#2
        out << "\nWeek No. $i\n"
        int total = XPathAPI.eval(week, 'sum(task/@total)').num() //|#3
        int done  = XPathAPI.eval(week, 'sum(task/@done)').num()  //|#3
        out << " planned $total of ${week.'@capacity'}\n"         //|#4
        out << " done    $done of $total"
    }
}
assert out.toString() == '''
Week No. 0
 planned 7 of 8
 done    6 of 7
Week No. 1
 planned 4 of 8
 done    0 of 4'''