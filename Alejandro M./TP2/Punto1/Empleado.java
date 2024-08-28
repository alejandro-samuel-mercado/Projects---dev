package TP2.Punto1;

import java.time.LocalDate;

public class Empleado {
    private int cuil;
    private String nombreYApellido;
    private LocalDate fechaIngreso;
    private int sueldo;
    private String departamento;

    public Empleado() {

    }

    public void mostrarDatos(int num) {
        System.out.println("Empleado " + num);
        System.out.println("Cuil: " + this.cuil);
        System.out.println("Nombre y apellido:" + this.nombreYApellido);
        System.out.println("Fecha de ingreso: " + fechaIngreso);
        System.out.println("Sueldo: " + this.sueldo);
        System.out.println("Departamento: " + this.departamento);
        System.out.println("--------------------------------");
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

}
