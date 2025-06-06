package vistas;

import modelo.Libreria;
import modelo.Libro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Coleccion extends JPanel{

    private JTable tablaLibros;
    private JScrollPane scrollPaneLibros = new JScrollPane(); // Componente del diseñador
    private Libreria libreria;

    private Libro libroSeleccionado;

    public Coleccion(Libreria libreria) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.libreria = libreria;

        // Columnas correctas según la clase Libro
        String[] columnas = {"ID", "Título", "Autor", "Disponibles", "Prestados"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        if (libreria != null) {
            List<Libro> libros = libreria.obtenerTodosLosLibros();
            for (Libro libro : libros) {
                Object[] fila = {
                        libro.getId(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getEjemplaresDisponibles(),
                        libro.getEjemplaresPrestados()
                };
                model.addRow(fila);
            }
        }

        tablaLibros = new JTable(model);
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        // Manejar selección de fila
        tablaLibros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && tablaLibros.getSelectedRow() != -1 && libreria != null) {
                    int filaSeleccionada = tablaLibros.getSelectedRow();
                    libroSeleccionado = libreria.obtenerTodosLosLibros().get(filaSeleccionada);
                }
            }
        });

        scrollPaneLibros = new JScrollPane(tablaLibros);
        this.add(scrollPaneLibros);

    }



    public JPanel getPanelPrincipal() {
        return this;
    }

    public Libro getLibroSeleccionado(){
        return libroSeleccionado;
    }

}

