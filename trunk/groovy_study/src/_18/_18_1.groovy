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

//������Ƽ ������ final�� ���̸� �б������� �ȴ�
