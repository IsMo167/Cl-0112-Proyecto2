//Referencia: https://javarush.com/es/groups/posts/es.3111.estructuras-de-datos-rbol-binario-en-java
public class Arbol {
    private NodoArbol nodoRaiz;

    public Arbol() {
        nodoRaiz = null;
    }

    // Insertar un nuevo nodo en el árbol
    public void insertarNodo(int valor) {
        NodoArbol nuevoNodo = new NodoArbol(valor);
        if (nodoRaiz == null) {
            nodoRaiz = nuevoNodo;
        } else {
            insertarRecursivamente(nodoRaiz, nuevoNodo);
        }
    }

    private void insertarRecursivamente(NodoArbol nodoActual, NodoArbol nuevoNodo) {
        if (nuevoNodo.obtenerValor() < nodoActual.obtenerValor()) {
            if (nodoActual.obtenerHijoIzquierdo() == null) {
                nodoActual.establecerHijoIzquierdo(nuevoNodo);
            } else {
                insertarRecursivamente(nodoActual.obtenerHijoIzquierdo(), nuevoNodo);
            }
        } else if (nuevoNodo.obtenerValor() > nodoActual.obtenerValor()) {
            if (nodoActual.obtenerHijoDerecho() == null) {
                nodoActual.establecerHijoDerecho(nuevoNodo);
            } else {
                insertarRecursivamente(nodoActual.obtenerHijoDerecho(), nuevoNodo);
            }
        }
    }

    // Buscar un nodo por su valor
    public NodoArbol encontrarNodoPorValor(int valor) {
        return encontrarNodoPorValorRecursivamente(nodoRaiz, valor);
    }

    private NodoArbol encontrarNodoPorValorRecursivamente(NodoArbol nodoActual, int valor) {
        if (nodoActual == null || nodoActual.obtenerValor() == valor) {
            return nodoActual;
        }
        if (valor < nodoActual.obtenerValor()) {
            return encontrarNodoPorValorRecursivamente(nodoActual.obtenerHijoIzquierdo(), valor);
        } else {
            return encontrarNodoPorValorRecursivamente(nodoActual.obtenerHijoDerecho(), valor);
        }
    }

    // Eliminar un nodo por su valor
    public boolean eliminarNodo(int valor) {
        nodoRaiz = eliminarNodoRecursivamente(nodoRaiz, valor);
        return nodoRaiz != null;
    }

    private NodoArbol eliminarNodoRecursivamente(NodoArbol nodoActual, int valor) {
        if (nodoActual == null) {
            return null;
        }

        if (valor < nodoActual.obtenerValor()) {
            nodoActual.establecerHijoIzquierdo(eliminarNodoRecursivamente(nodoActual.obtenerHijoIzquierdo(), valor));
        } else if (valor > nodoActual.obtenerValor()) {
            nodoActual.establecerHijoDerecho(eliminarNodoRecursivamente(nodoActual.obtenerHijoDerecho(), valor));
        } else {
            // Nodo encontrado
            if (nodoActual.obtenerHijoIzquierdo() == null) {
                return nodoActual.obtenerHijoDerecho();
            } else if (nodoActual.obtenerHijoDerecho() == null) {
                return nodoActual.obtenerHijoIzquierdo();
            } else {
                NodoArbol minimoNodoDerecho = encontrarMinimo(nodoActual.obtenerHijoDerecho());
                nodoActual.establecerValor(minimoNodoDerecho.obtenerValor());
                nodoActual.establecerHijoDerecho(eliminarNodoRecursivamente(nodoActual.obtenerHijoDerecho(), minimoNodoDerecho.obtenerValor()));
            }
        }
        return nodoActual;
    }

    private NodoArbol encontrarMinimo(NodoArbol nodo) {
        while (nodo.obtenerHijoIzquierdo() != null) {
            nodo = nodo.obtenerHijoIzquierdo();
        }
        return nodo;
    }

    // Imprimir el árbol de manera visual
    public void imprimirArbol() {
        if (nodoRaiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        // Usamos la pila personalizada
        Pila pilaGlobal = new Pila();
        pilaGlobal.apilar(nodoRaiz);
        int espacios = 32;
        boolean filaVacia = false;
        String separador = "-----------------------------------------------------------------";
        System.out.println(separador);

        while (!filaVacia) {
            Pila pilaLocal = new Pila();
            filaVacia = true;

            for (int j = 0; j < espacios; j++) {
                System.out.print(' ');
            }

            while (!pilaGlobal.estaVacia()) {
                NodoArbol nodoTemp = pilaGlobal.desapilar();
                if (nodoTemp != null) {
                    System.out.print(nodoTemp.obtenerValor());
                    pilaLocal.apilar(nodoTemp.obtenerHijoIzquierdo());
                    pilaLocal.apilar(nodoTemp.obtenerHijoDerecho());
                    if (nodoTemp.obtenerHijoIzquierdo() != null || nodoTemp.obtenerHijoDerecho() != null) {
                        filaVacia = false;
                    }
                } else {
                    System.out.print("__");
                    pilaLocal.apilar(null);
                    pilaLocal.apilar(null);
                }

                for (int j = 0; j < espacios * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }

            System.out.println();
            espacios /= 2;

            while (!pilaLocal.estaVacia()) {
                pilaGlobal.apilar(pilaLocal.desapilar());
            }
        }
        System.out.println(separador);
    }
}

 
