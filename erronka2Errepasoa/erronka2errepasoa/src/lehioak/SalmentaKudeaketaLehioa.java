package lehioak;

import objetuak.Salmenta;
import objetuak.Bezero;

import javax.swing.*;

import main.SupermerkatuKudeaketa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

public class SalmentaKudeaketaLehioa extends JFrame {
    private JTextField artikuluaField, kantitateaField, prezioaField, bezeroZenbakiaField;
    private JButton btnGorde, btnFitxategianGorde;
    private JTable table;
    private ArrayList<Salmenta> salmentak = new ArrayList<>();
    private ArrayList<Bezero> bezeroak = new ArrayList<>();
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

    public SalmentaKudeaketaLehioa() {
        // Cargar bezeroak desde el archivo .dat
        loadBezeroakFromFile();

        setTitle("Salmenta Kudeaketa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        artikuluaField = new JTextField();
        artikuluaField.setBounds(20, 56, 150, 25);
        getContentPane().add(artikuluaField);

        kantitateaField = new JTextField();
        kantitateaField.setBounds(20, 124, 150, 25);
        getContentPane().add(kantitateaField);

        prezioaField = new JTextField();
        prezioaField.setBounds(20, 185, 150, 25);
        getContentPane().add(prezioaField);

        bezeroZenbakiaField = new JTextField();
        bezeroZenbakiaField.setBounds(20, 244, 150, 25);
        getContentPane().add(bezeroZenbakiaField);

        btnGorde = new JButton("Gorde");
        btnGorde.setBounds(202, 325, 100, 25);
        getContentPane().add(btnGorde);

        btnFitxategianGorde = new JButton("Fitxategian Gorde");
        btnFitxategianGorde.setBounds(312, 325, 150, 25);
        btnFitxategianGorde.setVisible(false);
        getContentPane().add(btnFitxategianGorde);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 20, 250, 300);
        getContentPane().add(scrollPane);
        
        lblNewLabel = new JLabel("Artikulua:");
        lblNewLabel.setBounds(20, 43, 79, 14);
        getContentPane().add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Kantitatea:");
        lblNewLabel_1.setBounds(20, 109, 100, 14);
        getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Prezioa: ");
        lblNewLabel_2.setBounds(20, 170, 79, 14);
        getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Bezero Zenbakia:");
        lblNewLabel_3.setBounds(20, 231, 150, 14);
        getContentPane().add(lblNewLabel_3);
        
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(96, 326, 89, 23);
        getContentPane().add(btnAtzera);
        
        btnAtzera.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SupermerkatuKudeaketa SupermerkatuKudeaketa = new SupermerkatuKudeaketa();
        		dispose();
        	}
        });
        btnGorde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String artikulua = artikuluaField.getText();
                int kantitatea;
                double prezioa;
                int bezeroZenbakia;
        
                if (kantitateaField.getText().isEmpty() || prezioaField.getText().isEmpty() || bezeroZenbakiaField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mesedez, bete guztiak eremuak.");
                    return;
                }
        
                try {
                    kantitatea = Integer.parseInt(kantitateaField.getText());
                    prezioa = Double.parseDouble(prezioaField.getText());
                    bezeroZenbakia = Integer.parseInt(bezeroZenbakiaField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Mesedez, sartu zenbaki baliodunak.");
                    return;
                }
        
                Bezero bezero = findBezeroByZenbakia(bezeroZenbakia);
                if (bezero != null) {
                    Salmenta salmenta = new Salmenta(artikulua, kantitatea, prezioa, bezero);
                    salmentak.add(salmenta);
        
                    updateTable();
                    btnFitxategianGorde.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Bezeroa ez da aurkitu.");
                }
            }
        });

        btnFitxategianGorde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Salmenta.dat"))) {
                    oos.writeObject(salmentak);
                    JOptionPane.showMessageDialog(null, "Salmentak fitxategian gorde dira.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void loadBezeroakFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Bezeroak.dat"))) {
            bezeroak = (ArrayList<Bezero>) ois.readObject();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ez da Bezeroak.dat fitxategia aurkitu. Bezeroak hutsik hasiko dira.");
            bezeroak = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Bezero findBezeroByZenbakia(int bezeroZenbakia) {
        for (Bezero bezero : bezeroak) {
            if (bezero.getBezeroZenbakia() == bezeroZenbakia) {
                return bezero;
            }
        }
        return null;
    }

    private void updateTable() {
        String[] columnNames = {"Salmenta Kod", "Artikulua", "Kantitatea", "Prezioa", "Guztizkoa", "Bezero Zenbakia"};
        Object[][] data = new Object[salmentak.size()][6];
        for (int i = 0; i < salmentak.size(); i++) {
            data[i][0] = salmentak.get(i).getSalmentaKod();
            data[i][1] = salmentak.get(i).getArtikulua();
            data[i][2] = salmentak.get(i).getKantitatea();
            data[i][3] = salmentak.get(i).getPrezioa();
            data[i][4] = salmentak.get(i).getGustizkoa();
            data[i][5] = salmentak.get(i).getBezero().getBezeroZenbakia();
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
