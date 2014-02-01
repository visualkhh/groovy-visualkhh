class Listing_13_x3 extends GroovyTestCase {
    static final TEST_KEY = new Object()
    static final TEST_MAP = [key1: new Object(), key2: new Object()]

    void testBadInitialSize() {
        shouldFail(IllegalArgumentException) {
            new Hashtable(-1)
        }
    }

    void testHashtableRejectsNull() {
        shouldFail(NullPointerException) {
            new Hashtable().put(TEST_KEY, null)
        }
    }

    void testHashMapAcceptsNull() {
        def myMap = new HashMap()
        myMap.put(TEST_KEY, null)
        assert myMap.keySet().contains(TEST_KEY) 
    }

    void testHashMapReturnsOriginalObjects() {
        def myMap = new HashMap()
        TEST_MAP.entrySet().each {
            def myVal = TEST_MAP.get(it)
            myMap.put(it, myVal)
            assertSame(myVal, myMap.get(it))
        }
        assert TEST_MAP.dump().contains('java.lang.Object')
        assert myMap.size() == TEST_MAP.size()
    }
}
