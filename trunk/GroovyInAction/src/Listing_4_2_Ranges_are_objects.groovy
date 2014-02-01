result = ''                                       //|#1
(5..9).each{ element ->                           //|#1
    result += element                             //|#1
}                                                 //|#1
assert result == '56789'                          //|#1
                                                  
assert (0..10).isCase(5)                          
                                                  
age = 36                                          //|#2
switch(age){                                      //|#2
    case 16..20 : insuranceRate = 0.05 ; break    //|#2
    case 21..50 : insuranceRate = 0.06 ; break    //|#2
    case 51..65 : insuranceRate = 0.07 ; break    //|#2
    default: throw new IllegalArgumentException() //|#2
}                                                 //|#2
assert insuranceRate == 0.06                      //|#2
                                                  
ages = [20,36,42,56]                              //|#3
midage = 21..50                                   //|#3
assert ages.grep(midage) == [36,42]               //|#3