package _18
import java.io.Serializable

class MyBean implements Serializable {
    final def untyped='untyped'
}

def bean = new MyBean()
assert 'untyped' == bean.getUntyped()
println bean['untyped']
bean['untyped']='tttttttttt'; //error
bean.setUntyped('----------untyped');//error

//프로퍼티 변수에 final을 붙이면 읽기전용이 된다
