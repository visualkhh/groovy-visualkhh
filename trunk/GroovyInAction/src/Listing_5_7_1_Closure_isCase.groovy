assert [1,2,3].grep{ it<3 } == [1,2]

switch(10){
    case {println it; it%2 == 1} : assert false
}