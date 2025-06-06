import modelo.Libreria;
import modelo.Libro;
import vistas.LibreriaGUI;
import vistas.MainView;

import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Libreria modelo = new Libreria();
        Libro libro1 = new Libro("El Gran Gatsby", "F. Scott Fitzgerald", 10);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 15);
        Libro libro3 = new Libro("1984", "George Orwell", 8);
        Libro libro4 = new Libro("To Kill a Mockingbird", "Harper Lee", 12);
        Libro libro5 = new Libro("Matar un ruiseñor", "Harper Lee", 9);
        Libro libro6 = new Libro("Dune", "Frank Herbert", 8);
        Libro libro7 = new Libro("Fundación", "Isaac Asimov", 10);
        Libro libro8 = new Libro("Neuromante", "William Gibson", 6);
        Libro libro9 = new Libro("Segunda Fundación", "Isaac Asimov", 7);
        Libro libro10 = new Libro("¿Sueñan los androides con ovejas eléctricas?", "Philip K. Dick", 9);

        modelo.agregarLibro(libro1);
        modelo.agregarLibro(libro2);
        modelo.agregarLibro(libro3);
        modelo.agregarLibro(libro4);
        modelo.agregarLibro(libro5);
        modelo.agregarLibro(libro6);
        modelo.agregarLibro(libro7);
        modelo.agregarLibro(libro8);
        modelo.agregarLibro(libro9);
        modelo.agregarLibro(libro10);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LibreriaGUI v = LibreriaGUI.getLibreria(modelo);
                //v.setVisible(true);
                //MainView mv = new MainView(modelo);
            }
        });

    }
}