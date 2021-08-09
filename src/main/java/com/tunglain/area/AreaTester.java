package com.tunglain.area;

import java.util.ArrayList;
import java.util.List;

public class AreaTester {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Triangle(10,10));
        shapes.add(new Rectangle(10,10));
        shapes.add(new Triangle(20,30));
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
