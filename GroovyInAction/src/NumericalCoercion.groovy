types = [(byte)1,(short)1,(int)1,(char)1,1L,1F,1D,1G,1.0G]
names = types.collect{ align(shortname(it)) }

// header
print align(' ')
print names.join('')
println ''

// each combination
for (i in 0..types.size()-1){
    print names[i]
    for (j in 0..types.size()-1){
        try {print align(shortname(types[i]+types[j]))}
        catch(Throwable t){print align('n/a')}
    }
    println ''
}

def shortname(obj){
    obj.class.name - 'java.' - 'lang.' - 'math.'
}
def align(str){
    str.padLeft(11)
}