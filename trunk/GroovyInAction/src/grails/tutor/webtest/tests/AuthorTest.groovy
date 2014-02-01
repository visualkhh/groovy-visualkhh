
class AuthorTest extends grails.util.WebTest {

    // Unlike unit tests, functional tests are often sequence dependent.
    // Specify that sequence here.
    void suite() {
        testAuthorListNewDelete()
        // add tests for more operations here
    }

    def testAuthorListNewDelete() {
        webtest('Author basic operations: view list, create new entry, back to view, delete, view'){
            invoke(url:'author')
            verifyText(text:'Home')

            verifyListPage(0)

            clickLink(label:'New Author')
            verifyText(text:'Create Author')
            clickButton(label:'Create')
            verifyText(text:'Show Author', description:'Detail page')
            clickElement(xpath:"//button[text()='Back']")

            verifyListPage(1)

            clickLink(href:'delete', description:'delete the first element (there is only one)')
            verifyXPath(xpath:"//div[@class='message']", text:/Author.*deleted./, regex:true)

            verifyListPage(0)

    }   }

    String ROW_COUNT_XPATH = "count(//td[@class='actionButtons']/..)"

    def verifyListPage(int count) {
        ant.group(description:"verify Author list view with $count row(s)"){
            verifyText(text:'Author List')
            verifyXPath(xpath:ROW_COUNT_XPATH, text:count, description:"$count row(s) of data expected")
    }   }

}