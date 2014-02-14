package _D1

//데이터 소스 이용 커넥션
def source = new org.hsqldb.jdbc.JDBCDataSource();
source.database = 'jdbc:hsqldb:hsql://localhost/javaworld';
source.user = 'sa';
source.password = '';
def db = new groovy.sql.Sql(source);

//Row 가져오기
db.eachRow('SELECT SEQ, NAME, IP, LOGIN_DATE FROM LOGIN_LOG'){
	atRow->	
	println "SEQ : ${atRow.SEQ}, NAME : ${atRow.NAME}, IP : ${atRow.IP},  LOGIN_DATE : ${atRow.LOGIN_DATE}";
	println "SEQ : ${atRow[0]}, NAME : ${atRow[1]}, IP : ${atRow[2]},  LOGIN_DATE : ${atRow[3]}";
	println '--'*25;
}

println '**'*25;

//ResultSet 가져오기
db.query('SELECT SEQ, NAME, IP, LOGIN_DATE FROM LOGIN_LOG'){
	resultSet->
	if(resultSet.next()){
		print resultSet.getString(1); //여기서 인덱스는 0부터 시작이 아니라 1부터 시작이다.
		print '    '
		println resultSet.getString('NAME');
	}
}

println '**'*25;
//rows메서드를 이용하면 모든 행을 하나의 긴 리스트에 담을수 있다.
List list = db.rows('SELECT SEQ, NAME, IP, LOGIN_DATE FROM LOGIN_LOG')
println list;

println '**'*25;
//메타데이터 가져오기.
db.query('SELECT SEQ, NAME, IP, LOGIN_DATE FROM LOGIN_LOG'){
	resultSet->
		def meta = resultSet.metaData;	
		if(meta.columnCount<=0){
			return;	
		}
		while(resultSet.next()){
			for(i in 0..<meta.columnCount){
				print "${i} : ${meta.getColumnLabel(i+1)}".padRight(20);
				print resultSet.getObject(i+1);
				print '\n'
			}
			println '-'*40;
		}
}


/*
결과
SEQ : 81, NAME : B'B'B " B, IP : 13.13.13,  LOGIN_DATE : 1954-02-03
SEQ : 81, NAME : B'B'B " B, IP : 13.13.13,  LOGIN_DATE : 1954-02-03
--------------------------------------------------
SEQ : 85, NAME : DDD, IP : 1.1.1.1,  LOGIN_DATE : 1234-11-11
SEQ : 85, NAME : DDD, IP : 1.1.1.1,  LOGIN_DATE : 1234-11-11
--------------------------------------------------
SEQ : 86, NAME : DDD, IP : 2.2.2.2,  LOGIN_DATE : 1234-11-12
SEQ : 86, NAME : DDD, IP : 2.2.2.2,  LOGIN_DATE : 1234-11-12
--------------------------------------------------
SEQ : 87, NAME : DDD, IP : 3.3.3.3,  LOGIN_DATE : 1234-11-13
SEQ : 87, NAME : DDD, IP : 3.3.3.3,  LOGIN_DATE : 1234-11-13
--------------------------------------------------
SEQ : 79, NAME : BBB_UP, IP : 10.10.10,  LOGIN_DATE : 1954-02-01
SEQ : 79, NAME : BBB_UP, IP : 10.10.10,  LOGIN_DATE : 1954-02-01
--------------------------------------------------
SEQ : 80, NAME : BBB_UP, IP : 11.11.11,  LOGIN_DATE : 1954-02-02
SEQ : 80, NAME : BBB_UP, IP : 11.11.11,  LOGIN_DATE : 1954-02-02
--------------------------------------------------
SEQ : 82, NAME : CCC_UP, IP : 10.10.10,  LOGIN_DATE : 1954-02-01
SEQ : 82, NAME : CCC_UP, IP : 10.10.10,  LOGIN_DATE : 1954-02-01
--------------------------------------------------
SEQ : 83, NAME : CCC_UP, IP : 11.11.11,  LOGIN_DATE : 1954-02-02
SEQ : 83, NAME : CCC_UP, IP : 11.11.11,  LOGIN_DATE : 1954-02-02
--------------------------------------------------
SEQ : 84, NAME : CCC_UP, IP : 12.12.12,  LOGIN_DATE : 1954-02-03
SEQ : 84, NAME : CCC_UP, IP : 12.12.12,  LOGIN_DATE : 1954-02-03
--------------------------------------------------
**************************************************
81    B'B'B " B
**************************************************
[[SEQ:81, NAME:B'B'B " B, IP:13.13.13, LOGIN_DATE:1954-02-03], [SEQ:85, NAME:DDD, IP:1.1.1.1, LOGIN_DATE:1234-11-11], [SEQ:86, NAME:DDD, IP:2.2.2.2, LOGIN_DATE:1234-11-12], [SEQ:87, NAME:DDD, IP:3.3.3.3, LOGIN_DATE:1234-11-13], [SEQ:79, NAME:BBB_UP, IP:10.10.10, LOGIN_DATE:1954-02-01], [SEQ:80, NAME:BBB_UP, IP:11.11.11, LOGIN_DATE:1954-02-02], [SEQ:82, NAME:CCC_UP, IP:10.10.10, LOGIN_DATE:1954-02-01], [SEQ:83, NAME:CCC_UP, IP:11.11.11, LOGIN_DATE:1954-02-02], [SEQ:84, NAME:CCC_UP, IP:12.12.12, LOGIN_DATE:1954-02-03]]
**************************************************
0 : SEQ             81
1 : NAME            B'B'B " B
2 : IP              13.13.13
3 : LOGIN_DATE      1954-02-03
----------------------------------------
0 : SEQ             85
1 : NAME            DDD
2 : IP              1.1.1.1
3 : LOGIN_DATE      1234-11-11
----------------------------------------
0 : SEQ             86
1 : NAME            DDD
2 : IP              2.2.2.2
3 : LOGIN_DATE      1234-11-12
----------------------------------------
0 : SEQ             87
1 : NAME            DDD
2 : IP              3.3.3.3
3 : LOGIN_DATE      1234-11-13
----------------------------------------
0 : SEQ             79
1 : NAME            BBB_UP
2 : IP              10.10.10
3 : LOGIN_DATE      1954-02-01
----------------------------------------
0 : SEQ             80
1 : NAME            BBB_UP
2 : IP              11.11.11
3 : LOGIN_DATE      1954-02-02
----------------------------------------
0 : SEQ             82
1 : NAME            CCC_UP
2 : IP              10.10.10
3 : LOGIN_DATE      1954-02-01
----------------------------------------
0 : SEQ             83
1 : NAME            CCC_UP
2 : IP              11.11.11
3 : LOGIN_DATE      1954-02-02
----------------------------------------
0 : SEQ             84
1 : NAME            CCC_UP
2 : IP              12.12.12
3 : LOGIN_DATE      1954-02-03
----------------------------------------
*/
