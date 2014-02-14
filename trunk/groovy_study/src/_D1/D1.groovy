package _D1

import groovy.sql.Sql 

//드라이버 매니저 이용
def db  =  Sql.newInstance(
	'jdbc:hsqldb:hsql://localhost/javaworld',
	'sa',
	'',
	'org.hsqldb.jdbcDriver'
);

/* 패스잡가주기 전에 오류
Caught: java.lang.ClassNotFoundException: org.hsqldb.jdbcDriver
	at _D1.D1.run(D1.groovy:5)
*/