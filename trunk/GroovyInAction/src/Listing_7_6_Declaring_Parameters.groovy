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