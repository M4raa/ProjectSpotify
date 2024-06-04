package jpaswing.projectspotiy.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PlayerControlsPanel extends JPanel {
    private JButton previousButton, playButton, nextButton;
    private JSlider volumeSlider;

    public PlayerControlsPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(248, 203, 166)); // Player background color

        previousButton = createButton("src/main/resources/icons/backward-button.png");
        playButton = createButton("src/main/resources/icons/play-button.png");
        nextButton = createButton("src/main/resources/icons/forward-button.png");
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
        volumeSlider.setBackground(new Color(236, 249, 255)); // Volume slider backgorund color
        volumeSlider.setForeground(Color.BLACK); // Color del texto blanco

        GridBagConstraints gbcBottom = new GridBagConstraints();
        gbcBottom.fill = GridBagConstraints.HORIZONTAL;
        gbcBottom.weightx = 1; // Expande los componentes horizontalmente
        gbcBottom.insets = new Insets(0, 5, 0, 5); // Espacio entre los componentes

        add(previousButton, gbcBottom);
        add(playButton, gbcBottom);
        add(nextButton, gbcBottom);
        add(volumeSlider, gbcBottom);

        // Modificar el aspecto del JSlider para usar una bolita como indicador
        volumeSlider.setUI(new BasicSliderUI(volumeSlider) {
            @Override
            protected Dimension getThumbSize() {
                return new Dimension(20, 20); // Tamaño de la bolita
            }

            @Override
            public void paintThumb(Graphics g) {
                Rectangle thumbBounds = thumbRect;
                int thumbX = thumbBounds.x + thumbBounds.width / 2 - 10; // Centra la bolita horizontalmente
                int thumbY = thumbBounds.y + thumbBounds.height / 2 - 10; // Centra la bolita verticalmente
                g.setColor(Color.WHITE); // Color de la bolita
                g.fillOval(thumbX, thumbY, 20, 20); // Dibuja la bolita
            }

            @Override
            public void paintTrack(Graphics g) {
                super.paintTrack(g); // Pinta la pista del JSlider
            }
        });
    }

    private JButton createButton(String iconPath) {
        JButton button = new JButton();
        ImageIcon icon = new ImageIcon(iconPath);
        button.setIcon(icon);
        button.setBackground(new Color(60, 63, 65)); // Color de fondo gris oscuro
        button.setFocusPainted(false); // Elimina el borde al ganar el foco
        button.setBorderPainted(false); // Elimina el borde
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor al pasar sobre el botón
        button.setContentAreaFilled(false); // No rellena el área del botón
        button.setMargin(new Insets(10, 10, 10, 10)); // Márgenes internos del botón
        return button;
    }
    public class Main {
        public static void main(String[] args) {
            // Ejecutar la interfaz gráfica en el hilo de despacho de eventos
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // Crear una instancia de MusicPlayerUI y hacerla visible
                    MusicPlayerUI playerUI = new MusicPlayerUI();
                    playerUI.setVisible(true);
                }
            });
        }
    }
}