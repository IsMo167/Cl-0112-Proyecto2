/**
 * Clase: Arbol
 * Propósito: Crear un árbol binario
 */
public class Arbol { 
    //Atributos
    private NodoArbol nodoRaiz;

    /**
     * Constructor
     * Propósito: Inicializar mi árbol
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public Arbol() {
        this.nodoRaiz = null; //Se inicializa en null
    }
    //Setters y getters
    public NodoArbol getNodoRaiz(){
        return this.nodoRaiz;
    }
    public void setNodoRaiz(NodoArbol nodoRaiz){
        this.nodoRaiz = nodoRaiz;
    }

    /**
     * Método: esVacio
     * Propósito: Verificar si mi árbol está vacío o no
     * Parámetros de entrada:
     *      - null
     *      -
     * Parámetros de salida:
     *      - boolean: Representa si el árbol está vacío o no
     */
    public boolean esVacio(){
        boolean estaVacio = (this.nodoRaiz == null)? true : false;
        return estaVacio;
    }
    
    /**
     * Método: vaciar
     * Propósito: Vaciar mi árbol
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - null
     */
    public void vaciar(){
        this.nodoRaiz = null;
    }

    /**
     * Método: buscar
     * Propósito: Buscar si un valor se encuentra en el árbol
     * Parámetros de entrada:
     *      - int valor: Valor a buscar
     * Parámetros de salida:
     *      - boolean: Representa si se encontró el valor o no
     */
    public boolean buscar(int valor) {
        boolean seEncontro = false;
        if(this.nodoRaiz != null){
            seEncontro = buscarRec(this.nodoRaiz, valor);
        }
        return seEncontro;
    }

    /**
     * Método: buscarRec
     * Propósito: Buscar recursivamente en cada elemento del árbol
     * Parámetros de entrada:
     *      - NodoArbol nodo: Nodo el cuál debo analizar
     *      - int valor: Valor a ser buscado
     * Parámetros de salida:
     *      - boolean: Representa si se encontró el valor o no
     */
    private boolean buscarRec(NodoArbol nodo, int valor) {
        boolean seEncontro = false;
        if (nodo == null){
            return seEncontro;
        }else if(nodo.getValor() == valor){
            seEncontro = true;
        }
        seEncontro = seEncontro || buscarRec(nodo.getHijoIzquierdo(), valor);
        seEncontro = seEncontro || buscarRec(nodo.getHijoDerecho(), valor);
        
        return seEncontro;
    }

    /**
     * Método: insertar
     * Propósito: Insertar un valor en el árbol
     * Parámetros de entrada:
     *      - int valor: Valor a ser insertado
     * Parámetros de salida:
     *      - null
     */
    public void insertar(int valor) {
        if (nodoRaiz == null) {
            this.nodoRaiz = new NodoArbol(valor);
        } else {
            insertarRecursivamente(nodoRaiz, valor);
        }
    }

    /**
     * Método: insertarRecursivamente
     * Propósito: Identificar en qué posición debo insertar un valor 
     * Parámetros de entrada:
     *      - NodoArbol nodo: Nodo el cuál debo analizar 
     *      - int valor: Valor a ser insertado
     * Parámetros de salida:
     *      - null
     */
    private void insertarRecursivamente(NodoArbol nodo, int valor) {
        if (valor < nodo.getValor()) {
            if (nodo.getHijoIzquierdo() == null) {
                nodo.setHijoIzquierdo(new NodoArbol(valor));
            } else {
                insertarRecursivamente(nodo.getHijoIzquierdo(), valor);
            }
        } else if (nodo.getValor() < valor) {
            if (nodo.getHijoDerecho() == null) {
                nodo.setHijoDerecho(new NodoArbol(valor));
            } else {
                insertarRecursivamente(nodo.getHijoDerecho(), valor);
            }
        }
    }

    /**
     * Método: eliminar
     * Propósito: Eliminar un valor de un árbol
     * Parámetros de entrada:
     *      - int valor: Valor a ser eliminado
     * Parámetros de salida:
     *      - null
     */
    public void eliminar(int valor){
        this.nodoRaiz = eliminarRec(this.nodoRaiz, valor);
    }
    

    /**
     * Método: eliminarRec
     * Propósito: identificar cómo eliminar el nodo una vez encontrado
     * Parámetros de entrada:
     *      - NodoArbol nodo: Nodo que debo analizar
     *      - int valor: Valor que quiero eliminar
     * Parámetros de salida:
     *      - NodoArbol: Para mantener la estructura del árbol bien
     */
    public NodoArbol eliminarRec(NodoArbol nodo, int valor){
        if (nodo != null){
            //Caso Base: Encontró el valor a ser eliminado
            if(valor == nodo.getValor()){   
                //Eliminamos una hoja:
                if(nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null){ 
                    return null;
                }
                //Eliminamos un nodo con un único hijo
                else if(nodo.getHijoIzquierdo() == null ^ nodo.getHijoDerecho() == null){   
                    if(nodo.getHijoIzquierdo() == null){//Solo tiene hijo derecho
                        return nodo.getHijoDerecho();
                    }else{  //Solo tiene hijo izquierdo
                        return nodo.getHijoIzquierdo();
                    }
                } else{ //Eliminamos un nodo con dos hijos
                    NodoArbol sucesor = encontrarMinimo(nodo.getHijoDerecho());
                    nodo.setValor(sucesor.getValor());
                    nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), sucesor.getValor()));
                    return nodo;
                }
            }
            if(valor < nodo.getValor()){
                nodo.setHijoIzquierdo(eliminarRec(nodo.getHijoIzquierdo(), valor));
            } else{
                nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), valor));
            }
        }
        return nodo;
    }
    
    /**
     * Método: encontrarMinimo
     * Propósito: Encontrar el mínimo valor de un subArbol
     * Parámetros de entrada:
     *      - NodoArbol nodo: Cabeza del subArbol que estoy analizando
     * Parámetros de salida:
     *      - NodoArbol: Nodo mínimo del subArbol
     */
    public NodoArbol encontrarMinimo (NodoArbol nodo){
        while(nodo.getHijoIzquierdo() != null){ //Caso Rec
            return encontrarMinimo(nodo.getHijoIzquierdo());
        }
        return nodo;
    } 

    /**
     * Método: mostrar
     * Propósito: Guardar en un String el contenido de un árbol
     * Parámetros de entrada:
     *      - null
     * Parámetros de salida:
     *      - String: Contenido del árbol
     */
    public String mostrar(){

        String arbolTexto = "";
        if(this.nodoRaiz == null){
            arbolTexto += "El árbol se encuentra vacío";
        }else{
            arbolTexto += mostrarRec(this.nodoRaiz);
            arbolTexto += "}";
        }
        return arbolTexto;
    }

    /**
     * Método: mostrarRec
     * Propósito: Recorrer recursivamente el árbol en preorden e ir regresando los valores en formato de texto
     * Parámetros de entrada:
     *      - NodoArbol nodo: Nodo que debo analizar
     * Parámetros de salida:
     *      - String: Contenido del nodo
     */
    public String mostrarRec(NodoArbol nodo){
        String resultado = "";
        if(nodo != null){   //Solo se hace el recorrido si el nodo no es nulo  
            if(nodo == this.nodoRaiz){
                resultado += "{" + nodo.getValor();
            }
            else{
                resultado += ", " + nodo.getValor();
            }
            resultado += mostrarRec(nodo.getHijoIzquierdo());
            resultado += mostrarRec(nodo.getHijoDerecho());
        }
        return resultado;
    }

}
