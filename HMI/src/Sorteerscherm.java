import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sorteerscherm extends JDialog implements ActionListener {

    private JTextField JTnaam, JTtotaal, JTaantalBakje1, JTaantalBakje2;
    private JLabel JLnaam, JLtotaal, JLaantalBakje1, JLaantalBakje2, JLeerder;
    private JComboBox JCkleurBakje1, JCkleurBakje2, JCeerderGebruikte;
    private JTextArea visueelBakje1, visueelBakje2;
    private JButton terug, opslaan;

    public Sorteerscherm(JFrame frame){
        super(frame, true);

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);


        String[] kleuren = {"Kies kleur","Paars", "Rood", "Oranje", "Groen", "Geel"};
        String[] instellingen = {"Selecteer sorteerproces", "Sorteerproces1", "Sorteerproces2", "Sorteerproces3"};

        setResizable(false);
        setTitle("Sorteerscherm");
        setSize(1500,800);
        setLayout(null);
        setLocationRelativeTo(frame);

        JTnaam = new JTextField(10);
        JTnaam.setBounds(100, 100, 150, 35);
        add(JTnaam);

        JTtotaal = new JTextField(10);
        JTtotaal.setBounds(100, 145, 150, 35);
        add(JTtotaal);

        JTaantalBakje1 = new JTextField(10);
        JTaantalBakje1.setBounds(100, 190, 150, 35);
        add(JTaantalBakje1);

        JTaantalBakje2 = new JTextField(10);
        JTaantalBakje2.setBounds(100, 235, 150, 35);
        add(JTaantalBakje2);

        JLnaam = new JLabel("     Naam sorteerproces");
        JLnaam.setBounds(280, 100, 150, 35);
        JLnaam.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLnaam);

        JLtotaal = new JLabel("     Totaal aantal Skittles");
        JLtotaal.setBounds(280, 145, 150, 35);
        JLtotaal.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLtotaal);

        JLaantalBakje1 = new JLabel("     Aantal Skittles bakje1");
        JLaantalBakje1.setBounds(280,190, 150,35);
        JLaantalBakje1.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLaantalBakje1);

        JLaantalBakje2 = new JLabel("     Aantal Skittles bakje2");
        JLaantalBakje2.setBounds(280, 235, 150, 35);
        JLaantalBakje2.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLaantalBakje2);

        JLeerder = new JLabel("Selecteer hier een eerder gebruikt proces", SwingConstants.CENTER );
        JLeerder.setBounds(100, 290, 450, 35);
        JLeerder.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(JLeerder);

        JCkleurBakje1 = new JComboBox(kleuren);
        JCkleurBakje1.setBounds(460, 190, 90,35);
        JCkleurBakje1.setRenderer(dlcr);
        add(JCkleurBakje1);

        JCkleurBakje2 = new JComboBox(kleuren);
        JCkleurBakje2.setBounds(460, 235, 90, 35);
        JCkleurBakje2.setRenderer(dlcr);
        add(JCkleurBakje2);

        JCeerderGebruikte = new JComboBox(instellingen);
        JCeerderGebruikte.setBounds(100, 335, 450,35);
        JCeerderGebruikte.setRenderer(dlcr);
        add(JCeerderGebruikte);

        visueelBakje1 = new JTextArea("Visueel bakje1");
        visueelBakje1.setBounds(750, 100, 600, 250);
        add(visueelBakje1);

        visueelBakje2 = new JTextArea("Visueel bakje2");
        visueelBakje2.setBounds(750, 400, 600, 250);
        add(visueelBakje2);

        terug = new JButton("Terug");
        terug.setBounds(100, 700, 150, 35);
        add(terug);
        terug.addActionListener(this);

        opslaan = new JButton("Sorteerproces opslaan");
        opslaan.setBounds(1180, 700, 170,35);
        add(opslaan);
        opslaan.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == terug){
            dispose();
        }


    }
}
