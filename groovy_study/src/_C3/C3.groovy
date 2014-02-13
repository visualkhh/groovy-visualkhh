package _C3

class PersonDAO {
    public findAll () {
        'findAll  value'
    }
    public findAll(def name,def value) {
    		return name +' '+ value;
    }
	
	
	// 클로저로 처리할수도있다.
	public a_All = { 
		'a_All_val'
	}
	public b_All = { name,value->
	'b_All  name : '+name +'    value:'+value;
	
	}

		
}
def action = 'findAll'  // some external input
Object[] params = [];

dao = new PersonDAO()
println dao.invokeMethod (action,params);

params = ['findAllName','findValue']
println dao.invokeMethod (action,params);

 
// 클로저로 처리할수도있다.
println dao['a_All']()
println dao['b_All'](*['bname','bvalue'])

/*결과
findAll  value
findAllName findValue
a_All_val
b_All  name : bname    value:bvalue
*/