package integration.spring.java;

import integration.spring.groovy.Circle;
import integration.spring.groovy.MaxAreaInfo;
import integration.spring.common.Shape;

public class ShapeInfoMain
{
    public static void main(String[] args) {
        Shape s = new Square(7);
        Shape c = new Circle(4);
        new MaxAreaInfo().displayInfo(s, c);
        new MaxPerimeterInfo().displayInfo(s, c);
    }
}
