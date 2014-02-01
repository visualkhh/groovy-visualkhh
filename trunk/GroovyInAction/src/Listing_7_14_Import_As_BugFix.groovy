import thirdparty.MathLib as OrigMathLib

class MathLib extends OrigMathLib {
    Integer twice(Integer value) {
        return value * 2
    }
}

// nothing changes below here       //#1
def mathlib = new MathLib()

assert 10 == mathlib.twice(5)       //#2
assert 2 == mathlib.half(5)         //#3