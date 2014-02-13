package _C2
class MyClass {
    def first = 1                   // read-write property
    def getSecond() { first * 2 }   // read-only  property
    public third = 3                // public field property
	private private_val='private_val';
    protected protected_val='protected_val';
    final protected final_protected_val='final_protected_val';
    static String static_string_val='static_string_val';
	
	public def getFirst() {
		println '      call getFirest';
		return first;
	}
	public def getAt(String name){	//getAt�� �������̵��ϸ� �迭����,getAt�� ȣ���ϸ� �̰��� Ÿ��  �̸޼��尡 ������ ������Ƽ �����Ѵ�
		println '      call getAt  name:'+name	
		return this."$name"
//		return this.@"$name"
	}
	
	
	public void setFirst(def value){
		println '      call setFirest value:'+value;
		this.@first = value;
	}
	public void putAt(String name,def value){	//putAt �������̵��ϸ� �迭����,putAt ȣ���ϸ� �̰��� Ÿ��  �̸޼��尡 ������ ������Ƽ �����Ѵ�
		println '      call putAt  name:'+name+'   value:'+value
		this.@"$name"=value;
	}
}

obj = new MyClass()


println 'obj.properties  : '+obj.properties
println 'obj.properties[\'first\'] : ' + obj.properties['first']
println 'obj.properties.first    : ' + obj.properties.first
println 'obj.first               : ' + obj.first
println 'obj[\'first\']            : ' + obj['first']
println 'obj.getAt(\'first\')            : ' + obj.getAt('first')

println '----------';
one = 'first'
two = 'second'
obj[one] = obj[two]         // putAt(one)       //#3
obj.putAt(one,'first2');
obj[one] = 'second--';

println '----------';
println obj.dump();	//�ʵ� ������ static �Ⱥ��δ�.
//assert obj.dump() =~ 'first=2'                  //#4

println '----------';

/*���
      call getFirest
obj.properties  : [class:class _C2.MyClass, first:1, second:2, static_string_val:static_string_val, metaClass:org.codehaus.groovy.runtime.HandleMetaClass@90832e[groovy.lang.MetaClassImpl@90832e[class _C2.MyClass]]]
      call getFirest
obj.properties['first'] : 1
      call getFirest
obj.properties.first    : 1
      call getFirest
obj.first               : 1
      call getAt  name:first
      call getFirest
obj['first']            : 1
      call getAt  name:first
      call getFirest
obj.getAt('first')            : 1
----------
      call getAt  name:second
      call putAt  name:first   value:2
      call putAt  name:first   value:first2
      call putAt  name:first   value:second--
----------
<_C2.MyClass@149eb9f first=second-- third=3 private_val=private_val protected_val=protected_val final_protected_val=final_protected_val>
_C2.MyClass@149eb9f

*/