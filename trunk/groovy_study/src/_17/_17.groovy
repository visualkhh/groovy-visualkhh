package _17

class Equalizer {
    boolean equals(Equalizer e){ //이건 equals의 오버라이딩 된것이 아니라.  오버로딩된것이다.
    	println 'equals Equalizer : '+e.class
        return true
    }
//	boolean equals(e){ //이건 equals의 오버라이딩 된것이 아니라.  오버로딩된것이다.
//		println 'equals Object : '+e.class
//		return true
//	}
}

Object same  = new Equalizer()			
Object other = new Object()
//여기 객체를 Object로 받았다.

assert   new Equalizer().equals( same  ) //Equalizer에서 정의한 equals로 간다. //그루비는 자동으로 클레스형대로 찾아서간다
assert ! new Equalizer().equals( other ) // Object의 equals 메서드를 호출한다. //그루비는 자동으로 클레스형대로 찾아서간다

/*결과
equals Equalizer : class _17.Equalizer
*/


//자바
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
/*결과
false
false
equals String
true
 */