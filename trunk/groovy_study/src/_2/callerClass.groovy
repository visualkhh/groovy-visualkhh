package _2

import _2.sub.GClass;
GClass g = new GClass();
println "${g.private_var.class}    :    ${g.private_var}";
println "${g.public_var.class}    :    ${g.public_var}";//�ڹٿ����� �̰͸� ����� �ɰ��̴�.
println "${g.protected_var.class}    :    ${g.protected_var}";
println "${g.def_var.class}    :    ${g.def_var}";
/*
���
class java.lang.String    :    private_var
class java.lang.String    :    public_var
class java.lang.String    :    protected_var
class java.lang.String    :    def_var
*/

/*  �ڹٴ� ������
package khh.java;
public class GClass {
	private	String private_var="private_var";
	public String public_var="public_var";
	protected String protected_var="protected_var";
	String def_var ="def_var";
}
--------------------
import khh.java.GClass;
public class Test {
	public static void main(String[] args) {
		GClass g = new GClass();
		System.out.println( g.private_var);		//����
		System.out.println( g.public_var);		//����
		System.out.println( g.protected_var);	//����
		System.out.println( g.def_var);			//����

��	}
}
*/