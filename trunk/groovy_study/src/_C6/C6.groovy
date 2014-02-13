package _C6
example = new File('data/text')
println example.readLines()		//리스트로 반환

example.eachLine {		//한줄씩.
	println 'startWith:' + it.startsWith('show') + '        ('+it+')'
}

hex = []
example.eachByte { hex << String.format('%2X',it) }	//핵사코드
println hex;


example.splitEachLine(/\s/){		//정규식\s는 공백 문자  공백문자로 자르기.
	println it.toString()+'        it[0] :'+it[0]
}

example.withReader { reader ->				//withReader는  리더를  클로저에 전달한다.
	reader.eachLine {		//한줄씩.
		println 'withReader : '+it
	}
}

example.withInputStream { is ->				//withInputStream는  inputStream를  클로저에 전달한다.
	is.eachLine {		//한줄씩.
		println 'withInputStream : '+it
	}
}
/*
def text = new FileInputStream("copytut.txt").getText("UTF-8")
assert text == "ABC\nZYX\nABC\nZYX\n"
 */

/*
출력
[show me the money, show, me, the, money]
startWith:true        (show me the money)
startWith:true        (show)
startWith:false        (me)
startWith:false        (the)
startWith:false        (money)
[73, 68, 6F, 77, 20, 6D, 65, 20, 74, 68, 65, 20, 6D, 6F, 6E, 65, 79,  D,  A, 73, 68, 6F, 77,  D,  A, 6D, 65,  D,  A, 74, 68, 65,  D,  A, 6D, 6F, 6E, 65, 79]
[show, me, the, money]        it[0] :show
[show]        it[0] :show
[me]        it[0] :me
[the]        it[0] :the
[money]        it[0] :money
withReader : show me the money
withReader : show
withReader : me
withReader : the
withReader : money
withInputStream : show me the money
withInputStream : show
withInputStream : me
withInputStream : the
withInputStream : money

*/