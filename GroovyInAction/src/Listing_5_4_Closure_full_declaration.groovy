map = ['a':1, 'b':2]                              
map.each{ key, value -> map[key] = value * 2 }      //#1
assert map == ['a':2, 'b':4]                      
                                                  
doubler = {key, value -> map[key] = value * 2 }     //#2
map.each(doubler)                                   //#3
assert map == ['a':4, 'b':8]                      
                                                  
def doubleMethod (entry){                           //|#4
    map[entry.key] = entry.value * 2                //|#4
}                                                   //|#4
doubler = this.&doubleMethod                        //#5
map.each(doubler)                                   //#6
assert map == ['a':8, 'b':16]