def map = [a:[b:[c:1]]]           

assert map.a.b.c == 1		//�Ϲ���������

if (map && map.a && map.a.x){           //#1            �򰡴�����
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