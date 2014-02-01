reader = new StringReader('abc')                   
writer = new StringWriter()

reader.transformChar(writer) { it.next() }         //#1
assert 'bcd' == writer.toString()

reader = new File('data/example.txt').newReader()  
writer = new StringWriter()

reader.transformLine(writer) { it - 'line' }      //#2
assert " one\r\n two\r\n three\r\n" == writer.toString()

input  = new File('data/example.txt')
writer = new StringWriter()

input.filterLine(writer) { it =~ /one/ }          //#3
assert "line one\r\n" == writer.toString()

writer = new StringWriter()
writer << input.filterLine { it.size() > 8 }      //#4
assert "line three\r\n"  == writer.toString()
