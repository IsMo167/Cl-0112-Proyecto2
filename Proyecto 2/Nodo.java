public class Nodo { //Cambiarlo a  NodoLista
    
    // Atributos de la clase Nodo
    private String valor;        // El valor que guarda el nodo
    private Nodo siguiente;   // Referencia al siguiente nodo
    
    // Constructor de la clase Nodo
    public Nodo(String valor) {
        this.valor = valor;  // Inicializa el valor del nodo
        this.siguiente = null; // Inicializa el siguiente nodo como null
    }
    
    // Setters y getters
    public Object getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public Nodo getSiguiente() {
        return this.siguiente;
    }
    
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // Método para imprimir el valor del nodo
    public void imprimirNodo() {
        System.out.println(this.valor);
    }
}
