package lehioak;
import objektuak.Langile;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class langile extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel model;
    private JTable table;
    private JTextField izena;
    private JTextField abizenak;
    private JTextField nan;
    private JTextField saila;
    private JTextField soldata;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    langile frame = new langile();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public langile() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Langilea");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        
      //Lehenengo hilara
        JPanel GohikoPanela = new JPanel();
        GohikoPanela.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JLabel lblIzena = new JLabel("Izena:");
        GohikoPanela.add(lblIzena);
        
        izena = new JTextField(20);
        GohikoPanela.add(izena);
        
        JButton btnFitxategianGorde = new JButton("Fitxategian Gorde");
        GohikoPanela.add(btnFitxategianGorde);
        btnFitxategianGorde.setVisible(false);
        btnFitxategianGorde.addActionListener(e->{
            String filePath = "langileak.txt"; // artxiboaren izean + ubikazioa ipini dezakezu
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Kolumnen izenak
                for (int col = 0; col < model.getColumnCount(); col++) {
                    writer.write(model.getColumnName(col));
                    if (col < model.getColumnCount() - 1) {
                        writer.write(", "); // Kolumna bakoitza banatzeko
                    }
                }
                writer.newLine(); // fila bakoitzaren amaieran separazio bat
                //errenkadak eta kolumnak errekorritu
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        writer.write(model.getValueAt(row, col).toString());
                        if (col < model.getColumnCount() - 1) {
                            writer.write(", "); 
                        }
                    }
                    writer.newLine();
                    JOptionPane.showMessageDialog(langile.this, "Fitxategia ongi gorde da: " + filePath, "Mezua", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(langile.this, "Errorea: " + ex.getMessage(), "Mezua", JOptionPane.ERROR_MESSAGE);
            }
    
        });
        contentPane.add(GohikoPanela);
        
       //Bigarren hilara
        JPanel erdiPanela = new JPanel();
        erdiPanela.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JLabel lblAbizenak = new JLabel("Abizenak:");
        erdiPanela.add(lblAbizenak);
        
        abizenak = new JTextField(20);
        erdiPanela.add(abizenak);
        
        JButton btnGorde = new JButton("Gorde");
      
        /*TAULAN JOAN GORDETEKO DATU GUZTIAK*/
        btnGorde.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
                
        	String Izena = izena.getText();
            String Abizenak = abizenak.getText();
            String NAN = nan.getText();
            String Saila = saila.getText();
            String Soldata = soldata.getText();
            if (Izena.isEmpty() || Abizenak.isEmpty() || NAN.isEmpty() || Saila.isEmpty() || Soldata.isEmpty()) {
                JOptionPane.showMessageDialog(langile.this, "Hutsuneak ezin dira egon hutsik", "Errorea", JOptionPane.ERROR_MESSAGE);//necesitas decirle que el error viene de la ventana de langile
                return;
            } else if (NAN.length() != 9 && !Character.isLetter(NAN.charAt(8))) {//9-1 0-tik hasten garelako
                JOptionPane.showMessageDialog(langile.this, "NAN-a 9 karaktereak izan behar ditu", "Errorea", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                String filePath = "langileak.txt";
                boolean nanExists = false;
                //irakurri artxibo barruan ea existitzen duen nana
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(", "); // Jakinda datuak banatzen dira komen artean
                        if (data.length > 3 && data[3].trim().equals(NAN)) { // DNI-a hirugarren errenkadan dagoenez, hor konprobatuko du
                            nanExists = true;
                            break;
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(langile.this, "Errorea fitxategia irakurtzean: " + ex.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
                }
        
                if (nanExists) {
                    JOptionPane.showMessageDialog(langile.this, "Pertsona hau (NAN: " + NAN + ") jadanik erregistratuta dago!", "Errorea", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double soldata = Double.parseDouble(Soldata);//String moduan hartzen duenez, double batera pasa behar da
                try{
                    if(soldata < 0){
                        throw new IllegalArgumentException("Soldata negatiboa ez da onartua.");
                    }
                    else{
                        Langile langile = new Langile(Izena, Abizenak, NAN, 0.0, soldata, Saila);
                        model.addRow(new Object[]{langile.getLangile_zenb(), langile.getIzena(), langile.getAbizena(), langile.getNan(), langile.getSaila(), langile.getSoldata()});
                        
                    }
                    
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(langile.this, "soldata zenbaki positibo bat izan behar da", "Erorrea: ", JOptionPane.ERROR_MESSAGE);  
                }
                
            }
        
                btnFitxategianGorde.setVisible(true);
        	}
        });
       
        erdiPanela.add(btnGorde);
        
        contentPane.add(erdiPanela);

        //Hirugarren hilara
        JPanel panel_erdia_2 = new JPanel();
        panel_erdia_2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel lblNAN = new JLabel("NAN:");
        panel_erdia_2.add(lblNAN);

        nan = new JTextField(20); 
        panel_erdia_2.add(nan);

        contentPane.add(panel_erdia_2);

       //Laugarren hilara
        JPanel panel_erdia_3 = new JPanel();
        panel_erdia_3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel lblSaila = new JLabel("Saila:");
        panel_erdia_3.add(lblSaila);

        saila = new JTextField(20);
        panel_erdia_3.add(saila);

        contentPane.add(panel_erdia_3);

       //Bostgarren hilara
        JPanel panel_erdia_4 = new JPanel();
        panel_erdia_4.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 

        JLabel lblSoldata = new JLabel("Soldata:");
        panel_erdia_4.add(lblSoldata);

        soldata = new JTextField(20); 
        panel_erdia_4.add(soldata);

        contentPane.add(panel_erdia_4);

        //Seigarren hilara
        JPanel BehekoPanela = new JPanel();
        BehekoPanela.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 

    
        String[] columnNames = {"Zenbakia", "Izena", "Abizenak", "NAN", "Saila", "Soldata"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        BehekoPanela.add(scrollPane);

        contentPane.add(BehekoPanela);

    }
}