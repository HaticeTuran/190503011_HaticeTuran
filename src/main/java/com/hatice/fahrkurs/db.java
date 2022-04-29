package com.hatice.fahrkurs;
import java.io.IOException;
import java.sql.*;
import java.util.Set;

public class db {
    public  static Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Acer\\IdeaProjects\\FahrKurs\\src\\main\\java\\com\\hatice\\fahrkurs\\FahrKurs.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Person (TC,Name,Nachname,Geburtsdatum) VALUES('12345678901','Hatice','Turan','01.01.2001')");
            ResultSet res = stmt.executeQuery("SELECT * FROM Person");
            if(res.next()){
                System.out.println("username: "+res.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
