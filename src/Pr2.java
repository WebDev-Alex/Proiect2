import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import Persoana.*;

/*
    Creat de Tusinean Alexandru Gabriel
    AIA III
    Terminat in data de 23.10.2021
    Proiect 2 POO

    Detalii:
    În această aplicație, puteți adăuga in cele două liste; donatori și primitori de sânge in functie de datele introduse.
    Există două liste, de donatori și pacienți, completate cu date.
    Puteți selecta câte un element din fiecare lista.
    Puteți verifica dacă grupele de sânge ale celor două persoane selectate sunt compatibile.
    Puteți face transfuzia de sânge intre cele două persoane selectate, după care acestea dispar din liste.
    Puteți Sterge selectiile celor două liste.

    -Toate Datele Transfuziilor sunt salvate în fișierul out.txt.
    -Am folosit StringBuffer si toString in clasele Pacient și Donator (și toString în interfata IPersoana)
    -Am folosit mai mulți constructori pentru clasele Pacient și Donator.
    -Fiecare clasă are metode de tip get si variabile private.
    -Există mai multe variabile constante.
    -Am folosit ArrayList pentru a stoca date de tip Donator și sau Pacient.
    -Dacă datele introduse nu sunt valide, apare un Warning ModalBox.
*/

public class Pr2 {
    private JButton ADButton;
    private JButton APButton;
    private JButton donate;
    private JTextField grupa_S_donator;
    private JTextField grupa_S_pacient;
    private JList donatori;
    private JList primitori;
    private JPanel rootPanel;
    private JTextField prenumePacient;
    private JTextField numePacient;
    private JTextField prenumeDonator;
    private JTextField numeDonator;
    private JButton verifica;
    private JButton sterge;
    private final ListaPacienti listaPrim = new ListaPacienti(primitori);
    private final ListaDonatori listaDon = new ListaDonatori(donatori);
    private final File fila = new File("out.txt");

