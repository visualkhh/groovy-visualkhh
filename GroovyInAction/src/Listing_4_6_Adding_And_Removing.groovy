myList = []          
          
myList += 'a'                               //#1
assert myList == ['a']

myList += ['b','c']                         //#2
assert myList == ['a','b','c']

myList = []
myList <<  'a' << 'b'                       //#3
assert myList == ['a','b']

assert myList - ['b'] == ['a']              //#4

assert myList * 2 == ['a','b','a','b']      //#5
