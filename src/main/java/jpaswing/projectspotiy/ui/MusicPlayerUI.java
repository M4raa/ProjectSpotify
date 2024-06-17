package jpaswing.projectspotiy.ui;


import jpaswing.projectspotiy.service.Globals;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class MusicPlayerUI extends JFrame {
    private SearchPanel searchPanel;
    private DisplayPanel displayPanel;
    private PlayerUI playerUI;
    private Globals globals;
    public MusicPlayerUI(Globals globals) {
        initializeUI(globals);
    }

    private void initializeUI(Globals globals) {
        setTitle("Copia barata de Spotify");
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/icons/main-icon.jpeg"));
        setSize(800, 600);
        setMinimumSize(new Dimension(600, 400)); // Tamaño mínimo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Initialize panels
        displayPanel = new DisplayPanel(globals);
        searchPanel = new SearchPanel(displayPanel);

        // Add panels to the window
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(searchPanel, BorderLayout.NORTH);
        getContentPane().add(displayPanel, BorderLayout.CENTER);

        // Añadir ActionListeners a los botones de búsqueda
        searchPanel.addKeyListener(new KeyAdapter() {});
    }
    public void startPlayerUi(Globals globals,String url) {
        if (playerUI == null) {
            playerUI = new PlayerUI(globals,url);
        }

        getContentPane().add(playerUI, BorderLayout.SOUTH);
        validate();
        repaint();
    }

}
