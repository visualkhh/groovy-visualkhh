package _26


import org.codehaus.groovy.runtime.StringBufferWriter
import org.codehaus.groovy.runtime.InvokerHelper

class Traceable implements GroovyInterceptable{                //#1
    
    private int indent = 0
    
    Object invokeMethod(String name, Object args){              //#3
        System.out.println ("\n" + '  '*indent + "before methodName : '$name'")
        indent++
        def metaClass = InvokerHelper.getMetaClass(this)        //|#4
        def result = metaClass.invokeMethod(this, name, args)   //|#4
        indent--
        System.out.println ("\n" + '  '*indent + "after  methodName : '$name',  reuslt : $result ")
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

def traceMe = new Whatever() //#6

println 'traceMe.outer() :  '+traceMe.outer();

/*°á°ú

before methodName : 'outer'

  before methodName : 'inner'

  after  methodName : 'inner',  reuslt : 1 

after  methodName : 'outer',  reuslt : 1 
traceMe.outer() :  1
*/