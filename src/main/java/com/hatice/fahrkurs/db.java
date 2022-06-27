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

    //List of Personals
    public static ObservableList<Personal> listPersonal(){
        ObservableList<Personal> arr = FXCollections.observableArrayList();

        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Person.Name, Person.NachName, Person.TC, Personal.BenutzerName, Personal.Personal_nummer,Personal.Rolle FROM Person, Personal WHERE Person.TC == Personal.TC");
            while (res.next()){
                String s = res.getString("Name");
                String s1 = res.getString("NachName");
                String s2 = res.getString("TC");
                String s3 = res.getString("BenutzerName");
                String s4 = res.getString("Personal_nummer");
                String s5 = res.getString("Rolle");

                arr.add(new Personal(s,s1,s2,s5,s3,s4));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    // Lİst of students
    public static ObservableList<Fahrschueler> listSchueler(){
        ObservableList<Fahrschueler> arr = FXCollections.observableArrayList();

        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT FahrSchueler.Schueler_no, FahrSchueler.TC_No, Person.Name, Person.NachName, Person.Geburtsdatum FROM Person, FahrSchueler WHERE Person.TC == FahrSchueler.TC_No");
            while (res.next()){
                String s = res.getString("Schueler_no");
                String s1 = res.getString("TC_No");
                String s2 = res.getString("Name");
                String s3 = res.getString("NachName");
                String s4 = res.getString("Geburtsdatum");

                arr.add(new Fahrschueler(s,s1,s2,s3,s4));

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

    // Personal löschen
    public static void deletePersonal(String TC){
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Personal WHERE Personal.TC="+TC);
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

    // List of Lehrern
    public static ArrayList<Kursleiter> getLehrerList(){
        ArrayList<Kursleiter> arr = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT KursLeiter.KursLeiter_id,Personal_nummer, BenutzerName FROM Personal, KursLeiter WHERE Personal.TC = KursLeiter.KursLeiter_id");
            while (res.next()){
                String TC= res.getString("KursLeiter_id");
                String pn = res.getString("Personal_nummer");
                String bn = res.getString("BenutzerName");
                /*String n = res.getString("Name");
                String nn = res.getString("NachName");
                System.out.println(TC + n +nn );
                arr.add(new Kursleiter(TC,n,nn));*/
                arr.add(new Kursleiter(TC,bn,bn));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    // List of Personal
    public static ArrayList<Personal> getPersonalList(){
        ArrayList<Personal> arr = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT TC, Personal_nummer, BenutzerName FROM Personal");
            while (res.next()){
                String TC= res.getString("TC");
                String s1 = res.getString("BenutzerName");
                int pn = res.getInt("Personal_nummer");
                arr.add(new Personal(TC,s1,pn));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    // Einfuegen einer Personal
    public static Boolean addPersonal(String tc,String n, String nn,String gb, String bn,String pass){
        if(!db.containPersonal(bn,pass)){
            //System.out.println(GDatum);
            String s1 = "INSERT INTO Person (TC,Name,Nachname,Geburtsdatum) VALUES('"+tc+"','"+n+"','"+nn+"','" + gb + "');";
            String s2 = "INSERT INTO Personal (TC,BenutzerName,Passwort) VALUES("+tc+",'"+bn+"','"+pass+"');";
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
            ResultSet res = stmt.executeQuery("SELECT Rolle,BenutzerName FROM Personal ");
            while (res.next()){
                String s1 = res.getString("Rolle");
                String s2 = res.getString("BenutzerName");
                if(s1.equals("Admin") && s2.equals(Benutzername)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // Update the user to admin
    public static void makeAdmin(String s){
        String sql = "UPDATE Personal SET Rolle='Admin' WHERE BenutzerName= '" + s +"'";
        try {
            stmt.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // Update the personal to user
    public static void makeUser(String s){
        String sql = "UPDATE Personal SET Rolle='User' WHERE BenutzerName= '" + s +"'";
        try {
            stmt.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // update Passwort
    public static Boolean IsUpdatePasswort(String bn, String lp, String np){
           if(containPersonal(bn,lp)){
               String sql = "UPDATE Personal SET Passwort=" +"'"+np+"'"+ "WHERE Benutzername='"+bn+"'";
               try {
                   stmt.executeUpdate(sql);
               }catch (Exception e){
                   System.out.println(e);
               }
               return true;
           }else{
               return false;
           }
    }
    // add Kurse
    public static void addKurs(String Topic,String L_id,int cp){
        if(!db.containKurs(Topic,L_id)){
            String s1 = "INSERT INTO Kurs (Topic, Lehrer_id,Kapazitaet) VALUES('"+Topic+"','"+L_id+"',"+cp+");";

            try {
                stmt.executeUpdate(s1);
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    // add Kurse
    public static void updateKursCP(String Topic,String L_id,int cp){
        String s = "UPDATE Kurs SET Kapazitaet ="+cp+ " WHERE Topic ='"+Topic+"'AND Lehrer_id = '"+ L_id+"';";
        //String s1 = "INSERT INTO Kurs (Topic, Lehrer_id,Kapazitaet) VALUES('"+Topic+"','"+L_id+"',"+cp+");";

        try {
            stmt.executeUpdate(s);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // delete Kurse
    public static void deleteKurs(String Topic,String L_id,int cp){

        String s = "DELETE FROM Kurs WHERE Topic ='" + Topic + "' AND Lehrer_id ='"+ L_id +"'" + " AND Kapazitaet = "+ cp;

        try {
            stmt.executeUpdate(s);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Kontolle ob eine solche Kurs gibt
    public static Boolean containKurs(String Topic,String L_id){
        //this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Kurs;");
            while (res.next()){
                String s1 = res.getString("Topic");
                String s2 = res.getString("Lehrer_id");

                if(Topic.equals(s1) && L_id.equals(s2)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

}
