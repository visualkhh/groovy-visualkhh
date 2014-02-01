def a = 1
def log = ''
switch (a) {
    case 0  : log += '0' //#1
    case 1  : log += '1' //#1
    case 2  : log += '2' ; break
    default : log += 'default'
}
assert log == '12'