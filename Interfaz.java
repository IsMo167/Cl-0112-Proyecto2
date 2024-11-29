import javax.swing.*;
import java.awt.*;
//https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html


public class Interfaz extends JFrame {//Heredo la clase JFrame
    private boolean listaActiva = false;
    private boolean estructuraSeleccionada = false; //Para evaluar si ya seleccionó una estructura desde el menú
    //Método constructor
    public Interfaz(Lista lista, ArbolFinal arbol){
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
        setLayout(null);                      //Layout

        
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
        //Botones del JMenu
        listaItem.addActionListener(e -> {
            labelEstructura.setText("Estado actual de la lista:");
            contenidoEstructura.setText(lista.mostrar());
            this.listaActiva = true;
            this.estructuraSeleccionada = true;
            fieldIngresarDatos.setText(null);   //Reseteo el textField
        });
        arbolItem.addActionListener(e -> {
            labelEstructura.setText("Estado actual del árbol:");
            contenidoEstructura.setText(arbol.mostrar());
            this.listaActiva = false;
            this.estructuraSeleccionada = true;
            fieldIngresarDatos.setText(null);   //Reseteo el textField
        });

        // Botones de Insertar, Buscar y Eliminar

        //Para el botón de Insertar:
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

        //Para el botón de Buscar:
        botonBuscar.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(conversionValida(fieldIngresarDatos)){
                    int num = Integer.parseInt(fieldIngresarDatos.getText());
                    boolean seEncuentra;
                    if(this.listaActiva){   //Trabajamos la lista
                        seEncuentra = lista.seEncuentra(num);
                        if(seEncuentra){
                            JOptionPane.showMessageDialog(null, "El valor '" + num + "' SÍ se encuentra en la lista.");
                        }else{
                            JOptionPane.showMessageDialog(null, "El valor '" + num + "' NO se encuentra en la lista.");
                        }
                    }else{  //Trabajamos el árbol
                        seEncuentra = arbol.buscar(num);
                        if(seEncuentra){
                            JOptionPane.showMessageDialog(null, "El valor '" + num + "' SÍ se encuentra en el árbol.");
                        }else{
                            JOptionPane.showMessageDialog(null, "El valor '" + num + "' NO se encuentra en el árbol.");
                        }
                    }
                }
            }else{  //No seleccionamos una estructura
                JOptionPane.showMessageDialog(null, "Seleccione una estructura antes de realizar cualquier acción.");
            }
            fieldIngresarDatos.setText(null);
        });

        //Para el botón de Eliminar:
        botonEliminar.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(conversionValida(fieldIngresarDatos)){
                    int num = Integer.parseInt(fieldIngresarDatos.getText());
                    boolean seEncuentra;
                    if(this.listaActiva){   //Trabajamos la lista
                        seEncuentra = lista.seEncuentra(num);
                        if(seEncuentra){
                            lista.eliminar(num);
                            contenidoEstructura.setText(lista.mostrar());

                        }else{
                            JOptionPane.showMessageDialog(null, "El valor '" + num + 
                            "' NO se encuentra en la lista, por lo que no puede ser eliminado.");
                        }
                    }else{  //Trabajamos el árbol
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
            }else{  //No seleccionamos una estructura
                JOptionPane.showMessageDialog(null, "Seleccione una estructura antes de realizar cualquier acción.");
            }
            fieldIngresarDatos.setText(null);
        });

        //Para el botón de Vaciar:
        botonVaciar.addActionListener(e -> {
            if(this.estructuraSeleccionada){    //Comprueba que seleccionamos una estructura
                if(this.listaActiva){
                    if(lista.vacia()){
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
                    if(lista.vacia()){
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

    public static void main(String[] args){
        //Creo mi lista
        Lista lista = new Lista();
        //Creo mi árbol
        ArbolFinal arbol = new ArbolFinal();

        //Creo el objeto ventana
        Interfaz ventana = new Interfaz(lista, arbol);
        
        //Hago mi ventana visible
        ventana.setVisible(true);
    }
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