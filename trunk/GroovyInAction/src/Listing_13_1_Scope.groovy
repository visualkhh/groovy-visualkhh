class ExplicitThisTest extends GroovyTestCase {
    def zero = 0

    def getZero() { return 1 }

    def callMePlain(zero) {
        return zero
    }
    def callMeQualified(zero) {
        return this.zero
    }

    void testZero() {
        assert 0 == zero                          //|#1
        assert 0 == this.zero                     //|#1
        assert 0 == this.@zero                    //|#1
        assert 1 == getZero()
        assert 2 == callMePlain(2)                //#2
        assert 0 == callMeQualified(2)            //#3
        assert 1 == new ExplicitThisTest().zero   //#4
        assert 0 == new ExplicitThisTest().@zero  //#5
    }
}