def myMap = [a:1, b:2, c:3]

def store = ''
myMap.each {entry ->         //|#1
    store += entry.key       //|#1
    store += entry.value     //|#1
}                            //|#1
assert store.contains('a1')
assert store.contains('b2')
assert store.contains('c3')

store = ''
myMap.each {key, value ->    //|#2
    store += key             //|#2
    store += value           //|#2
}                            //|#2
assert store.contains('a1')
assert store.contains('b2')
assert store.contains('c3')

store = ''
for (key in myMap.keySet()) { //|#3
    store += key              //|#3
}                             //|#3
assert store.contains('a')
assert store.contains('b')
assert store.contains('c')

store = ''
for (value in myMap.values()) { //|#4
    store += value              //|#4
}                               //|#4
assert store.contains('1')
assert store.contains('2')
assert store.contains('3')