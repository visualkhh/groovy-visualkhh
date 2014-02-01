class MrBean {
    String firstname, lastname              //#1
    
    String getName(){                       //#2
        return "$firstname $lastname"
    }
}

def bean = new MrBean(firstname: 'Rowan')   //#3
bean.lastname = 'Atkinson'                  //#4

assert 'Rowan Atkinson' == bean.name        //#5