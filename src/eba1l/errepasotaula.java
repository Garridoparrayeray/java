package eba1l;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;


public class errepasotaula extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<Integer> listamodeloaBak;
    private DefaultListModel<Integer> listamodeloaBik;
    private JList<Integer> listaBak;
    private JList<Integer> listaBik;
    private JFormattedTextField zenbakiInput;
    private JLabel contadorLabel;
    private int contador = 0;
    private JLabel contadorPrimiko;
    int temp = 0;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    errepasotaula frame = new errepasotaula();
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
    public errepasotaula() {
        setTitle("Bakoiti eta Bikoiti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Modelo de listas
        listamodeloaBak = new DefaultListModel<>();
        listamodeloaBik = new DefaultListModel<>();

        // Listas y paneles de scroll
        listaBak = new JList<>(listamodeloaBak);
        listaBik = new JList<>(listamodeloaBik);
        JScrollPane scrollpaneBak = new JScrollPane(listaBak);
        JScrollPane scrollpaneBik = new JScrollPane(listaBik);

        // Panel para las listas y etiquetas de "Bakoiti" y "Bikoiti"
        JPanel panelListas = new JPanel(new BorderLayout(10, 10));
        panelListas.add(scrollpaneBak, BorderLayout.WEST);
        JLabel label = new JLabel("Bakoiti");
        scrollpaneBak.setColumnHeaderView(label);
        panelListas.add(scrollpaneBik, BorderLayout.EAST);
        
        JLabel label_1 = new JLabel("Bikoiti");
        scrollpaneBik.setColumnHeaderView(label_1);
        
        contentPane.add(panelListas, BorderLayout.CENTER);

        // Panel superior para el campo de entrada de números
        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel zenbakiak = new JLabel("Zenbakiak:");
        zenbakiInput = new JFormattedTextField();
        zenbakiInput.setColumns(10);
        panelEntrada.add(zenbakiak);
        panelEntrada.add(zenbakiInput);
        contentPane.add(panelEntrada, BorderLayout.NORTH);

        // Panel inferior para los botones
        JPanel botoiPanela = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton sartuBtn = new JButton("Sartu");
        JButton kenduBtn = new JButton("Kendu");
        JButton garbituBtn = new JButton("Garbitu");
        JButton exit = new JButton("Exit");
        JButton batezbeste = new JButton("BT BZ");
        contadorLabel = new JLabel("Movimientos: 0");
        contadorPrimiko = new JLabel("Primikos:");
        botoiPanela.add(contadorPrimiko);
        botoiPanela.add(contadorLabel);
        botoiPanela.add(sartuBtn);
        botoiPanela.add(kenduBtn);
        botoiPanela.add(garbituBtn);
        botoiPanela.add(exit);
        botoiPanela.add(batezbeste);
        
        batezbeste.addActionListener(e-> JOptionPane.showMessageDialog(this, BatezBestekoa()));
        sartuBtn.addActionListener(e->AddNumber());
        sartuBtn.addActionListener(e -> primiko());
        sartuBtn.addActionListener(e->contadormovimientos());
        kenduBtn.addActionListener(e -> {//si esta vacio, hacer esto
        	if(listamodeloaBak.isEmpty() && listamodeloaBik.isEmpty()) {
        		JOptionPane.showMessageDialog(this, "Ez daude parametrorik");
        	}else {
        		DeleteListBak(listaBak, listamodeloaBak);
        		DeleteListBik(listaBik, listamodeloaBik);
        	}
            contadormovimientos();
        });
        garbituBtn.addActionListener(e -> ClearAllLists());
        garbituBtn.addActionListener(e -> contadormovimientos());
               
        exit.addActionListener(e -> Exit());
        contentPane.add(botoiPanela, BorderLayout.SOUTH);
       }

    
    /*AÑADIR UN NUMERO SI ES BIKOITI A UN LADO, BAKOITI AL OTRO*/
	private void AddNumber() {
		if(zenbakiInput.getText().isEmpty()){
			JOptionPane.showMessageDialog(this, "Ezin da zenbakirik gehitu, utsik dago");
		}else {
			try {
				int Gehitu = Integer.parseInt(zenbakiInput.getText());
				if (Gehitu % 2 == 0) {
					int i = 0;
					while(i < listamodeloaBik.size() && listamodeloaBik.get(i) < Gehitu) {
						i++;
					}
					listamodeloaBik.add(i, Gehitu);
					
				}else {
					int i = 0;
					while(i < listamodeloaBak.size() && listamodeloaBak.get(i) < Gehitu) {
						i++;
					}
					
					
					listamodeloaBak.add(i, Gehitu);
				}
			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Zenbakia INT moduan egon behar da");
			}
			
		}	
	}

	/*DELETE DE LA LISTA INDIVIDUALMENTE!!!!!
	  * */
	 private void DeleteListBik(JList<Integer> listaBik, DefaultListModel<Integer> model) {
	        int[] selectedIndices = listaBik.getSelectedIndices();
	        if (selectedIndices.length > 0) {
	        	for (int i = selectedIndices.length - 1; i >= 0; i--) {
		           model.remove(selectedIndices[i]);
	        	}
		       
	        }
	  }
	 
	 /*DELETE DE LA LISTA INDIVIDUALMENTE!!!!!
	  * */
	 private void DeleteListBak(JList<Integer> listaBak, DefaultListModel<Integer> model) {
	        int[] selectedIndices = listaBak.getSelectedIndices();
	        if (selectedIndices.length > 0) {
	        	for (int i = selectedIndices.length - 1; i >= 0; i--) {
		           model.remove(selectedIndices[i]);
	        	}
		       
	        }
	  }
	/* SUMA DE DOS ELEMENTOS DE DOS LISTAS DIFERENTES
	 *  private void a() {
		 int selectedIndexBak = listaBak.getSelectedValue();
		 int selectedIndexBik = listaBik.getSelectedValue();
		 int sumar = selectedIndexBak + selectedIndexBik;
		 JOptionPane.showMessageDialog(this, "la suma es "+ sumar);
		 
	 }*/
	/*GEHIKETA ATRIBUTO GUZTIAK
	 * private int Batuketa(JList<Integer> list, DefaultListModel<Integer> model) {
		int gehiketa = 0;
		for(int i = 0; i < model.size(); i++) {
			gehiketa += model.get(i);
		}
		return gehiketa;
	}*/
	 
	 /*CONTADOR DE MOVIMIENTOS ENTERO
	  * */
	 private void contadormovimientos() {
		 contador++;
		 contadorLabel.setText("Movimientos: " + contador);
	 }
	 
	 /* LIMPIAR LAS DOS TABLAS*/
	 private void ClearAllLists() {
		 if(listamodeloaBak.isEmpty() && listamodeloaBik.isEmpty()) {
     		JOptionPane.showMessageDialog(this, "Ez daude parametrorik");
     		}else {
     			listamodeloaBak.clear(); 
    		    listamodeloaBik.clear(); 
    		    zenbakiInput.setText("");
     		}
		    
		}
	 /* SALIDA DEL SISTEMA*/
	 private void Exit() {
		 System.exit(-1);
	 }
	 
	 /*CONTADOR DE NUMEROS PRIMOS CON VISUALIZACION*/
	 private void primiko() {
		int Gehitu = Integer.parseInt(zenbakiInput.getText());
		
		boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(Gehitu); i++) {
            if (Gehitu % i == 0) {
                isPrime = false; 
                break;
            }
        }
        
        if (isPrime) {
            temp++; 
            contadorPrimiko.setText("Primikos: " + temp); 
		}
	
	 }
	 /*-----------------BATEZBESTEKOA--------------*/
	 private double BatezBestekoa(){
		 double BatezBeste;
		 int zenbakiGuztiak = 0;
		 int elementuKopurua = listamodeloaBak.size() + listamodeloaBik.size();
		 
		 if(listamodeloaBak != null || listamodeloaBik != null) {
			 for(int i = 0; i < listamodeloaBak.size();i++) {
				 zenbakiGuztiak += listamodeloaBak.get(i);
			 }
			 for (int i = 0; i < listamodeloaBik.size();i++) {
				 zenbakiGuztiak += listamodeloaBik.get(i);
			 }
		 }
		 
		 BatezBeste = (double) (zenbakiGuztiak/elementuKopurua);
		 return(BatezBeste);
	 }
}


	
	
	