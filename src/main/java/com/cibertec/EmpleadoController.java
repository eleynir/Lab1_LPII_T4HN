package com.cibertec;

import com.cibertec.gui.EmpleadoVista;

public class EmpleadoController {
    private EmpleadoDAO empleadoDao;
    private EmpleadoVista vista;

    public EmpleadoController(EmpleadoDAO empleadoDao, EmpleadoVista vista) {
        this.empleadoDao = empleadoDao;
        this.vista = vista;
        
        this.vista.getBtnInsertar().addActionListener(e -> crearEmpleadoDesdeVista());
        this.vista.getBtnActualizar().addActionListener(e -> actualizarEmpleadoDesdeVista());
        this.vista.getBtnEliminar().addActionListener(e -> eliminarEmpleadoDesdeVista());
        this.vista.getBtnMostrar().addActionListener(e -> mostrarEmpleadoDesdeVista());
    }

    private void crearEmpleadoDesdeVista() {
        String apellidos = vista.getTxtApellidos().getText();
        String nombres = vista.getTxtNombre().getText();
        int edad = 30;
        char sexo = 'M';
        double salario = 3000;

        crearEmpleado(apellidos, nombres, edad, sexo, salario);
    }

    private void actualizarEmpleadoDesdeVista() {
        int idEmpleado = Integer.parseInt(vista.getTxtId().getText());
        String apellidos = vista.getTxtApellidos().getText();
        String nombres = vista.getTxtNombre().getText();
        int edad = 30;
        char sexo = 'M';
        double salario = 3000;

        actualizarEmpleado(idEmpleado, apellidos, nombres, edad, sexo, salario);
    }

    private void eliminarEmpleadoDesdeVista() {
        int idEmpleado = Integer.parseInt(vista.getTxtId().getText());
        eliminarEmpleado(idEmpleado);
    }

    private void mostrarEmpleadoDesdeVista() {
        int idEmpleado = Integer.parseInt(vista.getTxtId().getText());
        mostrarEmpleado(idEmpleado);
    }

    public void crearEmpleado(String apellidos, String nombres, int edad, char sexo, double salario) {
        Empleado nuevoEmpleado = new Empleado(apellidos, nombres, edad, sexo, salario);
        empleadoDao.insertar(nuevoEmpleado);
        vista.mostrarMensaje("Empleado creado con éxito");
    }

    public void actualizarEmpleado(int idEmpleado, String nuevosApellidos, String nuevosNombres, int nuevaEdad, char nuevoSexo, double nuevoSalario) {
        Empleado empleado = empleadoDao.obtenerPorId(idEmpleado);
        if (empleado != null) {
            empleado.setApellidos(nuevosApellidos);
            empleado.setNombres(nuevosNombres);
            empleado.setEdad(nuevaEdad);
            empleado.setSexo(nuevoSexo);
            empleado.setSalario(nuevoSalario);
            empleadoDao.actualizar(empleado);
            vista.mostrarMensaje("Empleado actualizado con éxito");
        } else {
            vista.mostrarMensaje("Empleado no encontrado");
        }
    }

    public void eliminarEmpleado(int idEmpleado) {
        empleadoDao.eliminar(idEmpleado);
        vista.mostrarMensaje("Empleado eliminado con éxito");
    }

    public void mostrarEmpleado(int idEmpleado) {
        Empleado empleado = empleadoDao.obtenerPorId(idEmpleado);
        if (empleado != null) {
            vista.getTxtId().setText(String.valueOf(empleado.getIdEmpleado()));
            vista.getTxtNombre().setText(empleado.getNombres());
            vista.getTxtApellidos().setText(empleado.getApellidos());
        } else {
            vista.mostrarMensaje("Empleado no encontrado");
        }
    }
}


