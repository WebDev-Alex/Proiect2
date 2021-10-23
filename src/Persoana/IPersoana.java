package Persoana;

import java.util.Random;

//Interfata pentru pacienti si donatori
public interface IPersoana {
    public static final String TIP_PACIENT = "Pacient";
    public static final String TIP_DONATOR = "Donator";
    public static final Random R = new Random();
    public static final String[] grupe_sanguine = {"A", "B", "AB", "0"};

    public String getNume();
    public String getPrenume();
    public String getGrupaSanguina();
    public String toString();
}
