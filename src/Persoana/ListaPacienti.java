package Persoana;

import java.util.ArrayList;
import javax.swing.*;

public class ListaPacienti {
    //Lista cu toti pacientii.
    private final ArrayList<Pacient> TotalPacienti = new ArrayList<>();
    public static DefaultListModel modelPacienti = new DefaultListModel();

    //Metoda pentru adaugare de pacient cu parametru.
    public void updateLista(Pacient p){
        this.getListaPacienti().add(p);
    }

    //Metoda de tip get pentru lista cu pacienti.
    public ArrayList<Pacient> getListaPacienti(){
        return this.TotalPacienti;
    }

    //Initializare, Constructor principal.
    public ListaPacienti(JList j){
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.getListaPacienti().add(new Pacient(IPersoana.grupe_sanguine[IPersoana.R.nextInt(4)]));
        this.afiseazaPacientii(j);
    }

    //Metoda pentru stergerea si rescrierea tuturor pacientilor din lista, intr-un JList.
    public void afiseazaPacientii(JList j){
        modelPacienti.clear();
        j.setModel(modelPacienti);
        for (int i = 0; i < this.getListaPacienti().size(); i++) {
            modelPacienti.addElement(this.getListaPacienti().get(i).getNume() + "  " + this.getListaPacienti().get(i).getPrenume() + "   - Grupa: " + this.getListaPacienti().get(i).getGrupaSanguina());
        }
    }
}
