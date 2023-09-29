package com.cibertec;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpleado")
    private int idEmpleado;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Sexo")
    private char sexo;

    @Column(name = "Salario")
    private double salario;

    // Constructor vacío
    public Empleado() {}

    // Constructor completo
    public Empleado(String apellidos, String nombres, int edad, char sexo, double salario) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.edad = edad;
        this.sexo = sexo;
        this.salario = salario;
    }

    // Getters y setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                ", salario=" + salario +
                '}';
    }
}
