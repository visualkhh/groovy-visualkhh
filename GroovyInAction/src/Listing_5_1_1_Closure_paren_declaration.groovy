log = ''
(1..10).each({ log += it })
assert log == '12345678910'

// �Ҵ����� ũ���� �����ϱ�
def printer ={line->
	println line;
}

// Ư���� ����  
//Ŭ������ ��ȯ�ϴ� �Լ� 
def Closure getPrinter(){
return {line ->println line}
}