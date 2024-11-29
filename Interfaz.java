import javax.swing.*;
import java.awt.*;
//https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html

/**
 * Clase: Interfaz
 * Propósito: Crear una interfaz que me permita trabajar con listas y árboles
 */
public class Interfaz extends JFrame {//Heredo la clase JFrame
    //Atributos que necesitaré posteriormente
    private boolean listaActiva = false;    //Para saber si estoy trabajando con la lista o no
    private boolean estructuraSeleccionada = false; //Para evaluar si ya seleccionó una estructura desde el menú por primera vez

    /**
     * Método constructor
     * Propósito: Crear mi JFrame con las características deseadas
     * Parámetros de entrada:
     *      - Lista lista: Lista simplemente enlazada con la que trabajaré
     *      - Arbol arbol: Arbol binario con el que trabajaré
     * Parámetros de salida:
     *      - null
     */
    public Interfaz(Lista lista, Arbol arbol){
        /**
         * -------------------------------------------------------------------------------------------------------------------------
         * Configuraciones Generales: Colores, tamaños, datos del JFrame, etc.
         * -------------------------------------------------------------------------------------------------------------------------
         */
        //Datos de la pantalla:
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Obtener la resolución de la pantalla
        Dimension screenSize = toolkit.getScreenSize();

        int anchoMonitor = screenSize.width;
        int altoMonitor = screenSize.height;

        //Datos de los botones de insertar, buscar y eliminar que serán utilizados posteriormente
        int anchoBoton = anchoMonitor/4;   //Todos los botones tendrán mismo ancho, alto y posición en 'y'
        int altoBoton = 60;
        int y_Boton = 0;   
        int x_Inicial = 0; //Coordenada en x del primer botón

        //Colores de texto que serán utilizados posteriormente
        Color coloritemsMenu = Color.BLUE;
        //Plantillas de texto que serán utilizadas posteriormente
        Font fuenteCampoTexto = new Font("Arial", Font.BOLD, 18);
        Font fuenteItemsMenu = new Font("Times New Roman", Font.BOLD, 17);
        Font fuenteGrande = new Font("Times New Roman", Font.BOLD, 30);
        //Dimensiones que serán utilizadas posteriormente:
        Dimension dimensionitemsMenu = new Dimension(70,25);
        

        //Configuración del JFrame
        setTitle("Proyecto #2");                      //Título
        setExtendedState(MAXIMIZED_BOTH);                   //Le doy las dimensiones de mi pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);            //Comportamiento de salida
        setResizable(true);                       //Permito la posibilidad de minimizar mi ventana
        setLayout(null);                            //Layout

        
        /**
         * -------------------------------------------------------------------------------------------------------------------------
         * Configuraciones de la barra del menú
         * -------------------------------------------------------------------------------------------------------------------------
         */
        
        //El espacio en el que agregaré mi menú
        JMenuBar menuBar = new JMenuBar();            

        //Creo mi barra de menú. Esta tendrá las opciones que yo deseé
        JMenu menuArchivo = new JMenu("Estructura de Datos");
            //Cambio el estilo del texto
            menuArchivo.setFont(fuenteItemsMenu);
            //Opciones disponibles del menú:
            JMenuItem listaItem = new JMenuItem("Lista");   //Opción para trabajar con listas
            JMenuItem arbolItem = new JMenuItem("Árbol");   //Opción para trabajar con árboles

            JMenuItem [] itemsMenu = {listaItem, arbolItem};
            for (int i = 0; i < itemsMenu.length; i++) {
                // Cambiar el tamaño del botón
                itemsMenu[i].setPreferredSize(dimensionitemsMenu);
                // Cambiar la fuente del texto del botón
                itemsMenu[i].setFont(fuenteItemsMenu);
                // Cambiar el color del texto del botón
                itemsMenu[i].setForeground(coloritemsMenu);
                // Agregar el botón al menu
                menuArchivo.add(itemsMenu[i]);
            }
        //Agrego el menu al espacio del menú
        menuBar.add(menuArchivo);
        //Ligo el menú bar al JFrame. Es un método de JFrame
        setJMenuBar(menuBar);   


        JMenu menuFuncionesAdicionales = new JMenu("Funciones Adicionales");
            //Cambio el estilo del texto
            menuFuncionesAdicionales.setFont(fuenteItemsMenu);
            //Opciones disponibles del menú:
            JMenuItem ordenarListaItem = new JMenuItem("Ordenar Lista");   //Opción para ordenar la lista
            // Cambiar el tamaño del botón
            ordenarListaItem.setPreferredSize(new Dimension(120,25));
            // Cambiar la fuente del texto del botón
            ordenarListaItem.setFont(fuenteItemsMenu);
            // Cambiar el color del texto del botón
            ordenarListaItem.setForeground(coloritemsMenu);
            // Agregar el botón al menu
            menuFuncionesAdicionales.add(ordenarListaItem);

        menuBar.add(menuFuncionesAdicionales);

        /**
         * -------------------------------------------------------------------------------------------------------------------------
         * Configuraciones de los botones (aplican tanto para la lista como para el árbol)
         * -------------------------------------------------------------------------------------------------------------------------
         */


        //Botones de la lista
        JButton botonInsertar = new JButton("Insertar");   
        JButton botonBuscar = new JButton("Buscar");
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonVaciar = new JButton("Vaciar");

        JButton [] botonesPanelLista = {botonInsertar, botonBuscar, botonEliminar, botonVaciar};
        for (int i = 0; i < botonesPanelLista.length; i++) {
            // Ubicar el botón del panel lista
            botonesPanelLista[i].setBounds(x_Inicial+anchoBoton*i,y_Boton,anchoBoton,altoBoton);
            // Cambiar la fuente del texto del botón del panel lista
            botonesPanelLista[i].setFont(fuenteGrande);
            // Agregar el botón al panel
            add(botonesPanelLista[i]);
        }
        
        //Agrego el cuadro para igresar datos:
        JTextField fieldIngresarDatos = new JTextField();
        //Defino sus dimensiones
        fieldIngresarDatos.setBounds(x_Inicial, altoBoton,anchoMonitor, altoBoton);
        //Alineo el texto que vendrá en su interior
        fieldIngresarDatos.setHorizontalAlignment(SwingConstants.CENTER);
        //Le doy formato al texto que vendrá en su interior
        fieldIngresarDatos.setFont(fuenteCampoTexto);
        add(fieldIngresarDatos);

        //Encabezado previo a visualizar la lista o el árbol:
        JLabel labelEstructura = new JLabel("Seleccione una estructura de datos para poder ser visualizada", JLabel.CENTER);
        //Le doy Formato a mis títulos
        labelEstructura.setFont(fuenteGrande);
        //Lo oriento
        labelEstructura.setBounds(x_Inicial, altoBoton*2, anchoMonitor, altoBoton);
        
        //Lo agrego al panel
        add(labelEstructura);


        //Espacio de texto en el que se imprimirán los resultados
        JTextPane contenidoEstructura = new JTextPane();
            //Lo oriento:
            contenidoEstructura.setBounds(x_Inicial, altoBoton*3, anchoMonitor, altoMonitor-altoBoton*3);
            //Bloqueo su edición
            contenidoEstructura.setEditable(false);
            contenidoEstructura.setText("");
            //Alineo el texto que vendrá en su interior
            
            //Defino el estilo del texto
            contenidoEstructura.setFont(fuenteCampoTexto);

        //Lo agrego al JFrame
        add(contenidoEstructura);

        /**
         * -------------------------------------------------------------------------------------------------------------------------
         * Funcionalidad de todos los botones:
         * -------------------------------------------------------------------------------------------------------------------------
         */

        /**
         * Botón: El botón de lista en el menú
         * Propósito: Seleccionar la lista para trabajar con ella
         * Funcionamiento:
         *      - Me indica que estoy trabajando con la lista
         *      - Me muestra el estado actual de la lista
         */
        listaItem.addActionListener(e -> {
            labelEstructura.setText("Estado actual de la lista:");
            contenidoEstructura.setText(lista.mostrar());
            this.listaActiva = true;
            this.estructuraSeleccionada = true;
            fieldIngresarDatos.setText(null);   //Reseteo el textField
        });
        /**
         * Botón: El botón de árbol en el menú
         * Propósito: Seleccionar el árbol para trabajar con él
         * Funcionamiento:
         *      -Me indica que estoy trabajando con el árbol
         *      -Me muestra el estado actual del árbol
         */
        arbolItem.addActionListener(e -> {
            labelEstructura.setText("Estado actual del árbol:");
            contenidoEstructura.setText(arbol.mostrar());
            this.listaActiva = false;
            this.estructuraSeleccionada = true;
            fieldIngresarDatos.setText(null);   //Reseteo el textField
        });

        /**
         * Botón: El botón de Insertar
         * Propósito: Insertar un dato en una estructura de datos
         * Funcionamiento:
         *      - Verifica si tengo alguna estructura seleccionada
         *      - Verifica si es posible hacer la conversión String -> int
         *      - Verifica con qué estructura de datos estoy trabajando
         *      - Inserta el valor si no se encuentra en mi estructura
         *      - Muestra el estado actual de la estructura
         */
        botonInsertar.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(conversionValida(fieldIngresarDatos)){
                    int num = Integer.parseInt(fieldIngresarDatos.getText());
                    boolean seEncuentra;
                    if(this.listaActiva){   //Trabajamos la lista
                        seEncuentra = lista.seEncuentra(num);
                        if(seEncuentra){
                            JOptionPane.showMessageDialog(null, "El valor '" + num + 
                            "' ya se encuentra en la lista, por lo que no fue agregado.");
                        }else{
                            lista.insertar(num);
                            contenidoEstructura.setText(lista.mostrar());
                        }
                    }else{  //Trabajamos el árbol
                        seEncuentra = arbol.buscar(num);
                        if(seEncuentra){
                            JOptionPane.showMessageDialog(null, "El valor '" + num + 
                            "' ya se encuentra en el árbol, por lo que no fue agregado.");
                        }else{
                            arbol.insertar(num);
                            contenidoEstructura.setText(arbol.mostrar());
                        }
                    }
                }
            }else{  //No seleccionamos una estructura
                JOptionPane.showMessageDialog(null, "Seleccione una estructura antes de realizar cualquier acción.");
            }
            fieldIngresarDatos.setText(null);
        });

        /**
         * Botón: El botón de Buscar
         * Propósito: Buscar un dato en una estructura de datos
         * Funcionamiento:
         *      - Verifica si tengo alguna estructura seleccionada
         *      - Verifica si es posible hacer la conversión String -> int
         *      - Verifica con qué estructura de datos estoy trabajando
         *      - Verifica si la estructura está vacía o no
         *      - Me muestra si el valor se encuentra o no en mi estructura
         */
        botonBuscar.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(conversionValida(fieldIngresarDatos)){
                    int num = Integer.parseInt(fieldIngresarDatos.getText());
                    boolean seEncuentra;
                    if(this.listaActiva){   //Trabajamos la lista
                        if(lista.esVacio()){
                            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía, no hay nada que buscar.");
                        }else{
                            seEncuentra = lista.seEncuentra(num);
                            if(seEncuentra){
                                JOptionPane.showMessageDialog(null, "El valor '" + num + "' SÍ se encuentra en la lista.");
                            }else{
                                JOptionPane.showMessageDialog(null, "El valor '" + num + "' NO se encuentra en la lista.");
                            }
                        }
                    }else{  //Trabajamos el árbol
                        if(arbol.esVacio()){
                            JOptionPane.showMessageDialog(null, "El árbol se encuentra vacío, no hay nada que buscar.");
                        }else{
                            seEncuentra = arbol.buscar(num);
                            if(seEncuentra){
                                JOptionPane.showMessageDialog(null, "El valor '" + num + "' SÍ se encuentra en la lista.");
                            }else{
                                JOptionPane.showMessageDialog(null, "El valor '" + num + "' NO se encuentra en la lista.");
                            }
                        }
                    }
                }
            }else{  //No seleccionamos una estructura
                JOptionPane.showMessageDialog(null, "Seleccione una estructura antes de realizar cualquier acción.");
            }
            fieldIngresarDatos.setText(null);
        });

        /**
         * Botón: El botón de Eliminar
         * Propósito: Eliminar un dato en una estructura de datos
         * Funcionamiento:
         *      - Verifica si tengo alguna estructura seleccionada
         *      - Verifica si es posible hacer la conversión String -> int
         *      - Verifica con qué estructura de datos estoy trabajando
         *      - Verifica si la estructura se encuentra vacía
         *      - Verifica si el valor se encuentra en mi estructura
         *      - Elimina el valor si se encuentra en mi estructura
         *      - Muestra el estado actual de la estructura
         */
        botonEliminar.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(conversionValida(fieldIngresarDatos)){
                    int num = Integer.parseInt(fieldIngresarDatos.getText());
                    boolean seEncuentra;
                    if(this.listaActiva){   //Trabajamos la lista
                        if(lista.esVacio()){
                            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía, no hay nada que eliminar.");
                        }else{
                            seEncuentra = lista.seEncuentra(num);
                            if(seEncuentra){
                                lista.eliminar(num);
                                contenidoEstructura.setText(lista.mostrar());

                            }else{
                                JOptionPane.showMessageDialog(null, "El valor '" + num + 
                                "' NO se encuentra en la lista, por lo que no puede ser eliminado.");
                            }
                        }
                    }else{  //Trabajamos el árbol
                        if(arbol.esVacio()){
                            JOptionPane.showMessageDialog(null, "El árbol se encuentra vacío, no hay nada que eliminar.");
                        }else{
                            seEncuentra = arbol.buscar(num);
                            if(seEncuentra){
                                arbol.eliminar(num);
                                contenidoEstructura.setText(arbol.mostrar());
                            }else{
                                JOptionPane.showMessageDialog(null, "El valor '" + num + 
                                "' NO se encuentra en el árbol, por lo que no puede ser eliminado.");
                            }
                        }
                    }
                }
            }else{  //No seleccionamos una estructura
                JOptionPane.showMessageDialog(null, "Seleccione una estructura antes de realizar cualquier acción.");
            }
            fieldIngresarDatos.setText(null);
        });

        /**
         * Botón: El botón de Vaciar
         * Propósito: Vaciar una estructura de datos
         * Funcionamiento:
         *      - Verifica si tengo alguna estructura seleccionada
         *      - Verifica con qué estructura de datos estoy trabajando
         *      - Verifica si la estructura se encuentra vacía
         *      - Me pide comprobación de vacío de estructura
         *      - Vacía mi estructura
         *      - Muestra el estado actual de la estructura
         */
        botonVaciar.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(this.listaActiva){
                    if(lista.esVacio()){
                        JOptionPane.showMessageDialog(null, "La Lista ya se encuentra vacía.");
                    }else{
                        int respuesta = JOptionPane.showConfirmDialog(
                            null, "¿Estás seguro de vaciar la estructura?", "Confirmación de vaciado", 
                            JOptionPane.YES_NO_OPTION);
                        // Procesar la respuesta
                        if (respuesta == JOptionPane.YES_OPTION) {
                            lista.vaciar();
                            contenidoEstructura.setText(lista.mostrar());
                        }
                    }
                }else{  //Trabajamos con el árbol
                    if(arbol.esVacio()){
                        JOptionPane.showMessageDialog(null, "El árbol ya se encuentra vacío.");
                    }else{
                        int respuesta = JOptionPane.showConfirmDialog(
                            null, "¿Estás seguro de vaciar la estructura?", "Confirmación de vaciado", 
                            JOptionPane.YES_NO_OPTION);
                        // Procesar la respuesta
                        if (respuesta == JOptionPane.YES_OPTION) {
                            arbol.vaciar();
                            contenidoEstructura.setText(arbol.mostrar());
                        }
                    }
                }
            }else{  //No seleccionamos una estructura
                JOptionPane.showMessageDialog(null, "Seleccione una estructura antes de realizar cualquier acción.");
            }
            fieldIngresarDatos.setText(null);
        });

        //Para el botón de Ordenar (la lista):
        ordenarListaItem.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(this.listaActiva){
                    if(lista.esVacio()){
                        JOptionPane.showMessageDialog(null, "La Lista se encuentra vacía.");
                    }else{
                        // lista.ordenar();
                        JOptionPane.showMessageDialog(null, "La lista ha sido ordenada.");
                    }
                }
            }else{  //No seleccionamos una estructura
                JOptionPane.showMessageDialog(null, "Seleccione la lista para poder aplicar el método.");
            }
            fieldIngresarDatos.setText(null);
        });


    }
    /**
     * Método: main
     * Propósito: Inicializar mi lista, árbol, ventana y hacerla visible para poder utilizarla
     * Parámetros de entrada:
     *      - String[] args
     * Parámetros de salida:
     *      - null
     */
    public static void main(String[] args){
        //Creo mi lista
        Lista lista = new Lista();
        //Creo mi árbol
        Arbol arbol = new Arbol();

        //Creo el objeto ventana
        Interfaz ventana = new Interfaz(lista, arbol);
        
        //Hago mi ventana visible
        ventana.setVisible(true);
    }
    /**
     * Método: conversionValida
     * Propósito: Determinar si una conversión de texto a int es válida o no
     * Parámetros de entrada:
     *      - JTextField fieldIngresarDatos: Campo de texto de donde extraeré el texto a convertir 
     * Parámetros de salida:
     *      - boolean: Representa si la conversión fue válida o no
     */
    public static boolean conversionValida(JTextField fieldIngresarDatos){
        boolean conversionValida = false;
        try{
            int numero = Integer.parseInt(fieldIngresarDatos.getText());
            conversionValida = true;
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número entero.");
        }
        return conversionValida;
    }
}