package C9

reader = new StringReader('abc')                   
writer = new StringWriter()

reader.transformChar(writer) {		//reader에 문자 수만큼 클로저 호출된다    , 인자로받은 writer에  리턴값을 쓴다.  
	it.next();		//reader문자수만큼 돈다.
}         //#1
println  writer.toString()



reader = new File('data/text').newReader()  //리더를 리턴받는다.
writer = new StringWriter()

reader.transformLine(writer) {	//line만큼 돈다.  인자로 받은 writer 에 리턴값을 쓴다.
	it - 'o' 
}      //#2
println  writer.toString()



input  = new File('data/text')
writer = new StringWriter()

input.filterLine(writer) {  //필터를 건다  true , false로 리턴중  true만 write에 쓴다. 
	 it =~ /show/ 
 }          
println writer.toString()

writer = new StringWriter()
writer << input.filterLine {	//리턴값이 true면 writer에 쓴다.
	 it.size() > 8 
}      //#4
println writer.toString()
/*결과
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