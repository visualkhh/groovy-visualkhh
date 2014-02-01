
myFairStringy = 'The rain in Spain stays mainly in the plain!'

// words that end with 'ain': \b\w*ain\b
BOUNDS = /\b/
rhyme = /$BOUNDS\w*ain$BOUNDS/
found = ''
myFairStringy.eachMatch(rhyme) { match ->                      //#1
    found += match + ' '
}
assert found == 'rain Spain plain '
println found;


found = ''
(myFairStringy =~ rhyme).each { match ->                       //#2
    found += match + ' '
}
assert found == 'rain Spain plain '
println found;

cloze = myFairStringy.replaceAll(rhyme){ it-'ain'+'___' }      //#3
assert cloze == 'The r___ in Sp___ stays mainly in the pl___!'
println cloze;