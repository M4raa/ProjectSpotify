package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.service.Globals;
import jpaswing.projectspotiy.utilities.SearchMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class SearchPanel extends JPanel {

    private JButton trackSearchButton;
    private JTextField trackSearchField;
    private SearchMethods searchMethods;
    private DisplayPanel displayPanel;
    private JButton backButton;
    private JButton forwardButton;
    private Stack<String> viewStack;
    private Stack<String> forwardStack;
    private Globals globals;

    public SearchPanel(DisplayPanel displayPanel) {
        viewStack = new Stack<>();
        forwardStack = new Stack<>();
        this.displayPanel = displayPanel;
        this.searchMethods = new SearchMethods();
        this.globals = new Globals();
        setLayout(new GridBagLayout());
        setBackground(new Color(248, 203, 166));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inicialización y configuración de los botones de navegación
        //Back button
        backButton = createNavigationButton();
        ImageIcon backIcon = new ImageIcon("src/main/resources/icons/left-arrow.png");
        Image backIconImage = backIcon.getImage();
        Image backImage = backIconImage.getScaledInstance(25,25,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon backEscalatedImage = new ImageIcon(backImage);
        backButton.setIcon(backEscalatedImage);

        //Back Button Listener
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.lastPanel();
            }
        });
        add(backButton);

        //Forward button
        forwardButton = createNavigationButton();
        ImageIcon forwardIcon = new ImageIcon("src/main/resources/icons/right-arrow.png");
        Image forwardIconImage = forwardIcon.getImage();
        Image forwardImage = forwardIconImage.getScaledInstance(25,25,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon forwardEscalatedImage = new ImageIcon(forwardImage);
        forwardButton.setIcon(forwardEscalatedImage);

        //Forward Button Listener
        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.nextPanel();
            }
        });
        add(forwardButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 0, 5); // Espacio entre los componentes
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Configuración de cada conjunto de campo de búsqueda y botón
        trackSearchField = createSearchField("");
        trackSearchButton = createSearchButton("Search");

        // Añadir los componentes al panel
        add(createSearchPanel(trackSearchField, trackSearchButton), gbc);

        trackSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        //Enter KeyListener
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
        field.setBackground(new Color(255, 251, 235)); // Color de fondo pastel claro
        field.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Borde gris
        field.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente Arial, tamaño 14
        field.setPreferredSize(new Dimension(150, 30)); // Tamaño preferido
        return field;
    }

    private JButton createSearchButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(255, 231, 204)); // Color de fondo pastel claro
        button.setFocusPainted(false); // Elimina el borde al ganar el foco
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
    private JButton createNavigationButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(30, 30));
        button.setBackground(new Color(255,true));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    private void performSearch() {
        String searchText = trackSearchField.getText();
        try {
            List<Object> results = searchMethods.grandSearch(searchText);
            displayPanel.displayResults(results);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
