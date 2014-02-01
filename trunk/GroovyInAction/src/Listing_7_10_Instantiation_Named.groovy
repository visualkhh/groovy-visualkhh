class Vendor {                      
    String name, product
}

new Vendor()                            
new Vendor(name:   'Canoo')              
new Vendor(product:'ULC')                
new Vendor(name:   'Canoo', product:'ULC')             

def vendor = new Vendor(name: 'Canoo')
assert 'Canoo' == vendor.name