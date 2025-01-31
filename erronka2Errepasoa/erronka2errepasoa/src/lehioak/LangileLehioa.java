package lehioak;

import objetuak.Langile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

public class LangileLehioa extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FITXATEGIA = "Langileak.dat";
    private JTextField izenaField, abizenakField, nanField, sailaField, soldataField;
    private JTable table;
    private ArrayList<Langile> langileak;
    private boolean aldaketakGorde = false;

    public LangileLehioa() {
        setTitle("Langile Kudeaketa");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // Langileak kargatu
        langileak = kargatuLangileak();

        // Panelak
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        JPanel buttonPanel = new JPanel();

        // Etiketak eta sarrerak
        inputPanel.add(new JLabel("Izena:"));
        izenaField = new JTextField();
        inputPanel.add(izenaField);

        inputPanel.add(new JLabel("Abizenak:"));
        abizenakField = new JTextField();
        inputPanel.add(abizenakField);

        inputPanel.add(new JLabel("NAN:"));
        nanField = new JTextField();
        inputPanel.add(nanField);

        inputPanel.add(new JLabel("Saila:"));
        sailaField = new JTextField();
        inputPanel.add(sailaField);

        inputPanel.add(new JLabel("Soldata:"));
        soldataField = new JTextField();
        inputPanel.add(soldataField);

        // Botoiak
        JButton btnGorde = new JButton("Gorde");
        JButton btnFitxategianGorde = new JButton("Fitxategian Gorde");
        JButton btnIrten = new JButton("Irten");

        buttonPanel.add(btnGorde);
        buttonPanel.add(btnFitxategianGorde);
        buttonPanel.add(btnIrten);

        // Mahaiaren konfigurazioa
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        eguneratuMahai();

        // Paneletara gehitu
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Ekintzak
        btnGorde.addActionListener(e -> gordeLangilea());
        btnFitxategianGorde.addActionListener(e -> fitxategianGorde());
        btnIrten.addActionListener(e -> irten());

        // Leihoaren ixtea
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                irten();
            }
        });
    }

    private ArrayList<Langile> kargatuLangileak() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXATEGIA))) {
            return (ArrayList<Langile>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void fitxategianGorde() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FITXATEGIA))) {
            oos.writeObject(langileak);
            aldaketakGorde = false;
            JOptionPane.showMessageDialog(this, "Langileak fitxategian gorde dira.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Errorea fitxategian gordetzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gordeLangilea() {
        try {
            String izena = izenaField.getText().trim();
            String abizenak = abizenakField.getText().trim();
            String nan = nanField.getText().trim();
            String saila = sailaField.getText().trim();
            double soldata = Double.parseDouble(soldataField.getText().trim());

            if (izena.isEmpty() || abizenak.isEmpty() || nan.isEmpty() || saila.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Eremu guztiak bete behar dira.", "Errorea", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Langile langileBerria = new Langile(izena, abizenak, nan, saila, soldata);
            langileak.add(langileBerria);
            aldaketakGorde = true;
            eguneratuMahai();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sartu balio egokia soldatarako.", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eguneratuMahai() {
        String[] zutabeak = {"Zenbakia", "Izena", "Abizenak", "NAN", "Saila", "Soldata"};
        Object[][] datuak = new Object[langileak.size()][6];

        for (int i = 0; i < langileak.size(); i++) {
            Langile l = langileak.get(i);
            datuak[i][0] = l.getLangileZenbakia();
            datuak[i][1] = l.getIzena();
            datuak[i][2] = l.getAbizenak();
            datuak[i][3] = l.getNan();
            datuak[i][4] = l.getSaila();
            datuak[i][5] = l.getSoldata();
        }

        table.setModel(new DefaultTableModel(datuak, zutabeak));
    }

    private void irten() {
        if (aldaketakGorde) {
            int aukera = JOptionPane.showConfirmDialog(this, "Aldaketak gorde nahi dituzu irten baino lehen?", "Irten", JOptionPane.YES_NO_CANCEL_OPTION);
            if (aukera == JOptionPane.YES_OPTION) {
                fitxategianGorde();
                System.exit(0);
            } else if (aukera == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }
}