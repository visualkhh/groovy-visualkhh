package C10

file = new File('data/objects.dta')
out  = file.newOutputStream()
oos  = new ObjectOutputStream(out)

objects = [1, "Hello Groovy!", new Date()]
objects.each {                         //|#1
    oos.writeObject(it)                //|#1
}                                      //|#1
oos.close()

retrieved = []                        
file.eachObject {		//객체별로 뽑아낸다 여기선  3개번 돌게된다. 1, "Hello Groovy!", new Date()
	 retrieved << it 
 }    //|#2

println  retrieved
println  objects
println  retrieved==objects

/*결과
--
--
--
[1, Hello Groovy!, Thu Feb 13 23:37:05 KST 2014]
[1, Hello Groovy!, Thu Feb 13 23:37:05 KST 2014]
true
*/