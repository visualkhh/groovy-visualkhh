import junit.framework.*
import com.clarkware.junitperf.*
import temp.src.*

class RegexFilterPerfGTest extends TestCase {

  RegexFilterPerfGTest(test){
    super(test)                                        //#1
  }

  void testOr() {                                      //#2
    def filter = new RegexPackageFilter("java|org")
    assertTrue("value should be true",
      filter.applyFilter("org.sf.String"))
  }

  static main(args) {
    junit.textui.TestRunner.run(suite())
  }

  static Test suite() {
    def testCase = new RegexFilterPerfGTest("testOr")  //#3
    //20 users for load staggered at 100 ms
    def loadTest = new LoadTest(testCase, 20,          //#4
        new ConstantTimer(100))
    //each thread must return within 2100 ms
    return new TimedTest(loadTest, 2010)               //#5
  }
}
