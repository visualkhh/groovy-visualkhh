package integration.java;

import integration.groovy.Circle;
import integration.groovy.MaxAreaInfo;
import integration.common.Shape;

public class ShapeInfoMain
{
    public static void main(String[] args) {
        Shape s = new Square(7);
        Shape c = new Circle(4);
        new MaxAreaInfo().displayInfo(s, c);
        new MaxPerimeterInfo().displayInfo(s, c);
    }
}
