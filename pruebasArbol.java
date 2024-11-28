//Referencia: https://javarush.com/es/groups/posts/es.3111.estructuras-de-datos-rbol-binario-en-java
public class pruebasArbol {
    public static void main(String[] args) {
        // Crear una instancia del árbol
        Arbol arbol = new Arbol();

        /**
         * Inserto raíz
         */
        //Inserto una raíz
        arbol.insertarNodo(10);
        //Visualizo mi árbol
        arbol.imprimirArbol();

        /**
         * Inserto varios nodos más
         */
        arbol.insertarNodo(5);
        arbol.insertarNodo(10);
        arbol.insertarNodo(9);
        arbol.insertarNodo(6);
        arbol.insertarNodo(4);
        arbol.insertarNodo(7);
        arbol.imprimirArbol();
    }
}
