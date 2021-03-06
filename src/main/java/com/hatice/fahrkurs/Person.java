package com.hatice.fahrkurs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String Name;
    private String NachName;
    private String TC_Nummer;
    private Date Geburtsdatum;
    private String Geschlecht;
    private String Adresse;
    private String MailAdresse;
    private int TelefonNummer;

    public Person(String Tc){
        this.TC_Nummer = Tc;
    }

    public Person(String Tc,String n, String nn, String gd) throws ParseException {
        TC_Nummer = Tc;
        NachName = nn;
        Name = n;
        Geburtsdatum = new SimpleDateFormat("dd.MM.yyyy").parse(gd);
    }
    public Person(String Tc, String n, String nn){
        this.TC_Nummer = Tc;
        this.Name = n;
        this.NachName = nn;
    }

    public Person(String name, String nachName, String TC_Nummer, Date geburtsdatum, String geschlecht, String adresse, String mailAdresse, int telefonNummer) {
        Name = name;
        NachName = nachName;
        this.TC_Nummer = TC_Nummer;
        Geburtsdatum = geburtsdatum;
        Geschlecht = geschlecht;
        Adresse = adresse;
        MailAdresse = mailAdresse;
        TelefonNummer = telefonNummer;
    }

    public String getName() {
        return Name;
    }
    public String getNachName() {
        return NachName;
    }

    public String getTC_Nummer() {
        return TC_Nummer;
    }
    public Date getGeburtsdatum() {
        return Geburtsdatum;
    }

    public String getGeschlecht() {
        return Geschlecht;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getMailAdresse() {
        return MailAdresse;
    }

    public int getTelefonNummer() {
        return TelefonNummer;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNachName(String nachName) {
        NachName = nachName;
    }

    public void setTC_Nummer(String TC_Nummer) {
        this.TC_Nummer = TC_Nummer;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public void setGeschlecht(String geschlecht) {
        Geschlecht = geschlecht;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public void setMailAdresse(String mailAdresse) {
        MailAdresse = mailAdresse;
    }

    public void setTelefonNummer(int telefonNummer) {
        TelefonNummer = telefonNummer;
    }

    /*@Override
    public boolean equals( Object o){
        Person p = (Person) o;
        if(p.getTC_Nummer().equals(this.TC_Nummer)) return  true;
        else return false;
    }*/
    @Override
    public String toString(){
        return Name + " "+ NachName+ " "+TC_Nummer+" "+Geburtsdatum+" " +Geschlecht+" " +Adresse+ " "+MailAdresse+" " +TelefonNummer;
    }

}
