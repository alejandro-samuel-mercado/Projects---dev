package TP2.Punto1;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.milibreria.utilidades.validaciones;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del array:");
        int tamañoArray = validaciones.validarNumero(input);

        Empleado[] listaEmpleados = new Empleado[tamañoArray];
        for (int i = 0; i < tamañoArray; i++) {
            System.out.println("Empleado " + (i + 1));
            listaEmpleados[i] = agregarEmpleado(input);
        }
        System.out.println("Datos de empleados: ");
        for (Empleado empleado : listaEmpleados) {
            int num = 1;
            empleado.mostrarDatos(num);
            num++;
        }
    }

    public static Empleado agregarEmpleado(Scanner input) {
        Empleado empleados = new Empleado();
        System.out.println("Ingrese el cuil del empleado: ");
        empleados.setCuil(validaciones.validarNumero(input));

        System.out.println("Ingrese el nombre y el apellido: ");
        empleados.setNombreYApellido(validaciones.validarTextoIngresado(input));

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Ingrese la fecha de ingreso en formato yy/mm/dd: ");
        String fechaIngresada = input.nextLine();
        LocalDate fecha = LocalDate.parse(fechaIngresada, formatoFecha);
        empleados.setFechaIngreso(fecha);

        System.out.println("Ingrese el sueldo: ");
        empleados.setSueldo(validaciones.validarNumero(input));

        System.out.println("Ingrese el departamento: ");
        empleados.setDepartamento(validaciones.validarTextoIngresado(input));
        System.out.println("------------------------------------------------------");

        return empleados;
    }

}
