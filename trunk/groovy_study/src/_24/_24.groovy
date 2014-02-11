package _24

class StringCalculationCategory {    
    static def plus(String self, String operand) {
		println 'plus String'
        try {    
            return self.toInteger() + operand.toInteger()
        }
        catch (NumberFormatException fallback){
            return (self << operand).toString()
        }
    }
	
	static def plus(def self, def operand) {
		println 'plus Def'
			return (self + operand)
	}
	
	static def plus(ArrayList self, ArrayList operand) {
		println 'plus ArrayList'
		//(self + operand) 이렇게하게되면 재귀호출이된다.  오류남
		//self.plus(operand) 이렇게하게되면 재귀호출이된다.  오류남
			int cnt = self.size;
			for (int i = 0; i < operand.size; i++) {
				self[cnt++] = operand[i]
			}
			return self;
	}
	
	         
    static def minus(String self, String operand) {
    	println 'minus String'
    	try {    
    		return self.toInteger() - operand.toInteger()
    	}
    	catch (NumberFormatException fallback){
    		return (self << operand).toString()
    	}
    }        
	
}  

//여기서부터 StringCalculationCategory 클래스의 정의를 따르겠다.
use (StringCalculationCategory.class) { 
    assert 1    == '1' + '0'
    assert 2    == '1' + '1'
    assert 'x1' == 'x' + '1'
    assert 0    == '1' - '1'
	println '------------------';
	println "'1' + '0'   :  ${('1' + '0') } "
	println "'1' + '1'   :  ${('1' + '1') } "
	println "'x' + '1'   :  ${('x' + '1') } "
	println "'1' - '1'   :  ${('1' - '1') } "
	
	println ([1,2,3,4]+[5,6,7,8]);
	
}

/*결과
plus String
plus String
plus String
minus String
------------------
plus String
'1' + '0'   :  1 
plus String
'1' + '1'   :  2 
plus String
'x' + '1'   :  x1 
minus String
'1' - '1'   :  0 
plus ArrayList
[1, 2, 3, 4, 5, 6, 7, 8]

*/
