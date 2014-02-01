class VendorWithCtor {                      
    String name, product
    
    VendorWithCtor(name, product) {             //#1
        this.name    = name
        this.product = product
    }
}

def first = new VendorWithCtor('Canoo','ULC')   //#2

def second = ['Canoo','ULC'] as VendorWithCtor  //#3

VendorWithCtor third = ['Canoo','ULC']          //#4