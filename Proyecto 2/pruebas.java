public class pruebas {
    public static void main(String[] args) {
        /**
         * Prueba de nodos:
         */

        // Crear nodos
        Nodo nodo1 = new Nodo(3);
        Nodo nodo2 = new Nodo("Azucar");
        Nodo nodo3 = new Nodo(true);
    
        // Enlazar nodos
        nodo1.setSiguiente(nodo2);
        nodo2.setSiguiente(nodo3);       //El nodo3 está enlazado con el valor null
    
        // Imprimir valores
        System.out.println("Nodo 1:");
        nodo1.imprimirNodo();
    
        System.out.println("Nodo 2:");
        nodo1.getSiguiente().imprimirNodo();

        System.out.println("Nodo 3:");
        nodo3.imprimirNodo();

        /**
         * Prueba de lista:
         */

        //Crear lista
        Lista lista = new Lista();      //Lista vacía

        //Insertar cabeza:
        lista.insertar("Tercero");

        //Mostrar lista:
        lista.mostrarLista();

        //Insertar varios elementos más:
        lista.insertar(true);
        lista.insertar("Primero");
        lista.mostrarLista();

        //Buscar elementos
        System.out.println(lista.buscar("Primero"));
        System.out.println(lista.buscar("Hola"));
        System.out.println();

        //Eliminar elementos
        lista.eliminar("Primero");
        lista.mostrarLista();

        // lista.eliminar("Segundo");
        // lista.mostrarLista();

        // lista.eliminar("Tercero");
        // lista.mostrarLista();
    }
}
