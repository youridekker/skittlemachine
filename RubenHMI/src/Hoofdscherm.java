import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hoofdscherm extends JFrame implements ActionListener {
    private JButton start, stop, sorteer, log;
    private JTextArea graphic, instellingenHuidig, foutmeldingen;
    private JLabel huidig, fout;

    public Hoofdscherm() {
        setTitle("Hoofdscherm");
        setSize(1500,800);
        setLayout(null);

        //grafische weergave sorteerproces
        graphic = new JTextArea("Graphics");
        graphic.setBounds(100, 50, 1300, 350);
        add(graphic);

        //huidige instellingen sorteerproces
        instellingenHuidig = new JTextArea();
        instellingenHuidig.setBounds(100, 570, 400, 100);
        instellingenHuidig.setBorder(BorderFactory.createLineBorder(Color.gray));
        instellingenHuidig.setEditable(false);
        add(instellingenHuidig);

        //foutmeldingen huidige sorteerproces
        foutmeldingen = new JTextArea();
        foutmeldingen.setBounds(1000, 570, 400, 100);
        foutmeldingen.setText("");
        foutmeldingen.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(foutmeldingen);

        //startknop
        start = new JButton("Starten sorteerproces");
        start.setBounds(100, 420, 170, 35);
        add(start);
        //start.addActionListener(this);

        //stop knop
        stop = new JButton("Stoppen sorteerproces");
        stop.setBounds(1230, 420, 170, 35);
        add(stop);

        //sorteer knop
        sorteer = new JButton("Sorteren");
        sorteer.setBounds(1270, 710, 130, 35);
        add(sorteer);
        sorteer.addActionListener(this);

        log = new JButton("Taken log");
        log.setBounds(100, 710, 130, 35);
        add(log);
        log.addActionListener(this);

        //label met instellingen van huidige sorteerproces
        huidig = new JLabel(" Instellingen huidig sorteerproces");
        huidig.setBounds(100, 520, 300, 35);
        add(huidig);

        //label van de foutmeldingen
        fout = new JLabel(" Foutmelding");
        fout.setBounds(1000, 520, 200, 35);
        add(fout);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sorteer) {
            Sorteerscherm s = new Sorteerscherm(this);
            s.setVisible(true);
            if (s.isGoed()) {
                instellingenHuidig.setText("Naam: " + s.getNaamProces() + "\n"
                        + "Totaal aantal: " + s.getTotaal() + "\n"
                        + "Kleur bakje 1: " + s.getKleurBakje1() + ", aantal: " + s.getAantalBakje1() + "\n"
                        + "Kleur bakje 2: " + s.getKleurBakje2() + ", aantal: " + s.getAantalBakje2());

                int aantalderdebakje = s.getTotaal() - s.getAantalBakje2() - s.getAantalBakje1();
                //toevoegen aan database
                DBConnect db = new DBConnect("root", "");
                String sql = "INSERT INTO Bakje(kleur, hoeveelheid, derdebakje) values( \"" + s.getKleurBakje1() + "\"," + s.getAantalBakje1() + ", false); ";
                String sql2 = "INSERT INTO Bakje(kleur, hoeveelheid, derdebakje) values( \"" + s.getKleurBakje2() +"\","+ s.getAantalBakje2() + ", false);";
                String sql3 = "INSERT INTO Bakje(hoeveelheid, derdebakje) values(" + aantalderdebakje + ", true)";
                String sql4 = "SELECT * FROM Bakje ORDER BY ID DESC LIMIT 1";
                String sql6 = "SELECT * FROM Robot ORDER BY ID DESC LIMIT 1";

                System.out.println(sql);
                try {
                    db.connect();
                    int rs = db.getStatement().executeUpdate(sql);
                    ResultSet rs1 = db.getStatement().executeQuery(sql4);

                    int bakje1 = 0;
                    while (rs1.next()) {
                        bakje1 = rs1.getInt("ID");
                    }

                    int rs2 = db.getStatement().executeUpdate(sql2);
                    ResultSet rs3 = db.getStatement().executeQuery(sql4);

                    int bakje2 = 0;
                    while (rs3.next()) {
                        bakje2 = rs3.getInt("ID");
                    }

                    int rs4 = db.getStatement().executeUpdate(sql3);
                    ResultSet rs5 = db.getStatement().executeQuery(sql4);

                    int bakje3 = 0;
                    while(rs5.next()) {
                        bakje3 = rs5.getInt("ID");
                    }


                    String sql5 = "INSERT INTO Robot(hoeveelheid, bakje1, bakje2, bakje3) values(" + s.getTotaal() + ", " + bakje1 + "," + bakje2 + "," + bakje3 + ");";
                    int rs6 = db.getStatement().executeUpdate(sql5);
                    ResultSet rs7 = db.getStatement().executeQuery(sql6);

                    int robot = 0;
                    while (rs7.next()) {
                        robot = rs7.getInt("ID");
                    }

                    String sql7 = "INSERT INTO Proces(naam, robot1) values(\"" + s.getNaamProces() + "\"," + robot +");";

                    System.out.println(sql7);
                    int rs8 = db.getStatement().executeUpdate(sql7);

                    db.closeConnection();
                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
            }
        } else if (e.getSource() == log) {
            Logscherm l = null;
            try {
                l = new Logscherm(this);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
            l.setVisible(true);

        }
    }
}
