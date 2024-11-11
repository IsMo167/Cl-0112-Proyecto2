import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {
    public Interfaz() {
        // Configuración del JFrame
        setTitle("Proyecto #2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear un JPanel con un Layout de cuadrícula (2 columnas)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));  // 0 filas, 2 columnas, 10px de separación

        // Crear los botones
        JButton botonCrear = new JButton("Crear");
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonInsertar = new JButton("Insertar");
        JButton botonBuscar = new JButton("Buscar");
        JButton botonMostrar = new JButton("Mostrar");

        // Personalizar los botones (tamaño, fuente, color de fondo y color de texto)
        JButton[] botones = {botonCrear, botonEliminar, botonInsertar, botonBuscar, botonMostrar};
        Color[] coloresFondo = {Color.GREEN, Color.RED, Color.BLUE, Color.BLUE, Color.BLUE}; // Colores de fondo
        Color[] coloresTexto = {Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE}; // Colores de texto

        for (int i = 0; i < botones.length; i++) {
            // Cambiar el tamaño del botón
            botones[i].setPreferredSize(new Dimension(200, 100));
            // Cambiar la fuente del texto
            botones[i].setFont(new Font("Times New Roman", Font.BOLD, 48));
            // Cambiar el color de fondo y el color del texto
            botones[i].setBackground(coloresFondo[i]);
            botones[i].setForeground(coloresTexto[i]);
            // Agregar el botón al panel
            panel.add(botones[i]);
        }

        // Agregar el panel al frame
        add(panel);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        Interfaz ventana = new Interfaz();
        ventana.setVisible(true);
    }
}
