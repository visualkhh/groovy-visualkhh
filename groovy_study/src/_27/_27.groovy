package _27

class CustomInterceptor implements Interceptor{
	def beforeInvoke(Object object, String methodName, Object[] arguments) {		//메서드호출전
		println "beforeInvoke   object : ${object}, methodName : ${methodName}, arguments : ${arguments}"
		return null;
	}
	def afterInvoke( Object object, String methodName, Object[] arguments, Object result) {//메서드호출후
		println "afterInvoke   object : ${object}, methodName : ${methodName},  arguments : ${arguments}, result : ${result}"
		return result;
	}
	public boolean doInvoke() {
		return true;
	}
}

class Whatever1 {                            
    int outer(){
        return inner()        
    }
    int inner(){
        return 1
    }
}

def log = new StringBuffer("\n")
def tracer = new CustomInterceptor()                  //# implements Interceptor 구현한다.

def proxy = ProxyMetaClass.getInstance(Whatever1.class) //적용할 클래스를 선택한다.
proxy.interceptor = tracer								//proxy에 인텁셉터를 등록한다. (내가만든거)
proxy.use {                                            
    assert 1 == new Whatever1().outer()                 
}   
/*결과
beforeInvoke   object : class _27.Whatever1, methodName : ctor, arguments : []
afterInvoke   object : class _27.Whatever1, methodName : ctor,  arguments : [], result : _27.Whatever1@e79839
beforeInvoke   object : _27.Whatever1@e79839, methodName : outer, arguments : []
beforeInvoke   object : _27.Whatever1@e79839, methodName : inner, arguments : []
afterInvoke   object : _27.Whatever1@e79839, methodName : inner,  arguments : [], result : 1
afterInvoke   object : _27.Whatever1@e79839, methodName : outer,  arguments : [], result : 1
*/
