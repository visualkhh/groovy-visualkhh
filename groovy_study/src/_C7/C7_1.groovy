package _C7

//reader = new StringReader('abc')
//writer = new StringWriter()
//
//writer << "\nsome String"   << "\n"
//writer << [a:1, b:2]        << "\n"
//writer << [3,4]             << "\n"
//writer << new Date(0)       << "\n"
//writer << reader            << "\n"
//
//assert writer.toString() == '''
//some String
//["a":1, "b":2]
//[3, 4]
//Thu Jan 01 01:00:00 CET 1970
//abc
//'''

/////////

def r =  new File('data/text')
def w =  new File('data/out')
r.eachLine{  reader ->
	w<<reader<< "\n"	//이렇게하면 어떻게될까?ㅎㅎ
}