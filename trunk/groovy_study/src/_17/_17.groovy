package _17

class Equalizer {
    boolean equals(Equalizer e){ //�̰� equals�� �������̵� �Ȱ��� �ƴ϶�.  �����ε��Ȱ��̴�.
    	println 'equals Equalizer : '+e.class
        return true
    }
//	boolean equals(e){ //�̰� equals�� �������̵� �Ȱ��� �ƴ϶�.  �����ε��Ȱ��̴�.
//		println 'equals Object : '+e.class
//		return true
//	}
}

Object same  = new Equalizer()			
Object other = new Object()
//���� ��ü�� Object�� �޾Ҵ�.

assert   new Equalizer().equals( same  ) //Equalizer���� ������ equals�� ����. //�׷��� �ڵ����� Ŭ��������� ã�Ƽ�����
assert ! new Equalizer().equals( other ) // Object�� equals �޼��带 ȣ���Ѵ�. //�׷��� �ڵ����� Ŭ��������� ã�Ƽ�����

/*���
equals Equalizer : class _17.Equalizer
*/


//�ڹ�
/*
import GG;
import java.util.Date;


class GG{
	
	public boolean equals(String obj) {
		System.out.println("equals String");
		return true;
	}
}

public class TestJava {
	public static void main(String[] args) {
		GG g = new GG();
		
		Object s = new String("---");
		Object d = new Date(0);
		
		System.out.println( g.equals(s) );
		System.out.println( g.equals(d) );
		
		
		System.out.println( g.equals((String)s) );
	}
}

*/
/*���
false
false
equals String
true
 */