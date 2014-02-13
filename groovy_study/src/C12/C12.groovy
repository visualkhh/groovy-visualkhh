package C12
//문자열 실행
def e = 'taskmgr';
Process proc = e.execute();
println proc.text;

//문자열 배열 실행
def dircmd = ['cmd','/c','dir']
def dir = /\Program Files/;
println (dircmd+dir);
proc = (dircmd+dir).execute();
println proc.text;
//println proc.in.newReader().readLine();


//프로세스 스트림 받아올수 있다.
println proc.in		//입력
println proc.err	//출력
println proc.out	//아웃

//프로세스 out문자열을 보낼수도 있다.
//proc.out<<'aaa'
//proc<<'aaa'

//끝으로 프로세스를 실행하고 나면 간혹 영원히 끝나지 않는경우가 있다. 강제종료하여 해결한다
//그루비에서는 waitForOrKill(1000) 메서드가있다
proc.waitForOrKill(1000);
/*결과
[cmd, /c, dir, \Program Files]
 W 드라이브의 볼륨: TUBO_WORKSPACE
 볼륨 일련 번호: 0C11-E2EE

 W:\ 디렉터리


java.io.BufferedInputStream@16614e7
java.io.FileInputStream@979e8b
java.io.BufferedOutputStream@b754b2
*/
