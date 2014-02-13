package _C4

class C_4{
	def g1=044;
}


//is
def c1 = new  Date(1);
def c2 = new  Date(2);
def c3 = new  Date(2);
def c4 = c3;
println 'c1==c2 : '+(c1==c2)
println 'c2==c3 : '+(c2==c3)
println 'c3==c4 : '+(c3==c4)
println 'c3.is(c2) : '+(c3.is(c2))



//객체를 그 클로저의 수신자로 사용한다.
new Date().identity{
	println "$date.$month.$year"
}
new C_4().identity{
	println "$g1"
}

printf('hi %s   age : %d','hhk',29);

println ''
//sleep
def text = 'show me the money';
for ( c in text){
	sleep(100);
	print c;
}


println ''
//객체 되풀이 메서드
def list=[1,2,3,4,5,6,7,8,0];
list.each {
	print it+' ';
 }

/*
결과
c1==c2 : false
c2==c3 : true
c3==c4 : true
c3.is(c2) : false
13.1.114
36
hi hhk   age : 29
show me the money
1 2 3 4 5 6 7 8 0 
*/
