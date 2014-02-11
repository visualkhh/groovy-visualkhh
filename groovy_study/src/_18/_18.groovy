package _18

import java.io.Serializable

class MyBean implements Serializable {
    def untyped
    String typed
    def item1, item2
    def assigned = 'default value'
	//���������ڰ� ������ �ڵ�������Ƽ�� ������ �ʴ´�.
}

def bean = new MyBean()
assert 'default value' == bean.getAssigned()
println bean.getAssigned();

bean.setUntyped('some value')
assert 'some value' == bean.getUntyped()
println bean.getUntyped();

bean = new MyBean(typed:'another value',untyped:'untyped---',item1:'item1---')
assert 'another value' == bean.getTyped()
assert 'untyped---' == bean.getUntyped()
assert 'item1---' == bean.getItem1()
println bean.getTyped();
println bean.getUntyped();
println bean.getItem1();

/*
���
default value
some value
another value
untyped---
item1---
*/
