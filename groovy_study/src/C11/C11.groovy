package C11

//�����带 �����Ѵ�.
def t = new Thread(){ /*...*/}
t.start();

//�����带 �����Ѵ�
def t1= new Thread().start{println 'start Thread'}
println t1;

def t2 = Thread.start {                           // new Thread.start�� �������� �����ϱ�?
	println 'start Thread.start'
}
println t2;


//���󾲷��带 �����Ѵ�
Thread.startDaemon {println 'start Daemon Thread'}

//1���Ŀ� �����Ѵ�
new Timer().runAfter (1000){ println 'After 1000  start Thread' }
/*���
start Daemon Thread
start Thread
After 1000  start Thread
*/