class Summer {
    def sumWithDefaults(a, b, c=0){                         //#1
        return a + b + c
    }
    def sumWithList(List args){                             //#2
        return args.inject(0){sum,i -> sum += i}
    }    
    def sumWithOptionals(a, b, Object[] optionals){         //#3
        return a + b + sumWithList(optionals.toList())
    }
    def sumNamed(Map args){                                 //#4
    	println "map Arg1 ${args}"
        ['a','b','c'].each{args.get(it,0)}
        return args.a + args.b + args.c
    }
    def sumNamed(Map args,Map args1,Map args2){                                 //#4
		println "map Arg3 ${args}, ${args1}, ${args2}"
		return 3;
    }
}

def summer = new Summer()

assert 2 == summer.sumWithDefaults(1,1)
assert 3 == summer.sumWithDefaults(1,1,1)

assert 2 == summer.sumWithList([1,1])
assert 3 == summer.sumWithList([1,1,1])

assert 2 == summer.sumWithOptionals(1,1)
assert 3 == summer.sumWithOptionals(1,1,1)
assert 6 == summer.sumWithOptionals(1,1,1,1,1,1)

assert 2 == summer.sumNamed(a:1, b:1)
assert 3 == summer.sumNamed(a:1, b:1, c:1)
assert 1 == summer.sumNamed(c:1)
assert 3 == summer.sumNamed([a:1, b:1, c:1])
assert 3 == summer.sumNamed([a:1, b:1, c:1],[a:1, b:1, c:1],[a:1, b:1, c:1])