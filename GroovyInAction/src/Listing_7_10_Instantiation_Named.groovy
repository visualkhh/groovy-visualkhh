class Vendor {                      
    //String name, product
	def name, product
	//private String name, product  //private �ص� ����� 
}

new Vendor()                            
new Vendor(name:   'Canoo')              
new Vendor(product:'ULC')                
new Vendor(name:   'Canoo', product:'ULC')             
new Vendor(name:   'Canoo', product:1)         //�ڵ��ɽ���    
new Vendor(name:   'Canoo', product2:1) //������             

def vendor = new Vendor(name: 'Canoo')
assert 'Canoo' == vendor.name