package TP4.Punto2;

import java.util.Scanner;

import TP1.validaciones;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Tamaño de la cola");
        int tamaño = validaciones.validarNumero(input);
        ColaCircular<Integer> colaCircular = new ColaCircular<>(tamaño);
        ColaCircular<Integer> colaAuxiliar = new ColaCircular<>(tamaño);
        boolean salir = false;
        do {
            System.out.println(
                    "Eliga una opción: \n 1)Agregar enteros\n 2)Eliminar todo \n 3)Eliminar primer elemento de la cola\n 4)Mostrar Cola\n 5)Salir\n-----------------");
            int opcion = validaciones.validarNumero(input);
            switch (opcion) {
                case 1:
                    agregarEnteros(input, colaCircular);
                    break;
                case 2:
                    eliminarValores(colaCircular);
                    break;

                case 3:
                    eliminarPrimeroEnCola(colaCircular);
                    break;
                case 4:
                    mostrarValores(colaCircular, colaAuxiliar);
                    break;
                case 5:
                    System.out.println("Saliendo.....");
                    salir = true;
                    break;
                default:
                    System.out.println("------------\nOpción no válida\n-------------");
                    break;
            }
        } while (!salir);

    }

    public static void agregarEnteros(Scanner input, ColaCircular<Integer> colaCircular) {

        System.out.println("Ingrese un número: ");
        int num = validaciones.validarNumero(input);
        boolean agregar = colaCircular.offer(num);
        if (!agregar) {
            System.out.println("-----------\nCola llena\n-------------");
        }

    }

    public static void mostrarValores(ColaCircular<Integer> colaCircular, ColaCircular<Integer> colaAux) {
        System.out.println("-------------------");
        if (!colaCircular.isEmpty()) {

            while (!colaCircular.isEmpty()) {
                Integer elemento = colaCircular.poll();
                if (elemento != null) {
                    System.out.println(elemento);
                    colaAux.add(elemento);
                }
            }
        } else {
            System.out.println("-----------\nNo hay valores para mostrar\n-------------");
            return;
        }

        // Devolver los elementos a la cola
        while (!colaAux.isEmpty()) {
            int elemento = colaAux.poll();
            colaCircular.add(elemento);
        }

    }

    public static void eliminarPrimeroEnCola(ColaCircular<Integer> colaCircular) {
        if (!colaCircular.isEmpty()) {
            Integer elemento = colaCircular.remove();
            System.out.println("Se eliminó: " + elemento);
        } else {
            System.out.println("-----------\nError. La cola ya está vacía\n-------------");
        }
    }

    public static void eliminarValores(ColaCircular<Integer> colaCircular) {
        boolean vaciado = false;
        while (!colaCircular.isEmpty()) {
            Integer elemento = colaCircular.remove();
            System.out.println("Eliminando : " + elemento);
            vaciado = true;
        }
        if (!vaciado) {
            System.out.println("-----------\nError. La cola ya está vacía\n-------------");

        } else {
            System.out.println("Valores eliminados");
        }

    }
}
