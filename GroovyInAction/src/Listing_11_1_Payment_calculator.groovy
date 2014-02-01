def monthly = "amount*(rate/12) / (1-(1+rate/12)**-numberOfMonths)"

def shell = new GroovyShell()
def script = shell.parse(monthly)                         //#1

script.binding.amount = 154000                            //#2
script.rate = 3.75/100                                    //#3
script.numberOfMonths = 240

assert script.run() == 913.0480050387338

script.binding = new Binding(amount: 185000,              //|#4
                              rate: 3.50/100,             //|#4
                              numberOfMonths: 300)        //|#4

assert script.run() == 926.1536089487843