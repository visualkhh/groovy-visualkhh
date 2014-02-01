class SomeClass {
    static void main (args){                        //#1 자동으로 public 접근제한자 없으므로 
        def some = new SomeClass()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()
        assert 'ho' == some.publicTypedMethod()
        combinedMethod()                            //#2 현재 클래스의 정적 메서드 호출
    }
	static void main2 (args){
		args+'before';
		args+'after';;
	}
	static main3 (args){
		args+'before';
		args+'after';;
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

SomeClass f = new SomeClass();
def main2 = f.main2('main2');
def main3 = f.main3('main3');
println "main2 return : ${main2}";
println "main3 return : ${main3}";
