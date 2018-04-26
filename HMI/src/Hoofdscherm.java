import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.util.ArrayList;

public class Hoofdscherm extends JFrame implements ActionListener {

    private Bakje bakje;
    private ArrayList<String> instellingen;
    private JButton start, stop, sorteer, log;
    private JTextArea graphic, instellingenHuidig, foutmeldingen;
    private JLabel huidig, fout;

<<<<<<< HEAD
    public Hoofdscherm(){
        String skip = "\n";
        setTitle("Hoofdscherm");
        setSize(1500,800);
        setLayout(null);

        JTextArea graphic = new JTextArea("Graphic shit");
        graphic.setBounds(100,50,1300,350);
        graphic.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(graphic);

        JTextArea instellingHuidig = new JTextArea();
        instellingHuidig.setBounds(100, 570, 400, 100);
        instellingHuidig.setText("Naam sorteerproces: Beter niet"+ skip +"Totaal aantal Skittles: 30"+ skip +"Bakje1:  rood, 15"+ skip +"Bakje2: groen, 15");
        instellingHuidig.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(instellingHuidig);

        JTextArea foutmeldingen = new JTextArea();
        foutmeldingen.setBounds(1000, 570, 400, 100);
        foutmeldingen.setText("Foutmelding sorteerproces");
        foutmeldingen.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(foutmeldingen);

        JButton start = new JButton("Starten sorteerproces");
        start.setBounds(100,420,170,35);
        add(start);

        JButton stop = new JButton("Stoppen sorteerproces");
        stop.setBounds(1230, 420, 170, 35);
        add(stop);

        sorteer = new JButton("Sorteren");
        sorteer.setBounds(1270, 710, 130, 35);
        add(sorteer);
        sorteer.addActionListener(this);

        log = new JButton("Taken log");
        log.setBounds(100, 710, 130, 35);
        add(log);
        log.addActionListener(this);

        JLabel huidig = new JLabel(" Instellingen huidig sorteerproces");
        huidig.setBounds(100, 520, 200, 35);
        huidig.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(huidig);

        JLabel fout = new JLabel(" Foutmelding");
        fout.setBounds(1000, 520, 200, 35);
        fout.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(fout);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sorteer){
            Sorteerscherm s1 = new Sorteerscherm(this);
            s1.setVisible(true);
=======
>>>>>>> 7b885c7d494135ffd93b155ca773aedf80ecda28


    public Hoofdscherm() {
        String skip = "\n"; // Regel overslaan.

        instellingen = new ArrayList<>();



            setTitle("Hoofdscherm");
            setSize(1500, 800);
            setLayout(null);
            setVisible(true);

            JTextArea graphic = new JTextArea("Graphic shit"); // Hier komt een grafische representatie van het huidige proces.
            graphic.setBounds(100, 50, 1300, 350);
            graphic.setBorder(BorderFactory.createLineBorder(Color.gray));
            add(graphic);


            instellingenHuidig = new JTextArea(); // Hier staan de gegevens van het huidige sorteerproces.
            instellingenHuidig.setBounds(100, 570, 400, 100);
            instellingenHuidig.setBorder(BorderFactory.createLineBorder(Color.gray));
            instellingenHuidig.setEditable(false);
            add(instellingenHuidig);


            foutmeldingen = new JTextArea(); // Hier staan de eventuele foutmeldingen van het huidige sorteerproces.
            foutmeldingen.setBounds(1000, 570, 400, 100);
            foutmeldingen.setText("Foutmelding sorteerproces");
            foutmeldingen.setBorder(BorderFactory.createLineBorder(Color.gray));
            add(foutmeldingen);


            start = new JButton("Starten sorteerproces"); // Knop om het sorteerproces te starten.
            start.setBounds(100, 420, 170, 35);
            add(start);
            start.addActionListener(this);

            stop = new JButton("Stoppen sorteerproces"); // Knop om het sorteerproces te stoppen.
            stop.setBounds(1230, 420, 170, 35);
            add(stop);

            sorteer = new JButton("Sorteren"); // Knop om naar het "Sorteerscherm" te gaan.
            sorteer.setBounds(1270, 710, 130, 35);
            add(sorteer);
            sorteer.addActionListener(this);

            log = new JButton("Taken log"); // Knop om naar het "Logscherm" te gaan.
            log.setBounds(100, 710, 130, 35);
            add(log);
            log.addActionListener(this);

            JLabel huidig = new JLabel(" Instellingen huidig sorteerproces"); // Label van de instellingen van het huidige sorteerproces.
            huidig.setBounds(100, 520, 200, 35);
            huidig.setBorder(BorderFactory.createLineBorder(Color.gray));
            add(huidig);

            JLabel fout = new JLabel(" Foutmelding"); // Label van de foutmeldingen.
            fout.setBounds(1000, 520, 200, 35);
            fout.setBorder(BorderFactory.createLineBorder(Color.gray));
            add(fout);
        }

        @Override
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == sorteer) { // Dit gebeurt er als er op de sorteer knop wordt gedrukt.
                Sorteerscherm s1 = new Sorteerscherm(this);
                s1.setVisible(true);

                if (s1.isOk() == true) {
                    String skip = "\n";

                    String naam = s1.getJTnaam();
                    String totaal = s1.getJTtotaal();
                    String aantalBakje1 = s1.getJTaantalBakje1();
                    String aantalBakje2 = s1.getJTaantalBakje2();
                    String kleurBakje1 = s1.getJCkleurBakje1();
                    String kleurBakje2 = s1.getJCkleurBakje2();





                            String gegevens = "Naam sorteerproces: " + naam + skip + "Totaal aantal Skittles: " + totaal + skip + "Bakje1: " + aantalBakje1 + " " + kleurBakje1 + skip + "Bakje2: " + aantalBakje2 + " " + kleurBakje2;
                            voegToe(gegevens);
                            for (int i = 0; i < instellingen.size(); i++) {
                                String a = instellingen.get(i);
                                instellingenHuidig.append(a);
                            }


                }

            }

            if (e.getSource() == log) { // Dit gebeurt er als er op de log knop wordt gedrukt.
                Logscherm l1 = new Logscherm(this);
                l1.setVisible(true);
            }

            if (e.getSource() == start) {
                printInstellingen();
            }
        }

        public void voegToe (String s){
            instellingen.add(s);
        }

        public void printInstellingen () {
            for (int i = 0; i < instellingen.size(); i++) {
                String a = instellingen.get(i);
                System.out.println(a);
            }
        }


}
