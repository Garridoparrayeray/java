package lehioak;

import objetuak.Bezero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.SupermerkatuKudeaketa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class BezeroLehioa extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String FITXATEGIA = "Bezeroak.dat";
    private JTextField izenaField, abizenakField, nanField, aurreztutakoDiruaField;
    private JTable table;
    private ArrayList<Bezero> bezeroak;
    private boolean aldaketakGorde = false;

    public BezeroLehioa() {
        setTitle("Bezero Kudeaketa");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // Bezeroak kargatu
        bezeroak = kargatuBezeroak();

        // Panelak
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
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

        inputPanel.add(new JLabel("Aurreztutako dirua:"));
        aurreztutakoDiruaField = new JTextField();
        inputPanel.add(aurreztutakoDiruaField);

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
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        JButton btnAtzera = new JButton("Atzera");
        buttonPanel.add(btnAtzera);

        // Ekintzak
        btnAtzera.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SupermerkatuKudeaketa SupermerkatuKudeaketa = new SupermerkatuKudeaketa();
        		dispose();
        	}
        });
        btnGorde.addActionListener(e -> gordeBezeroa());
        btnFitxategianGorde.addActionListener(e -> fitxategianGorde());
        btnIrten.addActionListener(e -> irten());

        // Leihoaren ixtea
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                irten();
            }
        });
    }

    private ArrayList<Bezero> kargatuBezeroak() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXATEGIA))) {
            return (ArrayList<Bezero>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void fitxategianGorde() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FITXATEGIA))) {
            oos.writeObject(bezeroak);
            aldaketakGorde = false;
            JOptionPane.showMessageDialog(this, "Bezeroak fitxategian gorde dira.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Errorea fitxategian gordetzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gordeBezeroa() {
        try {
            String izena = izenaField.getText();
            String abizenak = abizenakField.getText();
            String nan = nanField.getText();
            double aurreztutakoDirua = Double.parseDouble(aurreztutakoDiruaField.getText());

            Bezero bezeroBerria = new Bezero(izena, abizenak, nan, aurreztutakoDirua);

            bezeroak.add(bezeroBerria);
            aldaketakGorde = true;
            eguneratuMahai();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sarrera ez da egokia.", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eguneratuMahai() {
        String[] zutabeak = {"Zenbakia", "Izena", "Abizenak", "NAN", "Aurreztutako Dirua"};
        Object[][] datuak = new Object[bezeroak.size()][5];

        for (int i = 0; i < bezeroak.size(); i++) {
            Bezero b = bezeroak.get(i);
            datuak[i][0] = b.getBezeroZenbakia();
            datuak[i][1] = b.getIzena();
            datuak[i][2] = b.getAbizenak();
            datuak[i][3] = b.getNan();
            datuak[i][4] = b.getAurreztutakoDirua();
        }

        table.setModel(new DefaultTableModel(datuak, zutabeak));
    }

    private void irten() {
        int aukera = JOptionPane.showConfirmDialog(this, "Ziur zaude irten nahi duzula?", "Irten", JOptionPane.YES_NO_OPTION);
        if (aukera == JOptionPane.YES_OPTION) {
            if (aldaketakGorde) {
                int gordeAukera = JOptionPane.showConfirmDialog(this, "Aldaketak gorde nahi dituzu?", "Gorde", JOptionPane.YES_NO_CANCEL_OPTION);
                if (gordeAukera == JOptionPane.YES_OPTION) {
                    fitxategianGorde();
                } else if (gordeAukera == JOptionPane.CANCEL_OPTION) {
                    return; // Ez irten
                }
            }
            System.exit(0);
        }
    }

}
