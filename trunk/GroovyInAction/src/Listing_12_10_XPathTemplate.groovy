/* todo: re-enable after issue resolved by Jochen
import org.apache.xpath.XPathAPI
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory
import groovy.text.SimpleTemplateEngine as STE

def doc  = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement

def binding = [scale:1, weeks:[] ]
use(DOMCategory) {
  XPathAPI.selectNodeList(plan, 'week').each{ week ->    //#1 
    binding.weeks <<  [
      total:    (int) XPathAPI.eval(week, 'sum(task/@total)').num(),
      done:     (int) XPathAPI.eval(week, 'sum(task/@done)').num(),
      capacity: week.'@capacity'.toInteger()
    ]
  }
}
def max = binding.weeks.capacity.max()                  //#2
if (max > 0) binding.scale = 200.intdiv(max)

def templateFile = new File('data/GroovyPlans.template.html')
def template     = new STE().createTemplate(templateFile) //#3

new File('data/XPathGroovyPlans.html').withWriter {
    it << template.make(binding)                        
}
*/