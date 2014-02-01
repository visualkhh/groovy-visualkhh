def listFiles(notify) {
    def names = new File('.').list()
    names.eachWithIndex { name, i ->
        notify(i * 10 / names.size(), name)
        sleep 50                                         //#1
    }
}
listFiles { filled, info ->
    print '\b' * 61
    print '#'*filled + ':'*(10-filled) +' '+ info.padRight(50)
}