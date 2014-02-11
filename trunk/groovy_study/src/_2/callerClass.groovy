package _2

import _2.sub.GClass;
GClass g = new GClass();
println "${g.private_var.class}    :    ${g.private_var}";
println "${g.public_var.class}    :    ${g.public_var}";//자바에서는 이것만 허용이 될것이다.
println "${g.protected_var.class}    :    ${g.protected_var}";
println "${g.def_var.class}    :    ${g.def_var}";
/*
결과
class java.lang.String    :    private_var
class java.lang.String    :    public_var
class java.lang.String    :    protected_var
class java.lang.String    :    def_var
*/

/*  자바는 에러남
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
		System.out.println( g.private_var);		//에러
		System.out.println( g.public_var);		//오케
		System.out.println( g.protected_var);	//에러
		System.out.println( g.def_var);			//에러

ㄴ	}
}
*/