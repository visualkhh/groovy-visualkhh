package _8

def map = [a:[b:[c:1]]]           

assert map.a.b.c == 1		//�Ϲ���������

if (map && map.a && map.a.x){           //#1        �򰡴�����    
	assert false;
    assert map.a.x.c == null
}    
            
//������Ʈ �߻������� ����ó���� ������Ѵ�.. �Ϲ�����ó��..  a�ȿ���x�� ������..
try {
    assert map.a.x.c == null
} catch (NullPointerException npe){     //#2
	println "NullPointerException : ${npe}"
}
 
//�����ϰ� �����ϴ�  ? �����ڸ� �����Ѵ� �̿����ڴ� �տ� �ִ� ���� ������ null�̸� ���� �ؼ����� ǥ������ �����ϰ� null�����Ѵ�.
assert map?.a?.x?.c == null             //#3
println 'map?.a?.x?.c '+map?.a?.x?.c
/*
���
NullPointerException : java.lang.NullPointerException: Cannot get property 'c' on null object
map?.a?.x?.c null
*/