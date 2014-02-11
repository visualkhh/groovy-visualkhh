package _10

class Vendor {                      
    //String name, product
	def name, product
	//private String name, product  //private 해도 적용됨 
}

new Vendor()                            
new Vendor(name:   'Canoo')              
new Vendor(product:'ULC')                
new Vendor(name:   'Canoo', product:'ULC')             
new Vendor(name:   'Canoo', product:1)         //자동케스팅    
//new Vendor(name:   'Canoo', product2:1) //오류남             

def vendor = new Vendor(name: 'Canoo')
assert 'Canoo' == vendor.name
println vendor.name;


//암묵적 생성
java.awt.Dimension area;
area = [20,100];
assert area.width ==20;
assert area.height == 100;
println    'area.width :    '+area.width ;   
println    'area.height : '+area.height ; 

/*
결과
Canoo
area.width :    20.0
area.height : 100.0

*/