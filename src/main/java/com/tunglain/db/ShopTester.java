package com.tunglain.db;

import java.sql.*;

public class ShopTester {
    public static void main(String[] args) {
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
                System.out.println(id);
                String name =resultSet.getString(2);
                System.out.println(name);
                int version = resultSet.getInt("version");
                System.out.println(version);
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
