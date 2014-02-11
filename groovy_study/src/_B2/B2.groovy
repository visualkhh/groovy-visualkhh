package _B2

def builder = new NodeBuilder()                          //#1
def ulcDate = new Date(107,0,1)
def invoices = builder.invoices{                         //#2
    invoice(date: ulcDate){                              //#3
        item(count:5){
            product(name:'ULC', dollar:1499)
        }
        item(count:1){
            product(name:'Visual Editor', dollar:499)
        }
    }
    invoice(date: new Date(106,1,2)){
        item(count:4) {
            product(name:'Visual Editor', dollar:499)
        }
    }
}

soldAt = invoices.grep {                                 //|#4
       it.item.product.any{ it.'@name' == 'ULC' }        //|#4
   }.'@date'                                             //|#4
assert soldAt == [ulcDate]
def writer = new StringWriter()
invoices.print(new PrintWriter(writer))              //#2
def result = writer.toString().replaceAll("\r","")   //#3
print result;

/*°á°ú
invoices() {
  invoice(date:Mon Jan 01 00:00:00 KST 2007) {
    item(count:5) {
      product(name:'ULC', dollar:1499)
    }
    item(count:1) {
      product(name:'Visual Editor', dollar:499)
    }
  }
  invoice(date:Thu Feb 02 00:00:00 KST 2006) {
    item(count:4) {
      product(name:'Visual Editor', dollar:499)
    }
  }
}
*/
