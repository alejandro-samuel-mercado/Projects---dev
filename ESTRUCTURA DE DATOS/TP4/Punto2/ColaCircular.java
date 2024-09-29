package TP4.Punto2;

public class ColaCircular<T> {
    private final static Integer defaultDimension = 10;
    private T[] queue;
    private int head;
    private int tail;

    public ColaCircular() {
        this(defaultDimension);
    }

    @SuppressWarnings("unchecked")
    public ColaCircular(int dimension) {
        this.queue = (T[]) new Object[dimension + 1]; // Inicializa el array
        this.head = 0;
        this.tail = 0;
    }

    // Método para obtener la posición siguiente de un elemento de la cola
    private int next(int pos) {
        pos++;
        if (pos >= this.queue.length) {
            pos = 0;
        }
        return pos;
    }

    // Método para añadir un elemento a la cola
    public void add(T element) {
        if (this.isFull()) {
            throw new IllegalStateException("Cola llena");

        }
        this.queue[this.tail] = element; // Añade el elemento a donde apunta el tail
        this.tail = this.next(this.tail); // Ahora el tail apunta a la siguiente posición
    }

    // Método para añadir un elemento sin lanzar excepción en caso de error
    public boolean offer(T element) {
        if (this.isFull()) {
            return false;
        }
        this.queue[this.tail] = element;
        this.tail = this.next(this.tail);
        return true;
    }

    // Método para devolver el primer elemento sin eliminarlo (lanza excepción si
    // está vacía)
    public T element() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        return this.queue[head];
    }

    // Método para devolver el primer elemento sin eliminarlo (no lanza excepción,
    // devuelve null)
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.queue[this.head];
    }

    // Método para eliminar y devolver el primer elemento (lanza excepción si está
    // vacía)
    public T remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        T element = this.queue[this.head];
        this.head = this.next(this.head);
        return element;
    }

    // Método para eliminar y devolver el primer elemento (retorna null si está
    // vacía)
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }
        T element = this.queue[this.head];
        this.head = this.next(this.head);
        return element;
    }

    // Método para obtener el tamaño actual de la cola
    public int size() {
        if (this.tail >= this.head) {
            return this.tail - this.head;
        } else {
            return this.queue.length - this.head + this.tail;
        }
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    // Método para verificar si la cola está llena
    public boolean isFull() {
        return this.next(this.tail) == this.head;
    }

}

// En este caso se opta por desperdiciar un espacio libre siempre en la
// implementación de la cola para distinguir fácilmente entre una cola llena y
// una vacía

// Es útil cuando la implementación debe ser fácil de entender y mantener, y
// cuando
// no se necesita la capacidad total del array. Este enfoque reduce la
// complejidad lógica a costa de perder un espacio.