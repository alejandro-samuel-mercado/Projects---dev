package TP5.Punto4;

import java.util.Comparator;

import utils.List.SingleLinkedList;

/**
 * Crear un programa que permita combinar dos listas enlazadas ordenadas de
 * números enteros en una sola, manteniendo el orden de los elementos.
 **/
public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> lista1 = new SingleLinkedList<>();
        SingleLinkedList<Integer> lista2 = new SingleLinkedList<>();
        SingleLinkedList<Integer> lista3 = new SingleLinkedList<>();
        listasAgregadas(lista1, lista2);
        unirListasEnOrden(lista1, lista2, lista3);
    }

    public static void listasAgregadas(SingleLinkedList<Integer> lista1, SingleLinkedList<Integer> lista2) {
        Comparator<Integer> comparator = Integer::compareTo;
        for (int i = 0; i < 5; i++) {
            int num = (int) (Math.random() * 100);
            lista1.AddInOrder(num, comparator);
        }
        System.out.println("Lista 1: ");
        lista1.mostrar();
        System.out.println("-----------------------\n");

        for (int i = 0; i < 8; i++) {
            int num = (int) (Math.random() * 100);
            lista2.AddInOrder(num, comparator);
        }
        System.out.println("Lista 2: ");
        lista2.mostrar();
        System.out.println("-----------------------\n");
    }

    public static void unirListasEnOrden(SingleLinkedList<Integer> lista1, SingleLinkedList<Integer> lista2,
            SingleLinkedList<Integer> lista3) {
        Comparator<Integer> comparator = Integer::compareTo;
        for (Integer num : lista1) {
            lista3.AddInOrder(num, comparator);
        }
        for (Integer num : lista2) {
            lista3.AddInOrder(num, comparator);
        }
        System.out.println("Lista 3 (Unión de lista 1 y lista 2): ");
        lista3.mostrar();
        System.out.println("-----------------------\n");

    }
}
