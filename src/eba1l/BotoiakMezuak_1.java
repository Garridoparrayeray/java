package eba1l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BotoiakMezuak_1 extends JFrame {
  
	//kanpotik deklaratutako ezaugarriak
	//private bakarrik klase honetan erabiltzeko
	private JTextField textField;
    private JButton buttonHola;
    private JButton buttonAdios;
    private JButton buttonKaixo;
    private JButton buttonAgur;
    //moldeatzeko aplikazioa. Editatzeko aplikazioaren itxura hemen jarri beharko dugu
    public BotoiakMezuak_1() {//botoien funtzioa
        super("Botoiak eta mezuak");//aplikazioari izena emoteko
        getContentPane().setLayout(new FlowLayout());
        //testua sartzeko kutxa
        
        textField = new JTextField(20);//deklarazioa. 20 karaktereeko testua sartzeko
        
        getContentPane().add(textField);//hasi 
        
        //botoiak egin goiko deklarazioekin
        buttonHola = new JButton("Hola");//sortzeko botoi berri bat. Scanner bezala buttonIzena = new JButton("Testua")
        buttonAdios = new JButton("Adios");//sortu botoi berri bat_2
        buttonKaixo = new JButton("Kaixo");
        buttonAgur = new JButton("Agur");
        
        //botoi guztiak hasi
        getContentPane().add(buttonHola);//botoia hasi
        getContentPane().add(buttonAdios);
        getContentPane().add(buttonKaixo);
        getContentPane().add(buttonAgur);

        ButtonListener listener = new ButtonListener();
        buttonHola.addActionListener(listener);//botoiari implementatzen diozu kapazitatea egiteko gauza gehiago kiklatu eta gero. Enter sakatuz eta gero
        buttonAdios.addActionListener(listener);//"entzuten" du akzioa. Klikatu, arrastratu, etab.
        buttonKaixo.addActionListener(listener);
        buttonAgur.addActionListener(listener);

        textField.addActionListener(listener);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);//aplikazioaren karratua
        setVisible(true);
    }
    //botoiaren akzioen funtzioa
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = textField.getText();
            String buttonClicked = e.getActionCommand();
            //botoia sakatu eta gero egiten diren akzioak	
            if (buttonClicked.equals("Hola")) {//klikatu eta gero
                System.out.println("[Hola] " + name);//print hau egin
            } else if (buttonClicked.equals("Adios")) {
                System.out.println("[Adios] " + name);
            } else if (buttonClicked.equals("Kaixo")) {
                System.out.println("[Kaixo] " + name);
            } else if (buttonClicked.equals("Agur")) {
                System.out.println("[Agur] " + name);
            }
        }
    }
    //hasteko aplikazioa betiko main-a
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {//runneatzeko aplikazio berria
                new BotoiakMezuak();//aplikazioaen izena
            }
        });
    }
}