def myMap = [a:1, b:2, c:3]
def other = [b:2, c:3, a:1]

assert myMap == other                                  //#1

assert myMap.isEmpty()  == false                       //|#2
assert myMap.size()     == 3                           //|#2
assert myMap.containsKey('a')                          //|#2
assert myMap.containsValue(1)                          //|#2
assert myMap.keySet()        == toSet(['a','b','c'])   //|#2
assert toSet(myMap.values()) == toSet([1,2,3])         //|#2
assert myMap.entrySet() instanceof Collection          //|#2      

assert myMap.any   {entry -> entry.value > 2  }        //|#3
assert myMap.every {entry -> entry.key   < 'd'}        //|#3

def toSet(list){                                       //|#4
    new java.util.HashSet(list)                        //|#4
}                                                      //|#4
