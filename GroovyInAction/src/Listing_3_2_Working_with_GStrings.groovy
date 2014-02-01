me      = 'Tarzan'                                          //|#1
you     = 'Jane'                                            //|#1
line    = "me $me - you $you"                               //|#1
assert  line == 'me Tarzan - you Jane'                      //|#1

date = new Date(0)                                          //|#2
out  = "Year $date.year Month $date.month Day $date.date"   //|#2
assert out == 'Year 70 Month 0 Day 1'                       //|#2

out = "Date is ${date.toGMTString()} !"                     //|#3
assert out == 'Date is 1 Jan 1970 00:00:00 GMT !'           //|#3

sql = """
SELECT FROM MyTable
  WHERE Year = $date.year
"""    
assert sql == """
SELECT FROM MyTable
  WHERE Year = 70
"""                                                         //#4

out = "my 0.02\$"                                           //|#5
assert out == 'my 0.02$'                                    //|#5