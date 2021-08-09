package com.tunglain.box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxTester {
    public static void main(String[] args) {
        /*List<Box> boxes = new ArrayList<>();
        boxes.add(new Box1());
        boxes.add(new Box2());
        boxes.add(new Box3());*/
        List<Box> boxes = Arrays.asList(
                new Box1(),
                new Box2(),
                new Box3()
        );
        int length = 3;
        int width = 14;
        int height = 6;
        boolean matched = false;
        for (Box box : boxes) {
            if (box.validate(length,width,height)) {
                System.out.println("Please choose Box " + box.name);
                matched = true;
                break;
            }
        }
        if(!matched) {
            System.out.println("No box for your object");
        }
//        Box1 box1 = new Box1();
//        Box2 box2 = new Box2();
//        if (box1.validate(length,width,height)) {
//            System.out.println("Please choose Box #1");
//        } else if (box2.validate(length,width,height)) {
//            System.out.println("Please choose Box #2");
//        } else {
//            System.out.println("No box for your object");
//        }
    }
}
