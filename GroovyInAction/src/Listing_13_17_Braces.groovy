def source = new File(args[0]).text

def nesting = 0
def maxnest = 0

for (c in source) {
    switch (c) {
        case '{' : nesting++
                   if (nesting > maxnest) maxnest++
                   break
        case '}' : nesting--
                   break
    }
}
println maxnest