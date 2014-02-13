package _C7

def outFile = new File('data/out')

def lines = ['line one','line two','line three']

outFile.write(lines[0..1].join("\n"))             //|#1  ���� ����  0,1 ���Ķ� \n����  �׵ڿ����

outFile.append("\n"+lines[2])                     //|#1 �ٿ�����. 3��°�� �ٿ����

println  outFile.readLines()

outFile.withWriter { writer ->                    //|#2 withWriter�� writer�� Ŭ������ ������
    writer.writeLine(lines[0])                    //|#2 �����
}                                                 //|#2
println  outFile.readLines()
outFile.withWriterAppend('ISO8859-1') { writer -> //|#2  �ٿ�����.
	writer.writeLine(lines[1])
//    writer << lines[1] << "\n"                    //|#2
}
println  outFile.readLines()
outFile << lines[2]                               //|#3 �ٿ�����
println  outFile.readLines()
/*���
[line one, line two, line three]
[line one]
[line one, line two]
[line one, line two, line three]
*/