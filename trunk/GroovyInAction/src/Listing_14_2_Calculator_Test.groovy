class CalculatorTest extends GroovyTestCase {
    static final NEG_NUMBERS   = [-2, -3, -4]  //#|1
    static final POS_NUMBERS   = [ 4,  5,  6]  //#|1
    static final MIXED_NUMBERS = [ 4, -6,  0]  //#|1
    private calc

    void setUp() {                            
        calc = new Calculator()               
    }                                         

    void testCalcHowManyFromSampleNumbers() { 
        check(0, NEG_NUMBERS, -1)             //|#2
        check(0, NEG_NUMBERS, -2)             //|#2
        check(2, NEG_NUMBERS, -4)             //|#2
        check(3, NEG_NUMBERS, -5)             //|#2
        check(0, POS_NUMBERS,  7)             //|#2
        check(0, POS_NUMBERS,  6)             //|#2
        check(2, POS_NUMBERS,  4)             //|#2
        check(3, POS_NUMBERS,  3)             //|#2
        check(0, MIXED_NUMBERS,  5)           //|#2
        check(1, MIXED_NUMBERS,  2)           //|#2
        check(1, MIXED_NUMBERS,  1)           //|#2
        check(1, MIXED_NUMBERS,  0)           //|#2
        check(2, MIXED_NUMBERS, -1)           //|#2
        check(3, MIXED_NUMBERS, -7)           //|#2
    }

    void testInputDataUnchanged() {           //#3
        def numbers = NEG_NUMBERS.clone()
        def origLength = numbers.size()
        calc.countHowManyBiggerThan(numbers, 0 /* don't care */)
        assertLength(origLength, numbers.toArray())
        assertArrayEquals(NEG_NUMBERS.toArray(), numbers.toArray())
    }

    void testCalcHowManyFromSampleStrings() { //#4
        check(2, ['Dog', 'Cat', 'Antelope'], 'Bird')
    }

    void testInputDataAssumptions() {         //#5
        assertTrue(NEG_NUMBERS.every{ it < 0 })
        assertTrue(POS_NUMBERS.every{ it > 0 })
        assertContains(0, MIXED_NUMBERS as int[])
        def negCount = 0
        def posCount = 0
        MIXED_NUMBERS.each { 
            if (it < 0) negCount++ else if (it > 0) posCount++ 
        }
        assert negCount > 0 && posCount > 0
    }

    private check(expectedCount, items, target) {
        assertEquals(
            expectedCount, 
            calc.countHowManyBiggerThan(items, target)
        )
    }
}

class Calculator {                              //|#6
    def countHowManyBiggerThan(items, target) { //|#6
        return items.grep{ it > target }.size() //|#6
    }                                           //|#6
}                                               //|#6