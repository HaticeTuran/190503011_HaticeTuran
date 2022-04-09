package com.hatice.fahrkurs;

import java.util.Date;

public class Person {
    String Name;
    String NachName;
    String TC_Nummer;
    Date Geburtsdatum;
    String Geschlecht;
    String Adresse;
    String MailAdresse;
    int TelefonNummer;
    public Person(String Tc){
        this.TC_Nummer = Tc;
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

    @Override
    public boolean equals( Object o){
        Person p = (Person) o;
        if(p.getTC_Nummer().equals(this.TC_Nummer)) return  true;
        else return false;
    }
}
