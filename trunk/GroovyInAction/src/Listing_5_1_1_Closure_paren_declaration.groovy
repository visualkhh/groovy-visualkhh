log = ''
(1..10).each({ log += it })
assert log == '12345678910'

// 할당으로 크로저 정의하기
def printer ={line->
	println line;
}

// 특수한 정의  
//클로저를 반환하는 함수 
def Closure getPrinter(){
return {line ->println line}
}