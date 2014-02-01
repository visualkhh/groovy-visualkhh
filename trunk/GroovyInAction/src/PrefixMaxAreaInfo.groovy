import integration.spring.common.Shape
import integration.spring.common.ShapeInfo

class PrefixMaxAreaInfo implements ShapeInfo {
    String prefix
    void displayInfo(Shape s1, Shape s2) {
        print prefix + ": The shape with the biggest area is: "
        if (s1.area() > s2.area()) println s1 else println s2
    }
}
