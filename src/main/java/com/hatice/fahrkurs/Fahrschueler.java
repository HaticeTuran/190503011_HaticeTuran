package com.hatice.fahrkurs;

public class Fahrschueler extends Person{
    int SchuelerNummer;
    Kurs angemeldeteKus;
    String Blutgruppe;

    public Fahrschueler(String Tc) {
        super(Tc);
    }

    public int getSchuelerNummer() {
        return SchuelerNummer;
    }

    public Kurs getAngemeldeteKus() {
        return angemeldeteKus;
    }

    public String getBlutgruppe() {
        return Blutgruppe;
    }

    public void setSchuelerNummer(int schuelerNummer) {
        SchuelerNummer = schuelerNummer;
    }

    public void setAngemeldeteKus(Kurs angemeldeteKus) {
        this.angemeldeteKus = angemeldeteKus;
    }

    public void setBlutgruppe(String blutgruppe) {
        Blutgruppe = blutgruppe;
    }
}
