class HashMapAndTableTest extends GroovyTestCase {
    static final KEY = new Object()
    static final MAP = [key1: new Object(), key2: new Object()]

    void testHashtableRejectsNull() {
        shouldFail(NullPointerException) {
            new Hashtable()[KEY] = null
        }
    }

    void testBadInitialSize() {
        def msg = shouldFail(IllegalArgumentException) { //#1
            new Hashtable(-1)
        }
        assertEquals "Illegal Capacity: -1", msg         //#2
    }

    void testHashMapAcceptsNull() {
        def myMap = new HashMap()
        myMap[KEY] = null
        assert myMap.keySet().contains(KEY)
    }

    void testHashMapReturnsOriginalObjects() {
        def myMap = new HashMap()
        MAP.entrySet().each {
            myMap[it] = MAP[it]
            assertSame  MAP[it], myMap[it]
        }
        assert MAP.dump().contains('java.lang.Object')   //#3
        assert myMap.size() == MAP.size()
    }
}
