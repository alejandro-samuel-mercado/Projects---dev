package TP5.Punto6;

import utils.List.*;
import java.util.Scanner;
import utils.validaciones;

/**
 * Implementar un método que elimine todos los elementos duplicados de una lista
 * enlazada, dejando elementos únicos. La lista de elementos puede ser simple
 * o doblemente enlazada.
 **/
public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> elements = new SingleLinkedList<>();
        agregarElementos(elements);
        boolean salir = false;
        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Eliminar duplicados ");
            System.out.println("3. Salir");
            opcion = validaciones.validarNumero(input, "Seleccione una opción:\n---------------------\n ");
            switch (opcion) {
                case 1:
                    elements.mostrar();
                    break;
                case 2:
                    elements.removeDuplicate();
                    break;
                case 3:
                    System.out.println("Saliendo......");
                    salir = true;
                    break;
                default:
                    break;
            }
        } while (!salir);
    }

    public static void agregarElementos(SingleLinkedList<Integer> elements) {
        for (int i = 0; i < 15; i++) {
            int num = (int) (Math.random() * 10);
            elements.addLast(num);
        }
    }
}
