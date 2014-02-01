class PretendFieldCounter {
    public count = 0
	def gg='gg';
	static    classField	= 'classField'
	protected field1		='field1';
	String    typedField 	='typedField'
	private   assignedField = new Date()
    Object get (String name) {
		println "get : ${name}";
        return 'pretend value'
    }
    void set (String name, Object value) {
		println "set  name : ${name},   value : ${value}";
        count++
    }
	
}

def pretender = new PretendFieldCounter()

assert pretender.isNoField == 'pretend value'
assert pretender.count     == 0

println "${pretender.isNoField}   ${pretender.count}";

pretender.isNoFieldEither  = 'just to increase counter'
assert pretender.count     == 1
println "count : ${pretender.count}";

pretender.gg='ggg';
println '---- '+pretender.gg
println '---- '+pretender.count
println '---- '+pretender.classField
println '---- '+pretender.field1
println '---- '+pretender.assignedField
println '---- '+pretender.assignedField2
println '---- '+pretender['assignedField2']
println '---- '+pretender['assignedField']
