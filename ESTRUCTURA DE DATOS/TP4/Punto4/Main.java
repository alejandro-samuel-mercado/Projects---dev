package TP4.Punto4;

import java.util.Scanner;
import TP4.Punto2.ColaCircular;
import TP4.validaciones;

public class Main {
    public static void main(String[] args) {
        ColaCircular<Visitante> colaGeneral = new ColaCircular<>(30);
        ColaCircular<Visitante> colaParaMontañaRusa = new ColaCircular<>(30);
        ColaCircular<Visitante> colaParaCalesita = new ColaCircular<>(30);
        ColaCircular<Visitante> colaAuxiliar = new ColaCircular<>(30);
        Scanner input = new Scanner(System.in);

        agregarVisitantesColaGeneral(input, colaGeneral);
        boolean salir = false;
        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Ver visitantes de la fila general");
            System.out.println("2. Transferir a la fila correspondiente según la edad");
            System.out.println("3. Mostrar fila para la montaña rusa y la calesita");
            System.out.println("4. Dejar pasar a un visitante");
            System.out.println("5  Dejar pasar a todos los visitantes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción:\n---------------------\n ");
            int opcion = validaciones.validarNumero(input);
            switch (opcion) {

                case 1:
                    mostrarFilaGeneral(colaGeneral, colaAuxiliar);
                    break;
                case 2:
                    transferirAJuegoPorEdad(colaGeneral, colaParaMontañaRusa, colaParaCalesita);
                    break;
                case 3:
                    mostrarFilaParaCadaJuego(colaParaMontañaRusa, colaParaCalesita);
                    break;
                case 4:
                    dejarPasarUnVisitante(input, colaParaMontañaRusa, colaParaCalesita);
                    break;
                case 5:
                    dejarPasarATodos(colaParaMontañaRusa, colaParaCalesita);
                    break;
                case 6:
                    System.out.println("Saliendo.....");
                    salir = true;
                    break;
                default:
                    System.out.println("------------\nOpción no válida\n-------------");
                    break;
            }
        } while (!salir);
    }

    public static void agregarVisitantesColaGeneral(Scanner input, ColaCircular<Visitante> colaGeneral) {

        int cantidadVisitantesAIngresar = 5 + (int) (Math.random() * 26); // Genera un tamaño entre 5 y 30

        for (int i = 0; i < cantidadVisitantesAIngresar; i++) {
            String nombre = "Visitante " + i;
            int edad = (int) ((Math.random() * 60) + 4);
            Visitante persona = new Visitante(i, nombre, edad);
            colaGeneral.add(persona);
        }
        System.out.println("---------\nVisitantes añadidos\n----------");
    }

    public static void mostrarFilaGeneral(ColaCircular<Visitante> colaGeneral, ColaCircular<Visitante> colaAux) {
        if (!colaGeneral.isEmpty()) {
            while (!colaGeneral.isEmpty()) {
                Visitante visitante = colaGeneral.poll();
                System.out.println(visitante.toString());
                colaAux.add(visitante);
            }

            while (!colaAux.isEmpty()) {
                Visitante visitante = colaAux.poll();
                colaGeneral.add(visitante);
            }
        } else {
            System.out.println("----------\nNo hay visitantes para mostrar\n--------------");
        }
    }

    public static void transferirAJuegoPorEdad(ColaCircular<Visitante> colaGeneral,
            ColaCircular<Visitante> colaParaMontañaRusa, ColaCircular<Visitante> colaParaCalesita) {
        if (!colaGeneral.isEmpty()) {
            while (!colaGeneral.isEmpty()) {
                for (int i = 0; i < 5 && !colaGeneral.isEmpty(); i++) {
                    Visitante visitante = colaGeneral.poll();
                    if (visitante.getEdad() >= 4 && visitante.getEdad() <= 12) {
                        colaParaCalesita.add(visitante);
                    } else if (visitante.getEdad() >= 4) {
                        colaParaMontañaRusa.add(visitante);
                    }
                }
            }
            System.out.println("-------\nVisitantes transferidos correctamente\n---------- ");
        } else {
            System.out.println("----------\nFila general vacía.No hay visitantes para transferir\n--------------");

        }
    }

    public static void mostrarFilaParaCadaJuego(ColaCircular<Visitante> colaParaMontañaRusa,
            ColaCircular<Visitante> colaParaCalesita) {
        ColaCircular<Visitante> auxMontañaRusa = new ColaCircular<>(30);
        ColaCircular<Visitante> auxCalesita = new ColaCircular<>(30);

        if (!colaParaCalesita.isEmpty() && !colaParaMontañaRusa.isEmpty()) {

            // Para la Montaña rusa
            System.out.println("-------Fila para Montaña rusa----------\n");
            while (!colaParaMontañaRusa.isEmpty()) {
                Visitante visitante = colaParaMontañaRusa.poll();
                System.out.println(visitante.toString());
                auxMontañaRusa.add(visitante);
            }

            while (!auxMontañaRusa.isEmpty()) {
                Visitante visitante = auxMontañaRusa.poll();
                colaParaMontañaRusa.add(visitante);
            }

            // Para la calesita
            System.out.println("\n-------Fila para Calesita----------\n");
            while (!colaParaCalesita.isEmpty()) {
                Visitante visitante = colaParaCalesita.poll();
                System.out.println(visitante.toString());
                auxCalesita.add(visitante);
            }

            while (!auxCalesita.isEmpty()) {
                Visitante visitante = auxCalesita.poll();
                colaParaCalesita.add(visitante);
            }

        } else {
            System.out.println("----------\nNo hay visitantes en la fila de cada juego para mostrar\n--------------");
        }
    }

    public static void dejarPasarUnVisitante(Scanner input, ColaCircular<Visitante> colaParaMontañaRusa,
            ColaCircular<Visitante> colaParaCalesita) {

        if (!colaParaCalesita.isEmpty() && !colaParaMontañaRusa.isEmpty()) {
            System.out.println("----------\n¿ Montaña rusa(m) o Calesita(c)?");
            String opcion = validaciones.validarTextoIngresado(input).toLowerCase();

            if (opcion.equals("m")) {
                Visitante visitante = colaParaMontañaRusa.poll();
                System.out.println(visitante.getAynVisitante() + " ingresó a la montaña rusa ");
            } else if (opcion.equals("c")) {
                Visitante visitante = colaParaCalesita.poll();
                System.out.println(visitante.getAynVisitante() + " ingresó a la calesita ");
            } else {
                System.out.println("No existe el juego ingresado");
            }
        } else {
            System.out.println(
                    "----------\nNo hay visitantes en la fila de cada juego para dejar pasar \n--------------");
        }
    }

    public static void dejarPasarATodos(ColaCircular<Visitante> colaParaMontañaRusa,
            ColaCircular<Visitante> colaParaCalesita) {
        int cantidadMontañaRusa = 0;
        int cantidadCalesita = 0;
        ColaCircular<Visitante> colaAux = new ColaCircular<>(30);

        if (!colaParaMontañaRusa.isEmpty()) {
            System.out.println("----------Montaña rusa-----------");
            while (!colaParaMontañaRusa.isEmpty()) {
                Visitante visitante = colaParaMontañaRusa.poll();
                System.out.println(visitante.getAynVisitante() + " ingresó");
                colaAux.add(visitante);
                cantidadMontañaRusa++;
            }
        } else {
            System.out.println("----------\nNo hay visitantes en la fila para la Montaña rusa\n--------------");
        }

        if (!colaParaCalesita.isEmpty()) {
            System.out.println("\n----------Calesita-----------");
            while (!colaParaCalesita.isEmpty()) {
                Visitante visitante = colaParaCalesita.poll();
                System.out.println(visitante.getAynVisitante() + " ingresó");
                colaAux.add(visitante);
                cantidadCalesita++;
            }
        } else {
            System.out.println("----------\nNo hay visitantes en la fila para la Calesita\n--------------");
        }
        mostrarCantidades(cantidadCalesita, cantidadMontañaRusa, colaAux);

    }

    public static void mostrarCantidades(int cantidadCalesita, int cantidadMontañaRusa,
            ColaCircular<Visitante> colaAux) {
        int cantidadMenoresEdad = 0;
        while (!colaAux.isEmpty()) {
            Visitante visitante = colaAux.poll();
            if (visitante.getEdad() < 18) {
                cantidadMenoresEdad++;
            }
        }
        System.out.println("-------------------------------------------\n");
        System.out.println("Cantidad de visitantes menores de edad: " + cantidadMenoresEdad);
        System.out.println("Cantidad de visitantes que ingresaron a la montaña rusa: " + cantidadMontañaRusa);
        System.out.println("Cantidad de visitantes que ingresaron a la calesita: " + cantidadCalesita);
    }
}