class Counter {
    public 	  count			= 0
	def 	  gg			= 'aaaaa';
	static    classField	= 'classField'
	protected field1		='field1';
	String    typedField 	='typedField'
	private   assignedField = new Date()
}

def counter = new Counter()

counter.count = 1
assert counter.count == 1

def fieldName = 'count'
counter[fieldName] = 2
assert counter['count'] == 2

println counter['count'];
println counter['gg'];
println counter['classField'];
println counter['field1'];
println counter['typedField'];
println counter['assignedField'];