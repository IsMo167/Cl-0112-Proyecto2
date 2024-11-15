//Referencia: https://javarush.com/es/groups/posts/es.3111.estructuras-de-datos-rbol-binario-en-java
public class NodoArbol {
    private int valor;               // El valor del nodo
    private NodoArbol hijoIzquierdo; // Referencia al hijo izquierdo
    private NodoArbol hijoDerecho;   // Referencia al hijo derecho

    // Constructor
    public NodoArbol(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    // Métodos para obtener el valor
    public int getValor() {
        return this.valor;
    }

    // Métodos para establecer el valor
    public void setValor(int valor) {
        this.valor = valor;
    }

    // Métodos para obtener el hijo izquierdo
    public NodoArbol getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    // Métodos para establecer el hijo izquierdo
    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    // Métodos para obtener el hijo derecho
    public NodoArbol getHijoDerecho() {
        return this.hijoDerecho;
    }

    // Métodos para establecer el hijo derecho
    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    // Método para imprimir el nodo 
    public void imprimirNodo() {
        System.out.println("Nodo seleccionado con valor: " + this.valor);
    }
}
 
