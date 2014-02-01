assert (0..10).contains(0)              //|#1	범위안에 속하는가?
assert (0..10).contains(5)              //|#1	범위안에 속하는가?  
assert (0..10).contains(10)             //|#1	범위안에 속하는가?
                                        //|#1
assert (0..10).contains(-1) == false    //|#1	범위안에 속하지 않는가?
assert (0..10).contains(11) == false    //|#1	범위안에 속하지 않는가?

assert (0..<10).contains(9)             //|#2	0부터~10보다 작은 범위에 9가 속하는가? 
assert (0..<10).contains(10) == false   //|#2	0부터~10보다 작은 범위에 9가 속하지 않는가?

                                        
def a = 0..10                           //|#3
assert a instanceof Range               //|#3
assert a.contains(5)                    //|#3
                                        
a = new IntRange(0,10)                  //|#4
assert a.contains(5)                    //|#4
                                                                                
assert (0.0..1.0).contains(0.5)   		//   
                                       
def today     = new Date()              //|#5
def yesterday = today-1                 //|#5
assert (yesterday..today).size() == 2   //|#5
                                        
assert ('a'..'c').contains('b')         //#6
                                        
def log = ''                            //|#7
for (element in 5..9){                  //|#7
    log += element                      //|#7
}                                       //|#7
assert log == '56789'                   //|#7

log = ''                                //|#8
for (element in 9..5){                  //|#8
    log += element                      //|#8
}                                       //|#8
assert log == '98765'                   //|#8

log = ''                                //|#9
(9..<5).each { element ->               //|#9
    log += element                      //|#9
}                                       //|#9
assert log == '9876'                    //|#9             