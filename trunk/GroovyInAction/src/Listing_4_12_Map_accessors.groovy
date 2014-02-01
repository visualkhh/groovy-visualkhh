def myMap = [a:1, b:2, c:3]

assert myMap['a']       == 1  //|#1
assert myMap.a          == 1  //|#1
assert myMap.get('a')   == 1  //|#1
assert myMap.get('a',0) == 1  //|#1

assert myMap['d']       == null   //|#2
assert myMap.d          == null   //|#2
assert myMap.get('d')   == null   //|#2

assert myMap.get('d',0) == 0      //|#3
assert myMap.d          == 0      //|#3

myMap['d'] = 1                    //|#4
assert myMap.d == 1               //|#4
myMap.d = 2                       //|#4
assert myMap.d == 2               //|#4