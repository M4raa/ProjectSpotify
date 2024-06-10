package jpaswing.projectspotiy.ui;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import jpaswing.projectspotiy.service.Globals;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PlayerUI extends JFrame {
    private JPanel reproductorPanel;
    private Globals globals;
    private JButton reproduce, nextSong, previousSong;
    private JSlider volumeSlider;
    private MediaPlayer mediaPlayer;
    private String url = globals.getCurrentTrack().getPreviewUrl();
    private DoubleProperty volume = new SimpleDoubleProperty(0.3); // Volumen inicial al máximo

    public PlayerUI() {
        initUI();
    }

    private void initUI() {
        setTitle("PLAYER");
        setSize(800, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reproductorPanel = new JPanel();
        reproductorPanel.setBackground(Color.BLACK); // Establece el color de fondo negro
        reproductorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        initButtons();

        volumeSlider = new JSlider(0, 100, 100);
        volumeSlider.setPreferredSize(new Dimension(200, 50));
        volumeSlider.setOpaque(false);
        volumeSlider.addChangeListener(e -> {
            volume.set(volumeSlider.getValue() / 100.0);
        });

        reproductorPanel.add(previousSong);
        reproductorPanel.add(reproduce);
        reproductorPanel.add(nextSong);
        reproductorPanel.add(volumeSlider);

        add(reproductorPanel);

        // Inicializa la Toolkit de JavaFX
        initFX();
    }

    private void initFX() {
        // Inicializa un JFXPanel para inicializar la Toolkit de JavaFX
        new JFXPanel();
        Platform.runLater(() -> {
            // Este código se ejecutará en el hilo de JavaFX después de que la Toolkit esté inicializada
        });
    }

    private void initButtons() {
        previousSong = createButton("src/main/resources/icons/previous.png");
        reproduce = createButton("src/main/resources/icons/play.png");
        nextSong = createButton("src/main/resources/icons/next.png");

        reproduce.setEnabled(true);
        reproduce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaPlayer.stop();
                } else {
                    try {
                        playAudio(url);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
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

    private void playAudio(String urlSong) throws LineUnavailableException {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }
        try {
            URL url = new URL(urlSong);
            URLConnection conexion = url.openConnection();
            InputStream entrada = conexion.getInputStream();
            File archivoTemporal = File.createTempFile("temporal_song", ".mp3");

            BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(archivoTemporal));

            byte[] buffer = new byte[1024];
            int longitud;
            while ((longitud = entrada.read(buffer)) != -1) {
                salida.write(buffer, 0, longitud);
            }
            salida.close();
            entrada.close();

            Media media = new Media(archivoTemporal.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.volumeProperty().bind(volume); // Vincula el volumen del MediaPlayer con la propiedad volume
            mediaPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
