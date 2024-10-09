package CLASES;

import CLASES.List.SingleLinkedList;

public class Prueba {

    public static void main(String[] args) {
        System.out.println("Demo de listas simples");
        SingleLinkedList<Integer> lista1 = new SingleLinkedList<>();
        SingleLinkedList<Integer> lista2 = new SingleLinkedList<>();
        int num;
        System.out.printf("\nNúmeros: ");
        for (int i = 0; i < 6; i++) {
            num = i + 1;
            System.out.printf("%d ", num);
            lista1.addLast(num);
        }

        System.out.printf("\nLista1: ");
        lista1.mostrar();

        System.out.println(lista1.get(2));
        lista1.remove(3);
        lista1.mostrar();
        //////////////// Con Iterator//////////////
        /*
         * for (int n : lista1) {
         * System.out.printf("%d ", n);
         * }
         * System.out.printf("\nLista1 con Iterator : ");
         * Iterator<Integer> iter = lista1.iterator();
         * while (iter.hasNext()) {
         * System.out.printf("%d ", iter.next());
         * }
         * 
         * System.out.println("");
         */
    }
}
