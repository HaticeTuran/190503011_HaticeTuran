package com.hatice.fahrkurs;

public class Kurs {
    Kursleiter Lehrer;
    int Kapazitaet;
    String Topic;
    Pruefung Pruefungen;

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

    public Pruefung getPruefungen() {
        return Pruefungen;
    }

    public void setPruefungen(Pruefung pruefungen) {
        Pruefungen = pruefungen;
    }


}
