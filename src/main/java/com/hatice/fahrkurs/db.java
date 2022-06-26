package com.hatice.fahrkurs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Set;

public class db {

    public  static Connection conn = null;
    public static Statement stmt;

    public static void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Acer\\IdeaProjects\\FahrKurs\\src\\main\\java\\com\\hatice\\fahrkurs\\FahrKurs.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            //Statement stmt = conn.createStatement();
            /*stmt.executeUpdate("INSERT INTO Person (TC,Name,Nachname,Geburtsdatum) VALUES('12345678901','Hatice','Turan','01.01.2001')");
            ResultSet res = stmt.executeQuery("SELECT * FROM Person");
            if(res.next()){
                System.out.println("username: "+res.getString("Name"));
            }*/
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static ResultSet ListSchueler(){
        //this.connect();
        ResultSet res;
        try{
            res = stmt.executeQuery("SELECT * FROM FahrSchueler");
        }catch (Exception e){
            System.out.println(e);
        }

        return res;
    }*/

    // Kontroliere, on eine solche Personal in db gibt
    public static Boolean containPersonal(String userName, String pass){
        //this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT BenutzerName , Passwort FROM Personal");
            while (res.next()){
                String s1 = res.getString("BenutzerName");
                String s2 = res.getString("Passwort");
                if(s1.equals(userName) && s2.equals(pass)){
                    return true;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // Lİst of students
    public static ObservableList<Fahrschueler> listSchueler(){
        ObservableList<Fahrschueler> arr = FXCollections.observableArrayList();

        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT FahrSchueler.TC_No, Person.Name, Person.Nachname  FROM Person, FahrSchueler WHERE Person.TC == FahrSchueler.TC_No");
            while (res.next()){
                String s1 = res.getString("TC_No");
                String s2 = res.getString("Name");
                String s3 = res.getString("Nachname");
                //Fahrschueler f = new Fahrschueler(s1,s2,s3);
                //arr.add(f);
                arr.add(new Fahrschueler(s1,s2,s3));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    // Schueler löschen
    public static void deleteSchueler(String TC){
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM FahrSchueler WHERE FahrSchueler.TC_No="+TC);
            stmt.executeUpdate("DELETE FROM Person WHERE Person.TC="+TC);
        }catch (Exception E){
            System.out.println(E);
        }
    }
    //Schueler einfügen


    public static Boolean addSchueler(String tc,String name, String nname, String GDatum,int KursId,String blutt,String L_id){
        if(!db.containSchueler(tc)){
            //System.out.println(GDatum);
            String s1 = "INSERT INTO Person (TC,Name,Nachname,Geburtsdatum) VALUES('"+tc+"','"+name+"','"+nname+"','" + GDatum + "');";
            String s2 = "INSERT INTO FahrSchueler (Kurs_id,Blutgruppe,Lehrer_id,TC_No) VALUES("+KursId+",'"+blutt+"','"+L_id+"','"+tc+"');";
            /*System.out.println(s1);
            System.out.println(s2);*/

            try {
                stmt.executeUpdate(s1);
                stmt.executeUpdate(s2);
            }catch (Exception e){
                System.out.println(e);
            }
            return true;
        }else{
            return false;

        }

    }

    // List of courses id
    public static ArrayList<Integer> getKursesID(){
        ArrayList<Integer> arr = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Kurs_id FROM Kurs");
            while (res.next()){
                int s1 = res.getInt("Kurs_id");
                arr.add(s1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }
    // Kontrolle, ob eine solche Student gibt
    public static Boolean containSchueler(String TC){
        //this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT TC_No FROM FahrSchueler");
            while (res.next()){
                String s1 = res.getString("TC_No");
                if(s1.equals(TC)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // Kontrolle, ob eine solche Admin gibt
    public static Boolean containAdmin(String Benutzername){
        //this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Rolle FROM Personal WHERE Personal.BenutzerName =="+Benutzername);
            while (res.next()){
                String s2 = res.getString("Rolle");
                if(s2.equals("Admin")){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

}
