/**
 * Referencias:
 * https://www.deltapci.com/java-listas-enlazadas-simples/
 * https://www.youtube.com/watch?v=9q758AJ1nck&t=1s
 * https://www.youtube.com/watch?v=WmVMRweAp7E
 */
public class Lista{
    //Atributos:
    private Nodo cabeza;

    //Método Constructor:
    public Lista(){
        cabeza = null;
    }

    //Setters y getters:
    public Nodo getCabeza(){
        return this.cabeza;
    }
    public void setCabeza(Nodo cabeza){
        this.cabeza = cabeza;
    }

    //Método de Insertar:
    public void insertar(String valor){     //Note que insertamos valores, no nodos
        if (this.cabeza == null){   //Si la lista está vacía:
            this.cabeza = new Nodo(valor);
        }
        else{   //Si ya hay una cabeza en la lista:
            Nodo nuevaCabeza = new Nodo(valor);     //Creo la nueva cabeza
            nuevaCabeza.setSiguiente(this.cabeza);      //La enlazo a la cabeza actual
            this.cabeza = nuevaCabeza;      //Redefino la nueva cabeza
        }
    }
    //Método de Buscar:
    public boolean buscar(String valor){
        boolean seEncuentra = false;
        if(this.cabeza != null){    //1. Si la cabeza no está vacía
            Nodo nodoActual = this.cabeza;
            while(nodoActual != null){
                if (nodoActual.getValor().equals(valor)){
                    seEncuentra = true;
                    return seEncuentra;
                }
                else{
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        return seEncuentra;     //2. Else: return false
    }

    //Método de Eliminar:
    public void eliminar(String valor){ //Queremos eliminar el 3 de: 1->2->3->4
        //Si el objeto es la cabeza:
        if(this.cabeza.getValor().equals(valor)){
            this.cabeza = this.cabeza.getSiguiente();
        }
        //Si el objeto no está en la cabeza: (asumimos que el objeto está)
        else{
            Nodo temporal = this.cabeza;
            Nodo siguiente = temporal.getSiguiente();
            while(!siguiente.getValor().equals(valor)){
                temporal = temporal.getSiguiente();
                siguiente = temporal.getSiguiente();
            }
            temporal.setSiguiente(
                                 //Si el siguiente no existe, enlazar a null, si sí existe, enlazar al siguiente de siguiente
                                 (siguiente == null)? null: siguiente.getSiguiente()
                                 );
        }
    }
    //Método para comprobar si la lista está vacía o no:
    public boolean vacia(){
        boolean listaVacia = (this.cabeza == null)? true : false;
        return listaVacia;
    }

    //Método para mostrar la lista:
    public String mostrar(boolean listaVacia){
        String textList = "";
        if(listaVacia){
            textList += "La lista se encuentra vacía.";
        }
        else{
            textList += this.cabeza.getValor();

            Nodo nodoTemporal = this.cabeza.getSiguiente();
            while(nodoTemporal != null){
                textList += "  ->  ";
                textList += nodoTemporal.getValor();
                nodoTemporal = nodoTemporal.getSiguiente();
            }
        }
        return(textList);
    }
}
