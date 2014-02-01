def engine   = new groovy.text.SimpleTemplateEngine()
def source   = getClass().classLoader.
                          getResource('/Number.template.html')
def template = engine.createTemplate(source)

out << template.make(goal:50, guess:49)