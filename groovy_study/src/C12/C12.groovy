package C12
//���ڿ� ����
def e = 'taskmgr';
Process proc = e.execute();
println proc.text;

//���ڿ� �迭 ����
def dircmd = ['cmd','/c','dir']
def dir = /\Program Files/;
println (dircmd+dir);
proc = (dircmd+dir).execute();
println proc.text;
//println proc.in.newReader().readLine();


//���μ��� ��Ʈ�� �޾ƿü� �ִ�.
println proc.in		//�Է�
println proc.err	//���
println proc.out	//�ƿ�

//���μ��� out���ڿ��� �������� �ִ�.
//proc.out<<'aaa'
//proc<<'aaa'

//������ ���μ����� �����ϰ� ���� ��Ȥ ������ ������ �ʴ°�찡 �ִ�. ���������Ͽ� �ذ��Ѵ�
//�׷�񿡼��� waitForOrKill(1000) �޼��尡�ִ�
proc.waitForOrKill(1000);
/*���
[cmd, /c, dir, \Program Files]
 W ����̺��� ����: TUBO_WORKSPACE
 ���� �Ϸ� ��ȣ: 0C11-E2EE

 W:\ ���͸�


java.io.BufferedInputStream@16614e7
java.io.FileInputStream@979e8b
java.io.BufferedOutputStream@b754b2
*/
