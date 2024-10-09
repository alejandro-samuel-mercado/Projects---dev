package TP4;

public class Queue<ELEMENT> {
    private final static Integer defaultDimension = 10;
    private ELEMENT[] data;
    private int frente;
    private int fin;
    private int count;

    // Constructor sin parámetros (usa la dimensión por defecto)
    public Queue() {
        this(defaultDimension);
    }

    // Constructor con dimensión específica
    @SuppressWarnings("unchecked")
    public Queue(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension]; // Inicializa el array
        this.frente = 0;
        this.fin = 0;
        this.count = 0;
    }

    // Método para obtener la posición siguiente de un elemento de la cola
    private int next(int pos) {
        pos++;
        if (pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }

    // Método para añadir un elemento a la cola
    public void add(ELEMENT element) {
        if (isFull()) {
            throw new IllegalStateException("Cola llena");
        }

        this.data[this.fin] = element; // Añade el elemento a donde apunta el tail
        this.fin = this.next(this.fin); // Ahora el tail apunta a la siguiente posición
        ++this.count;

    }

    // Método para añadir un elemento sin lanzar excepción en caso de error
    public boolean offer(ELEMENT element) {
        if (isFull()) {
            return false;
        }
        this.data[this.fin] = element;
        this.fin = this.next(this.fin);
        ++this.count;

        return true;
    }

    // Método para devolver el primer elemento sin eliminarlo (lanza excepción si
    // está vacía)
    public ELEMENT element() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        return this.data[this.frente];
    }

    // Método para devolver el primer elemento sin eliminarlo (no lanza excepción,
    // devuelve null)
    public ELEMENT peek() {
        if (isEmpty()) {
            return null;
        }
        return this.data[this.frente];
    }

    // Método para eliminar y devolver el primer elemento (lanza excepción si está
    // vacía)
    public ELEMENT remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        ELEMENT element = this.data[this.frente];
        this.frente = this.next(this.frente);
        --this.count;
        return element;
    }

    // Método para eliminar y devolver el primer elemento (retorna null si está
    // vacía)
    public ELEMENT poll() {
        if (isEmpty()) {
            return null;
        }
        ELEMENT element = this.data[this.frente];
        this.frente = this.next(this.frente);
        --this.count;
        return element;
    }

    // Método para obtener el tamaño actual de la cola
    public int size() {
        return this.count;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return this.size() <= 0;
    }

    // Método para verificar si la cola está llena
    public boolean isFull() {
        return this.size() >= this.data.length;
    }
}

/// --------------------------
// En este caso se hace uso de un contador,la cual utiliza memoria adicional y
/// requiere de un trabajo adicional al ser actualizado cada vez que se realiza
/// una operación de inserción o eliminación

// Es útil cuando se quiere aprovechar al máximo el espacio disponible en la
// cola y se está dispuesto a gestionar una variable adicional para contar los
// elementos. Esto es especialmente útil cuando el uso del espacio es una
// prioridad y se desea una capacidad total de N elementos.