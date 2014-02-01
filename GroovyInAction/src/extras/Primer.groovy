boolean isPrime(int x) {
    ! (2..<x).any { y ->  x % y == 0 }
}

for (i in 1..100) {
    println "$i : ${isPrime(i)}"
}