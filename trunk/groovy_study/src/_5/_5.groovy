package _5

class SomeClass {
    static void main (args){                        //#1 �ڵ����� public ���������� �����Ƿ�  �ڹ� ���θ޼��尡 �ȴ�.
	println "call main"
        def some = new SomeClass()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()//true
        assert 'ho' == some.publicTypedMethod()//true
          combinedMethod()                            //#2 ���� Ŭ������ ���� �޼��� ȣ�� 
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

//println '-----';  //�̺κ� �ּ��� Ǯ�ԵǸ�  ��Ŭ���ô� Script�� ��ӹްԵȴ� ���� run�޼��带 �����Ű�Եȴ�. 
/* ���
call main
*/