package com.hatice.fahrkurs;

public class Personal extends Person{
    int PersonalNummer;
    String Rolle;
    public Personal(String Tc){
        super(Tc);
    }
    public int getPersonalNummer() {
        return PersonalNummer;
    }

    public String getRolle() {
        return Rolle;
    }

    public void setPersonalNummer(int personalNummer) {
        PersonalNummer = personalNummer;
    }

    public void setRolle(String rolle) {
        Rolle = rolle;
    }

}
