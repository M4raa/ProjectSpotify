package jpaswing.projectspotiy.ui.Panels;

import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.ui.DisplayItem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AlbumPanels extends JPanel {
    private JPanel albumPanel1,albumPanel2;
    private JList<DisplayItem> resultsList1;
    private DefaultListModel<DisplayItem> listModel1;
    private JLabel albumImage;
    private JLabel albumArtistsLabel;

    public AlbumPanels() {
        setLayout(new GridLayout(1, 2)); // Display panels side by side

        //AlbumPanel1
        albumPanel1 = new JPanel(new BorderLayout());
        listModel1 = new DefaultListModel<>();
        resultsList1 = new JList<>(listModel1);
        resultsList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultsList1.setForeground(Color.BLACK);
        resultsList1.setBackground(new Color(236, 249, 255));
        resultsList1.setBorder(BorderFactory.createEmptyBorder());
        albumPanel1.add(new JScrollPane(resultsList1), BorderLayout.CENTER);
        add(albumPanel1);

        //AlbumPanel2
        albumPanel2 = new JPanel();
        albumPanel2.setLayout(new BoxLayout(albumPanel2, BoxLayout.Y_AXIS));
        albumPanel2.setBackground(new Color(236, 249, 255));
        albumImage = new JLabel();
        albumImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        albumImage.setPreferredSize(new Dimension(250, 250));
        albumArtistsLabel = new JLabel();
        albumArtistsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        albumPanel2.add(Box.createVerticalGlue()); // Add vertical space
        albumPanel2.add(albumImage);
        albumPanel2.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space between image and label
        albumPanel2.add(albumArtistsLabel);
        albumPanel2.add(Box.createVerticalGlue()); // Add vertical space
        add(albumPanel2);
    }

    public void updateContent(Album album) {
        updateTrackList(album.getTracks().getItems());
        updateAlbumImage(album.getImages().getFirst().getUrl());
        updateAlbumArtists(album.getArtists());
    }

    private void updateTrackList(List<Track> tracks) {
        listModel1.clear();
        for (Track track : tracks) {
            listModel1.addElement(new DisplayItem(track.getName(), track.getArtists()));
        }
    }

    private void updateAlbumImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            albumImage.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
            albumImage.setIcon(null);
            albumImage.setText("NO ALBUM IMAGE");
        }
    }

    private void updateAlbumArtists(List<Artist> artists) {
        List<String> artistNames = new ArrayList<>();
        for (Artist artist : artists) {
            artistNames.add(artist.getName());
        }
        albumArtistsLabel.setText("Artists: " + artistNames);
    }
}
