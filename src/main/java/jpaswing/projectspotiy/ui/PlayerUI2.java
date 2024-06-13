package jpaswing.projectspotiy.ui;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import jpaswing.projectspotiy.service.Globals;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;

public class PlayerUI2 extends JPanel {
    private Globals globals;
    private JButton playStopButton, nextSongButton, previousSongButton;
    private JSlider volumeSlider;
    private MediaPlayer mediaPlayer;
    private DoubleProperty volume = new SimpleDoubleProperty(0.3); // Inicializa el volumen al 30%
    private String url;

    private JProgressBar progressBar;
    private JLabel titleLabel, artistLabel, imageLabel;
    private Timer timer;

    public PlayerUI2(Globals globals, String prwUrl) {
        this.globals = globals;
        this.url = prwUrl;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Panel principal para el reproductor
        JPanel reproductorPanel = new JPanel(new BorderLayout());
        reproductorPanel.setBackground(new Color(163, 196, 243)); // Color de fondo del reproductor

        // Botones de control (al centro)
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        previousSongButton = createButton("src/main/resources/icons/backward-button.png");
        playStopButton = createButton("src/main/resources/icons/play-button.png");
        nextSongButton = createButton("src/main/resources/icons/forward-button.png");
        controlPanel.add(previousSongButton);
        controlPanel.add(playStopButton);
        controlPanel.add(nextSongButton);
        reproductorPanel.add(controlPanel, BorderLayout.CENTER);

        // Barra de volumen (a la derecha)
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
        volumeSlider.setBackground(new Color(236, 249, 255)); // Color de fondo de la barra de volumen
        volumeSlider.setForeground(new Color(43, 58, 103)); // Color del texto de la barra de volumen
        volumeSlider.setUI(new CustomSliderUI(volumeSlider)); // Utiliza una UI personalizada para el slider
        volumeSlider.addChangeListener(e -> {
            volume.set(volumeSlider.getValue() / 100.0);
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(volume.get());
            }
        });
        reproductorPanel.add(volumeSlider, BorderLayout.EAST);

        add(reproductorPanel, BorderLayout.NORTH);

        // Panel para mostrar información de la canción y la barra de progreso
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBackground(Color.WHITE); // Color de fondo del panel de información

        // Etiquetas para el título de la canción y el artista (dentro del reproductor)
        titleLabel = new JLabel(globals.getCurrentTrack().getName());
        artistLabel = new JLabel(globals.getCurrentTrack().getArtists().getFirst().getName());
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(titleLabel);
        textPanel.add(artistLabel);
        reproductorPanel.add(textPanel, BorderLayout.WEST);

