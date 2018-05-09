import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator; // Import voor de zoek functie op het Logscherm.


public class Logscherm extends JDialog implements ActionListener, ListSelectionListener {



    private ArrayList<String> lijstje = new ArrayList<>();
    private JButton terug, selecteer;
    private JLabel zoeken;
    private JComboBox zoek = new JComboBox();
    private JTextArea gegevens;
    private JList lijst;
    private JScrollPane scroll;

    public Logscherm(JFrame frame) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        super(frame, true);

        Database d1 = new Database();
        d1.connectie(); // Hier wordt er een database connectie aangemaakt.

        Statement st = d1.getCon().createStatement();
        String sql = ("SELECT * FROM sorteerproces ORDER BY ID;"); // Query pakt alles uit de database.
        ResultSet rs = st.executeQuery(sql);


        String id = "";
        while(rs.next()) {
            id = rs.getString("sorteerprocesNaam");
            int aantal = rs.getInt("aantal");
            String kleur = rs.getString("kleur");

            lijstje.add(id);
            zoek.addItem(id);// Voegt id toe aan de combobox.
        }

        String skip = "\n"; // Regel overslaan.

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // Combobox text in het midden zetten.

        setResizable(false);
        setTitle("Taken log scherm");
        setSize(800,500);
        setLayout(null);
        setLocationRelativeTo(frame);

        zoeken = new JLabel("Zoeken sorteerproces op naam", SwingConstants.CENTER); // Label van zoekfunctie.
        zoeken.setBounds(300, 25, 200, 35);
        zoeken.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(zoeken);

        terug = new JButton("Terug"); // Knop om terug te gaan naar hoofdscherm
        terug.setBounds(20, 410, 150, 35);
        add(terug);
        terug.addActionListener(this);


        scroll = new JScrollPane();
        scroll.setBounds(50, 115, 700, 100);

        zoek.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                return new JButton() {
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });

        lijst = new JList(lijstje.toArray()); // Lijst voor database gegevens.
        lijst.setBounds(50, 115, 700, 100);
        lijst.addListSelectionListener(this);
        lijst.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(lijst);
        add(scroll);
        scroll.setViewportView(lijst);

        AutoCompleteDecorator.decorate(zoek);
        // Zoekfunctie logscherm.
        zoek.setBounds(300, 70, 200, 35);
        zoek.setRenderer(dlcr);
        zoek.addActionListener(this);
        zoek.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(zoek);

        gegevens = new JTextArea(); // Gegevens van eerder gebruikte taken.
        gegevens.setBounds(50, 240, 700, 100);
        gegevens.setBorder(BorderFactory.createLineBorder(Color.gray));
        gegevens.setEditable(false);
        add(gegevens);

        d1.connectieSluiten(); // Sluit de database connectie.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == terug){ // Als de terug knop wordt ingedrukt.

            dispose();
        }

        if(e.getSource() == zoek){
            String naam = zoek.getSelectedItem().toString(); // Naam van item combobox.

            lijst.setSelectedIndex(zoek.getSelectedIndex());
            Database d1 = new Database();
            try {
                d1.connectie(); // Maakt een database connectie aan.
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            Statement st = null;
            try {
                st = d1.getCon().createStatement();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            String sql = ("SELECT * FROM sorteerproces ORDER BY ID;");

            ResultSet rs = null;
            try {
                rs = st.executeQuery(sql);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }



            try {
                while (rs.next()) {
                    String id = rs.getString("sorteerprocesNaam");
                    int aantal = rs.getInt("aantal");
                    String kleur = rs.getString("kleur");

                    if(naam.equals(id)){
                        String skip = "\n"; // Regel overslaan.
                        gegevens.setText("Naam sorteerproces: "+id +skip+"Aantal Skittles: "+ aantal +skip+"Kleur: "+kleur); // Pakt gegevens bij geselecteerde item.
                    }

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                d1.connectieSluiten();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource() == lijst){
            String naam = lijst.getSelectedValue().toString();

            Database d1 = new Database();
            try {
                d1.connectie();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            Statement st = null;
            try {
                st = d1.getCon().createStatement();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            String sql = ("SELECT * FROM sorteerproces ORDER BY ID;");

            ResultSet rs = null;
            try {
                rs = st.executeQuery(sql);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }



            try {
                while (rs.next()) {
                    String id = rs.getString("sorteerprocesNaam");
                    int aantal = rs.getInt("aantal");
                    String kleur = rs.getString("kleur");

                    if(naam.equals(id)){
                        String skip = "\n"; // Regel overslaan.
                        gegevens.setText("Naam sorteerproces: "+id +skip+"Aantal Skittles: "+ aantal +skip+"Kleur: "+kleur); // Pakt gegevens bij geselecteerde item.
                    }

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                d1.connectieSluiten();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
