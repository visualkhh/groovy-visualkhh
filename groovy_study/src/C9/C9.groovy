package C9

reader = new StringReader('abc')                   
writer = new StringWriter()

reader.transformChar(writer) {		//reader�� ���� ����ŭ Ŭ���� ȣ��ȴ�    , ���ڷι��� writer��  ���ϰ��� ����.  
	it.next();		//reader���ڼ���ŭ ����.
}         //#1
println  writer.toString()



reader = new File('data/text').newReader()  //������ ���Ϲ޴´�.
writer = new StringWriter()

reader.transformLine(writer) {	//line��ŭ ����.  ���ڷ� ���� writer �� ���ϰ��� ����.
	it - 'o' 
}      //#2
println  writer.toString()



input  = new File('data/text')
writer = new StringWriter()

input.filterLine(writer) {  //���͸� �Ǵ�  true , false�� ������  true�� write�� ����. 
	 it =~ /show/ 
 }          
println writer.toString()

writer = new StringWriter()
writer << input.filterLine {	//���ϰ��� true�� writer�� ����.
	 it.size() > 8 
}      //#4
println writer.toString()
/*���
bcd
shw me the money
shw
me
the
mney

show me the money
show

show me the money
*/