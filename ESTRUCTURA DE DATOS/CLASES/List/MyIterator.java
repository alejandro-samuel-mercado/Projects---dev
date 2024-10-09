package CLASES.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Sirve para crear un iterador personalizado para la clase List. Implementar un
 * iterador permite recorrer los elementos de la lista de una manera controlada
 * y flexible.
 * Hace que la lista sea compatible con el bucle for-each
 **/

public class MyIterator<E> implements Iterator<E> {
    private Node<E> actual;

    public MyIterator(Node<E> head) {
        this.actual = head; // Comenzar desde el inicio de la lista
    }

    /*
     * Devuelve true si hay más elementos en la colección que se pueden iterar. Esto
     * permite al usuario saber si puede seguir llamando a next() sin provocar una
     * excepción.
     */
    @Override
    public boolean hasNext() {
        return this.actual != null; // Hay más elementos si current no es null
    }

    /**
     * Devuelve el siguiente elemento en la iteración. Este método avanza el cursor
     * del iterador y, por lo tanto, es esencial para recorrer los elementos.
     **/
    @Override
    public E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No hay más elementos en la lista");
        }
        E item = this.actual.item; // Guardar el elemento actual
        this.actual = this.actual.next; // Avanzar al siguiente nodo
        return item; // Devolver el elemento
    }

    // Método remove() (opcional)
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operación no soportada");
    }
}
