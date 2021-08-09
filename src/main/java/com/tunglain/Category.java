package com.tunglain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Category {

    static final Category CATEGORY_LIFE = new Category(1,"生活用品");
    static final Category CATEGORY_COMPUTER = new Category(2,"電腦零組件");
//    final float PI = 3.14159f;

    int id;
    String name;
    int version = 1;

    public Category(int id ,String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Category> getDummyCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"生活用品"));
        categories.add(new Category(2,"電腦零組件"));
        return categories;
    }

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        //TODO:  read categories from database
        try {
            //1. JDBC Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. 連線資料庫, URL String
            String connectionUrl = "jdbc:sqlserver://tunglain;database=shop;user=sa;password=Tlc123456;";
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from category");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name =resultSet.getString(2);
                categories.add(new Category(id,name));
                //int version = resultSet.getInt("version");
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
