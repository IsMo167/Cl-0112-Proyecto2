public class pruebasLista {
    public static void main(String[] args) {
        /**
         * Crear lista e ingresar raíz
         */
        Lista lista1 = new Lista();
        System.out.println("Prueba insertar Cabeza: ");
        lista1.insertar(7);
        System.out.println(lista1.mostrar());
        //  Lista: 7

        /**
         * Agregar otros nodos
         */
        System.out.println("Prueba insertar varios nodos: ");
        lista1.insertar(1);
        lista1.insertar(3);
        lista1.insertar(5);
        System.out.println(lista1.mostrar());
        //  Lista: 1 -> 3 -> 5 -> 7

        // /**
        //  * ORdenar lista
        //  */
        // System.out.println("Prueba ordenar lista: ");
        // lista1.ordenar();
        // System.out.println(lista1.mostrar());
        // //  Lista: 1 -> 3 -> 5 -> 7


        // /**
        //  * Eliminación de nodos:
        //  */
        // System.out.println("Elimino cabeza: ");
        // lista1.eliminar(1);
        // System.out.println(lista1.mostrar());
        // //  Lista: 3 -> 5 -> 7

        // System.out.println("Elimino nodo de en medio: ");
        // lista1.eliminar(5);
        // System.out.println(lista1.mostrar());
        // //  Lista: 3 -> 7

        // System.out.println("Elimino último nodo: ");
        // lista1.eliminar(7);
        // System.out.println(lista1.mostrar());
        // //  Lista: 3

        // System.out.println("Elimino un nodo que no está: ");
        // lista1.eliminar(4);
        // System.out.println(lista1.mostrar());
        // //  Lista: 3

        // System.out.println("Elimino cabeza: ");
        // lista1.eliminar(3);
        // System.out.println(lista1.mostrar());
        // //  Lista: ' '

        // System.out.println("Intento eliminar de lista vacía: ");
        // lista1.eliminar(3);
        // System.out.println(lista1.mostrar());
        // //  Lista: ' '

    }
}
