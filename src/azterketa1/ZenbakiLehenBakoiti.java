package azterketa1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;


public class ZenbakiLehenBakoiti extends JFrame {

	private static final long serialVersionUID = 20241114L;
	private JPanel contentPane;
	private JTextField txtZenbakia;
	private JPanel panelGoiburua;
	private JLabel lblZenbakia;
	private JButton btnGehitu;
	private JButton btnEzabatu;
	private JButton btnGarbitu;

	private JPanel panelOina;
	private JLabel lblZenbakiakGuztira;
	private JLabel lblZerrendaBietakoGuztira;
	private JLabel lblBatazbesteko;
	private JLabel lblBienBatazbesteko;

	private JPanel panelErdikoa;
	private JPanel panelLehenak;
	private JLabel lblLehenak;
	private JList<Integer> lstLehenak;
	private DefaultListModel<Integer> dlmLehenak;
	private JPanel panelEzLehenak;
	private JLabel lblEzLehenak;
	private JList<Integer> lstEzLehenak;
	private DefaultListModel<Integer> dlmEzLehenak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZenbakiLehenBakoiti frame = new ZenbakiLehenBakoiti();
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
	public ZenbakiLehenBakoiti() {
		setTitle("Azterketa1 – Yeray Garrido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelGoiburua = new JPanel();
		contentPane.add(panelGoiburua, BorderLayout.NORTH);

		lblZenbakia = new JLabel("Zenbakia");
		panelGoiburua.add(lblZenbakia);

		txtZenbakia = new JTextField();
		txtZenbakia.setHorizontalAlignment(SwingConstants.RIGHT);
		txtZenbakia.setText("0");
		panelGoiburua.add(txtZenbakia);
		txtZenbakia.setColumns(10);

		btnGehitu = new JButton("Geitu");
		panelGoiburua.add(btnGehitu);
		
		btnEzabatu = new JButton("Ezabatu");
		panelGoiburua.add(btnEzabatu);

		btnGarbitu = new JButton("Garbitu");
		panelGoiburua.add(btnGarbitu);

		panelErdikoa = new JPanel();
		contentPane.add(panelErdikoa, BorderLayout.CENTER);
		panelErdikoa.setLayout(new BorderLayout(0, 0));

		panelLehenak = new JPanel();
		panelErdikoa.add(panelLehenak, BorderLayout.WEST);
		panelLehenak.setLayout(new BorderLayout(0, 0));

		// lstLehenak zerrendako datuen eredua sortzen dut
		dlmLehenak = new DefaultListModel<Integer>();

		// zerrenda sortzen dut
		lstLehenak = new JList<Integer>();
		// datu modeloa zerrendari atxikitzen diot
		lstLehenak.setModel(dlmLehenak);
		panelLehenak.add(lstLehenak, BorderLayout.CENTER);

		lblLehenak = new JLabel("Zenbaki Lehenak");
		lblLehenak.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLehenak.setHorizontalAlignment(SwingConstants.CENTER);
		panelLehenak.add(lblLehenak, BorderLayout.NORTH);

		panelEzLehenak = new JPanel();
		panelErdikoa.add(panelEzLehenak, BorderLayout.EAST);
		panelEzLehenak.setLayout(new BorderLayout(0, 0));

		lblEzLehenak = new JLabel("Zenbaki bakoiti ez lehena");
		lblEzLehenak.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEzLehenak.setHorizontalAlignment(SwingConstants.CENTER);
		panelEzLehenak.add(lblEzLehenak, BorderLayout.NORTH);

		// zerrendako datuen eredua sortzen dut lstEzLehenak
		dlmEzLehenak = new DefaultListModel<Integer>();

		// zerrenda sortzen dut
		lstEzLehenak = new JList<Integer>();
		// datuen eredua zerrendari lotzen diot
		lstEzLehenak.setModel(dlmEzLehenak);
		panelEzLehenak.add(lstEzLehenak, BorderLayout.CENTER);

		panelOina = new JPanel();
		contentPane.add(panelOina, BorderLayout.SOUTH);

		lblZenbakiakGuztira = new JLabel("ZenbakiakGuztira:");
		panelOina.add(lblZenbakiakGuztira);

		lblZerrendaBietakoGuztira = new JLabel("0");
		lblZerrendaBietakoGuztira.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblZerrendaBietakoGuztira.setHorizontalAlignment(SwingConstants.RIGHT);
		panelOina.add(lblZerrendaBietakoGuztira);

		lblBatazbesteko = new JLabel("Batazbestekoa: ");
		panelOina.add(lblBatazbesteko);

		lblBienBatazbesteko = new JLabel("0.0");
		lblBienBatazbesteko.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBienBatazbesteko.setHorizontalAlignment(SwingConstants.RIGHT);
		panelOina.add(lblBienBatazbesteko);
		btnGehitu.addActionListener(e->GehituZnbk());
		btnEzabatu.addActionListener(e->EzabatuBak(lstEzLehenak, dlmEzLehenak));
		btnEzabatu.addActionListener(e->EzabatuLehena(lstLehenak, dlmLehenak));
		btnGarbitu.addActionListener(e-> GarbituListak());
	}
	private void GehituZnbk() {
		int znbk;
		
		if(txtZenbakia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Errorea sartzean. Zenbakia eremua ezin\r\n"
					+ "da hutsik egon");
		}else {
			znbk = Integer.parseInt(txtZenbakia.getText());
			if(znbk % 2 == 0) {
				JOptionPane.showMessageDialog(this, znbk + " Ez da lehena ez bakoitia");
				}else {
				ZenbakiLehenak();
			}
			
			
		}
	}
	
