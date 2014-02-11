package _6

class SomeClass {    
    static void main (args){  
        assert 'untyped' == method(1)                   
        assert 'typed'   == method('whatever')        
        assert 'two args'== method(1,2)
		println  method(1)                 
		println  method('whatever')        
		println  method(1,2)               
        println  method(1,2,3)               
    }    
    static method(arg) {        
        return 'untyped'       
    }
    static method(String arg){     
        return 'typed'  
    }
    static method(arg1, Number arg2){     
        return 'two args'  
    }
     def method(arg1,arg2,arg3){     
    	return 'boolean args'  
    }
}
/*
°á°ú
untyped
typed
two args
Caught: groovy.lang.MissingMethodException: No signature of method: static _6.SomeClass.method() is applicable for argument types: (java.lang.Integer, java.lang.Integer, java.lang.Integer) values: [1, 2, 3]
Possible solutions: method(java.lang.Object), method(java.lang.String), method(java.lang.Object, java.lang.Number), method(java.lang.Object, java.lang.Object, java.lang.Object)
	at _6.SomeClass.main(_6.groovy:11)

*/