today = 'cmd /c date /t'.execute().text.split(/\D/)

proc = 'cmd /c date'.execute()

Thread.start { System.out  << proc.in  }
Thread.start { System.err  << proc.err }

proc << 'no-such-date'  + "\n" 
proc << today.join('-') + "\n" 

proc.out.close()
proc.waitForOrKill(0)
