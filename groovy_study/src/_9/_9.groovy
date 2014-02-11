package _9

import java.util.Map;

class VendorWithCtor {                      
    String name, product
    VendorWithCtor(){
    	println "디폴트 생성자"
	}
	
    VendorWithCtor(Map map){
    	println "Map 파라미터1개 생성자호출 : ${map},  ${map.class.name}"
    	this.name = name;
    }
	VendorWithCtor(name){
    	println "파라미터1개 생성자호출 : ${name},  ${name.class.name}"
		this.name = name;
	}
    VendorWithCtor(name, product) {             //#1
		println "파라미터2개 생성자호출  : ${name}, ${product}"
        this.name    = name
        this.product = product
    }
}

def first = new VendorWithCtor('Canoo','ULC_일반적인 생성')   //#2 일반적은 생성자호출
def first2 = new VendorWithCtor()   //#2 일반적은 생성자호출

def second = ['Canoo','ULC_강제 형변환'] as VendorWithCtor  //#3 강제 형변환
//def second = ['Canoo','ULC'].asType(VendorWithCtor)  //#3 강제 형변환 
def second2 = [] as VendorWithCtor  //#3 강제 형변환
Map map = [a:1,b:2,c:3];
def second3 = map as VendorWithCtor  //#3 강제 형변환 이건안된다..디폴트가탄다.. Map이있지만도..

VendorWithCtor third = ['Canoo','ULC_암묵적 형변환']          //#4 암묵적 형변환
VendorWithCtor third2 = ['Canoo 암묵적 형변환']          //#4 암묵적 형변환


/*
결과
파라미터2개 생성자호출  : Canoo, ULC_일반적인 생성
디폴트 생성자
파라미터1개 생성자호출 : [Canoo, ULC_강제 형변환],  java.util.ArrayList
파라미터1개 생성자호출 : [],  java.util.ArrayList
디폴트 생성자
파라미터2개 생성자호출  : Canoo, ULC_암묵적 형변환
파라미터1개 생성자호출 : Canoo 암묵적 형변환,  java.lang.String
*/
