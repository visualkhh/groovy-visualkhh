package integration.spring.java;

import integration.spring.common.Shape;
import integration.spring.common.ShapeInfo;

import java.lang.reflect.Constructor;

public class ShapeInfoFactoryMain
{
    public static void main(String[] args) {
        try {
            Shape s = new Square(7);
            Class groovyCircle = Class.forName("integration.spring.groovy.Circle");
            Class groovyMaxAreaInfo = Class.forName("integration.spring.groovy.MaxAreaInfo");
            Constructor cons = groovyCircle.getConstructors()[0];
            Shape c = (Shape) cons.newInstance(4);
            ShapeInfo info = (ShapeInfo) groovyMaxAreaInfo.newInstance();
            info.displayInfo(s, c);
            new MaxPerimeterInfo().displayInfo(s, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
