/**
 * Clase: Lista
 * Propósito: Crear una lista simplemente enlazada
 */
public class Lista{
    //Atributos:
    private NodoLista cabeza;

    /**
     * Constructor
     * Propósito: Inicializar mi lista.
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public Lista(){
        cabeza = null;
    }

    //Setters y getters:
    public NodoLista getCabeza(){
        return this.cabeza;
    }
    
    public void setCabeza(NodoLista cabeza){
        this.cabeza = cabeza;
    }

    /**
     * Método: esVacio
     * Propósito: Comprobar si la lista está vacía
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - boolean : true si está vacía o false si no lo está
     */
    public boolean esVacio(){
        boolean listaVacia = (this.cabeza == null)? true : false;
        return listaVacia;
    }

    /**
     * Método: vaciar
     * Propósito: vaciar la lista 
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public void vaciar(){
        this.cabeza = null;
    }
    
    /**
     * Método: seEncuentra
     * Propósito: Verificar si un valor se encuentra o no en la lista
     * Parámetros de entrada:
     *      - int valor : Valor a buscar
     * Parámetros de salida:
     *      - boolean: Representa si se encontró el valor o no
     */
    public boolean seEncuentra(int valor){
        boolean seEncuentra = false;
        if(this.cabeza != null){    //Si la lista no está vacía
            NodoLista NodoListaActual = this.cabeza;
            while(NodoListaActual != null){
                if (NodoListaActual.getValor() == valor){
                    seEncuentra = true;
                    return seEncuentra;
                }
                NodoListaActual = NodoListaActual.getSiguiente();
            }
        }
        return seEncuentra;    
    }

    /**
     * Método: insertar
     * Propósito: Insertar un valor en la lista
     * Parámetros de entrada:
     *      - int valor: Valor a insertar
     * Parámetros de salida:
     *      - null
     */
    public void insertar(int valor){     
        if (this.cabeza == null){   //Si la lista está vacía:
            this.cabeza = new NodoLista(valor);
        }
        else{   //Si no está vacía
            NodoLista nuevaCabeza = new NodoLista(valor);     //Creo la nueva cabeza
            nuevaCabeza.setSiguiente(this.cabeza);      //La enlazo a la cabeza actual
            this.cabeza = nuevaCabeza;      //Redefino la nueva cabeza
        }
    }

    /**
     * Método: eliminar
     * Propósito: Eliminar de la lista el valor ingresado
     * Parámetros de entrada:
     *      - int valor: Valor a eliminar
     * Parámetros de salida:
     *      - null
     */
    public void eliminar(int valor){ 
        if(!esVacio()){   //Si la lista no está vacía
            if(seEncuentra(valor)){ //Si el valor se encuentra en la lista
                //Si el objeto es la cabeza:                
                if(this.cabeza.getValor() == valor){
                    this.cabeza = this.cabeza.getSiguiente();
                } else{ //Si el objeto no es la cabeza
                    NodoLista temporal = this.cabeza;
                    while(temporal.getSiguiente().getValor() != valor){
                        temporal = temporal.getSiguiente();
                    }
                    NodoLista nodoAEliminar = temporal.getSiguiente();
                    temporal.setSiguiente(nodoAEliminar.getSiguiente());
                }
            }
        }
    }

    /**
     * Método: mostrar
     * Propósito: Obtener todos los elementos de la lista en formato de string para su posterior visualización
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - String: Todos los elementos de la lista
     */
    public String mostrar(){
        String textoLista = "";
        if(esVacio()){    //Lista vacía
            textoLista += "La lista se encuentra vacía.";
        } else if (this.cabeza.getSiguiente() == null){ //Lista con solo la cabeza
            textoLista += this.cabeza.getValor();
        }else{  //Lista con mínimo dos nodos
            NodoLista temporal = this.cabeza;
            while(temporal != null){
                if(temporal == this.cabeza){
                    textoLista += temporal.getValor();
                }else{
                    textoLista += "  ->  ";
                    textoLista += temporal.getValor();
                }
                temporal = temporal.getSiguiente();
            }  
        }
        return(textoLista);
    }
    