    public Pr2() {
        ADButton.addActionListener(new ActionListener() {
            //Eveniment buton Adauga Donator
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verificam daca textele introduse sunt valide
                if(prenumeDonator.getText().length() > 3 && numeDonator.getText().length() > 3){
                    //Verificam daca grupa sanguina introdusa exista
                    for (int i = 0; i < IPersoana.grupe_sanguine.length; i++) {
                        //Daca da, cream un Donator nou.
                        if(grupa_S_donator.getText().equals(IPersoana.grupe_sanguine[i])){
                            listaDon.updateLista(new Donator(
                                    numeDonator.getText(),
                                    prenumeDonator.getText(),
                                    (IPersoana.R.nextInt(40) + 14),
                                    grupa_S_donator.getText()
                            ));
                        }
                    }
                }
                //ModalBox in cazul in care datele nu sunt valide.
                else{
                    JOptionPane.showConfirmDialog(
                            null,
                            "Pentru a adauga un Donator, trebuie sa introduceti o grupa sanguina corecta, iar numele si prenumele pacientului sa aiba o lungime de cel putin 4 caractere",
                            "Avertisment!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );
                }
                //Afisam lista cu donatori.
                listaDon.afiseazaDonatorii(donatori);
            }
        });
        APButton.addActionListener(new ActionListener() {
            //Eveniment buton Adauga Donator
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verificam daca textele introduse sunt valide
                if(prenumePacient.getText().length() > 3 && numePacient.getText().length() > 3){
                    //Verificam daca grupa sanguina introdusa exista
                    for (int i = 0; i < IPersoana.grupe_sanguine.length; i++) {
                        //Daca da, cream un Donator nou.
                        if(grupa_S_pacient.getText().equals(IPersoana.grupe_sanguine[i])){
                            listaPrim.updateLista(new Pacient(
                                    numePacient.getText(),
                                    prenumePacient.getText(),
                                    (IPersoana.R.nextInt(20) + 14),
                                    grupa_S_pacient.getText()
                            ));
                        }
                    }
                }
                //ModalBox in cazul in care datele introduse sunt invalide.
                else{
                    JOptionPane.showConfirmDialog(
                            null,
                            "Pentru a adauga un pacient, trebuie sa introduceti o grupa sanguina corecta, iar numele si prenumele pacientului sa aiba o lungime de cel putin 4 caractere",
                            "Avertisment!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );
                }
                //Afisam lista cu donatori.
                listaPrim.afiseazaPacientii(primitori);
            }
        });

        //Event click - button - pentru a dona sange de la donator la pacient.
        donate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Selectam cate o valoare din listele cu donatori si pacienti
                int d = donatori.getSelectedIndex();
                int p = primitori.getSelectedIndex();
                //Verificam daca sunt valide selectiile.
                if(d != -1 && p != -1){
                    //Scriem toate datele transfuziilor realizate, intr-un fisier text, out.txt.
                    FileWriter fp;
                    try{
                        fp = new FileWriter(fila, true);
                        fp.append("\n----------------------------------------\n");
                        fp.append("\nDATE TRANSFUZIE\n");
                        fp.append(listaDon.getListaDonatori().get(d).toString());
                        fp.append(listaPrim.getListaPacienti().get(p).toString());
                        fp.append("\n----------------------------------------\n");
                        fp.close();
                    }catch(Exception t){System.out.print("Eroare");}
                    //Stergem elementele selectate din lista.
                    listaDon.getListaDonatori().remove(d);
                    listaPrim.getListaPacienti().remove(p);
                    //Reafisam listele.
                    listaDon.afiseazaDonatorii(donatori);
                    listaPrim.afiseazaPacientii(primitori);
                }
            }
        });

        //Event pentru a verifica daca sunt compatibile grupele sanguine ale donatorului si ale pacientului.
        verifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int d = donatori.getSelectedIndex();
                int p = primitori.getSelectedIndex();
                //Verificam daca ambele liste au un element selectat
                if(d != -1 && p != -1){
                    //Din donatorii si pacientii selectati luam grupa sanguina
                    String gr_d = (String) donatori.getSelectedValue();
                    String gr_p = (String) primitori.getSelectedValue();
                    String gr_d2 = gr_d.substring(gr_d.length() - 2);
                    String gr_p2 = gr_p.substring(gr_p.length() - 2);
                    //Aici se verifica daca sunt compatibile gr. Sanguine.//Din donatorii si pacientii selectati luam grupa sanguina
                    if(gr_d2.equals(" A")){
                        switch(gr_p2) {
                            case " A":
                            case "AB":
                                JOptionPane.showConfirmDialog(
                                        null,
                                        "Grupa de sange a donatorului este compatibila cu a pacientului.",
                                        "Rezultat",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                break;
                            case " B":
                            case " 0":
                                JOptionPane.showConfirmDialog(
                                        null,
                                        "Grupa de sange a donatorului nu este compatibila cu a pacientului.",
                                        "Rezultat",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.WARNING_MESSAGE
                                );
                                break;
                        }
                    }
                    if(gr_d2.equals(" B")){
                        switch(gr_p2) {
                            case " B":
                            case "AB":
                                JOptionPane.showConfirmDialog(
                                        null,
                                        "Grupa de sange a donatorului este compatibila cu a pacientului.",
                                        "Rezultat",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                break;
                            case " A":
                            case " 0":
                                JOptionPane.showConfirmDialog(
                                        null,
                                        "Grupa de sange a donatorului nu este compatibila cu a pacientului.",
                                        "Rezultat",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.WARNING_MESSAGE
                                );
                                break;
                        }
                    }
                    if(gr_d2.equals("AB")){
                        switch(gr_p2) {
                            case "AB":
                                JOptionPane.showConfirmDialog(
                                        null,
                                        "Grupa de sange a donatorului este compatibila cu a pacientului.",
                                        "Rezultat",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                break;
                            case " A":
                            case " B":
                            case " 0":
                                JOptionPane.showConfirmDialog(
                                        null,
                                        "Grupa de sange a donatorului nu este compatibila cu a pacientului.",
                                        "Rezultat",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.WARNING_MESSAGE
                                );
                                break;
                        }
                    }
                    if(gr_d2.equals(" 0")){
                        JOptionPane.showConfirmDialog(
                                null,
                                "Grupa de sange a donatorului este compatibila cu a pacientului.",
                                "Rezultat",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });
        //Event pentru stergerea selectiilor din liste.
        sterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donatori.clearSelection();
                primitori.clearSelection();
            }
        });
    }

    public static void main(String[] args) {
        //Desenam tot.
        JFrame frame = new JFrame();
        frame.setContentPane(new Pr2().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
