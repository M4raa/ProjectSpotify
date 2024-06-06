package jpaswing.projectspotiy.ui.Panels;

import jpaswing.projectspotiy.entityContent.entity.Playlist;
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

public class PlaylistPanels extends JPanel {
    private JPanel playlistPanel1,playlistPanel2;
    private JList<DisplayItem> resultsList1;
    private DefaultListModel<DisplayItem> listModel1;
    private JLabel playlistImage;
    private JLabel playlistArtistsLabel;

    public PlaylistPanels() {
        setLayout(new GridLayout(1, 2)); // Display panels side by side

        //PlaylistPanel1
        playlistPanel1 = new JPanel(new BorderLayout());
        listModel1 = new DefaultListModel<>();
        resultsList1 = new JList<>(listModel1);
        resultsList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultsList1.setForeground(Color.BLACK);
        resultsList1.setBackground(new Color(236, 249, 255));
        resultsList1.setBorder(BorderFactory.createEmptyBorder());
        playlistPanel1.add(new JScrollPane(resultsList1), BorderLayout.CENTER);
        add(playlistPanel1);

        //PlaylistPanel2
        playlistPanel2 = new JPanel();
        playlistPanel2.setLayout(new BoxLayout(playlistPanel2, BoxLayout.Y_AXIS));
        playlistPanel2.setBackground(new Color(236, 249, 255));
        playlistImage = new JLabel();
        playlistImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        playlistImage.setPreferredSize(new Dimension(250, 250));
        playlistArtistsLabel = new JLabel();
        playlistArtistsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playlistPanel2.add(Box.createVerticalGlue()); // Add vertical space
        playlistPanel2.add(playlistImage);
        playlistPanel2.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space between image and label
        playlistPanel2.add(playlistArtistsLabel);
        playlistPanel2.add(Box.createVerticalGlue()); // Add vertical space
        add(playlistPanel2);
    }

    public void updateContent(Playlist playlist) {
        //updateTrackList(playlist.getPlaylistTracks().getItems().forEach(trackItem -> trackItem.getTrack()));
        updateplaylistImage(playlist.getImages().getFirst().getUrl());
        //updateplaylistArtists(playlist.getArtists());
    }

    private void updateTrackList(List<Track> tracks) {
        listModel1.clear();
        for (Track track : tracks) {
            listModel1.addElement(new DisplayItem(track.getName(), track.getArtists()));
        }
    }

    private void updateplaylistImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            playlistImage.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
            playlistImage.setIcon(null);
            playlistImage.setText("NO playlist IMAGE");
        }
    }

    private void updateplaylistArtists(List<Artist> artists) {
        List<String> artistNames = new ArrayList<>();
        for (Artist artist : artists) {
            artistNames.add(artist.getName());
        }
        playlistArtistsLabel.setText("Artists: " + artistNames);
    }
}
