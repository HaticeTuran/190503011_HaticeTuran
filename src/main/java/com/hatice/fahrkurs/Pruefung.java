package com.hatice.fahrkurs;

import java.util.Date;

public class Pruefung {
    Date Datum;
    String Ort;
    String Topic;
    int Note;

    public Pruefung(Date datum, String ort, String topic, int note) {
        Datum = datum;
        Ort = ort;
        Topic = topic;
        Note = note;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public int getNote() {
        return Note;
    }

    public void setNote(int note) {
        Note = note;
    }

    @Override
    public String toString(){
        return Datum + " " + Ort + " "+ Topic + " "+Note;
    }
}
