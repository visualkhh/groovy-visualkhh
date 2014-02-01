import org.codehaus.groovy.runtime.StringBufferWriter
import org.codehaus.groovy.runtime.InvokerHelper

class Traceable implements GroovyInterceptable {                //#1
    
    Writer writer = new PrintWriter(System.out)                 //#2
    private int indent = 0
    
    Object invokeMethod(String name, Object args){              //#3
        writer.write("\n" + '  '*indent + "before method '$name'")
        writer.flush()
        indent++
        def metaClass = InvokerHelper.getMetaClass(this)        //|#4
        def result = metaClass.invokeMethod(this, name, args)   //|#4
        indent--
        writer.write("\n" + '  '*indent + "after  method '$name'")
        writer.flush()
        return result
    }      
}  
class Whatever extends Traceable {                              //#5
    int outer(){
        return inner()        
    }
    int inner(){
        return 1
    }
}

def log = new StringBuffer()
def traceMe = new Whatever(writer: new StringBufferWriter(log)) //#6

assert 1 == traceMe.outer()                                     //#7

assert log.toString() == """
before method 'outer'
  before method 'inner'
  after  method 'inner'
after  method 'outer'"""