
/**
 * Clase: NodoArbol
 * Propósito: Crear los objetos nodo con las características necesarias para poder construir un árbol a partir de estos
 */
public class NodoArbol {
    private int valor;               // El valor del nodo
    private NodoArbol hijoIzquierdo; // Referencia al hijo izquierdo
    private NodoArbol hijoDerecho;   // Referencia al hijo derecho

    /**
     * Constructor
     * Propósito: Inicializar un objeto nodo con valor definido y enlace a sus dos hijos como null
     * Parámetros de entrada:
     *      - int valor: Valor que se le asignará al atributo this.valor
     * Parámetros de salida:
     *      - null
     */
    public NodoArbol(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    // Setters y getters
    public int getValor() {
        return this.valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public NodoArbol getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }
    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
    public NodoArbol getHijoDerecho() {
        return this.hijoDerecho;
    }
    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
 
