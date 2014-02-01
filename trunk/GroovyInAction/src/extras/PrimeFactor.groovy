boolean isPrime(x) {
    return ! (2..<x).any { y -> x % y == 0 }
}
int primeBelow(x) {
    (x..1).find { isPrime(it) }
}
List primeFactors(x) {
    if (isPrime(x)) return [x]
    int p = primeBelow(x)
    while (p > 1) {
        if (x % p == 0) return [p, *primeFactors(x.intdiv(p))] 
        p = primeBelow(p-1)
    }    
}

for (n in 100..110) { println "$n : "+primeFactors(n)}