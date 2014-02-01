import org.codehaus.groovy.runtime.StringBufferWriter

class Whatever {                            
    int outer(){
        return inner()        
    }
    int inner(){
        return 1
    }
}

def log = new StringBuffer("\n")
def tracer = new TracingInterceptor()                  //#1
tracer.writer = new StringBufferWriter(log)
def proxy = ProxyMetaClass.getInstance(Whatever.class) //#2
proxy.interceptor = tracer
proxy.use {                                            //#3
    assert 1 == new Whatever().outer()                 //#4
}                                  
                                 
assert log.toString() == """
before Whatever.ctor()
after  Whatever.ctor()
before Whatever.outer()
  before Whatever.inner()
  after  Whatever.inner()
after  Whatever.outer()
"""


