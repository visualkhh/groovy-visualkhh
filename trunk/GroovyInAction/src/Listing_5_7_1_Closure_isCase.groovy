assert [1,2,3].grep{ it<3 } == [1,2]

switch(10){
    case {it%2 == 1} : assert false
}