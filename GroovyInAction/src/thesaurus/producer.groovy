import org.codehaus.groovy.scriptom.ActiveXProxy

def docName = "document.xml"
def locale = "fr_FR"

def xls = new ActiveXProxy("Excel.Application")
def workbooks = xls.Workbooks.Open(new File("thesaurus.xls").canonicalPath)
def activeSheet = workbooks.ActiveSheet

def word = new ActiveXProxy("Word.Application")
word.Documents.Add()
def doc = word.ActiveDocument

def styleFormatter = [
    "Document.Title":   { it.Font.Size = 24
                          it.Font.Name = "Arial"
                          it.ParagraphFormat.Alignment = 1 },
    "Section.Title":    { it.Font.Size = 18
                          it.Font.Name = "Arial" },
    "Subsection.Title": { it.Font.Size = 14
                          it.Font.Name = "Arial" },
    "Sentence":         { it.Font.Size = 12 }
]
    
def localeColumns = [:]
for (column in 'B'..'Z') {
    def loc = activeSheet.Range("${column}1").Value.value
    if (loc == null) break;
    else localeColumns[loc] = column
}

def sentenceCodeRows = [:]
for (row in 2..1000) {
    def code = activeSheet.Range("A${row}").Value.value
    if (code == null) break;
    else sentenceCodeRows[code] = row
}

def cursorPos = 0
def xmlDoc = new XmlParser().parse(new File(docName))
xmlDoc.each{ node ->
    def column = localeColumns[locale]
    def row = sentenceCodeRows[node['@code']]
    def translation = activeSheet.Range("${column}${row}").Value.value
    
    def range = doc.Range(cursorPos, cursorPos)
    range.Text = translation + "\n"
    styleFormatter[node['@format']].call(range)
    range.Select()
    cursorPos += translation.size() + 1
}

doc.SaveAs(new File(".\\document-${locale}.doc").canonicalPath)
word.Quit()
 
workbooks.Close(false, null, false)
xls.Quit()