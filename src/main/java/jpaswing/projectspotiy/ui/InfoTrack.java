package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Track;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class InfoTrack extends JPanel{
    private JLabel lblTrackName;
    private JLabel lblArtistName;
    private JLabel lblImage;
    public InfoTrack() throws IOException {
        initComponents();
    }

    private void initComponents() throws IOException {
        this.setLayout(new BorderLayout());

        lblImage = new JLabel();
        lblTrackName = new JLabel("Track Name");
        lblArtistName = new JLabel("Artist Name");

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(lblTrackName);
        textPanel.add(lblArtistName);

        this.add(lblImage, BorderLayout.WEST);
        this.add(textPanel, BorderLayout.CENTER);

    }

    public void setTrackInfo (Track track){
        lblTrackName.setText(track.getName());
        lblArtistName.setText(track.getArtists().toString());
    }

    public void setAlbumImage(Album album) {
        BufferedImage img = null;
        try {
            img = ImageIO.read((ImageInputStream) album.getImages().get(0));
            ImageIcon icon = new ImageIcon(img);
            lblImage.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
