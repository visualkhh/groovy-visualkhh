import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

def doc  = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement

use(DOMCategory){
    assert 'plan' == plan.nodeName
    assert 'week' == plan[1].nodeName
    assert 'week' == plan.week.nodeName
    assert '8'    == plan[1].'@capacity'
}