if (false) assert false                     //#1

if (null)                                   //#2
{                                           //#3
    assert false
} 
else 
{
    assert true
}

def i = 0                                   //#|4
while (i < 10) {                            //#|4
    i++                                     //#|4
}                                           //#|4
assert i == 10                              //#|4

def clinks = 0                              //#|5
for (remainingGuests in 0..9) {             //#|5
    clinks += remainingGuests               //#|5
}                                           //#|5
assert clinks == (10*9)/2                   //#|5

def list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]   //#|6
for (j in list) {                           //#|6
    assert j == list[j]                     //#|6
}                                           //#|6

list.each() { item ->                       //#|7
    assert item == list[item]               //#|7
}                                           //#|7

switch(3)  {                                //#|8
    case 1 : assert false; break            //#|8
    case 3 : assert true;  break            //#|8
    default: assert false                   //#|8
}                                           //#|8