package com.hatice.fahrkurs;

public class Personal extends Person{
    private int PersonalNummer;
    private String Rolle;
    private String Benutzername;
    public Personal(String TC, String Benutzername, int pn){
        super(TC);
        this.Benutzername = Benutzername;
        PersonalNummer = pn;
    }
    public Personal(String n, String nn, String tc, String r,String bn, String pn){
        super(tc,n,nn);
        Rolle = r;
        Benutzername = bn;
        PersonalNummer = Integer.parseInt(pn);
    }
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
        String s = "Personalnummer: " + String.valueOf(PersonalNummer) + "- Benutzername: "+ Benutzername + " ";
        return s + super.toString();
    }

    /*@Override
    public String toString(){
        return super.toString() +" "+ PersonalNummer +" "+Rolle;
    }*/

}
