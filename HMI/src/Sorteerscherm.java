import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;

public class Sorteerscherm extends JDialog implements ActionListener {

    private boolean isOk;
    private JTextField JTnaam, JTtotaal, JTaantalBakje1, JTaantalBakje2;
    private JLabel JLnaam, JLtotaal, JLaantalBakje1, JLaantalBakje2, JLeerder;
    private JComboBox JCkleurBakje1, JCkleurBakje2, JCeerderGebruikte;
    private JTextArea visueelBakje1, visueelBakje2;
    private JButton terug, opslaan;

    public String getJTnaam() {
        return JTnaam.getText();
    }

    public String getJTtotaal() {
        return JTtotaal.getText();
    }

    public String getJCkleurBakje2() {
        return JCkleurBakje2.getSelectedItem().toString();
    }

    public String getJCkleurBakje1() {
        return JCkleurBakje1.getSelectedItem().toString();
    }

    public String getJTaantalBakje1() {
        return JTaantalBakje1.getText();
    }

    public String getJTaantalBakje2() {
        return JTaantalBakje2.getText();
    }

    public Sorteerscherm(JFrame frame){
        super(frame, true);

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // Dit wordt gebruikt om tekst, in een combobox, in het midden te zetten.


        String[] kleuren = {"Kies kleur","Paars", "Rood", "Oranje", "Groen", "Geel"}; // Array kleuren van Skittles.
        String[] instellingen = {"Selecteer sorteerproces", "Sorteerproces1", "Sorteerproces2", "Sorteerproces3"}; // Array verschillende

        setResizable(false);
        setTitle("Sorteerscherm");
        setSize(1500,800);

        setLayout(null);
        setLocationRelativeTo(frame);

        JTnaam = new JTextField(10); // Textfield voor naam van sorteerproces.
        JTnaam.setBounds(100, 100, 150, 35);
        add(JTnaam);

        JTtotaal = new JTextField(10); // Textfield voor het aantal te sorteren Skittles.
        JTtotaal.setBounds(100, 145, 150, 35);
        add(JTtotaal);

        JTaantalBakje1 = new JTextField(10); // Textfield voor het aantal te sorteren voor bakje1.
        JTaantalBakje1.setBounds(100, 190, 150, 35);
        add(JTaantalBakje1);

        JTaantalBakje2 = new JTextField(10); // Textfield voor het aantal te sorteren voor bakje2.
        JTaantalBakje2.setBounds(100, 235, 150, 35);
        add(JTaantalBakje2);

        JLnaam = new JLabel("     Naam sorteerproces"); // Label van naam sorteerproces.
        JLnaam.setBounds(280, 100, 150, 35);
        JLnaam.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLnaam);

        JLtotaal = new JLabel("     Totaal aantal Skittles"); // Label van het totaal aantal.
        JLtotaal.setBounds(280, 145, 150, 35);
        JLtotaal.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLtotaal);

        JLaantalBakje1 = new JLabel("     Aantal Skittles bakje1"); // Label van het aantal bakje1.
        JLaantalBakje1.setBounds(280,190, 150,35);
        JLaantalBakje1.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLaantalBakje1);

        JLaantalBakje2 = new JLabel("     Aantal Skittles bakje2"); // Label van het aantal bakje2.
        JLaantalBakje2.setBounds(280, 235, 150, 35);
        JLaantalBakje2.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLaantalBakje2);

        JLeerder = new JLabel("Selecteer hier een eerder gebruikt proces", SwingConstants.CENTER ); // Label van eerder gebruikte processen.
        JLeerder.setBounds(100, 290, 450, 35);
        JLeerder.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLeerder);

        JCkleurBakje1 = new JComboBox(kleuren); // Combobox voor de kleur van de Skittle, voor bakje1.
        JCkleurBakje1.setBounds(460, 190, 90,35);
        JCkleurBakje1.setRenderer(dlcr);
        add(JCkleurBakje1);

        JCkleurBakje2 = new JComboBox(kleuren); // Combobox voor de kleur van de Skittle, voor bakje2.
        JCkleurBakje2.setBounds(460, 235, 90, 35);
        JCkleurBakje2.setRenderer(dlcr);
        add(JCkleurBakje2);

        JCeerderGebruikte = new JComboBox(instellingen); // Combobox voor eerder gebruikte processen.
        JCeerderGebruikte.setBounds(100, 335, 450,35);
        JCeerderGebruikte.setRenderer(dlcr);
        add(JCeerderGebruikte);

        visueelBakje1 = new JTextArea("Visueel bakje1"); // Visuele representatie van bakje1.
        visueelBakje1.setBounds(750, 100, 600, 250);
        add(visueelBakje1);

        visueelBakje2 = new JTextArea("Visueel bakje2"); // visuele representatie van bakje2.
        visueelBakje2.setBounds(750, 400, 600, 250);
        add(visueelBakje2);

        terug = new JButton("Terug"); // Knop om terug te gaan naar het hoofdscherm.
        terug.setBounds(100, 700, 150, 35);
        add(terug);
        terug.addActionListener(this);

        opslaan = new JButton("Sorteerproces opslaan"); // Knop om de ingevoerde instellingen op te slaan.
        opslaan.setBounds(1180, 700, 170,35);
        add(opslaan);
        opslaan.addActionListener(this);
    }

    public boolean isOk() {
        return isOk;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == terug){
            dispose();
        }

        if(e.getSource() == opslaan) {

            String naam = getJTnaam();
            String totaal = getJTtotaal();
            String aantalBakje1 = getJTaantalBakje1();
            String aantalBakje2 = getJTaantalBakje2();
            String kleurBakje1 = getJCkleurBakje1();
            String kleurBakje2 = getJCkleurBakje2();
            String melding = "";



            if (!totaal.equals("") && !aantalBakje1.equals("") && !aantalBakje2.equals("")) {


                if (Integer.parseInt(aantalBakje1) + Integer.parseInt(aantalBakje2) > Integer.parseInt(totaal)) {
                    melding += " Het totaal aantal Skittles, overschreid het totaal van bakje1 en bakje2!";
                }
            }
            if (naam.equals("")) {
                melding += " De naam van het sorteerproces is niet ingevuld!";
            }

            if (totaal.equals("")) {
                melding += " Het totaal aantal te sorteren Skittles is niet ingevuld!";
            }

            if (aantalBakje1.equals("")) {
                melding += " Het aantal te sorteren Skittles voor bakje1 is niet ingevuld!";
            }

            if (aantalBakje2.equals("")) {
                melding += " Het aantal te sorteren Skittles voor bakje2 is niet ingevuld!";
            }

            if (kleurBakje1.equals("")) {
                melding += " De kleur van de te sorteren Skittle voor bakje1 is niet ingevuld!";
            }

            if (kleurBakje2.equals("")) {
                melding += " De kleur van de te sorteren Skittle voor bakje2 is niet ingevuld!";
            }
            if (!melding.equals("")) {
                JOptionPane.showMessageDialog(this, "De invoer is niet compleet. " + melding);
                isOk = false;
            }else{
                isOk = true;
            }
            setVisible(false);



        }


    }
}
