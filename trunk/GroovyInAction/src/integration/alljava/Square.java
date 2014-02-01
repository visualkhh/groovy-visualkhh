package integration.alljava;

import integration.common.Shape;

public class Square implements Shape {
    private double side;
    Square(double side) { this.side = side; }
    public double area() { return side * side; }
    public double perimeter() { return 4 * side; }
}
