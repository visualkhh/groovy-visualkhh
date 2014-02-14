package _D1


import java.util.logging.Logger;

import groovy.sql.Sql 


//데이터 소스 이용 커넥션
def source = new org.hsqldb.jdbc.JDBCDataSource();
source.database = 'jdbc:hsqldb:hsql://localhost/javaworld';
source.user = 'sa';
source.password = '';
def db = new groovy.sql.Sql(source);

db.execute '''
DELETE FROM LOGIN_LOG
'''

db.execute '''
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES('AAA','123.123.123','2014-02-04');
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES('AAA','223.223.223','2014-02-05');
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES('AAA','201.203.204','2014-02-06');
'''

/////////prepared statement 제공////////
/*
 주의 prepared statement  에서는 '(작은따옴표) 쓰지말아야 한다.
명령문 쪽에서도 없어야하고 명령에 전달되는 문자열 내부에도 없어야 한다 
작은따옴표는 그루비를 위한것이지 SQL을 위한것이 아니다.
*/
String sql = '''
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES(?,?,?);
	'''
db.execute (sql,['BBB','10.10.10','1954-02-01']);
db.execute (sql,['BBB','11.11.11','1954-02-02']);
db.execute (sql,['B\'B\'B " B','13.13.13','1954-02-03']);

////////////////////////////////////////
sql = '''
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES('CCC',?,?);
	'''
db.execute (sql,['10.10.10','1954-02-01']);
db.execute (sql,['11.11.11','1954-02-02']);
db.execute (sql,['12.12.12','1954-02-03']);


///////////////////////////////////

def loglist = [
	[NAME:'DDD',	IP:'1.1.1.1',	LOGIN_DATE:'1234-11-11'],
	[NAME:'DDD',	IP:'2.2.2.2',	LOGIN_DATE:'1234-11-12'],
	[NAME:'DDD',	IP:'3.3.3.3',	LOGIN_DATE:'1234-11-13']
];

//로그를 찍어보장~
//Logger.getLogger ('groovy.sql').level = Level.FINE;

loglist.each { inRow -> 
	db.execute """
	INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
		VALUES(${inRow.NAME},${inRow.IP},${inRow.LOGIN_DATE});
	"""
}








