package jpaswing.projectspotiy.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    private HintTextField trackSearchField, albumSearchField, artistSearchField, playlistSearchField;
    private JButton trackSearchButton, albumSearchButton, artistSearchButton, playlistSearchButton;

    public SearchPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(60, 63, 65)); // Color de fondo gris oscuro
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes alrededor del panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0); // Espacio entre los componentes
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Configuración de cada conjunto de campo de búsqueda y botón
        trackSearchField = new HintTextField("Tracks");
        trackSearchButton = createSearchButton("Enter");
        albumSearchField = new HintTextField("Albums");
        albumSearchButton = createSearchButton("Enter");
        artistSearchField = new HintTextField("Artists");
        artistSearchButton = createSearchButton("Enter");
        playlistSearchField = new HintTextField("Playlists");
        playlistSearchButton = createSearchButton("Enter");

        // Añadir los componentes al panel
        add(createSearchPanel(trackSearchField, trackSearchButton), gbc);
        add(createSearchPanel(albumSearchField, albumSearchButton), gbc);
        add(createSearchPanel(artistSearchField, artistSearchButton), gbc);
        add(createSearchPanel(playlistSearchField, playlistSearchButton), gbc);
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

    public void addActionListeners() {
        trackSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(trackSearchField.getText(), "Tracks");
            }
        });
        albumSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(albumSearchField.getText(), "Albums");
            }
        });
        artistSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(artistSearchField.getText(), "Artists");
            }
        });
        playlistSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(playlistSearchField.getText(), "Playlists");
            }
        });
    }

    private void search(String searchText, String category) {
        // Aquí puedes implementar la lógica de búsqueda para diferentes categorías
        System.out.println("Buscar " + category + ": " + searchText);
    }
}

