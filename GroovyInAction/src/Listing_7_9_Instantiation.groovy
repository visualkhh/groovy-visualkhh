class VendorWithCtor {                      
    String name, product
    VendorWithCtor(){
    	println "����Ʈ ������"
	}
	
    VendorWithCtor(Map map){
    	println "Map �Ķ����1�� ������ȣ�� : ${map},  ${map.class.name}"
    	this.name = name;
    }
	VendorWithCtor(name){
    	println "�Ķ����1�� ������ȣ�� : ${name},  ${name.class.name}"
		this.name = name;
	}
    VendorWithCtor(name, product) {             //#1
		println "�Ķ����2�� ������ȣ��  : ${name}, ${product}"
        this.name    = name
        this.product = product
    }
}

def first = new VendorWithCtor('Canoo','ULC_�Ϲ����� ����')   //#2 �Ϲ����� ������ȣ��
def first2 = new VendorWithCtor()   //#2 �Ϲ����� ������ȣ��

def second = ['Canoo','ULC_���� ����ȯ'] as VendorWithCtor  //#3 ���� ����ȯ
def second2 = [] as VendorWithCtor  //#3 ���� ����ȯ
Map map = [a:1,b:2,c:3];
def second3 = map as VendorWithCtor  //#3 ���� ����ȯ �̰Ǿȵȴ�..����Ʈ��ź��.. Map����������..
//def second = ['Canoo','ULC'].asType(VendorWithCtor)  //#3 ���� ����ȯ 

VendorWithCtor third = ['Canoo','ULC_�Ϲ��� ����ȯ']          //#4 �Ϲ��� ����ȯ
VendorWithCtor third2 = ['Canoo �Ϲ��� ����ȯ']          //#4 �Ϲ��� ����ȯ