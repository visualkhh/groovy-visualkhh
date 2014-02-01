def builder = new NodeBuilder()
builder.prefs(name:'Dierk') { 
    language('Groovy')
    conference('http://www.waterfall2006.com')
    for (i in 9..17) {
        workingHour(i)
    }
}    