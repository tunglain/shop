package com.tunglain;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        //購物
        //商品 : id,名,price
        int n = 10;

//        List<Category> categories = Category.getCategories();
//        for (Category category : categories) {
//            System.out.println(category.name);
//        }

        List<Product> products = Product.getProductsFromFile();
        for (Product product : products) {
            if (product instanceof SalesProduct)
            {
                System.out.print("*");
            }
//            System.out.println(product.name + "*");
            System.out.println(product);
        }

        Product toothbrush = new Product("牙刷",Category.CATEGORY_LIFE);
//        Product toothbrush = new Product("牙刷",categories.get(0));
//        Product toothbrush = new Product(1,"牙刷",150); //call constructor
//        toothbrush.id = 1;
//        toothbrush.name = "牙刷";
//        toothbrush.price = 150;
        toothbrush.publish();

        Product mouse = new Product("滑鼠",Category.CATEGORY_COMPUTER);
//        Product mouse = new Product("滑鼠",categories.get(1));
//        Product mouse = new Product("滑鼠",199);
//        mouse.id = 2;
//        mouse.name = "滑鼠";
//        mouse.price = 199;

        OrderItem item = new OrderItem(mouse,3);
        OrderItem item2 = new OrderItem(toothbrush);
//        System.out.println(mouse.id);

    }
}
