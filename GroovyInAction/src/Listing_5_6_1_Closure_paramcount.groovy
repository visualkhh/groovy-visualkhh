def caller (Closure closure){
    closure.getParameterTypes().size()
}

assert caller { one -> }      == 1
assert caller { one, two -> } == 2