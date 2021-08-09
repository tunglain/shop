package com.tunglain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Product {
    //屬性 field , property
    protected int id;  //成員, Member , instance
    String name; //成員, Member
    int price = 1 ; //成員, Member
    float discount = 1.0f;
    Category category;

    public Product() {
        super();
    }

    public Product(String name, Category category) {
        this.id = 0;
        this.name = name;
        this.category = category;
    }

    public Product(int id,Category category,String name,int price) {
        this(id,name,price);
        this.category = category;
    }

    //Constructor
    public Product(int id,String name,int price) {
        this(name,price);
        this.id = id;
    }

    public Product(String name,int price) {
        this.name = name;
        this.price = price;
    }

    //Encapsulation 封裝
    public static List<Product> getProductsFromFile() {
        List<Category> categories = Category.getCategories();
        List<Product> products = new ArrayList<>();
        HashMap<String,String> categoriesMap = new HashMap<>();
        for (Category category : categories) {
            categoriesMap.put(String.valueOf(category.id),category.name);
        }
        try {
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                //TODO : possible bug for index
                int categoryId = Integer.parseInt(tokens[1]);
                String categoryName = categoriesMap.get(String.valueOf(categoryId));
//                Category category = categories.get(Integer.parseInt(tokens[1])-1);
                Category category = new Category(categoryId,categoryName);
                String name = tokens[2];
                int price = Integer.parseInt(tokens[3]);
                Product product;
                if (tokens.length > 4) {
                    float discount = Float.parseFloat(tokens[4]);
                    product = new SalesProduct(id,category,name , price,
                            discount);
                } else {
                    product = new Product(id,category,name , price);
                }
                products.add(product);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    //方法 method
    void publish() { //成員, Member

    }

    public boolean isOnSale() {
        if (discount < 1.0f) {
            return true;
        }else return false;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + getPrice() ;
    }
}
