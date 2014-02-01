/** XXX todo filescanner currently broken
def files = new AntBuilder().fileScanner {
    fileset(dir: '.') {
        include(name: 'Listing*.groovy')
    }
}
def scriptName = getClass().name + '.groovy'
assert files.collect{ it.name }.contains(scriptName)
y = 1
println y
*/