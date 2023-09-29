package com.cibertec;

import java.util.List;

public interface EmpleadoDAO {
    void insertar(Empleado empleado);
    void actualizar(Empleado empleado);
    void eliminar(int idEmpleado);
    Empleado obtenerPorId(int idEmpleado);
    List<Empleado> obtenerTodos();
}
