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
import javax.swing.plaf.basic.BasicSliderUI;
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

public class PlayerUI extends JPanel {
    private JPanel reproductorPanel;
    private Globals globals;
    private JButton playStopButton, nextSongButton, previousSongButton;
    private JSlider volumeSlider;
    private MediaPlayer mediaPlayer;
    private DoubleProperty volume = new SimpleDoubleProperty(0.3); // Initializes 30%
    private String url;

    public PlayerUI(Globals globals, String prwUrl) {
        this.globals = globals;
        this.url = prwUrl;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        reproductorPanel = new JPanel(new BorderLayout());
        reproductorPanel.setBackground(new Color(163,196,243)); // Set background color
        reproductorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        initButtons();

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
        volumeSlider.setBackground(new Color(236, 249, 255)); // Volume slider background color
        volumeSlider.setForeground(new Color(43,58,103)); // Color text
        volumeSlider.addChangeListener(e -> {
            volume.set(volumeSlider.getValue() / 100.0);
        });

        // Convert volume indicator to a dot
        volumeSlider.setUI(new BasicSliderUI(volumeSlider) {
            @Override
            protected Dimension getThumbSize() {
                return new Dimension(10, 10); // Dot size
            }

            @Override
            public void paintThumb(Graphics g) {
                Rectangle thumbBounds = thumbRect;
                int thumbX = thumbBounds.x + thumbBounds.width / 2 - 5; // Dot horizontal alignment
                int thumbY = thumbBounds.y + thumbBounds.height / 2 - 5; // Dot vertical alignment
                g.setColor(Color.WHITE); // Dot color
                g.fillOval(thumbX, thumbY, 10, 10); // Dot fill
            }

            @Override
            public void paintTrack(Graphics g) {
                super.paintTrack(g); // JSlider fill
            }
        });

        reproductorPanel.add(previousSongButton);
        reproductorPanel.add(playStopButton);
        reproductorPanel.add(nextSongButton);
        reproductorPanel.add(volumeSlider);

        add(reproductorPanel, BorderLayout.NORTH);

        // Create panel to display song information and progress bar
        JPanel infoPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(globals.getCurrentTrack().getName());
        JLabel artistLabel = new JLabel(globals.getCurrentTrack().getArtists().getFirst().getName());
        //JLabel imageLabel = new JLabel(new ImageIcon(globals.getCurrentTrack().getAlbum().getImages().getFirst().getUrl()));

        // Create progress bar to display song progress
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true); // Show the value as a string
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        // Add components to infoPanel
        //infoPanel.add(imageLabel, BorderLayout.WEST);
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(titleLabel);
        textPanel.add(artistLabel);
        infoPanel.add(textPanel, BorderLayout.CENTER);
        infoPanel.add(progressBar, BorderLayout.SOUTH);

        add(infoPanel, BorderLayout.CENTER);

        // JavaFX Toolkit initialization
        initFX();
    }

    private void initFX() {
        // JFXPanel initialization for JavaFX Toolkit
        new JFXPanel();
        Platform.runLater(() -> {
        });
    }

    private void initButtons() {
        previousSongButton = createButton("src/main/resources/icons/backward-button.png");
        playStopButton = createButton("src/main/resources/icons/play-button.png");
        nextSongButton = createButton("src/main/resources/icons/forward-button.png");

        playStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaPlayer.stop();
                    playStopButton.setIcon(new ImageIcon("src/main/resources/icons/play-button.png")); // Change icon to play
                } else {
                    try {
                        playAudio(url);
                        playStopButton.setIcon(new ImageIcon("src/main/resources/icons/pause-button.png")); // Change icon to pause
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
        button.setFocusPainted(false); // Deletes border when gains focus
        button.setBorderPainted(false); // Border delete
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Changes cursor when hovering
        button.setContentAreaFilled(false); // Doesn't fill area of the cursor
        button.setMargin(new Insets(10, 10, 10, 10)); // Button inner margins
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
            mediaPlayer.volumeProperty().bind(volume);
            mediaPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
