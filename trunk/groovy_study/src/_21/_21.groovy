package _21

class Go{
    def g;
    public void setG(def g) {
        println 'setG '+g;
        this.g = g;
    }
	
	
    public void set(def name,def value) {
        println 'No such property Name -> Set Name:'+name+', value:'+value;
    }
	public def get(String name) {
		return 'No such property Name -> '+name;
	}
	
}
 
def g = new Go([g:'1']);
println 'g.g;  : ' + g.g;  
println 'g.gg; : ' + g.gg; 

println '';
g.g='g_value'
g.gg='gg_value';
println '';

println 'g.g;  : ' + g.getAt("g");  
println 'g.gg; : ' + g.getAt("gg"); 



/*°á°ú
setG 1
g.g;  : 1
g.gg; : No such property Name -> gg

setG g_value
No such property Name -> Set Name:gg, value:gg_value

g.g;  : g_value
g.gg; : No such property Name -> gg
*/