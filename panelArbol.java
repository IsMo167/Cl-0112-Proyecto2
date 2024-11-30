import javax.swing.*;
import java.awt.*;


/**
 * Clase: panelArbol
 * Propósito: Definir el componente en el que dibujaré mi árbol
 */
class panelArbol extends JPanel {
    private Arbol arbol;

    /**
     * Constructor
     * Propósito: Crear mi panel
     * Parámetros de entrada:
     *      - Arbol arbol: Árbol que estaré dibujando
     * Parámetros de salida:
     *      - null
     */
    public panelArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    /**
     * Método: paintComponent
     * Propósito:  pintar el árbol
     * Parámetros de entrada:
     *      - Graphics g: Para poder realizar el dibujo
     * Parámetros de salida:
     *      - null
     */
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);    //Para eliminar el contenido del panel y dibujarlo de cero, sin que se superpongan dibujos anteriores.
        if (arbol.getNodoRaiz() != null) {  //Solo dibujo un nodo no nulo
            int anchoPanel = getWidth();
            int altoNodoRaiz = 40;
            dibujarNodo(g, arbol.getNodoRaiz(), anchoPanel/2, altoNodoRaiz, anchoPanel/4);
        }
    }

    /**
     * Método: dibujarNodo
     * Propósito: Dibuja todos los nodos de mi árbol
     * Parámetros de entrada:
     *      - Graphics g: Para poder realizar los dibujos
     *      - NodoArbol nodo: Nodo que estoy dibujando
     *      - int x: Posición horizontal en la que orientar el dibujo de mi nodo
     *      - int y: Posición vertical en la que orientar el dibujo de mi nodo
     *      - int distanciaHorizontalSeparacion: Distancia horizontal en la que separaré los nodos de mi árbol. Conforme vaya bajando de nivel,
     *          esta distancia será menor.
     * Parámetros de salida:
     *      - null
     */
    private void dibujarNodo(Graphics g, NodoArbol nodo, int x, int y, int distanciaHorizontalSeparacion) {   
        if (nodo != null) { //Solo dibuja un nodo si no es nulo

            // Primero dibujo las líneas que unen los hijos que existan para que se dibujen por debajo del círculo y texto
            if (nodo.getHijoIzquierdo() != null) {
                g.drawLine(x, y, x - distanciaHorizontalSeparacion, y + 50);
            }
            if (nodo.getHijoDerecho() != null) {
                g.drawLine(x, y, x + distanciaHorizontalSeparacion, y + 50);
            }

            // Variables necesarias para ubicar el círculo y la estrella
            int radio = 40;
            int xCentro = x - (radio/2);
            int yCentro = y - (radio/2);

            if (nodo == arbol.getNodoRaiz()){   //Dibujaré la raíz con una estrella por afuera
                dibujarRaiz(g, nodo, 3*radio/4);

            } else{ //Dibujaré los hijos como bolitas
                if(nodo.getValor() % 2 == 0){
                    //Dibujo el nodo relleno y su borde
                    g.setColor(Color.GREEN);    //El color del círculo relleno
                    g.fillOval(xCentro, yCentro, radio, radio);   // Dibuo el círculo relleno
                    g.setColor(Color.BLACK);    //El color del borde del círculo
                    g.drawOval(xCentro, yCentro, radio, radio);   //Dibuo el borde
                }else{
                    //Dibujo el nodo relleno y su borde
                    g.setColor(Color.BLUE);    //El color del círculo relleno
                    g.fillOval(xCentro, yCentro, radio, radio);   // Dibuo el círculo relleno
                    g.setColor(Color.BLACK);    //El color del borde del círculo
                    g.drawOval(xCentro, yCentro, radio, radio);   //Dibuo el borde
                }
            }

            // Dibujo el valor del nodo
            String valor = nodo.toString();     //Obtengo el valor a dibujar

            Font fuenteTexto= new Font("Times New Roman", Font.BOLD, 30);   //Defino la fuente que quiero
            g.setFont(fuenteTexto); //Establezco mi fuente en el graphics

            //Proceso para obtener mi ancho y alto específicos para poder centrar el texto en el círculo
            FontMetrics fm = g.getFontMetrics();    
            int textoAncho = fm.stringWidth(valor);
            int textoAlto = fm.getAscent();
            //Dibujo mi texto centrado
            g.drawString(valor, x - textoAncho / 2, y + textoAlto / 4);


            // Ahora sí, dibujo los hijos que existan
            if (nodo.getHijoIzquierdo() != null) {
                dibujarNodo(g, nodo.getHijoIzquierdo(), x - distanciaHorizontalSeparacion, y + 50, distanciaHorizontalSeparacion / 2);
            }
            if (nodo.getHijoDerecho() != null) {
                dibujarNodo(g, nodo.getHijoDerecho(), x + distanciaHorizontalSeparacion, y + 50, distanciaHorizontalSeparacion / 2);
            }
        }
    }

    /**
     * Método: dibujarRaiz
     * Propósito: Se encarga de dibujar el nodo raíz 
     * Parámetros de entrada:
     *      - Graphics g: Para poder realizar los dibujos
     *      - NodoArbol nodo: nodo raíz
     *      - int radio: Radio en el que se encerrará nuestro valor
     * Parámetros de salida:
     *      - null
     */
    private void dibujarRaiz(Graphics g, NodoArbol nodo, int radio) {

        int verticesEstrella = 10;
        int radioExterno = (int) Math.round (2*radio); // El radio del círculo que conecta los picos externos de la estrella
        double anguloInicial = -Math.PI/2;
        //Defino mis puntos de la estrella
        int[] xPuntos = obtenerPuntosXEstrella(getWidth()/2, radio, radioExterno, anguloInicial, verticesEstrella);
        int[] yPuntos = obtenerPuntosYEstrella(35, radio, radioExterno, anguloInicial, verticesEstrella);

        //Dibujo la estrella rellena de amarillo
        g.setColor(Color.YELLOW);   
        g.fillPolygon(xPuntos, yPuntos, verticesEstrella);
        //Dibujo el borde de la estrella:
        g.setColor(Color.BLACK);    
        g.drawPolygon(xPuntos, yPuntos, verticesEstrella); 
    }
    

    /**
     * Método: obtenerPuntosXEstrella
     * Propósito: Obtener la posición en 'x' de los puntos de la estrella
     * Parámetros de entrada:
     *      - int xCentro: Posición horizontal del centro del radio interno de la estrella.
     *      - int radio: Medida del radio interno de la estrella. 
     *      - double anduloInicial: Ángulo respecto al eje horizontal respecto al cual se colocará el primer punto
     *      - int vertices: Cantidad de vertices que contrendrá la estrella
     * Parámetros de salida:
     *      - int[] : Arreglo de enteros de las posiciones horizontales de los vértices
     */
    public int[] obtenerPuntosXEstrella(int xCentro, int radio, int radioExterno, double anguloInicial, int vertices){
        int[] xPuntos = new int[vertices]; 

        //Defino los puntos de mi estrella:

        double anguloIncremento = 2 * Math.PI / vertices;
        for (int i = 0; i < vertices; i++) {
            double anguloVertice = anguloInicial + i*anguloIncremento;
            if(i%2 == 0){   //Estoy en un vértice externo
                xPuntos[i] = (int) Math.round(xCentro + radioExterno * Math.cos(anguloVertice));
            } else{ //Estoy en un vértice interno
                xPuntos[i] = (int) Math.round(xCentro + radio * Math.cos(anguloVertice));
            }
        }
        return xPuntos;
    }

    /**
     * Método: obtenerPuntosYEstrella
     * Propósito: Obtener la posición en 'y' de los puntos de la estrella
     * Parámetros de entrada:
     *      - int yCentro: Posición vertical del centro del radio interno de la estrella.
     *      - int radio: Medida del radio interno de la estrella. 
     *      - double anduloInicial: Ángulo respecto al eje horizontal respecto al cual se colocará el primer punto
     *      - int vertices: Cantidad de vertices que contrendrá la estrella
     * Parámetros de salida:
     *      - int[] : Arreglo de enteros de las posiciones verticales de los vértices
     */
    public int[] obtenerPuntosYEstrella(int yCentro, int radio, int radioExterno, double anguloInicial, int vertices){
        int[] yPuntos = new int[vertices]; 

        double anguloIncremento = 2 * Math.PI / vertices;

        for (int i = 0; i < vertices; i++) {
            double anguloVertice = anguloInicial + i*anguloIncremento;
            if(i%2 == 0){   //Estoy en un vértice externo
                yPuntos[i] = (int) Math.round(yCentro + radioExterno * Math.sin(anguloVertice));
            } else{ //Estoy en un vértice interno
                yPuntos[i] = (int) Math.round(yCentro + radio * Math.sin(anguloVertice));
            }
        }
        return yPuntos;
    }
}