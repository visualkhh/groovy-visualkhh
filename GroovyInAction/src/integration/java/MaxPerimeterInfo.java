package integration.java;

import integration.common.Shape;

public class MaxPerimeterInfo {
    void displayInfo(Shape s1, Shape s2) {
        System.out.print("The shape with the biggest perimeter is: ");
        System.out.println(s1.perimeter() > s2.perimeter() ? s1.getClass().getName()
                                                           : s2.getClass().getName());
    }
}