        // Barra de progreso de la canción (debajo del reproductor)
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true); // Muestra el porcentaje
        infoPanel.add(progressBar, BorderLayout.CENTER);

        // Imagen de la canción (opcional, a la izquierda del panel de información)
        ImageIcon imageIcon;
        if (globals.getCurrentTrack().getAlbum().getImages().isEmpty()) {
            imageIcon = null; // No hay imágenes disponibles
        } else {
            imageIcon = new ImageIcon(globals.getCurrentTrack().getAlbum().getImages().getFirst().getUrl());
        }

        if (imageIcon == null || imageIcon.getImage() == null) {
            imageLabel = new JLabel("No Image", SwingConstants.CENTER);
        } else {
            imageLabel = new JLabel(imageIcon);
        }
        infoPanel.add(imageLabel, BorderLayout.WEST);

        add(infoPanel, BorderLayout.CENTER);

        // Inicialización de JavaFX Toolkit (si es necesario)
        initFX();

        // Action Listeners para los botones de reproducción
        playStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaPlayer.pause();
                    playStopButton.setIcon(new ImageIcon("src/main/resources/icons/play-button.png")); // Cambia el ícono a "Play"
                } else {
                    playAudio(url);
                    playStopButton.setIcon(new ImageIcon("src/main/resources/icons/pause-button.png")); // Cambia el ícono a "Pause"
                }
            }
        });

        // Timer para actualizar la barra de progreso
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    double currentSeconds = mediaPlayer.getCurrentTime().toSeconds();
                    double totalSeconds = mediaPlayer.getTotalDuration().toSeconds();
                    int progress = (int) (currentSeconds / totalSeconds * 100);
                    progressBar.setValue(progress);
                }
            }
        });
        timer.start();
    }

    private void initFX() {
        // Inicialización de JFXPanel para JavaFX Toolkit
        new JFXPanel();
        Platform.runLater(() -> {
            // Registrar un EventHandler para manejar el evento de finalización de la reproducción
            mediaPlayer.setOnEndOfMedia(() -> {
                // Cambiar el ícono a "Play" cuando la canción termine
                SwingUtilities.invokeLater(() -> {
                    playStopButton.setIcon(new ImageIcon("src/main/resources/icons/play-button.png"));
                });
            });
        });
    }

    private JButton createButton(String iconPath) {
        JButton button = new JButton();
        ImageIcon icon = new ImageIcon(iconPath);
        button.setIcon(icon);
        button.setBackground(new Color(60, 63, 65)); // Color de fondo gris oscuro
        button.setFocusPainted(false); // No muestra el borde al obtener el foco
        button.setBorderPainted(false); // Sin borde
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor al pasar por encima
        button.setContentAreaFilled(false); // No rellena el área del botón
        button.setMargin(new Insets(10, 10, 10, 10)); // Márgenes internos del botón
        return button;
    }

    private void playAudio(String urlSong) {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
            mediaPlayer.dispose(); // Liberar recursos del reproductor anterior
        }
        try {
            URL url = new URL(urlSong);
            Media media = new Media(url.toExternalForm());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.volumeProperty().bind(volume);
            mediaPlayer.play();

            // Actualizar etiquetas y barra de progreso con nueva canción
            updateSongInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Actualiza la información de la canción (etiquetas y barra de progreso)
    private void updateSongInfo() {
        SwingUtilities.invokeLater(() -> {
            titleLabel.setText(globals.getCurrentTrack().getName());
            artistLabel.setText(globals.getCurrentTrack().getArtists().getFirst().getName());

            // Actualiza la imagen de la canción si está disponible
            ImageIcon imageIcon;
            if (globals.getCurrentTrack().getAlbum().getImages().isEmpty()) {
                imageIcon = null; // No hay imágenes disponibles
                imageLabel.setIcon(null);
                imageLabel.setText("No Image");
            } else {
                imageIcon = new ImageIcon(globals.getCurrentTrack().getAlbum().getImages().getFirst().getUrl());
                imageLabel.setIcon(imageIcon);
                imageLabel.setText("");
            }

            // Reiniciar la barra de progreso
            progressBar.setValue(0);
        });
    }

    public void stopPlayback() {
        if (mediaPlayer != null) {
            mediaPlayer.stop(); // Detener la reproducción actual
            mediaPlayer.dispose(); // Liberar recursos del MediaPlayer
            mediaPlayer = null; // Marcar como null para indicar que ya no hay instancia activa
            timer.stop(); // Detener el timer de actualización de la barra de progreso
        }
    }

    // Clase para personalizar la UI del JSlider
    private class CustomSliderUI extends javax.swing.plaf.basic.BasicSliderUI {
        public CustomSliderUI(JSlider b) {
            super(b);
        }

        @Override
        protected Dimension getThumbSize() {
            return new Dimension(15, 15); // Tamaño del "thumb" del slider
        }

        @Override
        public void paintTrack(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GRAY); // Color de la barra del slider
            g2d.fillRect(trackRect.x, trackRect.y + trackRect.height / 2 - 3, trackRect.width, 6); // Dibuja la barra del slider
        }

        @Override
        public void paintThumb(Graphics g) {
            Rectangle knobBounds = thumbRect;
            int x = knobBounds.x + knobBounds.width / 2 - 7;
            int y = knobBounds.y + knobBounds.height / 2 - 7;
            g.setColor(new Color(43, 58, 103)); // Color del "thumb" del slider
            g.fillOval(x, y, 15, 15); // Dibuja el "thumb" del slider
        }
    }
}