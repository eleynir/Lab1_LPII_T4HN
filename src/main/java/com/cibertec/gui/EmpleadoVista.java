package com.cibertec.gui;


import javax.swing.*;

import com.cibertec.EmpleadoController;
import com.cibertec.EmpleadoDAOImpl;

import java.awt.*;

public class EmpleadoVista extends JFrame {
    // Componentes de la GUI
    private JTextField txtId = new JTextField(10);
    private JTextField txtNombre = new JTextField(10);
    private JTextField txtApellidos = new JTextField(10);
    private JButton btnInsertar = new JButton("Insertar");
    private JButton btnActualizar = new JButton("Actualizar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnMostrar = new JButton("Mostrar Por ID");
    
    public EmpleadoVista() {
        // Configuración de la ventana
        setTitle("CRUD Empleado");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // Añadir componentes a la ventana
        add(new JLabel("ID:"));
        add(txtId);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellidos:"));
        add(txtApellidos);
        add(btnInsertar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnMostrar);
    }

    // Getters para acceder a los componentes desde el controlador
    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellidos() { return txtApellidos; }
    public JButton getBtnInsertar() { return btnInsertar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnMostrar() { return btnMostrar; }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public static void main(String[] args) {
        EmpleadoVista vista = new EmpleadoVista();
        EmpleadoDAOImpl empleadoDao = new EmpleadoDAOImpl();
        EmpleadoController controlador = new EmpleadoController(empleadoDao, vista);
        vista.setVisible(true);
    }

}
