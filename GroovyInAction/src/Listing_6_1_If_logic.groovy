assert true               //|#1
assert !false             //|#1

assert ('a' =~ /./)       //|#2
assert !('a' =~ /b/)      //|#2

assert [1]                //|#3
assert ![]                //|#3

assert ['a':1]            //|#4
assert ![:]               //|#4

assert 'a'                //|#5
assert !''                //|#5

assert 1                  //|#6
assert 1.1                //|#6
assert 1.2f               //|#6
assert 1.3g               //|#6
assert 2L                 //|#6
assert 3G                 //|#6
assert !0                 //|#6

assert new Object()       //|#7
assert !null              //|#7

