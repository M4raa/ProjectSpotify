package jpaswing.projectspotiy.ui;


import jpaswing.projectspotiy.service.Globals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class MusicPlayerUI extends JFrame {
    private SearchPanel searchPanel;
    private DisplayPanel displayPanel;
    private PlayerControlsPanel playerControlsPanel;
    private Globals globals;
    public MusicPlayerUI(Globals globals) {
        initializeUI(globals);
    }

    private void initializeUI(Globals globals) {
        setTitle("BANANAA");
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/icons/main-icon.jpeg"));
        setSize(800, 600);
        setMinimumSize(new Dimension(600, 400)); // Tamaño mínimo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Inicializar paneles
        displayPanel = new DisplayPanel(globals);
        searchPanel = new SearchPanel(displayPanel);
        playerControlsPanel = new PlayerControlsPanel(globals);

        // Añadir los paneles a la ventana
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(searchPanel, BorderLayout.NORTH);
        getContentPane().add(displayPanel, BorderLayout.CENTER);
        //getContentPane().add(playerControlsPanel, BorderLayout.SOUTH);

        // Añadir ActionListeners a los botones de búsqueda
        searchPanel.addKeyListener(new KeyAdapter() {});
    }
    public void startPlayerControlsPanel() {
        if (playerControlsPanel == null) {
            playerControlsPanel = new PlayerControlsPanel(globals);
        }
        getContentPane().add(playerControlsPanel, BorderLayout.SOUTH);
        validate();
        repaint();
    }

}
