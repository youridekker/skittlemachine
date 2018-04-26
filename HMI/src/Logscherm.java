import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Logscherm extends JDialog implements ActionListener {



    private JButton terug;
    private JLabel zoeken;
    private JComboBox zoek;
    private JTextArea gegevens;

    public Logscherm(JFrame frame){
        super(frame, true);

        String skip = "\n";

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        setResizable(false);
        setTitle("Taken log scherm");
        setSize(1500,800);
        setLayout(null);
        setLocationRelativeTo(frame);

        zoeken = new JLabel("Zoeken sorteerproces op naam", SwingConstants.CENTER);
        zoeken.setBounds(650, 100, 200, 35);
        zoeken.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(zoeken);

        terug = new JButton("Terug");
        terug.setBounds(100, 700, 150, 35);
        add(terug);
        terug.addActionListener(this);

        zoek = new JComboBox(new Object[]{"","Ester", "Jordi",
                "Jordina", "Jorge", "Sergi"});
        zoek.setBounds(650, 150, 200, 35);
        zoek.setRenderer(dlcr);
        add(zoek);

        gegevens = new JTextArea("Totaal aantal gesorteerde Skittles: 30"+ skip +"Bakje1: rood, 15"+ skip +"Bakje2: groen, 12");
        gegevens.setBounds(100, 200, 1300, 300);
        gegevens.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(gegevens);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == terug){
            dispose();
        }
    }
}
