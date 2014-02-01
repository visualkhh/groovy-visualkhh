class SomeClass {
    def       someProperty
    public    someField
    private   somePrivateField
}

def obj = new SomeClass()

def store = []
obj.properties.each { property ->
    store += property.key
    store += property.value
}
assert store.contains('someProperty')
assert store.contains('someField')        == false 
assert store.contains('somePrivateField') == false
assert store.contains('class')
assert store.contains('metaClass')

assert obj.properties.size() == 3