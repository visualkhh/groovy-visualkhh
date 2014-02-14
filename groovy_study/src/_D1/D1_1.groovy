package _D1

import groovy.sql.Sql 
//데이터 소스 이용 커넥션
def source = new org.hsqldb.jdbc.JDBCDataSource();
source.database = 'jdbc:hsqldb:hsql://localhost/javaworld';
source.user = 'sa';
source.password = '';
def db = new groovy.sql.Sql(source);
def db2 = new Sql(db); //또하나의 커넥션이 만들어진다.