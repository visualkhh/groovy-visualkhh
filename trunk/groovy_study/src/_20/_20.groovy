package _20

class DoublerBean {
    public value                           //#1
    
    void setValue(value){
        this.value = value                 //#2
    }
    
    def getValue(){                        
        value * 2                          //#3
    }
}

def bean = new DoublerBean(value: 100)     

assert 200 == bean.value                   //#4
assert 100 == bean.@value                  //#5

println 'bean.value;    :  '+bean.value;
println 'bean.@value;   :  '+bean.@value;
/* °á°ú
bean.value;    :  200
bean.@value;   :  100
*/