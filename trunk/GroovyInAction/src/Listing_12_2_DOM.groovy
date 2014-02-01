import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Node

def fac     = DocumentBuilderFactory.newInstance()
def builder = fac.newDocumentBuilder()
def doc     = builder.parse(new FileInputStream('data/plan.xml'))
def plan    = doc.documentElement

String info(node) {
    switch (node.nodeType) {
        case Node.ELEMENT_NODE:
             return 'element: '+ node.nodeName
        case Node.ATTRIBUTE_NODE:
             return "attribute: ${node.nodeName}=${node.nodeValue}"
        case Node.TEXT_NODE:
             return 'text: '+ node.nodeValue
    }
    return 'some other type: '+ node.nodeType
}

assert 'element: plan' == info(plan)

def week =  plan.childNodes.find{'week' == it.nodeName}     //#1
assert 'element: week' == info(week)

def task =  week.childNodes.item(1)                         //#2
assert 'element: task' == info(task)

def title = task.attributes.getNamedItem('title')
assert 'attribute: title=read XML chapter' == info(title)

/* todo: the crimson parser is not doing this, but xerces does
def todo = title.childNodes.item(0)
assert 'text: read XML chapter' == info(todo)
*/