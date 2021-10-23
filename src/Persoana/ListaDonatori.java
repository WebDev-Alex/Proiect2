package Persoana;

import java.util.ArrayList;
import javax.swing.*;

public class ListaDonatori {
    //Lista cu variabile de tip Donator.
    private final ArrayList<Donator> TotalDonatori = new ArrayList<>();
    public static DefaultListModel modelDonatori = new DefaultListModel();

    //Metoda - Adaugam un obiect nou de tip Donator.
    public void updateLista(Donator p){
        this.getListaDonatori().add(p);
    }

    //Metoda - tip get - returneaza lista de Donatori.
    public ArrayList<Donator> getListaDonatori(){
        return this.TotalDonatori;
    }

    //Constructor principal cu parametru JList  -  Adauga 5 Obiecte tip Donator si le afiseaza.
    public ListaDonatori(JList j){
        this.getListaDonatori().add(new Donator(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaDonatori().add(new Donator(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaDonatori().add(new Donator(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaDonatori().add(new Donator(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaDonatori().add(new Donator(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.afiseazaDonatorii(j);
    }

    //Metoda pentru afisarea Donatorilor.
    public void afiseazaDonatorii(JList j){
        modelDonatori.clear();
        j.setModel(modelDonatori);
        for (int i = 0; i < this.getListaDonatori().size(); i++) {
            modelDonatori.addElement(this.getListaDonatori().get(i).getNume() + "  " + this.getListaDonatori().get(i).getPrenume() + "   - Grupa: " + this.getListaDonatori().get(i).getGrupaSanguina());
        }
    }
}
