package jpaswing.projectspotiy.ui.Panels;

import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.entityContent.entity.several.Owner;
import jpaswing.projectspotiy.service.Globals;
import jpaswing.projectspotiy.ui.DisplayItem;
import jpaswing.projectspotiy.ui.MusicPlayerUI;

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
    private Globals globals;

    public PlaylistPanels(Globals globals) {
        this.globals = globals;
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
        List <Track> tracks = new ArrayList<>();
        playlist.getPlaylistTracks().getItems().forEach(trackItem -> tracks.add(trackItem.getTrack()));
        updateTrackList(tracks);
        updateplaylistImage(playlist.getImages().getFirst().getUrl());
        updateplaylistArtists(playlist.getOwner());
    }

    private void updateTrackList(List<Track> tracks) {
        listModel1.clear();
        for (Track track : tracks) {
            listModel1.addElement(new DisplayItem(track.getName(), track));
        }
        resultsList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                handleTrackSelection();
            }
        });
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
    private void handleTrackSelection() {
        int selectedIndex = resultsList1.getSelectedIndex();
        if (selectedIndex != -1) {
            DisplayItem selectedItem = listModel1.getElementAt(selectedIndex);
            Object originalObject = selectedItem.getOriginalObject();
            if (originalObject instanceof Track) {
                globals.setCurrentTrack((Track) originalObject);
                String url = globals.getCurrentTrack().getPreviewUrl();
                if (url == null) {
                    JOptionPane.showMessageDialog(this, "No preview available for this track.", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    ((MusicPlayerUI) SwingUtilities.getWindowAncestor(this)).startPlayerUi(globals,url);
                }
            }
        }
    }
    private void updateplaylistArtists(Owner owner) {
        playlistArtistsLabel.setText("Owner: " + owner.getDisplayName());
    }
}
