package com.hatice.fahrkurs;

public class Note {
    private int NotenID;
    private int PruefungID;
    private int Note;
    private String SchuelerID;

    public void setNotenID(int notenID) {
        NotenID = notenID;
    }

    public void setPruefungID(int pruefungID) {
        PruefungID = pruefungID;
    }

    public void setSchuelerID(String schuelerID) {
        SchuelerID = schuelerID;
    }

    public void setNote(int note) {
        Note = note;
    }

    public int getNotenID() {
        return NotenID;
    }

    public int getPruefungID() {
        return PruefungID;
    }

    public String getSchuelerID() {
        return SchuelerID;
    }
    public int getNote() {
        return Note;
    }
}
