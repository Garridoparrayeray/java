package eba1l;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class ERREPASOARIKETA_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERREPASOARIKETA_1 frame = new ERREPASOARIKETA_1();
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
	public ERREPASOARIKETA_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Emaitza: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(9, 230, 74, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(80, 237, 229, 24);
		contentPane.add(lblNewLabel_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		formattedTextField.setBounds(96, 18, 74, 20);
		contentPane.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		formattedTextField_1.setBounds(315, 20, 74, 20);
		contentPane.add(formattedTextField_1);
		
		JLabel lblNewLabel = new JLabel("Zenbakia 1: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 11, 105, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblZenbakia = new JLabel("Zenbakia 2: ");
		lblZenbakia.setFont(new Font("Arial", Font.BOLD, 15));
		lblZenbakia.setBounds(204, 11, 105, 36);
		contentPane.add(lblZenbakia);
		/* zenbakiak formattedTextField batetik hartzen ditugu. Gero gehiketa egin eta Ipini label berrian. HAU EGIN BAINO LEHEN DEKLARATU LABELAK ETA GUZTIA GOIHAN*/
		JButton btnNewButton = new JButton("Gehitu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num1 = Integer.parseInt(formattedTextField.getText());//IMPORTANTEA ERREPASATU
					int num2 = Integer.parseInt(formattedTextField_1.getText());//X2
					lblNewLabel_2.setText(String.valueOf(num1 + num2));
				}catch (NumberFormatException ex) {
					lblNewLabel_2.setText("Sartu zenbakiak, int moduan");
				}
			}
		});
		btnNewButton.setBounds(9, 97, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kendu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num1 = Integer.parseInt(formattedTextField.getText());
					int num2 = Integer.parseInt(formattedTextField_1.getText());
					lblNewLabel_2.setText(String.valueOf(num1 - num2));
				}catch (NumberFormatException ex){
					lblNewLabel_2.setText("Sartu zenbakiak, int moduan");
				}
				
			}
		});
		btnNewButton_1.setBounds(108, 96, 89, 23);
		contentPane.add(btnNewButton_1);

		
		
		JButton btnNewButton_3 = new JButton("Erromatar Znbk");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//ERROMATAR ZENBAKIAK ATERATZEKO
					int num1 = Integer.parseInt(formattedTextField.getText());
					String num_erromatar = "";
					String erromatar[] = {"M", "MC", "D", "DC", "C", "CX" , "L", "LX", "X", "XI", "V", "VI", "I"};
					int n[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
					for(int i = 0; i < n.length; i++) {
						while (num1 >= n[i]) {
			                num_erromatar += erromatar[i];
			                num1 -= n[i];
			            }
						
					}
					lblNewLabel_2.setText(num_erromatar);
				}catch (NumberFormatException ex){
					lblNewLabel_2.setText("Sartu zenbakiak, int moduan");
				}
			}
		});
		btnNewButton_3.setBounds(321, 98, 89, 23);
		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton_2 = new JButton("Pow");
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Double num1 = Double.parseDouble(formattedTextField.getText());
					Double num2 = Double.parseDouble(formattedTextField_1.getText());
					lblNewLabel_2.setText(String.valueOf(Math.pow(num1, num2)));
				}catch (NumberFormatException ex){
					lblNewLabel_2.setText("Sartu zenbakiak, double moduan");
				}
			}
		});
			
		btnNewButton_2.setBounds(211, 96, 89, 23);
		contentPane.add(btnNewButton_2);

	}
}
