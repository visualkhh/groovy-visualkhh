file = new File('data/objects.dta')
out  = file.newOutputStream()
oos  = new ObjectOutputStream(out)

objects = [1, "Hello Groovy!", new Date()]
objects.each {                         //|#1
    oos.writeObject(it)                //|#1
}                                      //|#1
oos.close()

retrieved = []                        
file.eachObject { retrieved << it }    //|#2

assert retrieved == objects

