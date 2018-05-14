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

    public Hoofdscherm() {
        String skip = "\n";
        setTitle("Hoofdscherm");
        setSize(1500, 800);
        setLayout(null);

        JTextArea graphic = new JTextArea("Graphic shit");
        graphic.setBounds(100, 50, 1300, 350);
        graphic.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(graphic);

        JTextArea instellingHuidig = new JTextArea();
        instellingHuidig.setBounds(100, 570, 400, 100);
        instellingHuidig.setText("Naam sorteerproces: Beter niet" + skip + "Totaal aantal Skittles: 30" + skip + "Bakje1:  rood, 15" + skip + "Bakje2: groen, 15");
        instellingHuidig.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(instellingHuidig);

        JTextArea foutmeldingen = new JTextArea();
        foutmeldingen.setBounds(1000, 570, 400, 100);
        foutmeldingen.setText("Foutmelding sorteerproces");
        foutmeldingen.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(foutmeldingen);

        JButton start = new JButton("Starten sorteerproces");
        start.setBounds(100, 420, 170, 35);
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
        if (e.getSource() == sorteer) {
            Sorteerscherm s1 = new Sorteerscherm(this);
            s1.setVisible(true);


            public void voegToe(String s){
                instellingen.add(s);
            }

            public void printInstellingen () {
                for (int i = 0; i < instellingen.size(); i++) {
                    String a = instellingen.get(i);
                    System.out.println(a);
                }
            }
        }
    }
}