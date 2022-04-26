package com.hatice.fahrkurs;

import java.util.ArrayList;

public class Kursleiter extends Personal{
    private ArrayList<Kurs> Kurse;
    private ArrayList<Fahrschueler> Schueler;

    public Kursleiter(String Tc) {
        super(Tc);
    }

    public void addSchueler(Fahrschueler f){
        Schueler.add(f);
    }
    public void loescheSchueler(Fahrschueler f){
        Schueler.remove(f);
    }
    public void addKurs(Kurs k){
        Kurse.add(k);
    }
    public void loescheKurs(Kurs k){
        Kurse.remove(k);
    }
    @Override
    public String toString(){
        return super.toString();
    }

}