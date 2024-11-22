package eba1l;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;

public class JLehioAriketaYERAY extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField znbk;
	private DefaultListModel<Integer> listamodeloa;
	private JList<Integer> zenbakiLista;
	private JLabel emaitza;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLehioAriketaYERAY frame = new JLehioAriketaYERAY();
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
	public JLehioAriketaYERAY() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		setTitle("JLehioAriketa");
		
		
		/*INPUT-a*/
		znbk = new JTextField();
		znbk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		contentPane.add(znbk, BorderLayout.NORTH);
		
		
		/* Listak eta beraien akzioak*/
		listamodeloa = new DefaultListModel<>();
		zenbakiLista = new JList<>(listamodeloa);
		/*SCROLL-A*/
		JScrollPane Scroll = new JScrollPane(zenbakiLista);
		contentPane.add(Scroll, BorderLayout.CENTER);
		
		
			/*BOTOIAK eta EMAITZA*/
			 JPanel behekopanela = new JPanel();
			 behekopanela.setLayout(new BorderLayout());
	     contentPane.add(behekopanela, BorderLayout.SOUTH);

	     // JLabel emaitzarekin
	     emaitza = new JLabel("Zenbakien gehiketa: 0");
	    
	     behekopanela.add(emaitza, BorderLayout.NORTH); // Beheko panelean, ipini gohian jlabel-a

	     // Botoien Panela
	     JPanel BotoiPanela = new JPanel();
	     BotoiPanela.setLayout(new GridLayout(1, 2)); // 2 botoi errenkada batean
	     behekopanela.add(BotoiPanela, BorderLayout.SOUTH); // botoiak beheko partean jarri
			JButton bidali = new JButton("Sartu");
			bidali.addActionListener(e->GehituZenbakia());
			/******KODE LUZEA ***
			 * bidali.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					GehituEmaitza();
				}
			});*/
			
			JButton Ezabatu = new JButton("Ezabatu");
			Ezabatu.addActionListener(e-> EzabatuEmaitza());
			
			BotoiPanela.add(bidali);
			BotoiPanela.add(Ezabatu);
	}
	
	private int EmaitzaBatuta() {
		int gehiketa = 0;
		for(int i = 0; i < listamodeloa.size(); i++) {
			gehiketa += listamodeloa.get(i);//batu zenbakiak
		}
		return gehiketa;
	}
	
	private void GehituZenbakia() {//zenbaki bat gehitu taulara
		  try {
	            Integer balorea = Integer.parseInt(znbk.getText());
	            
	            if(listamodeloa.contains(balorea)) {
	            	JOptionPane.showMessageDialog(this,"Zenbaki hau " +balorea+ " badago jada zerrendan");
	            }else {
	            	int index = 0;
	            	while(index < listamodeloa.size() && listamodeloa.get(index) < balorea) {//lista 0 baino handiagoa bada(errenkarik badeko) ETA balorea baino txikiagoa bada, gehitu
	            		index++;//index baino handiagoa denean, jarri zenbakia
	            	}
	            	listamodeloa.add(index, balorea);
	            	emaitza.setText("Emaitza: " + EmaitzaBatuta());//emaitza totala gehituta
	            }
	            
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Sartu zenbaki OSO bat.");
	        }
	}
	
	private void EzabatuEmaitza() {//zenbaki bat kendu taulatik
		Integer HartutakoErrenkada = zenbakiLista.getSelectedValue();
       if (HartutakoErrenkada != null) {//errenkada hartuta badaukagu
    	   Integer Hartutakoznbk = zenbakiLista.getSelectedValue();
    	   emaitza.setText("Emaitza: " + (EmaitzaBatuta() - Hartutakoznbk));//Berritu emaitza
    	   listamodeloa.removeElement(Hartutakoznbk);	 //kendu hautatutako zenbakia 
       }else {
    	   JOptionPane.showMessageDialog(this, "Aukeratu zenbaki bat zerrendan");
       }
	}
}