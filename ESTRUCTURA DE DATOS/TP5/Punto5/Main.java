package TP5.Punto5;

import java.util.Scanner;

import utils.validaciones;
import utils.List.DoublyLinkedList;

/**
 * Desarrollar métodos para recorrer una lista doblemente enlazada en ambas
 * direcciones. El usuario debe elegir en qué sentido recorrer la lista.
 * Al recorrer se deben mostrar los elementos de la lista sin eliminarlos.
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> lista1 = new DoublyLinkedList<>();
        listasAgregadas(lista1);

        Scanner input = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Recorrer lista hacia adelante");
            System.out.println("2. Recorrer lista hacia atrás");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción:\n---------------------\n ");

            opcion = validaciones.validarNumero(input, "");
            switch (opcion) {
                case 1:
                    lista1.travelNext();
                    break;
                case 2:
                    lista1.travelBack();
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

    public static void listasAgregadas(DoublyLinkedList<Integer> lista1) {
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            lista1.addLast(num);
        }
    }

}