//Referencia: https://javarush.com/es/groups/posts/es.3111.estructuras-de-datos-rbol-binario-en-java
public class Arbol { //Clase árbol
    private NodoArbol nodoRaiz;

    public Arbol() {
        nodoRaiz = null; //Se inicializa en null
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
        if (nuevoNodo.getValor() < nodoActual.getValor()) {
            if (nodoActual.getHijoIzquierdo() == null) {
                nodoActual.setHijoIzquierdo(nuevoNodo);
            } else {
                insertarRecursivamente(nodoActual.getHijoIzquierdo(), nuevoNodo);
            }
        } else if (nuevoNodo.getValor() > nodoActual.getValor()) {
            if (nodoActual.getHijoDerecho() == null) {
                nodoActual.setHijoDerecho(nuevoNodo);
            } else {
                insertarRecursivamente(nodoActual.getHijoDerecho(), nuevoNodo);
            }
        }
    }

    // Buscar un nodo por su valor
    public NodoArbol encontrarNodoPorValor(int valor) {
        return encontrarNodoPorValorRecursivamente(nodoRaiz, valor);
    }

    private NodoArbol encontrarNodoPorValorRecursivamente(NodoArbol nodoActual, int valor) {
        if (nodoActual == null || nodoActual.getValor() == valor) {
            return nodoActual;
        }
        if (valor < nodoActual.getValor()) {
            return encontrarNodoPorValorRecursivamente(nodoActual.getHijoIzquierdo(), valor);
        } else {
            return encontrarNodoPorValorRecursivamente(nodoActual.getHijoDerecho(), valor);
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

        if (valor < nodoActual.getValor()) {
            nodoActual.setHijoIzquierdo(eliminarNodoRecursivamente(nodoActual.getHijoIzquierdo(), valor));
        } else if (valor > nodoActual.getValor()) {
            nodoActual.setHijoDerecho(eliminarNodoRecursivamente(nodoActual.getHijoDerecho(), valor));
        } else {
            // Nodo encontrado
            if (nodoActual.getHijoIzquierdo() == null) {
                return nodoActual.getHijoDerecho();
            } else if (nodoActual.getHijoDerecho() == null) {
                return nodoActual.getHijoIzquierdo();
            } else {
                NodoArbol minimoNodoDerecho = encontrarMinimo(nodoActual.getHijoDerecho());
                nodoActual.setValor(minimoNodoDerecho.getValor());
                nodoActual.setHijoDerecho(eliminarNodoRecursivamente(nodoActual.getHijoDerecho(), minimoNodoDerecho.getValor()));
            }
        }
        return nodoActual;
    }

    private NodoArbol encontrarMinimo(NodoArbol nodo) {
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
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
                    System.out.print(nodoTemp.getValor());
                    pilaLocal.apilar(nodoTemp.getHijoIzquierdo());
                    pilaLocal.apilar(nodoTemp.getHijoDerecho());
                    if (nodoTemp.getHijoIzquierdo() != null || nodoTemp.getHijoDerecho() != null) {
                        filaVacia = false;
                    }
                } else {
                    System.out.print("null");
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

 
