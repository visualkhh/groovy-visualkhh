def outFile = new File('data/out.txt')

def lines = ['line one','line two','line three']

outFile.write(lines[0..1].join("\n"))             //|#1
outFile.append("\n"+lines[2])                     //|#1

assert lines == outFile.readLines()

outFile.withWriter { writer ->                    //|#2
    writer.writeLine(lines[0])                    //|#2
}                                                 //|#2
outFile.withWriterAppend('ISO8859-1') { writer -> //|#2
    writer << lines[1] << "\n"                    //|#2
}
outFile << lines[2]                               //|#3

assert lines == outFile.readLines()