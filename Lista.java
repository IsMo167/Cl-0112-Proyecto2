/**
 * Referencias:
 * https://www.deltapci.com/java-listas-enlazadas-simples/
 * https://www.youtube.com/watch?v=9q758AJ1nck&t=1s
 * https://www.youtube.com/watch?v=WmVMRweAp7E
 */
public class Lista{
    //Atributos:
    private NodoLista cabeza;

    //Método Constructor:
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

    //Método para comprobar si la lista está vacía o no:
    public boolean vacia(){
        boolean listaVacia = (this.cabeza == null)? true : false;
        return listaVacia;
    }

    //Método de vaciar
    public void vaciar(){
        this.cabeza = null;
    }
    
    //Método de Buscar:
    public boolean seEncuentra(int valor){
        boolean seEncuentra = false;
        if(this.cabeza != null){    //1. Si la cabeza no está vacía
            NodoLista NodoListaActual = this.cabeza;
            while(NodoListaActual != null){
                if (NodoListaActual.getValor() == valor){
                    seEncuentra = true;
                    return seEncuentra;
                }
                NodoListaActual = NodoListaActual.getSiguiente();
            }
        }
        return seEncuentra;     //2. Else: return false
    }

    //Método de Insertar:
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

    //Método de Eliminar:
    public void eliminar(int valor){ 
        if(!vacia()){   //Si la lista no está vacía
            if(seEncuentra(valor)){ //Si el valor se encuentra en la lista
                //Si el objeto es la cabeza:                //Queremos eliminar el 3 de: 1->2->3->4
                if(this.cabeza.getValor() == valor){
                    this.cabeza = this.cabeza.getSiguiente();
                } else{
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

    //Método para mostrar la lista:
    public String mostrar(){
        String textoLista = "";
        if(vacia()){    //Lista vacía
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
    
    // //Para ordenar la lista
    // public void ordenar(){
    //     if(this.cabeza == null || this.cabeza.getSiguiente() == null){
    //         //La lista ya está ordenada
    //     }else{
    //         NodoLista nodoFijo = this.cabeza;
    //         while(nodoFijo.getSiguiente() != null){
    //             NodoLista nodoComparacion = nodoFijo.getSiguiente();
    //             if(nodoComparacion.getValor() < nodoFijo.getValor()){
    //                 int valorTemporal = nodoFijo.getValor();
    //                 nodoFijo.setValor(nodoComparacion.getValor());
    //                 nodoComparacion.setValor(valorTemporal);
    //             }
    //             nodoFijo = nodoFijo.getSiguiente();
    //         }
    //     }
    // }

}
