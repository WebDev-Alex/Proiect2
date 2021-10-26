package Persoana;

public class Pacient implements IPersoana{
    final private String nume;
    final private String prenume;
    final private int varsta;
    final private String grupa_sanguina;

    //Constructor principal.
    public Pacient(){
        //Nume si prenume random, din IPersoana.
        nume = IPersoana.nume_default[IPersoana.R.nextInt(IPersoana.nume_default.length - 1)];
        prenume = IPersoana.prenume_default[IPersoana.R.nextInt(IPersoana.prenume_default.length - 1)];
        varsta = IPersoana.R.nextInt(20) + 14;
        grupa_sanguina = "A";
    }

    //Constructor cu parametru Grupa Sanguina.
    public Pacient(String grupa_sanguinaP){
        nume = IPersoana.nume_default[IPersoana.R.nextInt(IPersoana.nume_default.length - 1)];
        prenume = IPersoana.prenume_default[IPersoana.R.nextInt(IPersoana.prenume_default.length - 1)];
        varsta = IPersoana.R.nextInt(20) + 14;
        grupa_sanguina = grupa_sanguinaP;
    }
    //Constructor cu parametrii Nume, Prenume si grupa Sanguina.
    public Pacient(String numeP, String prenumeP, int varstaP, String grupa_sanguinaP){
        nume = numeP;
        prenume = prenumeP;
        varsta = varstaP;
        grupa_sanguina = grupa_sanguinaP;
    }

    //Getters pentru variabile.
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
        str.append("\nDate Pacient:\n");
        str.append(this.getNume());
        str.append(" ");
        str.append(this.getPrenume());
        str.append("\nGrupa Sanguina:  ");
        str.append(this.getGrupaSanguina());
        str.append("\nVarsta: ");
        str.append(this.varsta);
        str.append("\n--------------------\n");

        return str.toString();
    }
}
