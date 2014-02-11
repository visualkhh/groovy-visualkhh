package _4

class SomeClass {
    
    public    public_var='old_public_var_val'	
	String    string_var='old_string_var_val'
    def       def_var	='old_def_var_val'//필드를 정의할 때 접근 제한자를 지정하지 않으면 이름에 맞는 ‘프로퍼티’가 만들어진다.(geter,seter)
    static    static_var='old_static_var_val'
    protected protected_var1, protected_var2, protected_var3
    private   assignedField = new Date()
    public static final String CONSTA = 'a', CONSTB = 'b'
	
	def notVar_GetCallCount=0;
	def notVar_SetCallCount=0;
	
	Object get (String name) {
		notVar_GetCallCount++;
		println "get : ${name}";
		return 'pretend value'
	}
	void set (String name, Object value) {
		notVar_SetCallCount++
		println "set  name : ${name},   value : ${value}";
	}

}
	SomeClass somclass = new SomeClass();
	println 'b_somclass.public_var : '+somclass.public_var;
	println 'b_somclass.string_var : '+somclass.string_var;
	println 'b_somclass.def_var : '+somclass.def_var;
	println 'b_somclass.not_var: '+somclass.not_var;
	
	println '';
	somclass.public_var = 'new_public_var_val';
	somclass.string_var = 'new_string_var_val';
	somclass.def_var = 'new_def_var_val';
	somclass.not_var = 'new_not_var_val';
	println '';
	
	
	println 'a_somclass.public_var : '+somclass.public_var;
	println 'a_somclass.string_var : '+somclass.string_var;
	println 'a_somclass.def_var : '+somclass.def_var;
	println 'a_somclass.not_var : '+somclass.not_var;
	
	
	println '';
	println 'somclass.notVar_GetCallCount   :   ' + somclass.notVar_GetCallCount;
	println 'somclass.notVar_SetCallCount   :   ' + somclass.notVar_SetCallCount;
	   
	/* 결과
		b_somclass.public_var : old_public_var_val
		b_somclass.string_var : old_string_var_val
		b_somclass.def_var : old_def_var_val
		get : not_var
		b_somclass.not_var: pretend value
		
		set  name : not_var,   value : new_not_var_val
		
		a_somclass.public_var : new_public_var_val
		a_somclass.string_var : new_string_var_val
		a_somclass.def_var : new_def_var_val
		get : not_var
		a_somclass.not_var : pretend value
		
		somclass.notVar_GetCallCount   :   2
		somclass.notVar_SetCallCount   :   1

	*/

