package vistas;

import modelo.Libreria;
import modelo.Libro;

import javax.swing.*;
import java.awt.*;

public class LibreriaGUI extends JFrame{
    private JPanel contentPane;
    private JButton agregarLibroButton;
    private JButton prestarLibroButton;
    private JButton devolverLibroButton;
    private JPanel centerPanel;
    private JPanel westPanel;
    private JPanel southPanel;
    private JPanel northPanel;
    private JLabel mensajeLabel;

    private static Libreria libreria;
    private static LibreriaGUI instance;
    private Coleccion anaquel;
    // Sigleton
    public static LibreriaGUI getLibreria(Libreria lib){
        if(instance == null && lib != null) {
            libreria = lib;
            instance = new LibreriaGUI(libreria);
        }
        return instance;
    }

    private LibreriaGUI(Libreria libreria){
        setSize(new Dimension(600,800));
        setTitle("Librería Universitaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        mensajeLabel.setText(" ");
        centerPanel.setLayout(new FlowLayout());
        agregarLibroButton.addActionListener(e -> {
            showAddPanel();
        });
        prestarLibroButton.addActionListener(e -> {
            prestarLibro();
        });
        devolverLibroButton.addActionListener(e -> {
            devolverLibro();
        });

        showBooks();
        setVisible(true);
        pack();
    }
    private void showBooks(){
        centerPanel.removeAll();
        anaquel = new Coleccion(libreria);
        centerPanel.add(anaquel.getPanelPrincipal());
        centerPanel.revalidate();                 // 3. Recalcular el layout
        centerPanel.repaint();                   // 4. Volver a pintar
    }
    private void showAddPanel(){
        anaquel = null;
        centerPanel.removeAll();
        AltaLibroPanel alta = new AltaLibroPanel();
        centerPanel.add(alta.getPanelPrincipal());
        centerPanel.revalidate();                 // 3. Recalcular el layout
        centerPanel.repaint();                   // 4. Volver a pintar
    }

    public void addBook(Libro libro){
        libreria.agregarLibro(libro);

        mostrarMensaje("Libro Creado:" + libro.getTitulo(),false);
        showBooks();
    }
    public void cancelar() {
        showBooks();
    }

    public void prestarLibro() {
        if (anaquel != null) {
            Libro libro = anaquel.getLibroSeleccionado();
            if (libro != null) {
                libro.prestar();
                mostrarMensaje("Libro Prestado : " + libro.getTitulo(),false);
                showBooks();
            } else {
                mostrarMensaje("No hay libro seleccionado",true);
            }
        }
    }

    public void devolverLibro() {
        if (anaquel != null) {
            Libro libro = anaquel.getLibroSeleccionado();
            if (libro != null) {
                libro.devolver();
                mostrarMensaje("Libro Devuelto : " + libro.getTitulo(), false);
                showBooks();
            } else {
                mostrarMensaje("No hay libro seleccionado", true);
            }
        }
    }

    public void mostrarMensaje(String mensaje, boolean error) {
        mensajeLabel.setText(mensaje);
        mensajeLabel.setForeground(error ? Color.RED : Color.BLUE);

        // Timer para borrar el mensaje luego de 3 segundos
        Timer timer = new Timer(3000, e -> mensajeLabel.setText(" "));
        timer.setRepeats(false);
        timer.start();
    }

}
