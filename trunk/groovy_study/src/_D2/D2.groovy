package _D2

import groovy.sql.DataSet 

def source = new org.hsqldb.jdbc.JDBCDataSource();
source.database = 'jdbc:hsqldb:hsql://localhost/javaworld';
source.user = 'sa';
source.password = '';
def db = new groovy.sql.Sql(source);


// 테이블에 새로운 행을 추가할수있다.
DataSet login_log = db.dataSet("LOGIN_LOG");
login_log.add(
	name:"dataset",
	ip:"0.0.0.0",
	login_date:"1986-04-25",
);

println '---each----'
login_log.each {
	println it.name+'   '+it.ip+'    '+it.login_date;
}

println '---findAll--where name=dataset--'
//특정 조건으로찾은 행들  DataSet를 리턴한다
//여기서 데이터를 다가져온후 클로저로 일일이 걸러내는것같이 할것같지만
//사실은 findAll은  클로저에 제시된 표현식으로 sql을 만들어서 실행한다. 
//each할때 쿼리실행이된다.
DataSet login_log_where1 = login_log.findAll {
	 it.name=='dataset';
}
login_log_where1.each {
	println it.name+'   '+it.ip+'    '+it.login_date;
}
println 'login_log_where1 sql : '+login_log_where1.sql;
println 'login_log_where1 parameters : '+login_log_where1.parameters;




DataSet login_log_where2 = login_log.findAll {
	it.name=='dataset' && it.ip=='0.0.0.0';
}
login_log_where2.each {
   println it.name+'   '+it.ip+'    '+it.login_date;
}
println 'login_log_where2 sql : '+login_log_where2.sql;
println 'login_log_where2 parameters : '+login_log_where2.parameters;

/*
 &&					->		AND
 ||					->		OR
 ==					->		=
 다른연산자 			->		그대로적용
 it.propertyname 	->		프로퍼티 이름을 필드로 보고 그대로적용
 상수					->		? 표현식은 인자 리스트에 들어간다
 */

/* 결과
---each----
B'B'B " B   13.13.13    1954-02-03
DDD   1.1.1.1    1234-11-11
DDD   2.2.2.2    1234-11-12
DDD   3.3.3.3    1234-11-13
BBB_UP   10.10.10    1954-02-01
BBB_UP   11.11.11    1954-02-02
CCC_UP   10.10.10    1954-02-01
CCC_UP   11.11.11    1954-02-02
CCC_UP   12.12.12    1954-02-03
dataset   0.0.0.0    1986-04-25
---findAll--where name=dataset--
dataset   0.0.0.0    1986-04-25
login_log_where1 sql : select * from LOGIN_LOG where name = ?
login_log_where1 parameters : [dataset]
dataset   0.0.0.0    1986-04-25
login_log_where2 sql : select * from LOGIN_LOG where (name = ? and ip = ?)
login_log_where2 parameters : [dataset, 0.0.0.0]


 */

