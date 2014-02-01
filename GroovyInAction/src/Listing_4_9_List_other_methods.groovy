def list = [1,2,3]

assert list.count(2) == 1                   //|#1
assert list.max() == 3                      //|#1
assert list.min() == 1                      //|#1                                             
                                            //|#1
def even = list.find { item ->              //|#1                                                          
    item % 2 == 0                           //|#1
}                                           //|#1
assert even == 2                            //|#1
                                            //|#1
assert list.every { item -> item < 5}       //|#1 
assert list.any   { item -> item < 2}       //|#1  

def store = ''
list.each { item ->                         //|#2
    store += item                           //|#2
}                                           //|#2
assert store == '123'                       //|#2
                                            //|#2
store = ''                                  //|#2
list.reverseEach{ item ->                   //|#2
    store += item                           //|#2
}                                           //|#2
assert store == '321'                       //|#2

assert list.join('-') == '1-2-3'            //|#3
                                            //|#3
result = list.inject(0){ clinks, guests ->  //|#3
    clinks += guests                        //|#3
}                                           //|#3
assert result     == 0 + 1+2+3              //|#3
assert list.sum() == 6                      //|#3
                                            //|#3
factorial = list.inject(1){ fac, item ->    //|#3
    fac *= item                             //|#3
}                                           //|#3
assert factorial == 1 * 1*2*3               //|#3
