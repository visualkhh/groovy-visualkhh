def a = 1
while (true) {          //#1
    a++
    break               //#2
}
assert a == 2

for (i in 0..10) {
    if (i==0)  continue //#3
    a++
    if (i > 0) break    //#4
}
assert a==3