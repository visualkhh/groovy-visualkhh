steps = 0
primeCache = [2]
 
int half(x) { x.intdiv(2) + 1 } 
 
boolean isPrime(x) {
    if (primeCache.contains(x)) return true 
    (2..<half(x)).every {y -> x % y != 0 } ? 
        primeCache << x : 
        false
}
 
int primeBelow(x) { (x..1).find { isPrime(it) } }
 
List primeFactors(x) {    
    if (isPrime(x)) return [x]
    int p = primeBelow(half(x))
    while (p > 1) {
        if (x % p == 0) return [p, *primeFactors(x.intdiv(p))]
        p = primeBelow(p-1)
    }
}
 
use (ModCountCategory.class) { 
    for (n in 1000..1010) { 
        ModCountCategory.count = 0
        factors = primeFactors(n)
        println "$n : $factors".padRight(30) + "(in " + "${ModCountCategory.count}".padLeft(5) + " steps)" 
        assert n == factors.inject(1){result, item -> result *= item }
    }
}

class ModCountCategory {
    static int count = 0
    static int mod(Integer self, Integer argument) {
        count++
        int x = self.intdiv(argument)
        return self - argument*x        
    }
}