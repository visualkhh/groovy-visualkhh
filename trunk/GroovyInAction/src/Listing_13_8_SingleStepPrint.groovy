def show(code) {
    for (line in code.split("\n")){
        if (!line) continue
        print line.padRight(25) + '//-> '
        println evaluate(line).inspect()        //#1
    }
}
show '''
data = [0,1,2,3]
data[1..2]
data.collect { it / 2 }
'''