import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sorteerscherm extends JDialog implements ActionListener {
    private JTextField JTnaam, JTtotaal, JTaantalBakje1, JTaantalBakje2;
    private JLabel JLnaam, JLtotaal, JLaantalBakje1, JLaantalBakje2, JLNieuw;
    private JComboBox JCkleurBakje1, JCkleurBakje2;
    private JButton terug, opslaan;
    private JLabel FMtotaal, FMBakje1, FMBakje2, FMgeheel, FMnaam;
    private boolean letter = false, letter2 = false;
    private boolean goed;

    public Sorteerscherm(JFrame frame) {
        super(frame, true);

        setTitle("Sorteerscherm");
        setSize(800,500);
        setLayout(null);

        String[] kleuren = {"Kies kleur","Paars", "Rood", "Oranje", "Groen", "Geel"}; // Array kleuren van Skittles.
        String[] instellingen = {"Selecteer sorteerproces", "Sorteerproces1", "Sorteerproces2", "Sorteerproces3"}; // Array verschillende

        FMnaam = new JLabel("");
        FMnaam.setBounds(460, 100, 200, 35);
        add(FMnaam);

        FMtotaal = new JLabel("");
        FMtotaal.setBounds(460, 145, 200, 35);
        add(FMtotaal);

        FMBakje1 = new JLabel("");
        FMBakje1.setBounds(600, 190, 200, 35);
        add(FMBakje1);

        FMBakje2 = new JLabel("");
        FMBakje2.setBounds(600, 235, 200, 35);
        add(FMBakje2);

        FMgeheel = new JLabel("");
        FMgeheel.setBounds(100, 300, 500, 100);
        add(FMgeheel);

        JLNieuw = new JLabel("Een nieuw sorteerproces aanmaken:");
        JLNieuw.setBounds(120, 50, 300, 35);
        add(JLNieuw);

        JTnaam = new JTextField(10); // Textfield voor naam van sorteerproces.
        JTnaam.setBounds(300, 100, 150, 35);
        add(JTnaam);

        JTtotaal = new JTextField(10); // Textfield voor het aantal te sorteren Skittles.
        JTtotaal.setBounds(300, 145, 150, 35 );
        add(JTtotaal);

        JTaantalBakje1 = new JTextField(10); // Textfield voor het aantal te sorteren voor bakje1.
        JTaantalBakje1.setBounds(300,190, 150,35);
        add(JTaantalBakje1);

        JTaantalBakje2 = new JTextField(10); // Textfield voor het aantal te sorteren voor bakje2.
        JTaantalBakje2.setBounds(300, 235, 150, 35);
        add(JTaantalBakje2);

        JLnaam = new JLabel("     Naam sorteerproces:"); // Label van naam sorteerproces.
        JLnaam.setBounds( 100, 100, 200, 35);
        add(JLnaam);

        JLtotaal = new JLabel("     Totaal aantal Skittles:"); // Label van het totaal aantal.
        JLtotaal.setBounds(100, 145, 200, 35);
        add(JLtotaal);

        JLaantalBakje1 = new JLabel("     Aantal Skittles bakje1:"); // Label van het aantal bakje1.
        JLaantalBakje1.setBounds(100, 190, 200, 35);
        add(JLaantalBakje1);

        JLaantalBakje2 = new JLabel("     Aantal Skittles bakje2:"); // Label van het aantal bakje2.
        JLaantalBakje2.setBounds(100, 235, 200, 35);
        add(JLaantalBakje2);

        JCkleurBakje1 = new JComboBox(kleuren); // Combobox voor de kleur van de Skittle, voor bakje1.
        JCkleurBakje1.setBounds(460, 190, 120,35);
        //JCkleurBakje1.setRenderer(dlcr);
        add(JCkleurBakje1);

        JCkleurBakje2 = new JComboBox(kleuren); // Combobox voor de kleur van de Skittle, voor bakje2.
        JCkleurBakje2.setBounds(460, 235, 120, 35);
        //JCkleurBakje2.setRenderer(dlcr);
        add(JCkleurBakje2);

        terug = new JButton("Terug"); // Knop om terug te gaan naar het hoofdscherm.
        terug.setBounds(100, 400, 150, 35);
        add(terug);
        terug.addActionListener(this);

        opslaan = new JButton("Sorteerproces opslaan"); // Knop om de ingevoerde instellingen op te slaan.
        opslaan.setBounds(400, 400, 170,35);
        add(opslaan);
        opslaan.addActionListener(this);
    }

    public String getNaamProces() {
        return JTnaam.getText();
    }

    public int getTotaal() {
        try {
            return Integer.parseInt(JTtotaal.getText());
        } catch (Exception e) {
            FMtotaal.setText("geen juiste waarde ingevuld!");
            return 0;
        }
    }

    public String getKleurBakje1() {
        return JCkleurBakje1.getSelectedItem().toString();
    }

    public String getKleurBakje2() {
        return JCkleurBakje2.getSelectedItem().toString();
    }

    public int getAantalBakje1() {
        try {
            letter = false;
            return Integer.parseInt(JTaantalBakje1.getText());
        } catch (Exception e) {
            FMBakje1.setText("Geen juiste waarde ingevuld!");
            letter = true;
            return 0;
        }
    }

    public int getAantalBakje2() {
        try {
            letter2 = false;
            return Integer.parseInt(JTaantalBakje2.getText());
        } catch (Exception e) {
            FMBakje2.setText("Geen juiste waarde ingevuld!");
            letter2 = true;
            return 0;
        }
    }

    public boolean isGoed() {
        return goed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == terug) {
            this.setVisible(false);
        }
        if (e.getSource() == opslaan) {
            FMtotaal.setText("");
            FMBakje1.setText("");
            FMBakje2.setText("");
            FMgeheel.setText("");
            FMnaam.setText("");
            goed = true;
            if (getTotaal() <= 0) {
                FMtotaal.setText("Totaal is lager dan 0");
                goed = false;
            }
            if (getTotaal() < getAantalBakje1() + getAantalBakje2()) {
                FMgeheel.setText("Totaal kleiner dan bakje 1 en bakje 2");
                goed = false;
            }
            if (getAantalBakje1() <= 0 && !letter) {
                FMBakje1.setText("aantal bakje 1 is te laag");
                goed = false;
            }
            if (getAantalBakje2() <= 0 && !letter2) {
                FMBakje2.setText("aantal bakje 2 is te laag");
                goed = false;
            }
            if (getNaamProces().equals("")) {
                FMnaam.setText("Naam proces is niet ingevuld");
                goed = false;
            }
            if (getKleurBakje1().equals("Kies kleur")) {
                FMgeheel.setText("Kleur bakje 1 is niet ingevuld");
                goed = false;
            }
            if (getKleurBakje2().equals("Kies kleur")) {
                FMgeheel.setText(FMgeheel.getText() + "\n" + "Kleur bakje 2 is niet ingevuld");
                goed = false;
            }
            if (getKleurBakje1().equals(getKleurBakje2())) {
                FMgeheel.setText("Kleur bakje 1 is het hetzelfde als kleur van bakje 2");
                goed = false;
            }
            if (goed) {
                this.setVisible(false);
            }
        }
    }
}
