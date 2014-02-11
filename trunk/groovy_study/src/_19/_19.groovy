package _19

class MrBean {
    String firstname, lastname              //#1 
    
    String getName(){                       //#2 가상 프로퍼티의 생성자 가상의name이생긴거다/
        return "$firstname $lastname"
    }
}

def bean = new MrBean(firstname: 'Rowan')   //#3
bean.lastname = 'Atkinson'                  //#4

assert 'Rowan Atkinson' == bean.name        //#5 자동으로 생긴name 읽고 쓰고한다.
println bean.name ;
/*결과
Rowan Atkinson
*/