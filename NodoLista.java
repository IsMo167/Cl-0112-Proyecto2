/**
 * Clase: NodoLista
 * Propósito: Crear los objetos nodo con las características necesarias para poder construir una lista enlazada a partir de estos
 */


public class NodoLista { 
    
    // Atributos de la clase Nodo
    private int valor;        // El valor que guarda el nodo
    private NodoLista siguiente;   // Referencia al siguiente nodo
    
    /**
     * Constructor
     * Propósito: Inicializar un objeto nodo con valor definido y enlace al siguiente nodo como null
     * Parámetros de entrada:
     *      - int valor: Valor que se le asignará al atributo this.valor
     * Parámetros de salida:
     *      - null
     */
    public NodoLista(int valor) {
        this.valor = valor;  // Inicializa el valor del nodo
        this.siguiente = null; // Inicializa el siguiente nodo como null
    }
    
    // Setters y getters
    public int getValor() {
        return this.valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public NodoLista getSiguiente() {
        return this.siguiente;
    }
    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}
