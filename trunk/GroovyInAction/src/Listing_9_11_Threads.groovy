class Storage {
    List stack = []
    synchronized void leftShift(value){  //#1
        stack << value
        println "push: $value"
        notifyAll()                      //#2
    }
    synchronized Object pop() {
        while (stack.isEmpty()) {        //#3
            try{ wait() }                //#3
            catch(InterruptedException e){} 
        }
        def value = stack.pop()        
        println "pop : $value"
        return value
    }
}
storage = new Storage()

Thread.start {                           //|#4
    for (i in 0..9) {                    //|#4
        storage << i                     //|#4
        sleep 100                        //|#4
    }                                    //|#4
}                                        //|#4

Thread.start {                           //|#5
    10.times {                           //|#5
        sleep 200                        //|#5
        value = storage.pop()            //|#5
    }                                    //|#5
}                                        //|#5
