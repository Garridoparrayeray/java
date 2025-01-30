package examen2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GestionEquiposBaloncesto extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String ARCHIVO = "equiposbaloncesto.ser";
    private JTable tabla;
    private JTextField txtCodigo, txtNombre, txtCreacion, txtPlantilla, txtPresupuesto, txtGanados, txtPerdidos;
    private JLabel lblTotalEquiposValor, lblPresupuestoMedioValor, lblPresupuestoTotalValor;
    private ArrayList<EquipoBaloncesto> equipos;
    private boolean datosModificados = false;

    public GestionEquiposBaloncesto() {
        setTitle("Gestión de Equipos - [Tu Nombre]"); // Cambia por tu nombre
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Para manejar el cierre
        setLocationRelativeTo(null);

        // Componentes
        inicializarComponentes();
        cargarEquipos();
        actualizarTabla();

        // Evento al cerrar la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                salir();
            }
        });
    }

    private void inicializarComponentes() {
        // Campos de texto
        txtCodigo = new JTextField(10);
        txtNombre = new JTextField(10);
        txtCreacion = new JTextField(10);
        txtPlantilla = new JTextField(10);
        txtPresupuesto = new JTextField(10);
        txtGanados = new JTextField(10);
        txtPerdidos = new JTextField(10);

        // Botones
        JButton btnInsertar = new JButton("Insertar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnSalir = new JButton("Salir");

        // Etiquetas de totales
        lblTotalEquiposValor = new JLabel("0");
        lblPresupuestoMedioValor = new JLabel("0.0");
        lblPresupuestoTotalValor = new JLabel("0.0");

        // Configurar layout
        JPanel panelCampos = new JPanel(new GridLayout(7, 2));
        panelCampos.add(new JLabel("Código:")); panelCampos.add(txtCodigo);
        panelCampos.add(new JLabel("Nombre:")); panelCampos.add(txtNombre);
        panelCampos.add(new JLabel("Creación:")); panelCampos.add(txtCreacion);
        panelCampos.add(new JLabel("Plantilla:")); panelCampos.add(txtPlantilla);
        panelCampos.add(new JLabel("Presupuesto:")); panelCampos.add(txtPresupuesto);
        panelCampos.add(new JLabel("Ganados:")); panelCampos.add(txtGanados);
        panelCampos.add(new JLabel("Perdidos:")); panelCampos.add(txtPerdidos);

        JPanel panelTotales = new JPanel(new GridLayout(3, 2));
        panelTotales.add(new JLabel("Total Equipos:")); panelTotales.add(lblTotalEquiposValor);
        panelTotales.add(new JLabel("Presupuesto Medio:")); panelTotales.add(lblPresupuestoMedioValor);
        panelTotales.add(new JLabel("Presupuesto Total:")); panelTotales.add(lblPresupuestoTotalValor);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnInsertar); panelBotones.add(btnBorrar); panelBotones.add(btnSalir);

        // Tabla
        tabla = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Añadir componentes al JFrame
        add(scrollPane, BorderLayout.CENTER);
        add(panelCampos, BorderLayout.NORTH);
        add(panelTotales, BorderLayout.SOUTH);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnInsertar.addActionListener(e -> insertarEquipo());
        btnBorrar.addActionListener(e -> borrarEquipo());
        btnSalir.addActionListener(e -> salir());
        tabla.getSelectionModel().addListSelectionListener(e -> actualizarCampos());
    }

    private void cargarEquipos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            equipos = (ArrayList<EquipoBaloncesto>) ois.readObject();
        } catch (FileNotFoundException e) {
            equipos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            equipos = new ArrayList<>();
        }
    }

    private void guardarEquipos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(equipos);
            datosModificados = false;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        String[] columnas = {"Código", "Nombre", "Creación", "Plantilla", "Presupuesto", "Ganados", "Perdidos", "% Victorias"};
        Object[][] datos = new Object[equipos.size()][8];

        for (int i = 0; i < equipos.size(); i++) {
            EquipoBaloncesto eq = equipos.get(i);
            datos[i][0] = eq.getCodigo();
            datos[i][1] = eq.getNombre();
            datos[i][2] = eq.getCreacion();
            datos[i][3] = eq.getPlantilla();
            datos[i][4] = eq.getPresupuesto();
            datos[i][5] = eq.getGanados();
            datos[i][6] = eq.getPerdidos();
            datos[i][7] = eq.porcentajeVictorias();
        }

        tabla.setModel(new DefaultTableModel(datos, columnas));
        calcularTotales();
    }

    private void calcularTotales() {
        int total = equipos.size();
        double totalPresupuesto = 0.0;

        for (EquipoBaloncesto eq : equipos) {
            totalPresupuesto += eq.getPresupuesto();
        }

        double media = total == 0 ? 0.0 : totalPresupuesto / total;

        lblTotalEquiposValor.setText(String.valueOf(total));
        lblPresupuestoTotalValor.setText(String.format("%.2f", totalPresupuesto));
        lblPresupuestoMedioValor.setText(String.format("%.2f", media));
    }

    private void actualizarCampos() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            EquipoBaloncesto eq = equipos.get(filaSeleccionada);
            txtCodigo.setText(eq.getCodigo());
            txtNombre.setText(eq.getNombre());
            txtCreacion.setText(String.valueOf(eq.getCreacion()));
            txtPlantilla.setText(String.valueOf(eq.getPlantilla()));
            txtPresupuesto.setText(String.valueOf(eq.getPresupuesto()));
            txtGanados.setText(String.valueOf(eq.getGanados()));
            txtPerdidos.setText(String.valueOf(eq.getPerdidos()));
        }
    }

    private void insertarEquipo() {
        try {
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            int creacion = Integer.parseInt(txtCreacion.getText());
            int plantilla = Integer.parseInt(txtPlantilla.getText());
            double presupuesto = Double.parseDouble(txtPresupuesto.getText());
            int ganados = Integer.parseInt(txtGanados.getText());
            int perdidos = Integer.parseInt(txtPerdidos.getText());

            EquipoBaloncesto nuevo = new EquipoBaloncesto(codigo, nombre, creacion, plantilla, presupuesto, ganados, perdidos);

            if (equipos.contains(nuevo)) {
                JOptionPane.showMessageDialog(this, "Error. Ya existe un equipo con código " + codigo, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                equipos.add(nuevo);
                datosModificados = true;
                actualizarTabla();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrarEquipo() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            equipos.remove(filaSeleccionada);
            datosModificados = true;
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para borrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salir() {
        if (datosModificados) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios antes de salir?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                guardarEquipos();
                System.exit(0);
            } else if (opcion == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestionEquiposBaloncesto().setVisible(true));
    }
}