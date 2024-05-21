package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.controller.PlaylistController;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.repository.PlaylistRepo;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

public class PlayerUI extends JFrame {
    private JPanel reproductorPanel;
    private JButton reproduce, nextSong, previousSong;
    private ImageIcon btnReproduce, btnNext, btnPrevious;
    private Clip clip;
    private JSlider barraRepro;
    private JLabel etiqueta = new JLabel();

    public PlayerUI() {
        initUI();
    }

    private void initUI() {
        setTitle("PLAYER");
        setSize(400, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reproductorPanel = new JPanel();
        initButtons();

        reproductorPanel.add(reproduce);
        reproductorPanel.add(previousSong);
        reproductorPanel.add(nextSong);

        add(reproductorPanel);
    }

    private void initButtons() {
        reproduce = new JButton("play");
        nextSong = new JButton(">>");
        previousSong = new JButton("<<");

        btnReproduce = new ImageIcon(getClass().getResource("src/main/resources/icons/play.png"));
        reproduce.setIcon(btnReproduce);
        reproduce.setEnabled(true);

        reproduce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                    clip.close();
                } else {
                    String previewUrl = "https://p.scdn.co/mp3-preview/example.mp3"; // Example URL, replace with actual track URL
                    try {
                        playAudio(previewUrl);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnNext = new ImageIcon(getClass().getResource("src/main/resources/icons/next.png"));
        nextSong.setIcon(btnNext);

        btnPrevious = new ImageIcon(getClass().getResource("src/main/resources/icons/previous.png"));
        previousSong.setIcon(btnPrevious);
    }

    private void playAudio(String audioUrl) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        URL url = new URL(audioUrl);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(url.openStream()));
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PlayerUI playerUI = new PlayerUI();
                playerUI.setVisible(true);
            }
        });
    }
}
