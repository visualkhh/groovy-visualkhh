package _D1

//������ �ҽ� �̿� Ŀ�ؼ�
def source = new org.hsqldb.jdbc.JDBCDataSource();
source.database = 'jdbc:hsqldb:hsql://localhost/javaworld';
source.user = 'sa';
source.password = '';
def db = new groovy.sql.Sql(source);


db.execute '''
DELETE FROM LOGIN_LOG WHERE NAME ='AAA'
'''

db.execute '''
UPDATE LOGIN_LOG SET NAME='BBB_UP' WHERE NAME ='BBB'
'''


def updateCnt = db.executeUpdate ('''
UPDATE LOGIN_LOG SET NAME='CCC_UP' WHERE NAME ='CCC'
''')
println 'WHERE NAME =\'CCC\'  updateCnt : '+updateCnt

/* ���
WHERE NAME ='CCC'  updateCnt : 3
*/