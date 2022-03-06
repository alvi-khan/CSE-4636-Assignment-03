package com.example.lab03_assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    static String databaseUrl = "jdbc:sqlite:D:\\Downloads\\Lab03_Assignment\\database";

    public static Item getItem(int itemID) {
        String query = "SELECT * FROM items WHERE id = ?";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(databaseUrl);
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, String.valueOf(itemID));
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Item item = new Item();
            item.id = resultSet.getInt("id");
            item.name = resultSet.getString("name");
            item.image = resultSet.getString("image");
            return item;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Item> getItems() {
        String query = "SELECT * FROM items";
        List<Item> results = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(databaseUrl);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Item item = new Item();
                item.id = resultSet.getInt("id");
                item.name = resultSet.getString("name");
                item.image = resultSet.getString("image");
                results.add(item);
            }

            conn.close();
            statement.close();
            resultSet.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
