package integration.alljava;

public class MaxAreaInfo {
    void displayInfo(Square s, Circle c) {
        System.out.print("The shape with the biggest area is: ");
        System.out.println(s.area() > c.area() ? "square" : "circle");
    }
}
