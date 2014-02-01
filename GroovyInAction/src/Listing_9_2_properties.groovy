class MyClass {
    def first = 1                   // read-write property
    def getSecond() { first * 2 }   // read-only  property
    public third = 3                // public field property
}

obj = new MyClass()

keys = ['first','second','third',
        'class','__timeStamp','metaClass']
assert obj.properties.keySet() == new HashSet(keys)

assert 1 == obj.properties['first']             //|#1
assert 1 == obj.properties.first                //|#1

assert 1 == obj.first                           //|#2
assert 1 == obj['first']    // getAt('first')   //|#2

one = 'first'
two = 'second'
obj[one] = obj[two]         // putAt(one)       //#3
assert obj.dump() =~ 'first=2'                  //#4