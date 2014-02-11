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
println '[*list]       : ' + [*list];	//���⼭ Ȯ�꿬������ ����� Ȯ���غ����ִ�. �������� ���� �״�� .���̵���.
println '[]+list       : '+([]+list);	//���ʿ�+������ ���°�  list�� ó���� ���� ���� ����Ʈ�� �ְڴٴ¼Ҹ���. �� Ȯ�꿬���ڶ� ���� �����Ѵ�. 
println '[list]       : ' + [list];		//����ü������/ 
assert 10==sum(*list); 
assert 10==sum(list);
assert 11==sum([2,2,3,4]);
assert 12==sum(3,2,3,4);


println '-------------' 
def range=(1..3);
assert [0,1,2,3] ==[0,*range];
assert [0,1,2,3] ==[0]+range;
assert [0,1,2,3] ==[0,range].flatten();
println '[0,*range];            :  '+([0,*range]);        //Ȯ�꿬������ ����Ȱ� �� �������� 
println '[0,range]              :  '+[0,range];
println '[0]+range;             :  '+([0]+range);             
println '[0,range].flatten();   :  '+([0,range].flatten());   



println '-------------' 
//�ʿ����� �����ִ�.
def map =[a:1,b:2];
assert [a:1,b:2,c:3] == [c:3,*:map];
assert [a:1,b:2,c:3] == [c:3,*:map];
assert [a:1,b:2,c:3] == [c:3]+[*:map];

println '[c:3,*:map];   : '+([c:3,*:map]);   
println '[c:3,*:map];   : '+([c:3,*:map]);   
println '[c:3]+[*:map]; : '+([c:3]+[*:map]); 

/*���
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

