import java.util.logging.*

class LoggingCalculatorTest extends GroovyLogTestCase {
    static final MIXED_NUMBERS = [99, 2, 1, 0, -1, -2, -99]
    private calc

    void setUp() {
        calc = new LoggingCalculator()
    }

    void testCalculatorAndLog(){
        def capturedLog = stringLog(Level.FINER, 'LoggingCalculator') {    //#1
            assertEquals(4, calc.countHowManyBiggerThan(MIXED_NUMBERS, -1))
        }
        checkLogCount(1, "was equal", capturedLog)
        checkLogCount(4, "was bigger", capturedLog)
        checkLogCount(2, "was smaller", capturedLog)
        checkLogCount(4, /[^d][^o][^n][^'][^t] count this one/, capturedLog) // too long for typesetting < 68
        checkLogCount(3, "don't count this one", capturedLog)
    }

    private checkLogCount(expectedCount, regex, log) {
        def matcher = (log =~ regex)
        assertEquals log, expectedCount, matcher.count
    }
}
