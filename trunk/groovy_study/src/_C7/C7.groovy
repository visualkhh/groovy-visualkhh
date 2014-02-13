package _C7

def outFile = new File('data/out')

def lines = ['line one','line two','line three']

outFile.write(lines[0..1].join("\n"))             //|#1  덮어 쓰기  0,1 합쳐라 \n으로  그뒤에써라

outFile.append("\n"+lines[2])                     //|#1 붙여쓰기. 3번째꺼 붙여써라

println  outFile.readLines()

outFile.withWriter { writer ->                    //|#2 withWriter는 writer를 클로저에 보낸다
    writer.writeLine(lines[0])                    //|#2 덮어쓰기
}                                                 //|#2
println  outFile.readLines()
outFile.withWriterAppend('ISO8859-1') { writer -> //|#2  붙여쓰기.
	writer.writeLine(lines[1])
//    writer << lines[1] << "\n"                    //|#2
}
println  outFile.readLines()
outFile << lines[2]                               //|#3 붙여쓰기
println  outFile.readLines()
/*결과
[line one, line two, line three]
[line one]
[line one, line two]
[line one, line two, line three]
*/