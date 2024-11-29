import javax.swing.*;
import java.awt.*;

public class JTextPaneCircleExample {
    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Ejemplo: Número rodeado por un círculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Crear un JTextPane
        JTextPane textPane = new JTextPane();
        textPane.setText("42"); // Número a mostrar
        textPane.setEditable(false); // Deshabilitar edición
        textPane.setFont(new Font("Arial", Font.BOLD, 24)); // Ajustar la fuente
        textPane.setOpaque(false); // Hacer transparente el fondo

        // Crear un JPanel personalizado para dibujar el círculo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Dibujar el círculo
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.RED);

                // Calcular posición y tamaño del círculo
                int x = getWidth() / 2 - 50;
                int y = getHeight() / 2 - 50;
                int diameter = 100;
                g2d.drawOval(x, y, diameter, diameter);
            }
        };

        // Usar un layout para centrar el JTextPane en el panel
        panel.setLayout(new GridBagLayout());
        panel.add(textPane); // Agregar el JTextPane al panel

        // Agregar el panel al JFrame
        frame.add(panel, BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
