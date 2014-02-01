def quickSort(list) {
    if (list.size() < 2) return list
   
	def pivot  = list[list.size().intdiv(2)]				//정수의 나눗셈에서 정수 결과 값이 필요할때. 1.intdiv(2) = 1/2같음 
    def left   = list.findAll {item -> item <  pivot }        //|#1
    def middle = list.findAll {item -> item == pivot }        //|#1
    def right  = list.findAll {item -> item >  pivot }        //|#1
    return (quickSort(left) + middle + quickSort(right))      //#2
}

assert quickSort([])                == []
assert quickSort([1])               == [1]

assert quickSort([1,2])             == [1,2]
assert quickSort([2,1])             == [1,2]
assert quickSort([3,1,2])           == [1,2,3]
assert quickSort([3,1,2,2])         == [1,2,2,3]                
assert quickSort([1.0f,'a',10,null])== [null, 1.0f, 10, 'a']  //#3 
assert quickSort('Karin and Dierk') == '  DKaadeiiknnrr'.toList()//#4