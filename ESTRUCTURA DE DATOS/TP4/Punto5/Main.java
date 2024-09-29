package TP4.Punto5;

import java.util.Scanner;
import TP4.Punto2.ColaCircular;
import TP4.validaciones;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Tamaño de la primera cola: ");
        int tamaño1 = validaciones.validarNumero(input);
        System.out.print("Tamaño de la segunda cola: ");
        int tamaño2 = validaciones.validarNumero(input);
        ColaCircular<Integer> primeraCola = new ColaCircular<>(tamaño1);
        ColaCircular<Integer> segundaCola = new ColaCircular<>(tamaño2);
        ColaCircular<Integer> colaIntercalada = new ColaCircular<>(tamaño1 + tamaño2);

        agregarNumerosAColas(input, primeraCola, segundaCola, tamaño1, tamaño2);
        intercalarColas(primeraCola, segundaCola, colaIntercalada, tamaño1, tamaño2);
        mostrarElementosDeColas(primeraCola, segundaCola, colaIntercalada, tamaño1, tamaño2);

    }

    public static void agregarNumerosAColas(Scanner input, ColaCircular<Integer> primeraCola,
            ColaCircular<Integer> segundaCola, int tamaño1, int tamaño2) {

        // Primera cola
        System.out.println("\n----------Primera cola--------------");
        System.out.println("Ingrese " + tamaño1 + " números\n");
        for (int i = 0; i < tamaño1; i++) {
            System.out.print("Num" + (i + 1) + ": ");
            int num = validaciones.validarNumero(input);
            primeraCola.add(num);
        }

        // Segunda cola
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
        ColaCircular<Integer> primeraColaAux = new ColaCircular<>(tamaño1);
        ColaCircular<Integer> segundaColaAux = new ColaCircular<>(tamaño2);

        if (!primeraCola.isEmpty() || !segundaCola.isEmpty()) {
            while (!primeraCola.isEmpty() || !segundaCola.isEmpty()) {
                if (!primeraCola.isEmpty()) {
                    Integer num = primeraCola.poll();
                    colaIntercalada.add(num);
                    primeraColaAux.add(num);
                }
                if (!segundaCola.isEmpty()) {
                    Integer num = segundaCola.poll();
                    colaIntercalada.add(num);
                    segundaColaAux.add(num);
                }
            }

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
        // ColaCircular<Integer> primeraColaAux = new ColaCircular<>(tamaño1);
        // ColaCircular<Integer> segundaColaAux = new ColaCircular<>(tamaño2);
        // ColaCircular<Integer> colaIntercaladaAux = new ColaCircular<>(tamaño1 +
        // tamaño2);

        if (!primeraCola.isEmpty() || !segundaCola.isEmpty() || !colaIntercalada.isEmpty()) {
            System.out.println("\n---------Primera cola----------\n");
            while (!primeraCola.isEmpty()) {
                Integer num = primeraCola.poll();
                System.out.print(num + " ");
                // primeraColaAux.add(num);
            }
            // Devolver valores a la cola 1 original
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
            // Devolver valores a la cola 2 original
            /*
             * while (!segundaColaAux.isEmpty()) {
             * segundaCola.add(segundaColaAux.poll());
             * }
             */

            /////////////////////////////////
            int sumaTercerCola = 0;
            System.out.println("\n---------Cola intercalada---------\n");
            while (!colaIntercalada.isEmpty()) {
                Integer num = colaIntercalada.poll();
                System.out.print(num + " ");
                sumaTercerCola += num;
                // colaIntercaladaAux.add(num);
            }
            // Devolver valores a la cola 3 original
            /*
             * while (!colaIntercaladaAux.isEmpty()) {
             * 
             * colaIntercalada.add(colaIntercaladaAux.poll());
             * }
             */
            System.out.println("\n------\nSuma de los elementos de la tecer cola: " + sumaTercerCola);

        }
    }

}
