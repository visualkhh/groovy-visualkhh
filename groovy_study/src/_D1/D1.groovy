package _D1

import groovy.sql.Sql 

//����̹� �Ŵ��� �̿�
def db  =  Sql.newInstance(
	'jdbc:hsqldb:hsql://localhost/javaworld',
	'sa',
	'',
	'org.hsqldb.jdbcDriver'
);

/* �н��Ⱑ�ֱ� ���� ����
Caught: java.lang.ClassNotFoundException: org.hsqldb.jdbcDriver
	at _D1.D1.run(D1.groovy:5)
*/