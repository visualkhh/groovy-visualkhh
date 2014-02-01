def source = new File(args[0]).text

def nesting = 0
def maxnest = 0

for (c in source) {
    switch (c) {
        case "{":<POST_INC>nesting</POST_INC>
            if (nesting > maxnest) <POST_INC>maxnest</POST_INC>
            break
        case "}":<POST_DEC>nesting</POST_DEC>
            break
    }
}


println(maxnest)