class SomeClass {
    
    public    fieldWithModifier
    static    classField
    def       untypedField
    protected field1, field2, field3
    String    typedField
    private   assignedField = new Date()
    
    
    public static final String CONSTA = 'a', CONSTB = 'b'
    
    def someMethod(){
        def localUntypedMethodVar = 1
        int localTypedMethodVar = 1
        def localVarWithoutAssignment, andAnotherOne        
    }
	
}

def somclass = new SomeClass();
somclass.setUntypedField ('1');
SomeClass.classField ='f';
somclass.fieldWithModifier='ff';



def localvar = 1           //|#1
boundvar1 = 1              //|#1
                           //|#1
def someMethod(){          //|#1
    localMethodVar = 1     //|#1
    boundvar2 = 1          //|#1
}                          //|#1
