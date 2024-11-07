/**
 * Referencias:
 * https://www.deltapci.com/java-listas-enlazadas-simples/
 * https://www.youtube.com/watch?v=9q758AJ1nck&t=1s
 * https://www.youtube.com/watch?v=WmVMRweAp7E
 */
public class Lista{
    //Defino los atributos
    private Nodo cabeza;

    //Constructor #1: Creo la lista vacía
    public Lista(){
        cabeza = null;
    }
    //Insertar #1: Inserto un valor al inicio de la lista
    public void insertarValor(Object valor){
        if (this.cabeza == null){
            this.cabeza = new Nodo(valor);
        }
        else{
            Nodo nuevaCabeza = new Nodo(valor, this.cabeza);
            this.cabeza = nuevaCabeza;
        }
    }
    public void mostrarLista(){
        int contador = 0;
        Nodo nodoTemporal = this.cabeza;
        while(nodoTemporal != null){
            System.out.println(contador + ": " + nodoTemporal.getValor());
            contador ++ ;
            nodoTemporal = nodoTemporal.getSiguiente();
        }
        System.out.println("-------------------------------\n");
    }
}
