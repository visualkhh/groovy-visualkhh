twister = 'she sells sea shells at the sea shore of seychelles'
// some more complicated regex: 
// word that starts and ends with same letter
regex = /\b(\w)\w*\1\b/

start = System.currentTimeMillis()
100000.times{
    twister =~ regex                        //#1
}
first = System.currentTimeMillis() - start

start = System.currentTimeMillis()
pattern = ~regex                            //#2
100000.times{
    pattern.matcher(twister)                //#3
}
second = System.currentTimeMillis() - start

assert first > second * 1.20
