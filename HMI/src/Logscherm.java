import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator; // Import voor de zoek functie op het Logscherm.


public class Logscherm extends JDialog implements ActionListener {



    private JButton terug;
    private JLabel zoeken;
    private JComboBox zoek;
    private JTextArea gegevens;

    public Logscherm(JFrame frame){
        super(frame, true);

        String skip = "\n"; // Regel overslaan.

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // Combobox text in het midden zetten.

        setResizable(false);
        setTitle("Taken log scherm");
        setSize(1500,800);
        setLayout(null);
        setLocationRelativeTo(frame);

        zoeken = new JLabel("Zoeken sorteerproces op naam", SwingConstants.CENTER); // Label van zoekfunctie.
        zoeken.setBounds(650, 100, 200, 35);
        zoeken.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(zoeken);

        terug = new JButton("Terug"); // Knop om terug te gaan naar hoofdscherm
        terug.setBounds(100, 700, 150, 35);
        add(terug);
        terug.addActionListener(this);

        zoek = new JComboBox(new Object[]{"","Ester", "Jordi", // Zoekfunctie logscherm. Hier moet een ArrayList komen met eerder gebruikte taken.
                "Jordina", "Jorge", "Sergi"});
        zoek.setBounds(650, 150, 200, 35);
        zoek.setRenderer(dlcr);
        add(zoek);

        gegevens = new JTextArea("Totaal aantal gesorteerde Skittles: 30"+ skip +"Bakje1: rood, 15"+ skip +"Bakje2: groen, 12"); // Gegevens van eerder gebruikte taken.
        gegevens.setBounds(100, 200, 1300, 300);
        gegevens.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(gegevens);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == terug){ // Als de terug knop wordt ingedrukt.
            dispose();
        }
    }
}
