package _3

class SomeClass {
    
    public    public_var='old_public_var_val'	
	String    string_var='old_string_var_val'
    def       def_var	='old_def_var_val'//�ʵ带 ������ �� ���� �����ڸ� �������� ������ �̸��� �´� ��������Ƽ���� ���������.(geter,seter)
    static    static_var='old_static_var_val'
    protected protected_var1, protected_var2, protected_var3
    private   assignedField = new Date()
    public static final String CONSTA = 'a', CONSTB = 'b'
	

}
	SomeClass somclass = new SomeClass();
	println 'b_somclass.public_var : '+somclass['public_var'];
	println 'b_somclass.string_var : '+somclass['string_var'];
	println 'b_somclass.def_var : '+somclass['def_var'];
	
	println '';
	somclass['public_var'] = 'new_public_var_val';
	somclass['string_var'] = 'new_string_var_val';
	somclass['def_var'] = 'new_def_var_val';
	println '';
	
	
	println 'a_somclass.public_var : '+somclass['public_var'];
	println 'a_somclass.string_var : '+somclass['string_var'];
	println 'a_somclass.def_var : '+somclass['def_var'];
	
	
	println '';
	/* ���
	b_somclass.public_var : old_public_var_val
	b_somclass.string_var : old_string_var_val
	b_somclass.def_var : old_def_var_val
	
	
	a_somclass.public_var : new_public_var_val
	a_somclass.string_var : new_string_var_val
	a_somclass.def_var : new_def_var_val
	*/
