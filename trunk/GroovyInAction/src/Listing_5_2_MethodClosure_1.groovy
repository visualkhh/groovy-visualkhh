class MethodClosureSample {
    int limit
    
    MethodClosureSample (int limit) {   
        this.limit = limit              
    }                                     
    
    boolean validate (String value) {     
		println this.limit + '  '+value
        return value.length() <= limit    
    }                                     
}

def MethodClosureSample first = new MethodClosureSample (6)  //#1
def MethodClosureSample second = new MethodClosureSample (5) //#1

def Closure firstClosure = first.&validate                   //#2

def words = ['long string', 'medium', 'short', 'tiny']

assert 'medium' == words.find (firstClosure)                 //#3
assert 'short' == words.find (second.&validate)              //#4

def gogo  = words.find { 
				println 'find : '+it
				return true;
			}
println gogo;
