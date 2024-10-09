package TP4.Punto5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* Tamaño de las queue */
        System.out.print("Tamaño de la primera cola: ");
        int tamaño1 = validaciones.validarNumero(input);
        System.out.print("Tamaño de la segunda cola: ");
        int tamaño2 = validaciones.validarNumero(input);

        ColaCircular<Integer> primeraCola = new ColaCircular<>(tamaño1);
        ColaCircular<Integer> segundaCola = new ColaCircular<>(tamaño2);
        ColaCircular<Integer> colaIntercalada = new ColaCircular<>(tamaño1 + tamaño2);

        /* Métodos */
        agregarNumerosAColas(input, primeraCola, segundaCola, tamaño1, tamaño2);
        intercalarColas(primeraCola, segundaCola, colaIntercalada, tamaño1, tamaño2);
        mostrarElementosDeColas(primeraCola, segundaCola, colaIntercalada, tamaño1, tamaño2);
        sumaTercerCola(colaIntercalada);

    }

    public static void agregarNumerosAColas(Scanner input, ColaCircular<Integer> primeraCola,
            ColaCircular<Integer> segundaCola, int tamaño1, int tamaño2) {

        /* Agregar números a la primera cola */
        System.out.println("\n----------Primera cola--------------");
        System.out.println("Ingrese " + tamaño1 + " números\n");
        for (int i = 0; i < tamaño1; i++) {
            System.out.print("Num" + (i + 1) + ": ");
            int num = validaciones.validarNumero(input);
            primeraCola.add(num);
        }

        /* Agregar números a la segunda cola */
        System.out.println("\n----------Segunda cola--------------");
        System.out.println("Ingrese " + tamaño2 + " números\n");
        for (int i = 0; i < tamaño2; i++) {
            System.out.print("Num" + (i + 1) + ": ");
            int num = validaciones.validarNumero(input);
            segundaCola.add(num);
        }

    }

    public static void intercalarColas(ColaCircular<Integer> primeraCola, ColaCircular<Integer> segundaCola,
            ColaCircular<Integer> colaIntercalada, int tamaño1, int tamaño2) {

        /* Colas auxiliares para devolver elementos a colas originales */
        ColaCircular<Integer> primeraColaAux = new ColaCircular<>(tamaño1);
        ColaCircular<Integer> segundaColaAux = new ColaCircular<>(tamaño2);

        /*
         * Añade uno por uno, de manera intercalada, cada elemento de ambas colas a una
         * tercer cola
         */
        if (!primeraCola.isEmpty() || !segundaCola.isEmpty()) {

            while (!primeraCola.isEmpty() || !segundaCola.isEmpty()) {

                /* Añade un elemento de la primera a la tercer cola */
                if (!primeraCola.isEmpty()) {
                    Integer num = primeraCola.poll();
                    colaIntercalada.add(num);
                    primeraColaAux.add(num);
                }

                /* Añade un elemento de la segunda a la tercer cola */
                if (!segundaCola.isEmpty()) {
                    Integer num = segundaCola.poll();
                    colaIntercalada.add(num);
                    segundaColaAux.add(num);
                }
            }

            /* Devuelve los elementos a las colas originales */
            while (!primeraColaAux.isEmpty()) {
                primeraCola.add(primeraColaAux.poll());
            }
            while (!segundaColaAux.isEmpty()) {
                segundaCola.add(segundaColaAux.poll());
            }

            System.out.println("---------\nIntercalación realizada\n----------\n");
        } else {
            System.out.println("----------\nLas colas 1 y 2 están vacías\n--------------");

        }
    }

    public static void mostrarElementosDeColas(ColaCircular<Integer> primeraCola, ColaCircular<Integer> segundaCola,
            ColaCircular<Integer> colaIntercalada, int tamaño1, int tamaño2) {

        /* Colas auxiliares para devolver elementos a colas originales */
        // ColaCircular<Integer> primeraColaAux = new ColaCircular<>(tamaño1);
        // ColaCircular<Integer> segundaColaAux = new ColaCircular<>(tamaño2);
        ColaCircular<Integer> colaIntercaladaAux = new ColaCircular<>(tamaño1 + tamaño2);

        if (!primeraCola.isEmpty() || !segundaCola.isEmpty() || !colaIntercalada.isEmpty()) {
            System.out.println("\n---------Primera cola----------\n");
            while (!primeraCola.isEmpty()) {
                Integer num = primeraCola.poll();
                System.out.print(num + " ");
                // primeraColaAux.add(num);
            }

            /* Devolver valores a la cola 1 original */
            /*
             * while (!primeraColaAux.isEmpty()) {
             * primeraCola.add(primeraColaAux.poll());
             * }
             */

            System.out.println("\n---------Segunda cola----------\n");
            while (!segundaCola.isEmpty()) {
                Integer num = segundaCola.poll();
                System.out.print(num + " ");
                // segundaColaAux.add(num);
            }
            /* Devolver valores a la cola 1 original */
            /*
             * while (!segundaColaAux.isEmpty()) {
             * segundaCola.add(segundaColaAux.poll());
             * }
             */

            System.out.println("\n---------Cola intercalada---------\n");
            while (!colaIntercalada.isEmpty()) {
                Integer num = colaIntercalada.poll();
                System.out.print(num + " ");
                colaIntercaladaAux.add(num);
            }

            /* Devolver valores a la cola 3 original */
            while (!colaIntercaladaAux.isEmpty()) {
                colaIntercalada.add(colaIntercaladaAux.poll());
            }

        }
    }

    public static void sumaTercerCola(ColaCircular<Integer> colaIntercalada) {

        int sumaTercerCola = 0;
        System.out.println("\n--------Sumatoria de números de la cola intercalada--------");

        if (!colaIntercalada.isEmpty()) {
            while (!colaIntercalada.isEmpty()) {
                Integer num = colaIntercalada.poll();
                sumaTercerCola += num;
            }
            System.out.println("\nSuma de los elementos de la tecer cola: " + sumaTercerCola);

        } else {
            System.out.println("\nLa tercer cola está vacía");
        }
    }

}
