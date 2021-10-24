package Persoana;

import java.util.Random;

//Interfata pentru pacienti si donatori
public interface IPersoana {
    public static final String TIP_PACIENT = "Pacient";
    public static final String TIP_DONATOR = "Donator";
    public static final String[] prenume_default = {
            "Andrei",
            "Gabriel",
            "Ionut",
            "Stefan",
            "Alexandru",
            "Maria",
            "Alexandra",
            "Elena",
            "Ioana",
            "Iulia",
            "Gabriela",
            "Ana-Maria",
            "Marian",
            "Paul",
            "Constantin",
            "Daniel",
            "Dan",
            "Mihaela",
            "Pavel",
            "Raul",
            "Codruta",
            "Cosmin"
    };
    public static final String[] nume_default = {
            "Popa",
            "Popescu",
            "Pop",
            "Radu",
            "Ionescu",
            "Dumitru",
            "Stoica",
            "Stan",
            "Gheorghe",
            "Rusu",
            "Munteanu",
            "Matei",
            "Constantin",
            "Serban",
            "Urs",
            "Hulpe",
            "Rus"
    };
    public static final Random R = new Random();
    public static final String[] grupe_sanguine = {"A", "B", "AB", "0"};

    public String getNume();
    public String getPrenume();
    public String getGrupaSanguina();
    public String toString();
}