    /**
     * Método: detonarOrdenamientoCreciente
     * Propósito: Verificar si mi lista está o no desordenada en orden creciente
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - boolean: Representa si está ordenada o no
     */
    public boolean detonarOrdenamientoCreciente(){
        boolean listaDesordenada = false;
        NodoLista nodoActual = this.cabeza;
        while(nodoActual.getSiguiente() != null){
            if(nodoActual.getValor() > nodoActual.getSiguiente().getValor()){
                listaDesordenada = true;
                return listaDesordenada;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return listaDesordenada;
    }

    /**
     * Método: intercambiarNodosCreciente
     * Propósito: Intercambiar los primeros dos nodos que no estén ordenados de forma creciente
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public void intercambiarNodosCreciente(){
        NodoLista nodo = this.cabeza;   //Empiezo a verificar en la cabeza
        while(nodo.getSiguiente() != null){ 
            if(nodo.getValor() > nodo.getSiguiente().getValor()){   //Hago el cambio de nodos
                int valorTemporal = nodo.getValor();
                nodo.setValor(nodo.getSiguiente().getValor());
                nodo.getSiguiente().setValor(valorTemporal);
            }
            nodo = nodo.getSiguiente();
        }
    }

    /**
     * Método: ordenarCreciente
     * Propósito: ordenar la lista en orden creciente de valores
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public void ordenarCreciente(){
        boolean listaDesordenada = detonarOrdenamientoCreciente(); //Verifico que mi lista esté desordenada
        while(listaDesordenada){    //Mientras la lista esté desordenada
            intercambiarNodosCreciente();   //Intercambio los primeros dos nodos que no estén en posición
            listaDesordenada = detonarOrdenamientoCreciente();  //Compruebo que siga desordenada
        }
    }

    /**
     * Método: detonarOrdenamientoDecreciente
     * Propósito: Verificar si mi lista está o no desordenada en orden decreciente
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - boolean: Representa si está ordenada o no
     */
    public boolean detonarOrdenamientoDecreciente(){
        boolean listaDesordenada = false;
        NodoLista nodoActual = this.cabeza;
        while(nodoActual.getSiguiente() != null){
            if(nodoActual.getValor() < nodoActual.getSiguiente().getValor()){
                listaDesordenada = true;
                return listaDesordenada;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return listaDesordenada;
    }

    /**
     * Método: intercambiarNodosDecreciente
     * Propósito: Intercambiar los primeros dos nodos que no estén ordenados de forma decreciente
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public void intercambiarNodosDecreciente(){
        NodoLista nodo = this.cabeza;   //Empiezo a verificar en la cabeza
        while(nodo.getSiguiente() != null){ 
            if(nodo.getValor() < nodo.getSiguiente().getValor()){   //Hago el cambio de nodos
                int valorTemporal = nodo.getValor();
                nodo.setValor(nodo.getSiguiente().getValor());
                nodo.getSiguiente().setValor(valorTemporal);
            }
            nodo = nodo.getSiguiente();
        }
    }

    /**
     * Método: ordenarDcCreciente
     * Propósito: ordenar la lista en orden decreciente de valores
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public void ordenarDecreciente(){
        boolean listaDesordenada = detonarOrdenamientoDecreciente(); //Verifico que mi lista esté desordenada
        while(listaDesordenada){    //Mientras la lista esté desordenada
            intercambiarNodosDecreciente();   //Intercambio los primeros dos nodos que no estén en posición
            listaDesordenada = detonarOrdenamientoDecreciente();  //Compruebo que siga desordenada
        }
    }


    public static void main(String[] args) {
        Lista lista1 = new Lista();
        lista1.insertar(7);
        lista1.insertar(4);
        lista1.insertar(6);
        lista1.insertar(1);
        lista1.insertar(10);
        System.out.println("Lista Desordenada: " + lista1.detonarOrdenamientoCreciente());
        System.out.println(lista1.mostrar());
        //Lista desordenada:
        //10  ->  1  ->  6  ->  4  ->  7
        lista1.ordenarCreciente();
        System.out.println("Lista Desordenada: " + lista1.detonarOrdenamientoCreciente());
        System.out.println(lista1.mostrar());

  
    }
}
