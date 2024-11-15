//Referencia: https://javarush.com/es/groups/posts/es.3111.estructuras-de-datos-rbol-binario-en-java
public class Pila {
    private NodoPila cima;

    // Clase interna NodoPila para representar cada elemento de la pila
    private class NodoPila {
        NodoArbol nodo;
        NodoPila siguiente;

        NodoPila(NodoArbol nodo) {
            this.nodo = nodo;
            this.siguiente = null;
        }
    }

    // Constructor de la pila
    public Pila() {
        cima = null;
    }

    // Método para agregar un nodo a la pila (push)
    public void apilar(NodoArbol nodo) {
        NodoPila nuevoNodo = new NodoPila(nodo);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    // Método para sacar un nodo de la pila (pop)
    public NodoArbol desapilar() {
        if (estaVacia()) {
            return null;
        }
        NodoArbol nodo = cima.nodo;
        cima = cima.siguiente;
        return nodo;
    }

    // Método para ver el nodo en la cima de la pila (peek)
    public NodoArbol cima() {
        return estaVacia() ? null : cima.nodo;
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }
}

 
