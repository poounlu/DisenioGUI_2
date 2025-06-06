package vistas;

import modelo.Libreria;
import modelo.Libro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainView extends JFrame {
    private Libreria miLib;
    private Libro libroSeleccionado;
    private JLabel mensajeLabel;

    private Coleccion anaquel;
    private JPanel contenedorCentral = new JPanel();

    public MainView(Libreria modelo){
        miLib = modelo;
        setTitle("Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel westPanel = new JPanel(new FlowLayout());
        JPanel botonesPanel = new JPanel(new GridLayout(3, 1, 5, 5));

        JButton btnAgregar = new JButton("Agregar Libro");
        JButton btnPrestar = new JButton("Prestar Libro");
        JButton btnDevolver = new JButton("Devolver Libro");

        btnAgregar.addActionListener(e -> {
            // Codigo para agregar
            mostrarAlta();
        });
        btnPrestar.addActionListener(e -> {
            // codigo para prestar
        });
        btnDevolver.addActionListener(e -> {
            // codigo para devolver
        });

        botonesPanel.add(btnAgregar);
        botonesPanel.add(btnPrestar);
        botonesPanel.add(btnDevolver);
        westPanel.add(botonesPanel);

        add(westPanel, BorderLayout.WEST);
        // Sur
        mensajeLabel = new JLabel("");

        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(mensajeLabel);
        add(southPanel, BorderLayout.SOUTH);


        add(contenedorCentral, BorderLayout.CENTER);
        mostrarAnaquel();

        setSize(600, 400);
        setVisible(true);
        mostrarMensaje("Hola amigos!!!",false);
    }
/*
    private  void mostrarAnaquel(){
        centerPanel.removeAll();
        anaquel = new Coleccion(miLib);
        centerPanel.add(anaquel.getPanelPrincipal());
        centerPanel.revalidate();                 // 3. Recalcular el layout
        centerPanel.repaint();                   // 4. Volver a pintar
    }
  */

    private  void mostrarAnaquel(){

      Libreria libreria = miLib;

      // Columnas correctas según la clase Libro
      String[] columnas = {"ID", "Título", "Autor", "Disponibles", "Prestados"};
      DefaultTableModel model = new DefaultTableModel(columnas, 0);

      if (libreria != null) {
          java.util.List<Libro> libros = libreria.obtenerTodosLosLibros();
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

      JTable tablaLibros = new JTable(model);
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

      JScrollPane scroll = new JScrollPane(tablaLibros);
      this.add(scroll,BorderLayout.CENTER);
      //contenedorCentral.add(scroll);

  }


    private void mostrarAlta() {
        //anaquel = null;
        contenedorCentral.removeAll();
        //AltaLibroPanel alta = new AltaLibroPanel();
        LibroFormPanel alta = new LibroFormPanel();
        contenedorCentral.add(alta);
        contenedorCentral.revalidate();                 // 3. Recalcular el layout
        contenedorCentral.repaint();                   // 4. Volver a pintar
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
