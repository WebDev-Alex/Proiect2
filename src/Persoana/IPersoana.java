package Persoana;

import java.util.Random;

//Interfata pentru pacienti si donatori
public interface IPersoana {
    String[] prenume_default = {
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
            "Dani",
            "Mihaela",
            "Pavel",
            "Raul",
            "Codruta",
            "Cosmin"
    };
    String[] nume_default = {
            "Popa",
            "Popescu",
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
            "Ursu",
            "Hulpe"
    };
    Random R = new Random();
    String[] grupe_sanguine = {"A", "B", "AB", "0"};

    String getNume();
    String getPrenume();
    String getGrupaSanguina();
    String toString();
}
