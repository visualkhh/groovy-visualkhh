package _D1

import groovy.sql.Sql 
//������ �ҽ� �̿� Ŀ�ؼ�
def source = new org.hsqldb.jdbc.JDBCDataSource();
source.database = 'jdbc:hsqldb:hsql://localhost/javaworld';
source.user = 'sa';
source.password = '';
def db = new groovy.sql.Sql(source);
def db2 = new Sql(db); //���ϳ��� Ŀ�ؼ��� ���������.