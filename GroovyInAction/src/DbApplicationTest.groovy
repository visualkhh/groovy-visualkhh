/*

proc = 'cmd /c cd listing && groovy Listing_9_2_Application'.execute()

Thread.start { System.out  << proc.in  }
Thread.start { System.err  << proc.err }

proc << 'exit'  + "\n"

proc.out.close()
proc.waitForOrKill(0)
*/
create Paul Tergat 1969-06-17
create Khalid Khannouchi
update 1 dateOfBirth 1971-12-22
sort firstname
delete 1