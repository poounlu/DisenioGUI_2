package vistas;
import modelo.Libro;

import javax.swing.*;
import java.awt.*;

public class AltaLibroPanel extends JPanel {
    private JTextField tituloField;
    private JTextField autorField;
    private JTextField disponiblesField;

    private JButton crearButton;
    private Libro libroCreado;
    private JButton cancelarButton;

    private LibreriaGUI base = LibreriaGUI.getLibreria(null);

    public AltaLibroPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Etiquetas y campos
        add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        tituloField = new JTextField();
        tituloField.setPreferredSize(new Dimension(300, 25));
        add(tituloField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        add(new JLabel("Autor:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        autorField = new JTextField();
        autorField.setPreferredSize(new Dimension(300, 25));
        add(autorField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        add(new JLabel("Ejemplares:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        disponiblesField = new JTextField();
        disponiblesField.setPreferredSize(new Dimension(300, 25));
        add(disponiblesField, gbc);

        // Botones
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        crearButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");
        botonesPanel.add(crearButton);
        botonesPanel.add(cancelarButton);
        add(botonesPanel, gbc);


        // Acción del botón
        crearButton.addActionListener(e -> {
            try {
                String titulo = tituloField.getText().trim();
                String autor = autorField.getText().trim();
                int disponibles = Integer.parseInt(disponiblesField.getText().trim());

                libroCreado = new Libro(titulo, autor, disponibles);
                base.addBook(libroCreado);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, ingresá número válido en 'ejemplares'.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelarButton.addActionListener(e -> {
            base.cancelar();
        });

    }
    public JPanel getPanelPrincipal() {
        return this;
    }
    public Libro getLibroCreado() {
        return libroCreado;
    }
}

