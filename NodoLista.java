public class NodoLista { //Cambiarlo a  NodoLista
    
    // Atributos de la clase Nodo
    private int valor;        // El valor que guarda el nodo
    private NodoLista siguiente;   // Referencia al siguiente nodo
    
    // Constructor de la clase Nodo
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
