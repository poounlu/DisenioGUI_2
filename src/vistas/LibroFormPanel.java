package vistas;

import javax.swing.*;
import java.awt.*;

public class LibroFormPanel extends JPanel {
    public JTextField tituloField;
    public JTextField autorField;
    public JTextField cantidadField;
    public JButton crearButton;
    public JButton cancelarButton;

    public LibroFormPanel() {
        setLayout(new BorderLayout());

        // Panel de campos con GridLayout
        JPanel camposPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        camposPanel.add(new JLabel("Título:"));
        tituloField = new JTextField();
        camposPanel.add(tituloField);

        camposPanel.add(new JLabel("Autor:"));
        autorField = new JTextField();
        camposPanel.add(autorField);

        camposPanel.add(new JLabel("Cantidad Disponible:"));
        cantidadField = new JTextField();
        camposPanel.add(cantidadField);

        // Panel de botones con FlowLayout
        JPanel botonesPanel = new JPanel(new FlowLayout());
        crearButton = new JButton("Crear");
        cancelarButton = new JButton("Cancelar");
        botonesPanel.add(crearButton);
        botonesPanel.add(cancelarButton);

        // Agregar los paneles al principal
        add(camposPanel, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);
    }
}

