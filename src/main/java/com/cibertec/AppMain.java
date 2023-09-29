package com.cibertec;

public class AppMain {

    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

        // Insertar un nuevo empleado
        Empleado nuevoEmpleado = new Empleado("Perez", "Juan", 30, 'M', 5000.00);
        empleadoDAO.insertar(nuevoEmpleado);
        System.out.println("Empleado insertado: " + nuevoEmpleado);

        // Obtener y mostrar un empleado por ID
        Empleado empleadoObtenido = empleadoDAO.obtenerPorId(nuevoEmpleado.getIdEmpleado());
        System.out.println("Empleado obtenido por ID: " + empleadoObtenido);

        // Actualizar un empleado
        empleadoObtenido.setSalario(6000.00);
        empleadoDAO.actualizar(empleadoObtenido);
        Empleado empleadoActualizado = empleadoDAO.obtenerPorId(empleadoObtenido.getIdEmpleado());
        System.out.println("Empleado actualizado: " + empleadoActualizado);

        // Mostrar todos los empleados (para verificar la inserción)
        System.out.println("\nTodos los empleados antes de la eliminación:");
        for (Empleado e : empleadoDAO.obtenerTodos()) {
            System.out.println(e);
        }

        // Eliminar un empleado
        empleadoDAO.eliminar(empleadoObtenido.getIdEmpleado());
        System.out.println("\nEmpleado con ID " + empleadoObtenido.getIdEmpleado() + " eliminado.");

        // Mostrar todos los empleados (para verificar la eliminación)
        System.out.println("\nTodos los empleados después de la eliminación:");
        for (Empleado e : empleadoDAO.obtenerTodos()) {
            System.out.println(e);
        }
    }
}
