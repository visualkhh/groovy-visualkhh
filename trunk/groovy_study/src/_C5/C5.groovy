package _C5

file = new File('W:\\code.google\\groovy-visualkhh\\groovy_study\\src\\_C5\\C5.groovy')
file.eachLine{println it}
println '';
println '';
println('-------file.readLines()-------------------');
def lines = file.readLines(); //list�� ��ȯ�Ѵ�
println lines;	
println('-----lines.any{it =~/File/}-------------------');
println lines.any{it =~/File/};	
println('-----lines.grep{it =~/File/}-------------------');
println lines.grep{it =~/File/};	
/*
���
package _C5

file = new File('W:\\code.google\\groovy-visualkhh\\groovy_study\\src\\_C5\\C5.groovy')
file.eachLine{println it}
println '';
println '';
println('-------file.readLines()-------------------');
def lines = file.readLines(); //list�� ��ȯ�Ѵ�
println lines;	
println('-----lines.any{it =~/File/}-------------------');
println lines.any{it =~/File/};	
println('-----lines.grep{it =~/File/}-------------------');
println lines.grep{it =~/File/};	


-------file.readLines()-------------------
[package _C5, , file = new File('W:\\code.google\\groovy-visualkhh\\groovy_study\\src\\_C5\\C5.groovy'), file.eachLine{println it}, println '';, println '';, println('-------file.readLines()-------------------');, def lines = file.readLines(); //list�� ��ȯ�Ѵ�, println lines;	, println('-----lines.any{it =~/File/}-------------------');, println lines.any{it =~/File/};	, println('-----lines.grep{it =~/File/}-------------------');, println lines.grep{it =~/File/};	]
-----lines.any{it =~/File/}-------------------
true
-----lines.grep{it =~/File/}-------------------
[file = new File('W:\\code.google\\groovy-visualkhh\\groovy_study\\src\\_C5\\C5.groovy'), println('-----lines.any{it =~/File/}-------------------');, println lines.any{it =~/File/};	, println('-----lines.grep{it =~/File/}-------------------');, println lines.grep{it =~/File/};	]

*/