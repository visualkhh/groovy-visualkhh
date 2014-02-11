package _7

import java.util.List;
import java.util.Map;

class Summer {
    def sumWithDefaults(a, b, c=0){                         //#1
        return a + b + c
    }
    def sumWithList(List args){                             //#2
        return args.inject(0){sum,i -> sum += i}//0�ʱⰪ�����ְ�(������sum) list���ڸ�ŭ ����.(���ڰ�:i)
    }    
    def sumWithOptionals(a, b, Object[] optionals){         //#3
        return a + b + sumWithList(optionals.toList())
    }
    def sumNamed(Map args){                                 //#4
		['a','b','c'].each{args.get(it,0)}		//�ʱⰪ�ο� 
        return args.a + args.b + args.c
    }
    def sumNamed(Map args,Map args1,Map args2){                                 //#4
		return 3;
    }
}

def summer = new Summer()

//#1ȣ��
assert 2 == summer.sumWithDefaults(1,1)		
assert 3 == summer.sumWithDefaults(1,1,1)	
println  'summer.sumWithDefaults(1,1)		:'+summer.sumWithDefaults(1,1)		
println  'summer.sumWithDefaults(1,1,1)     :'+summer.sumWithDefaults(1,1,1)

//#2ȣ��
assert 2 == summer.sumWithList([1,1])		
assert 3 == summer.sumWithList([1,1,1])		
println 'summer.sumWithList([1,1])	    : '+summer.sumWithList([1,1])	
println 'summer.sumWithList([1,1,1])	: '+summer.sumWithList([1,1,1])	


//#3ȣ��
assert 2 == summer.sumWithOptionals(1,1)
assert 3 == summer.sumWithOptionals(1,1,1)
assert 6 == summer.sumWithOptionals(1,1,1,1,1,1)
println    'summer.sumWithOptionals(1,1)          :'+summer.sumWithOptionals(1,1)          
println    'summer.sumWithOptionals(1,1,1)        :'+summer.sumWithOptionals(1,1,1)        
println    'summer.sumWithOptionals(1,1,1,1,1,1)  :'+summer.sumWithOptionals(1,1,1,1,1,1)  


//mapȣ��
assert 2 == summer.sumNamed(a:1, b:1)		
assert 3 == summer.sumNamed(a:1, b:1, c:1)
assert 1 == summer.sumNamed(c:1)
assert 3 == summer.sumNamed([a:1, b:1, c:1])
assert 3 == summer.sumNamed([a:1, b:1, c:1],[a:1, b:1, c:1],[a:1, b:1, c:1])
println 'summer.sumNamed(a:1, b:1)		                                 :'+summer.sumNamed(a:1, b:1)		                                 
println 'summer.sumNamed(a:1, b:1, c:1)                                  :'+summer.sumNamed(a:1, b:1, c:1)                                    
println 'summer.sumNamed(c:1)                                            :'+summer.sumNamed(c:1)                                              
println 'summer.sumNamed([a:1, b:1, c:1])                                :'+summer.sumNamed([a:1, b:1, c:1])                                  
println 'summer.sumNamed([a:1, b:1, c:1],[a:1, b:1, c:1],[a:1, b:1, c:1]):'+summer.sumNamed([a:1, b:1, c:1],[a:1, b:1, c:1],[a:1, b:1, c:1])  

/*
���
summer.sumWithDefaults(1,1)		:2
summer.sumWithDefaults(1,1,1)     :3
summer.sumWithList([1,1])	    : 2
summer.sumWithList([1,1,1])	: 3
summer.sumWithOptionals(1,1)          :2
summer.sumWithOptionals(1,1,1)        :3
summer.sumWithOptionals(1,1,1,1,1,1)  :6
summer.sumNamed(a:1, b:1)		                                 :2
summer.sumNamed(a:1, b:1, c:1)                                  :3
summer.sumNamed(c:1)                                            :1
summer.sumNamed([a:1, b:1, c:1])                                :3
summer.sumNamed([a:1, b:1, c:1],[a:1, b:1, c:1],[a:1, b:1, c:1]):3

*/
