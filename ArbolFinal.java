public class ArbolFinal { //Clase árbol
    private NodoArbol nodoRaiz;

    public ArbolFinal() {
        this.nodoRaiz = null; //Se inicializa en null
    }
    public NodoArbol getNodoRaiz(){
        return this.nodoRaiz;
    }
    public void setNodoRaiz(NodoArbol nodoRaiz){
        this.nodoRaiz = nodoRaiz;
    }


    public boolean esVacio(){
        boolean estaVacio = (this.nodoRaiz == null)? true : false;
        return estaVacio;
    }
    
    public void vaciar(){
        this.nodoRaiz = null;
    }
     // Buscar un nodo por su valor
     public boolean buscar(int valor) {
        boolean seEncontro = false;
        if(this.nodoRaiz != null){
            seEncontro = buscarRec(this.nodoRaiz, valor);
        }
        return seEncontro;
    }

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

    // Insertar un nuevo nodo en el árbol
    public void insertar(int valor) {
        if (nodoRaiz == null) {
            this.nodoRaiz = new NodoArbol(valor);
        } else {
            insertarRecursivamente(nodoRaiz, valor);
        }
    }

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

    public void eliminar(int valor){
        this.nodoRaiz = eliminarRec(this.nodoRaiz, valor);
    }
    
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
    
    public NodoArbol encontrarMinimo (NodoArbol nodo){
        while(nodo.getHijoIzquierdo() != null){ //Caso Rec
            return encontrarMinimo(nodo.getHijoIzquierdo());
        }
        return nodo;
    } 


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

    public static void main(String[] args) {
        ArbolFinal arbol1 = new ArbolFinal();

        arbol1.insertar(10);
        arbol1.insertar(5);
        arbol1.insertar(20);
        arbol1.insertar(8);
        arbol1.insertar(15);
        arbol1.insertar(25);
        arbol1.insertar(7);
        arbol1.insertar(9);
        System.out.println(arbol1.mostrar());
        System.out.println(arbol1.buscar(16));

    }
}
