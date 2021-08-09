package com.tunglain.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Box {
    int id;
    String name;
    int length;
    int width;
    int height;
    int price;

    public Box(int id, String name, int length, int width, int height, int price) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static List<Box> getBoxList() {
        List<Box> boxes = new ArrayList<>();
        //TODO:  read Box from database
        try {
            //1. JDBC Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. 連線資料庫, URL String
            String connectionUrl = "jdbc:sqlserver://tunglain;database=box;user=test1234;password=test1234;";
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from box");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name =resultSet.getString("name");
                int length = resultSet.getInt("length");
                int width = resultSet.getInt("width");
                int height = resultSet.getInt("height");
                int price = resultSet.getInt("price");
                boxes.add(new Box(id,name,length,width,height,price));
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boxes;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + length + "\t" + width + "\t" + height + "\t" + price;
    }

    public boolean validate (int length, int width , int height) {
        return  length<=this.length && width<=this.width && height<=this.height;
    }
}
