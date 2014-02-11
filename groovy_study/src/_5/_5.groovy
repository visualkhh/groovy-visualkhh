package _5

class SomeClass {
    static void main (args){                        //#1 자동으로 public 접근제한자 없으므로  자바 메인메서드가 된다.
	println "call main"
        def some = new SomeClass()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()//true
        assert 'ho' == some.publicTypedMethod()//true
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

//println '-----';  //이부분 주석을 풀게되면  이클래시는 Script를 상속받게된다 따라서 run메서드를 실행시키게된다. 
/* 결과
call main
*/