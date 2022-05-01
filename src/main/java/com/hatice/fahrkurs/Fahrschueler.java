package com.hatice.fahrkurs;

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
