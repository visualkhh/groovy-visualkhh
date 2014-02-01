class SomeClass {
    
    static void main (args){                        //#1
        def some = new SomeClass()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()
        assert 'ho' == some.publicTypedMethod()
        combinedMethod()                            //#2
    }
    
    void publicVoidMethod(){
    }
    
    def publicUntypedMethod(){
        return 'hi'    
    } 
    String publicTypedMethod() {        
        return 'ho'       
    }
    
    protected static final void combinedMethod(){
    }    
}