def map = [a:[b:[c:1]]]           

assert map.a.b.c == 1		//일반적인접근

if (map && map.a && map.a.x){           //#1            평가단축기법
	assert false;
    assert map.a.x.c == null
}    
            
//널포인트 발생에따른 예외처리를 해줘야한다.. 일반적인처리..  a안에는x가 없으니..
try {
    assert map.a.x.c == null
} catch (NullPointerException npe){     //#2
	println "NullPointerException : ${npe}"
}
 
//안전하게 참조하는  ? 연산자를 제공한다 이연산자는 앞에 있는 참조 변수가 null이면 현재 해석중인 표현식을 중지하고 null리턴한다.
assert map?.a?.x?.c == null             //#3