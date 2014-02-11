package _16

def oracle(Object o) { return 'object' }
def oracle(String o) { return 'string' }

Object x = 1     
Object y = 'foo'

assert 'object' == oracle(x)
assert 'string' == oracle(y) //#1 자바라면 ‘object’를 호출할것이다.
println oracle(x);
println oracle(y);
println oracle(y as Object);
/* 결과
object
string
object
*/