	private void ZenbakiLehenak() {
		int Gehitu;
		boolean Lehena;
		Lehena = true;
		Gehitu = Integer.parseInt(txtZenbakia.getText());
		
        for (int i = 2; i <= Math.sqrt(Gehitu); i++) {
            if (Gehitu % i == 0) {
                Lehena = false;
                break;
                
            }
        }
        if(dlmLehenak.contains(Gehitu) || dlmEzLehenak.contains(Gehitu)) {
        	JOptionPane.showMessageDialog(this, "Errorea gehitzean." +Gehitu+ "zenbakia dagoeneko zerrenda batean dago");
        }else {
          if (Lehena) {
          	int index = 0;
          	while(index < dlmLehenak.size() && dlmLehenak.get(index) < Gehitu) {//lista 0 baino handiagoa bada(errenkarik badeko) ETA balorea baino txikiagoa bada, gehitu
          		index++;//index baino handiagoa denean, jarri zenbakia
          	}
            dlmLehenak.add(index, Gehitu);
            lblZenbakiakGuztira.setText("ZenbakiakGuztira: "+ kalkulatuGuztizkoa());
            
          }else {
          	int index = 0;
          	while(index < dlmEzLehenak.size() && dlmLehenak.get(index) < Gehitu) {//lista 0 baino handiagoa bada(errenkarik badeko) ETA balorea baino txikiagoa bada, gehitu
          		index++;//index baino handiagoa denean, jarri zenbakia
          	}
           		dlmEzLehenak.add(index, Gehitu);
           		lblZenbakiakGuztira.setText("ZenbakiakGuztira: "+ kalkulatuGuztizkoa());
          
          	}
        }
      
	}
	private void EzabatuBak(JList<Integer> listaBak, DefaultListModel<Integer> model) {
    int[] selectedIndices = listaBak.getSelectedIndices();
    if (selectedIndices.length > 0) {
    	for (int i = selectedIndices.length - 1; i >= 0; i--) {
   		
    		model.remove(selectedIndices[i]);
    	}
     
    }else {
    	JOptionPane.showMessageDialog(this, "Errorea ezabatzean. Zerrendetan EZ dago elementurik hautatuta ");
    }
	}
	private void EzabatuLehena(JList<Integer> listaLehena, DefaultListModel<Integer> model) {
    int[] selectedIndices = listaLehena.getSelectedIndices();
    
    if (selectedIndices.length > 0) {
    	for (int i = selectedIndices.length - 1; i >= 0; i--) {
    		
    		model.remove(selectedIndices[i]);
    	}
    
     
    }else {
    	JOptionPane.showMessageDialog(this, "Errorea ezabatzean. Zerrendetan EZ dago elementurik hautatuta");
    }
	}
	 private void GarbituListak() {
		 if(dlmLehenak.isEmpty() && dlmEzLehenak.isEmpty()) {
     		JOptionPane.showMessageDialog(this, "Errore bat gertatu da zerrendak hustutzean. Zerrendak dagoeneko hutsik daude");
     		}else {
     			dlmLehenak.clear(); 
     			dlmEzLehenak.clear(); 
    		   txtZenbakia.setText("0");
     		}
		    
		}
	 private int kalkulatuGuztizkoa() {
		 int Gehiketa = 0;
		 for(int i = 0; i < dlmLehenak.size();i++) {
			 Gehiketa += dlmLehenak.get(i);
		 }
		 for(int i = 0; i < dlmEzLehenak.size();i++) {
			 Gehiketa += dlmEzLehenak.get(i);
		 }
		 return Gehiketa;

		}
	
}
