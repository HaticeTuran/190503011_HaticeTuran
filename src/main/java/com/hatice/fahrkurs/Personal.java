package com.hatice.fahrkurs;

public class Personal extends Person{
    private int PersonalNummer;
    private String Rolle;
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

    @Override
    public String toString(){
        return super.toString() +" "+ PersonalNummer +" "+Rolle;
    }

}
