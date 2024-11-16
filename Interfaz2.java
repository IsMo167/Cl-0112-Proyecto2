import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
//https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html

public class Interfaz2 extends JFrame {//Heredo la clase JFrame
    //Método constructor
    public Interfaz2(Lista lista){

        //Configuración del JFrame
        setTitle("Proyecto #2");                    //Título
        setSize(1000, 800);                  //Dimensiones(ancho y alto)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Comportamiento de salida
        setLocationRelativeTo(null);                    //Centro la ventana en la pantalla

        //Configuración del menú
        JMenuBar menuBar = new JMenuBar();            //El espacio en el que agregaré las opciones del menú
            //Opciones disponibles del menú:
            JMenu menuLista = new JMenu("Lista");   //Opción para trabajar con listas
            JMenu menuArbol = new JMenu("Árbol");   //Opción para trabajar con árboles


        //Ligo las opciones del menú, al menú
        menuBar.add(menuLista);
        menuBar.add(menuArbol);

        //Ligo el menú bar al JFrame. Es un método de JFrame
        setJMenuBar(menuBar);   


        
        //Creo un segundo panel para poder trabajar con la lista
        JPanel panelLista = new JPanel();

        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));  //Cómo se organizará la distribución de los elementos

        //Defino mis elementos del panel:
        JButton botonInsertar = new JButton("Insertar");   
        JTextField campoInsertar = new JTextField();

        JButton botonBuscar = new JButton("Buscar");
        JTextField campoBuscar = new JTextField();

        JButton botonEliminar = new JButton("Eliminar");
        JTextField campoEliminar = new JTextField();

        JLabel etiquetaMostrar = new JLabel("Estado actual de la lista:");
        JTextPane panelMostrar = new JTextPane();
            //Configuraciones del JTextPane 'panelMostrar'
            panelMostrar.setEditable(false);
            panelMostrar.setText("La lista se encuentra vacía.");

        JButton[] botones = {botonInsertar, botonBuscar, botonEliminar};
        Color[] coloresFondo = {Color.GREEN, Color.BLUE, Color.RED}; // Colores de fondo
        Color[] coloresTexto = {Color.BLACK, Color.WHITE, Color.WHITE}; // Colores de texto
        
        for (int i = 0; i < botones.length; i++) {
            // Cambiar el tamaño del botón
            botones[i].setPreferredSize(new Dimension(100, 50));
            // Cambiar la fuente del texto
            botones[i].setFont(new Font("Times New Roman", Font.BOLD, 18));
            // Cambiar el color de fondo y el color del texto
            botones[i].setBackground(coloresFondo[i]);
            botones[i].setForeground(coloresTexto[i]);
            // Agregar el botón al panel
            panelLista.add(botones[i]);
        }

        //Ligo los botones y los espacios a 'panelLista'
        panelLista.add(botonInsertar);
        panelLista.add(campoInsertar);
        panelLista.add(botonBuscar);
        panelLista.add(campoBuscar);
        panelLista.add(botonEliminar);
        panelLista.add(campoEliminar);
        panelLista.add(etiquetaMostrar);
        panelLista.add(panelMostrar);

        //Ligo 'panelLista' al panel principal
        add(panelLista);

        //Añado funcionalidad a los botones:

        //Para el botón de Insertar:
        botonInsertar.addActionListener(e -> {
            String valor = campoInsertar.getText();
            if(valor.isEmpty()){    //Caso de valor ingresado vacío
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor para ser insertado.");
            }
            else{   //Caso de valor ingresado no vacío
                lista.insertar(campoInsertar.getText());    //Inserto el valor en la lista
                JOptionPane.showMessageDialog(null, "Valor insertado exitosamente.");   //Mensaje de confirmación
                campoInsertar.setText(null);                        //Reseteo el textField
                String textList = lista.mostrar(false);    //Defino el estado actual de mi lista (note que luego de insertar cualquier valor, la lista nunca estará vacía)
                panelMostrar.setText(textList);                       //Actualizo el estado de la lista en el JTextPane 'panelMostrar'
            }
        });
        
        //Para el botón de Buscar:
        botonBuscar.addActionListener(e -> {
            boolean listaVacia = lista.vacia();
            if(listaVacia){     //Caso de lista vacía
                JOptionPane.showMessageDialog(null, "Error al buscar: La lista se encuentra vacía.");
            }
            else{   //Caso de lista no vacia
                String valorABuscar = campoBuscar.getText();
                if(valorABuscar.isEmpty()){     //Caso de valor ingresado vacío
                    JOptionPane.showMessageDialog(null, "Ingrese un valor para ser buscado.");
                }
                else{   //Caso de valor ingresado no vacío
                    boolean valorEncontrado = lista.buscar(campoBuscar.getText());
                    if(valorEncontrado){    //Caso de valor ingresado en la lista
                        JOptionPane.showMessageDialog(null, "El valor '" + campoBuscar.getText() +  "', SÍ se encuentra en la lista.");
                    }
                    else{   //Caso de valor ingresado NO en la lista
                        JOptionPane.showMessageDialog(null, "El valor '" + campoBuscar.getText() +  "', NO se encuentra en la lista.");
                    }
                }
            }
            campoBuscar.setText(null);                           //Reseteo el textField
            String textList = lista.mostrar(false);     //Defino el estado actual de mi lista
            panelMostrar.setText(textList);                        //Actualizo el estado de la lista en el JTextPane 'panelMostrar'
        });

        botonEliminar.addActionListener(e -> {
            boolean listaVacia = lista.vacia();
            if(listaVacia){
                JOptionPane.showMessageDialog(null, "Error al eliminar: La lista se encuentra vacía.");
            }
            else{
                String valorAEliminar = campoEliminar.getText();
                if(valorAEliminar.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor para ser eliminado.");
                }
                else{
                    boolean valorEncontrado = lista.buscar(valorAEliminar);
                    if(valorEncontrado){
                        lista.eliminar(valorAEliminar);
                        JOptionPane.showMessageDialog(null, "El valor '" + valorAEliminar +  "', ha sido eliminado exitosamente.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar: El valor '" + valorAEliminar +  "', NO se encuentra en la lista.");
                    }
                }
            }
            campoEliminar.setText(null);                        //Reseteo el textField
            listaVacia = lista.vacia();                           //Vuelvo a hacer la comprobación
            String textList = lista.mostrar(listaVacia);          //Defino el estado actual de mi lista
            panelMostrar.setText(textList);                       //Actualizo el estado de la lista en el JTextPane 'panelMostrar'
        });
    }

    public static void main(String[] args){
        //Creo mi lista vacía:
        Lista lista = new Lista();

        //Creo el objeto ventana
        Interfaz2 ventana = new Interfaz2(lista);
        
        //Hago mi ventana visible
        ventana.setVisible(true);
    }
}