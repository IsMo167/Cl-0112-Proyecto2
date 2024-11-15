//Referencia: https://javarush.com/es/groups/posts/es.3111.estructuras-de-datos-rbol-binario-en-java
public class MainArbol {
    public static void main(String[] args) {
        // Crear una instancia del árbol
        Arbol arbol = new Arbol();

        // Insertar nodos en el árbol
        System.out.println("Insertando nodos...");
        arbol.insertarNodo(5);
        arbol.insertarNodo(14);
        arbol.insertarNodo(6);
        arbol.insertarNodo(1);
        arbol.insertarNodo(9);
        arbol.insertarNodo(7);
        arbol.insertarNodo(4);
        arbol.insertarNodo(10);
        arbol.insertarNodo(3);
        arbol.insertarNodo(2);

        // Imprimir el árbol
        System.out.println("\nÁrbol después de insertar nodos:");
        arbol.imprimirArbol();

        // Eliminar un nodo
        System.out.println("\nEliminando el nodo con valor 5...");
        arbol.eliminarNodo(5);

        // Imprimir el árbol después de la eliminación
        System.out.println("\nÁrbol después de eliminar el nodo 5:");
        arbol.imprimirArbol();

        // Buscar un nodo por su valor
        System.out.println("\nBuscando el nodo con valor 7...");
        NodoArbol nodoEncontrado = arbol.encontrarNodoPorValor(7);
        if (nodoEncontrado != null) {
            nodoEncontrado.imprimirNodo();
        } else {
            System.out.println("Nodo no encontrado.");
        }
    }
}
