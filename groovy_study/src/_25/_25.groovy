package _25

class PCategory{
	static void gogoSave(Object self){
		//self �����ϴ��Լ�
		println 'gogoSave Call '+self.gogo;;
	}
}
class GG{
	def gogo=[1,3]
	GG(){	
		use (PCategory){
			gogoSave();
		}
		gogoSave();
	}
	public void gogoSave(){
		println 'GG Class gogoSave()';
	}
	
	
}

def gg = new GG();
GroovyObjectSupport 
/*���
gogoSave Call [1, 3]
GG Class gogoSave()
*/