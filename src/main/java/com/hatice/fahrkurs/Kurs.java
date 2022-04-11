package com.hatice.fahrkurs;

public class Kurs {
    private Kursleiter Lehrer;
    private int Kapazitaet;
    private String Topic;
    private Pruefung Pruefung;

    public Kurs(Kursleiter lehrer, int kapazitaet, String topic, com.hatice.fahrkurs.Pruefung pruefung) {
        Lehrer = lehrer;
        Kapazitaet = kapazitaet;
        Topic = topic;
        Pruefung = pruefung;
    }

    public Kursleiter getLehrer() {
        return Lehrer;
    }

    public void setLehrer(Kursleiter lehrer) {
        Lehrer = lehrer;
    }

    public int getKapazitaet() {
        return Kapazitaet;
    }

    public void setKapazitaet(int kapazitaet) {
        Kapazitaet = kapazitaet;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public Pruefung getPruefung() {
        return Pruefung;
    }

    public void setPruefung(Pruefung pruefungen) {
        Pruefung = pruefungen;
    }

    @Override
    public String toString(){
        return Lehrer + " " + Kapazitaet + " " + Topic +" " +Pruefung;
    }


}
