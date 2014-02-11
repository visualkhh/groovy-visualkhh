package _23

def getList(){
	return [1,2,3,4]
}

def sum(a,b,c,d){
	return a+b+c+d;
}
println 'this.list;           : ' + this.list;
println 'getProperty (\'list\') : ' + getProperty ('list'); 

println 'sum(*list)  : '+  sum(*list)
println 'sum(list)   : '+  sum(list) 
println '-------------' 
println 'list       : '+(list);
println '[*list]       : ' + [*list];	//여기서 확산연산자의 기능을 확인해볼수있다. 오리지널 값이 그대로 .값이들어간다.
println '[]+list       : '+([]+list);	//뒤쪽에+연산이 들어가는건  list를 처리한 값을 앞쪽 리스트에 넣겠다는소리다. 즉 확산연산자랑 같은 일을한다. 
println '[list]       : ' + [list];		//그자체가들어간다/ 
assert 10==sum(*list); 
assert 10==sum(list);
assert 11==sum([2,2,3,4]);
assert 12==sum(3,2,3,4);


println '-------------' 
def range=(1..3);
assert [0,1,2,3] ==[0,*range];
assert [0,1,2,3] ==[0]+range;
assert [0,1,2,3] ==[0,range].flatten();
println '[0,*range];            :  '+([0,*range]);        //확산연산자의 연산된값 즉 오리지널 
println '[0,range]              :  '+[0,range];
println '[0]+range;             :  '+([0]+range);             
println '[0,range].flatten();   :  '+([0,range].flatten());   



println '-------------' 
//맵에서도 쓸수있다.
def map =[a:1,b:2];
assert [a:1,b:2,c:3] == [c:3,*:map];
assert [a:1,b:2,c:3] == [c:3,*:map];
assert [a:1,b:2,c:3] == [c:3]+[*:map];

println '[c:3,*:map];   : '+([c:3,*:map]);   
println '[c:3,*:map];   : '+([c:3,*:map]);   
println '[c:3]+[*:map]; : '+([c:3]+[*:map]); 

/*결과
this.list;           : [1, 2, 3, 4]
getProperty ('list') : [1, 2, 3, 4]
sum(*list)  : 10
sum(list)   : 10
-------------
[*list]       : [1, 2, 3, 4]
[]+list       : [1, 2, 3, 4]
[list]       : [[1, 2, 3, 4]]
-------------
[0,*range];            :  [0, 1, 2, 3]
[0,range]              :  [0, 1..3]
[0]+range;             :  [0, 1, 2, 3]
[0,range].flatten();   :  [0, 1, 2, 3]
-------------
[c:3,*:map];   : [c:3, a:1, b:2]
[c:3,*:map];   : [c:3, a:1, b:2]
[c:3]+[*:map]; : [c:3, a:1, b:2]

*/

