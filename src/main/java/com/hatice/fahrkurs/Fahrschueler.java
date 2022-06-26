package com.hatice.fahrkurs;

import java.text.ParseException;

public class Fahrschueler extends Person{
    private int SchuelerNummer;
    private Kurs angemeldeteKus;
    private String Blutgruppe;

    public Fahrschueler(String Tc) {
        super(Tc);
    }
    public Fahrschueler(String Tc, String n, String nn){
        super(Tc,n,nn);
    }
    public Fahrschueler(String Sno, String Tc, String n, String nn, String gd ) throws ParseException {
        super(Tc,n,nn,gd);
        SchuelerNummer = Integer.parseInt(Sno);
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

    @Override
    public String toString(){
        return super.toString() + " "+SchuelerNummer +" "+angemeldeteKus+" "+Blutgruppe;
    }
}
