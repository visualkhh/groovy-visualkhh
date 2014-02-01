def plan = new XmlParser().parse(new File('data/plan.xml'))

assert 'plan' == plan.name()
assert 'week' == plan.week[0].name()
assert 'task' == plan.week[0].task[0].name()
assert 'read XML chapter' == plan.week[0].task[0].'@title'