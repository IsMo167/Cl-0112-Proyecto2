//Referencia: https://javarush.com/es/groups/posts/es.3111.estructuras-de-datos-rbol-binario-en-java
import java.util.Scanner;
public class MainArbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear una instancia del árbol
        Arbol arbol = new Arbol();

        // Insertar nodos en el árbol
        System.out.println("Insertar la cantidad de nodos que desea que tenga el árbol: ");
        int cantidadNodos = scanner.nextInt();

        for (int i = 0; i < cantidadNodos; i++ ){
            System.out.println("Ingrese el valor del nodo " + (i+1) + ": ");
            int valorNodo = scanner.nextInt();
            arbol.insertar(valorNodo);
        }


        System.out.println("Desea imprimir el árbol a ésta instancia? (escriba true/false): ");
        boolean mostrarArbol = scanner.nextBoolean();
        if (mostrarArbol == true){
            arbol.imprimirArbol();
        }
        else{
            System.out.println ("Siguiente paso...");
        }

        // Eliminar nodos del árbol
        System.out.println("Insertar la cantidad de nodos que desea eliminar del árbol: ");
        int cantidadNodosEliminar = scanner.nextInt();

        for (int i = 0; i < cantidadNodosEliminar; i++ ){
            if(cantidadNodosEliminar <= cantidadNodos){        
                System.out.println("Ingrese el valor a eliminar # " + (i+1));
                int valorNodoEliminar = scanner.nextInt();
                if(arbol.encontrarNodoPorValor (valorNodoEliminar) != null){
                    arbol.eliminar(valorNodoEliminar);
                    System.out.println("Se elimina el nodo: " + valorNodoEliminar);
                }
                else{
                    System.out.println ("No se puede eliminar un nodo que no existe.");
                }
            }
            else{
                System.out.println("Cantidad de nodos a eliminar fuera de rango.");
            }
        }

        System.out.println("Desea imprimir el árbol a ésta instancia? (escriba true/false): ");
        boolean mostrarArbolEliminar = scanner.nextBoolean();
        if (mostrarArbol == true){
            arbol.imprimirArbol();
        }
        else{
            System.out.println ("Siguiente paso...");
        }

        // Buscar un nodo por su valor
        System.out.println("Ingrese el nodo que desea buscar: ");
        int buscarNodo = scanner.nextInt();
        NodoArbol nodoEncontrado = arbol.encontrarNodoPorValor(buscarNodo);
        if (nodoEncontrado != null) {
            System.out.println ("Se encontró el nodo! El nodo encontrado es: " + buscarNodo);
        } else {
            System.out.println("Nodo no encontrado.");
        }
    }
}
