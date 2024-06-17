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
import java.net.MalformedURLException;
import java.util.List;

public class SearchPanel extends JPanel {

    private JButton trackSearchButton;
    private JTextField trackSearchField;
    private SearchMethods searchMethods;
    private DisplayPanel displayPanel;
    private JButton backButton;
    private JButton forwardButton;
    private JPanel  navPanel;
    private JLabel loadingLabel;

    public SearchPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
        this.searchMethods = new SearchMethods();
        this.navPanel = new JPanel();
        setLayout(new GridBagLayout());
        setBackground(new Color(163,196,243));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inicialización y configuración de los botones de navegación
        backButton = createNavigationButton("src/main/resources/icons/left-arrow.png");
        forwardButton = createNavigationButton("src/main/resources/icons/right-arrow.png");

        // Panel para contener los botones de navegación
        navPanel.setBackground(new Color(163, 196, 243)); // Fondo igual al del panel principal
        navPanel.add(backButton);
        navPanel.add(forwardButton);

        // Configuración del GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 0, 5); // Espacio entre los componentes
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Añadir el panel de navegación en la primera celda
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(navPanel, gbc);

        // Configuración del campo de búsqueda y el botón de búsqueda
        trackSearchField = createSearchField("");
        trackSearchButton = createSearchButton("Search");
        trackSearchButton.setPreferredSize(new Dimension(80, 30)); // Ajusta el tamaño del botón
        trackSearchButton.setHorizontalTextPosition(SwingConstants.LEFT);

        // Panel para contener el campo de búsqueda y el botón
        JPanel searchPanel = createSearchPanel(trackSearchField, trackSearchButton);

        // Añadir el panel de búsqueda en la segunda celda de la misma fila
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(searchPanel, gbc);

        //Gif
        loadingLabel = new JLabel(new ImageIcon("src/main/resources/icons/load.gif"));
        loadingLabel.setVisible(false); // Inicialmente oculto
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 0, 0, 0); // Añadir espacio superior para separación
        add(loadingLabel, gbc);

        trackSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    performSearch();
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Enter KeyListener
        trackSearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        displayPanel.clearPanel();
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        performSearch();
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    private JTextField createSearchField(String hint) {
        JTextField field = new JTextField(hint);
        field.setBackground(new Color(163,196,243)); // Color de fondo pastel claro
        field.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Borde gris
        field.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente Arial, tamaño 14
        field.setPreferredSize(new Dimension(150, 30)); // Tamaño preferido
        return field;
    }

    private JButton createSearchButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(163,196,243)); // Color de fondo pastel claro
        button.setFocusPainted(false); // Elimina el borde al ganar el foco
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente Arial, tamaño 14
        button.setPreferredSize(new Dimension(80, 30)); // Tamaño preferido
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        return button;
    }

    private JPanel createSearchPanel(JTextField searchField, JButton searchButton) {
        JPanel panel = new JPanel(new BorderLayout(5, 5)); // BorderLayout con espacio de 5px entre componentes
        panel.add(searchField, BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.EAST);
        return panel;
    }

    private JButton createNavigationButton(String iconPath) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(30, 30));
        button.setBackground(new Color(0, true)); // Ajusta el fondo transparente según sea necesario

        ImageIcon icon = new ImageIcon(iconPath);
        Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(image));
        button.setRolloverIcon(new ImageIcon(image)); // Asegura que el rollover use la misma imagen

        button.setFocusPainted(false); // Evita que se muestre el borde al enfocarse
        button.setContentAreaFilled(false); // Evita que se pinte el fondo

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button == backButton) {
                    displayPanel.lastPanel();
                } else if (button == forwardButton) {
                    displayPanel.nextPanel();
                }
            }
        });

        return button;
    }

    private void performSearch() throws MalformedURLException {
        String searchText = trackSearchField.getText();
        if (searchText.isEmpty()) {
            displayPanel.clearPanel();
        }
        // Mostrar el GIF de carga
        loadingLabel.setVisible(true);

        SwingWorker<List<Object>, Void> worker = new SwingWorker<List<Object>, Void>() {
            @Override
            protected List<Object> doInBackground() throws Exception {
                return searchMethods.grandSearch(searchText);
            }

            @Override
            protected void done() {
                try {
                    List<Object> results = get();
                    displayPanel.displayResults(results);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // Ocultar el GIF de carga
                    loadingLabel.setVisible(false);
                }
            }
        };

        worker.execute();
    }
}
