package _1

class SomeClass {
    
    public    public_var='old_public_var_val'	
	String    string_var='old_string_var_val'
    def       def_var	='old_def_var_val'//필드를 정의할 때 접근 제한자를 지정하지 않으면 이름에 맞는 ‘프로퍼티’가 만들어진다.(geter,seter)
    static    static_var='old_static_var_val'
    protected protected_var1, protected_var2, protected_var3
    private   assignedField = new Date()
    public static final String CONSTA = 'a', CONSTB = 'b'
	
//	//public_var properties
//	public def getPublic_var() {
//		println 'call getPublic_var()'
//		return this.public_var;
//	}
//	public void setPublic_var(def value) {
//		println 'call setPublic_var(def value)'
//		this.public_var = value;
//	}
//	
//	//string_var properties
//	public def getString_var() {
//		println 'call getString_var()'
//		return this.string_var;
//	}
//	public void setString_var(def value) {
//		println 'call setString_var(def value)'
//		this.string_var = value;
//	}
//	
//	//def_var properties
//	public def getDef_var() {
//		println 'call getDef_var()'
//		return this.def_var;
//	}
//	public void setDef_var(def value) {
//		println 'call setDef_var(def value)'
//		this.def_var = value;
//	}
}
	SomeClass somclass = new SomeClass();
	println 'b_somclass.public_var : '+somclass.public_var;
	println 'b_somclass.string_var : '+somclass.string_var;
	println 'b_somclass.def_var : '+somclass.def_var;
	
	println '';
	somclass.public_var = 'new_public_var_val';
	somclass.string_var = 'new_string_var_val';
	somclass.def_var = 'new_def_var_val';
	println '';
	
	
	println 'a_somclass.public_var : '+somclass.public_var;
	println 'a_somclass.string_var : '+somclass.string_var;
	println 'a_somclass.def_var : '+somclass.def_var;
	
	
	println '';
	println SomeClass.class.methods.name.grep(~/[get].*/);//get으로 시작하는 메서드이름가져와보자
	println SomeClass.class.methods.name.grep(~/[set].*/);//set으로 시작하는 메서드이름가져와보자
	   
	/* 결과
		b_somclass.public_var : old_public_var_val
		b_somclass.string_var : old_string_var_val
		b_somclass.def_var : old_def_var_val
		
		
		a_somclass.public_var : new_public_var_val
		a_somclass.string_var : new_string_var_val
		a_somclass.def_var : new_def_var_val
		
		[getMetaClass, this$dist$invoke$2, this$dist$set$2, this$dist$get$2, getString_var, getDef_var, getStatic_var, getProperty, equals, toString, getClass]
		[setMetaClass, this$dist$invoke$2, this$dist$set$2, this$dist$get$2, super$1$wait, super$1$wait, super$1$wait, super$1$toString, super$1$notify, super$1$notifyAll, super$1$getClass, super$1$equals, super$1$clone, super$1$hashCode, super$1$finalize, setString_var, setDef_var, setStatic_var, setProperty, equals, toString]
	*/

