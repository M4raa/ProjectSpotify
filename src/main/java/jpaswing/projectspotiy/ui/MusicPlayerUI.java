package jpaswing.projectspotiy.ui;


import javax.swing.*;
import java.awt.*;

public class MusicPlayerUI extends JFrame {
    private SearchPanel searchPanel;
    private DisplayPanel displayPanel;
    private PlayerControlsPanel playerControlsPanel;

    public MusicPlayerUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Music Player");
        setSize(800, 600);
        setMinimumSize(new Dimension(600, 400)); // Tamaño mínimo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Inicializar paneles
        displayPanel = new DisplayPanel();
        searchPanel = new SearchPanel(displayPanel);
        playerControlsPanel = new PlayerControlsPanel();

        // Añadir los paneles a la ventana
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(searchPanel, BorderLayout.NORTH);
        getContentPane().add(displayPanel, BorderLayout.CENTER);
        getContentPane().add(playerControlsPanel, BorderLayout.SOUTH);

        // Añadir ActionListeners a los botones de búsqueda
        searchPanel.addActionListeners();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicPlayerUI ui = new MusicPlayerUI();
            ui.setVisible(true);
        });
    }
}
