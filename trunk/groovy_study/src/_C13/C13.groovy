package _C13

println 'cmd /c date /t'.execute().text;
today = 'cmd /c date /t'.execute().text.split(/\D/)

println 'cmd /c date'.execute();
proc = 'cmd /c date'.execute()

Thread.start {
	System.out  << proc.in  
}
//Thread.start {
//	 System.err  << proc.err 
// }

proc << 'no-such-date'  + "\n" 
println today.join('-')
proc << today.join('-') + "\n" 
println ''
println ''
println ''
proc.out.close()
proc.waitForOrKill(0)

/*
2014-02-14 

java.lang.ProcessImpl@1cef4f7
2014-02-14



현재 날짜: 2014-02-14 
새로운 날짜를 입력하십시오: (년-월-일) no-such-date
시스템이 입력된 날짜를 받아들일 수 없습니다.
새로운 날짜를 입력하십시오: (년-월-일) 
*/