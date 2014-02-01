def node = new XmlParser().parse(new File('data/plan.xml'))
def path = new XmlSlurper().parse(new File('data/plan.xml'))

assert 'plan' == node.name()
assert 'plan' == path.name()

assert 2 == node.children().size()
assert 2 == path.children().size()

assert 5 == node.week.task.size()                       //|#1
assert 5 == path.week.task.size()                       //|#1

assert 6 == node.week.task.'@done'*.toInteger().sum()   //#2

assert path.week[1].task.every{ it.'@done' == '0' }     //#3