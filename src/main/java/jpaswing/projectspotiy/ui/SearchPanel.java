package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.utilities.SearchMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchPanel extends JPanel {

    private JButton trackSearchButton;
    private JTextField trackSearchField;
    private SearchMethods searchMethods;
    private DisplayPanel2 displayPanel2;
    private JButton backButton;
    private JButton forwardButton;

    public SearchPanel(DisplayPanel2 displayPanel2) {
        this.displayPanel2 = displayPanel2;
        this.searchMethods = new SearchMethods();
        setLayout(new GridBagLayout());
        setBackground(new Color(60, 63, 65)); // Color de fondo gris oscuro
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes alrededor del panel

        // Inicialización y configuración de los botones de navegación
        backButton = createNavigationButton("◀");
        backButton.setEnabled(false); // Desactivar el botón de retroceso inicialmente
        forwardButton = createNavigationButton("▶");
        forwardButton.setEnabled(false); // Desactivar el botón de avance inicialmente
        // Añadir los botones de navegación al panel de búsqueda con un espacio entre ellos
        add(backButton);
        add(Box.createRigidArea(new Dimension(10, 0))); // Espacio horizontal entre los botones
        add(forwardButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0); // Espacio entre los componentes
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Configuración de cada conjunto de campo de búsqueda y botón
        trackSearchField = createSearchField("");
        trackSearchButton = createSearchButton("Enter");

        // Añadir los componentes al panel
        add(createSearchPanel(trackSearchField, trackSearchButton), gbc);

        trackSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        // Agregar KeyListener al campo de búsqueda
        trackSearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performSearch();
                }
            }
        });
    }

    private JTextField createSearchField(String hint) {
        JTextField field = new JTextField(hint);
        field.setBackground(new Color(220, 220, 220)); // Color de fondo pastel claro
        field.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Borde gris
        field.setForeground(Color.BLACK); // Color del texto negro
        field.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente Arial, tamaño 14
        field.setPreferredSize(new Dimension(150, 30)); // Tamaño preferido
        return field;
    }

    private JButton createSearchButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(220, 220, 220)); // Color de fondo pastel claro
        button.setForeground(Color.BLACK); // Color del texto negro
        button.setFocusPainted(false); // Elimina el borde al ganar el foco
        button.setBorderPainted(false); // Elimina el borde
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente Arial, tamaño 14
        button.setPreferredSize(new Dimension(75, 30)); // Tamaño preferido
        return button;
    }

    private JPanel createSearchPanel(JTextField searchField, JButton searchButton) {
        JPanel panel = new JPanel(new BorderLayout(5, 5)); // BorderLayout con espacio de 5px entre componentes
        panel.add(searchField, BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.EAST);
        return panel;
    }
    // Método para crear botones de navegación
    private JButton createNavigationButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(220, 220, 220)); // Color de fondo pastel claro
        button.setForeground(Color.BLACK); // Color del texto negro
        button.setFocusPainted(false); // Elimina el borde al ganar el foco
        button.setBorderPainted(false); // Elimina el borde
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente Arial, tamaño 14
        button.setPreferredSize(new Dimension(40, 30)); // Tamaño preferido
        return button;
    }

    private void performSearch() {
        String searchText = trackSearchField.getText();
        try {
            List<Object> results = searchMethods.grandSearch(searchText);
            displayPanel2.displayResults(results);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
