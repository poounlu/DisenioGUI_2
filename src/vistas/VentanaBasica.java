package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaBasica {
    private JFrame ventana;

    public VentanaBasica() {
        crearVentana();
    }

    private void crearVentana(){
        ventana = new JFrame("Mi ventana");

        JPanel contenedor = (JPanel) ventana.getContentPane();
        ventana.setSize(600,600);
        contenedor.setBorder(new EmptyBorder(6,6,6,6));
        JLabel etiqueta = new JLabel("Hola mundo");
        contenedor.add(etiqueta);
        ventana.pack();
        ventana.setVisible(true);
    }
}
