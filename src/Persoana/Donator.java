package Persoana;

public class Donator implements IPersoana{
    final private String nume;
    final private String prenume;
    final private int varsta;
    final private String grupa_sanguina;

    //Constructor principal.
    public Donator(){
        nume = "DonatorPPPP";
        prenume = "Privat";
        varsta = 20;
        grupa_sanguina = "A";
    }

    //Constructor Ad. Gr. Sanguina
    public Donator(String grupa_sanguinaD){
        nume = "Donator";
        prenume = "Privat";
        varsta = 20;
        grupa_sanguina = grupa_sanguinaD;
    }
    //Constructor Adauga Nume, Prenume si gr. Sanguina
    public Donator(String numeD, String prenumeD, int varstaD, String grupa_sanguinaD){
        nume = numeD;
        prenume = prenumeD;
        varsta = varstaD;
        grupa_sanguina = grupa_sanguinaD;
    }

    //Getters pentru date.
    public String getNume(){
        return this.nume;
    }

    public String getPrenume(){
        return this.prenume;
    }

    public String getGrupaSanguina(){
        return this.grupa_sanguina;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("\n--------------------\n");
        str.append("\nDate Donator:\n");
        str.append(this.getNume());
        str.append(" ");
        str.append(this.getPrenume());
        str.append("\nGrupa Sanguina:  " + this.getGrupaSanguina());
        str.append("\nVarsta: " + this.varsta);
        str.append("\n--------------------\n");

        return str.toString();
    }
}
