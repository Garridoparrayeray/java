package main;

import lehioak.LangileLehioa;
import lehioak.BezeroLehioa;
import lehioak.SalmentaKudeaketaLehioa;

import javax.swing.*;
import java.awt.*;

public class SupermerkatuKudeaketa extends JFrame {
    public SupermerkatuKudeaketa() {
        setTitle("Supermerkatu Kudeaketa - Menua");
        setSize(400, 300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Evitar cierre directo
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new GridLayout(4, 1, 10, 10)); // Disposición vertical para los botones

        // Listener para preguntar si se quiere salir al cerrar la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        SupermerkatuKudeaketa.this,
                        "Ziur zaude irten nahi duzula?",
                        "Irten",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Botón para abrir LangileLehioa
        JButton langileakButton = new JButton("Langile Kudeaketa");
        langileakButton.addActionListener(e -> new LangileLehioa().setVisible(true));
        add(langileakButton);

        // Botón para abrir BezeroLehioa
        JButton bezeroakButton = new JButton("Bezero Kudeaketa");
        bezeroakButton.addActionListener(e -> new BezeroLehioa().setVisible(true));
        add(bezeroakButton);

        // Botón para abrir SalmentaKudeaketaLehioa
        JButton salmentakButton = new JButton("Salmenta Kudeaketa");
        salmentakButton.addActionListener(e -> new SalmentaKudeaketaLehioa().setVisible(true));
        add(salmentakButton);

        // Botón para salir de la aplicación
        JButton irtenButton = new JButton("Irten");
        irtenButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Ziur zaude irten nahi duzula?",
                    "Irten",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        add(irtenButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SupermerkatuKudeaketa menu = new SupermerkatuKudeaketa();
            menu.setVisible(true);
        });
    }
}
