package com.tunglain.db;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//建立資料庫 box
//建立表格 box
//建立2-3筆郵便箱資料 id ,name, length ,width, height ,price
public class BoxExam {
    public static void main(String[] args) {
        // connect to database(localhost)
        Scanner scanner = new Scanner(System.in);
        List<Box> boxes = Box.getBoxList();
        //price sort
        boxes.sort(Comparator.comparing(Box::getPrice));
        for (Box box : boxes) {
            System.out.println(box);
        }
        try {
            //Please enter your object length :
            System.out.print("Please enter your object length:");
            int length = Integer.parseInt(scanner.next());
            //Please enter your object width :
            System.out.print("Please enter your object width:");
            int width = Integer.parseInt(scanner.next());
            //Please enter your object height :
            System.out.print("Please enter your object height:");
            int height = Integer.parseInt(scanner.next());
            boolean matched = false;
            //box name, price or no box for you
            for (Box box : boxes) {
                if (box.validate(length, width, height)) {
                    System.out.println("Please choose " + box.name + " , price is " + box.price);
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                System.out.println("No box for your object");
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("你輸入的不是數字,請重新輸入數字");
        }
    }
}
