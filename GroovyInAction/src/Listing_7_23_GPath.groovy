class Invoice {                                          //|#1
    List    items                                        //|#1
    Date    date                                         //|#1
}                                                        //|#1
class LineItem {                                         //|#1
    Product product                                      //|#1
    int     count                                        //|#1
    int total() {                                        //|#1
        return product.dollar * count                    //|#1
    }                                                    //|#1
}                                                        //|#1
class Product {                                          //|#1
    String  name                                         //|#1
    def     dollar                                       //|#1
}                                                        //|#1

def ulcDate = new Date(107,0,1)
def ulc = new Product(dollar:1499, name:'ULC')           //|#2
def ve  = new Product(dollar:499,  name:'Visual Editor') //|#2
                                                         //|#2
def invoices = [                                         //|#2
    new Invoice(date:ulcDate, items: [                   //|#2
        new LineItem(count:5, product:ulc),              //|#2
        new LineItem(count:1, product:ve)                //|#2
    ]),                                                  //|#2
    new Invoice(date:[107,1,2], items: [                 //|#2
        new LineItem(count:4, product:ve)                //|#2
    ])                                                   //|#2
]                                                        //|#2

assert [5*1499, 499, 4*499] == invoices.items*.total()   //#3

assert ['ULC'] ==
    invoices.items.grep{it.total() > 7000}.product.name  //#4

def searchDates = invoices.grep{                         //|#5
    it.items.any{it.product == ulc}                      //|#5
}.date*.toString()                                       //|#5
assert [ulcDate.toString()] == searchDates
