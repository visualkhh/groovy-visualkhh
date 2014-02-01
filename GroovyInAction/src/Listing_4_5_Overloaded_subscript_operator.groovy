myList = ['a','b','c','d','e','f']          
                                            
assert myList[0..2]  == ['a','b','c']       //#1
assert myList[0,2,4] == ['a','c','e']       //#2
                                            
myList[0..2] = ['x','y','z']                //#3                                           
assert myList == ['x','y','z','d','e','f']  
                                            
myList[3..5] = []                           //#4
assert myList == ['x','y','z']              
                                            
myList[1..1] = ['y','1','2']                //#5
assert myList == ['x','y','1','2','z']      
