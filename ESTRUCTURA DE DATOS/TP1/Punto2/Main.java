package TP1.Punto2;

import java.util.Scanner;
import TP1.validaciones;

public class Main {
    public static void main(String[] args) {
        ArticuloDeLibreria articulo = new ArticuloDeLibreria();
        Scanner scanner = new Scanner(System.in);
        boolean salir = true;
        cargarDatos(scanner, articulo);
        while (salir) {
            salir = opciones(scanner, articulo, salir, articulo.getCantidad());
        }
    }

    /**
     * VBHRBRBFKRKGB
     * 
     * @param scanner  hbbhjbhhjb
     * @param articulo hbjbjhbjhbjh
     * @throws
     */
    public static void cargarDatos(Scanner scanner, ArticuloDeLibreria articulo) {
        System.out.println("Ingrese un código");
        int codigo = validaciones.validarNumero(scanner);
        System.out.println("Ingrese un nombre");
        String nombre = validaciones.validarTextoIngresado(scanner);
        System.out.println("Ingrese un precio");
        float precio = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Ingrese una cantidad");
        int cantidad = validaciones.validarNumero(scanner);

        articulo.setCodigo(codigo);
        articulo.setNombre(nombre);
        articulo.setPrecio(precio);
        articulo.setCantidad(cantidad);

    }

    public static boolean opciones(Scanner scanner, ArticuloDeLibreria articulo, boolean salir, int cantidad) {
        System.out.println("Eliga un opcion");
        String op = scanner.nextLine();

        switch (op) {
            case "1":
                System.out.println("Cantidad a depositar: ");
                cantidad = scanner.nextInt();
                scanner.nextLine();
                articulo.depositarEnStock(cantidad);
                break;
            case "2":

                cantidad = articulo.retirarDeStock(scanner);
                break;
            case "3":
                String datos = articulo.toStringg();
                System.out.println(datos);
                break;
            case "4":
                return false;
            default:
                System.out.println("Opción incorrecta");
                break;
        }
        return true;
    }

}
