class SomeClass {
    
    public    fieldWithModifier
    static    classField
    def       untypedField//필드를 정의할 때 접근 제한자를 지정하지 않으면 이름에 맞는 ‘프로퍼티’가 만들어진다.(geter,seter)
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
println SomeClass.class.methods.name.grep(~/[get|set].*/);//get으로 시작하는 메서드이름가져와보자

SomeClass.classField ='f';
somclass.fieldWithModifier='ff';



def localvar = 1           //|#1
boundvar1 = 1              //|#1
                           //|#1
def someMethod(){          //|#1
    localMethodVar = 1     //|#1
    boundvar2 = 1          //|#1
}                          //|#1
