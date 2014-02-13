package _C1

newline = "\n"

println 'newline.toString();  : ' + newline.toString();	
println 'newline.dump();      : ' + newline.dump();		//객체의 생태 즉 필드들의 이름과 값을 리턴한다.
println 'newline.inspect();   : ' + newline.inspect();	//최대한 소스코드와비슷한 형태로 리턴

println '';
class C1_1{
	def def_val=1;
	String string_val=1;
	public public_val=1;
	private private_val=1;
}
C1_1 c = new C1_1();
println C1_1.dump();			//객체의 생태 즉 필드들의 이름과 값을 리턴한다.
println C1_1.inspect();
println C1_1.toString();
println ''
println c.dump();				//객체의 생태 즉 필드들의 이름과 값을 리턴한다.
println c.inspect();
println c.toString();

//////프로퍼티 접근////////
println ''
println c.properties;


/*결과
newline.toString();  : 

newline.dump();      : <java.lang.String@a value=
 offset=0 count=1 hash=10>
newline.inspect();   : "\n"

<java.lang.Class@ae533a cachedConstructor=null newInstanceCallerCache=null name=_C1.C1_1 declaredFields=java.lang.ref.SoftReference@1cef4f7 publicFields=null declaredMethods=java.lang.ref.SoftReference@349471 publicMethods=java.lang.ref.SoftReference@1fdadcd declaredConstructors=java.lang.ref.SoftReference@19d75ee publicConstructors=null declaredPublicFields=null declaredPublicMethods=java.lang.ref.SoftReference@a98932 classRedefinedCount=0 lastRedefinedCount=0 genericInfo=null enumConstants=null enumConstantDirectory=null annotations=null declaredAnnotations=null annotationType=null>
class _C1.C1_1
class _C1.C1_1

<_C1.C1_1@7eb366 def_val=1 string_val=1 public_val=1 private_val=1>
_C1.C1_1@7eb366
_C1.C1_1@7eb366

[class:class _C1.C1_1, string_val:1, def_val:1, metaClass:org.codehaus.groovy.runtime.HandleMetaClass@941db6[groovy.lang.MetaClassImpl@941db6[class _C1.C1_1]]]

*/