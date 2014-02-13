package C11

//쓰레드를 시작한다.
def t = new Thread(){ /*...*/}
t.start();

//쓰레드를 시작한다
def t1= new Thread().start{println 'start Thread'}
println t1;

def t2 = Thread.start {                           // new Thread.start와 차이점이 무엇일까?
	println 'start Thread.start'
}
println t2;


//데몬쓰레드를 시작한다
Thread.startDaemon {println 'start Daemon Thread'}

//1초후에 시작한다
new Timer().runAfter (1000){ println 'After 1000  start Thread' }
/*결과
start Daemon Thread
start Thread
After 1000  start Thread
*/