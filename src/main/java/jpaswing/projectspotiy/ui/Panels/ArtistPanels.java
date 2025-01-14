package jpaswing.projectspotiy.ui.Panels;

import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Track;
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

public class ArtistPanels extends JPanel {
    private JPanel upperPanel,bottomPanel;
    private JList<DisplayItem> tracksList;
    private ArtistsController artistsController;
    private DefaultListModel<DisplayItem> listModel1;
    private JLabel artistImage;
    private JLabel albumArtistsLabel;
    private Globals globals;

    public ArtistPanels(Globals globals) {
        this.globals = globals;
        this.artistsController = new ArtistsController();
        setLayout(new GridLayout(1, 2)); // Display panels side by side

        //upperPanel
        upperPanel = new JPanel(new BorderLayout());
        listModel1 = new DefaultListModel<>();
        tracksList = new JList<>(listModel1);
        tracksList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tracksList.setForeground(Color.BLACK);
        tracksList.setBackground(new Color(236, 249, 255));
        tracksList.setBorder(BorderFactory.createEmptyBorder());
        upperPanel.add(new JScrollPane(tracksList), BorderLayout.CENTER);
        add(upperPanel);

        //bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBackground(new Color(236, 249, 255));
        artistImage = new JLabel();
        artistImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        artistImage.setPreferredSize(new Dimension(250, 250));
        albumArtistsLabel = new JLabel();
        albumArtistsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(Box.createVerticalGlue()); // Add vertical space
        bottomPanel.add(artistImage);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space between image and label
        bottomPanel.add(albumArtistsLabel);
        bottomPanel.add(Box.createVerticalGlue()); // Add vertical space
        add(bottomPanel);
    }

    public void updateContent(Artist artist) throws IOException {
        updateTrackList(artistsController.topTracksByArtistId(artist.getId()));
        updateArtistImage(artist.getImages().getFirst().getUrl());
    }

    private void updateTrackList(List<Track> tracks) {
        listModel1.clear();
        for (Track track : tracks) {
            listModel1.addElement(new DisplayItem(track.getName(), track));
        }
        tracksList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                handleTrackSelection();
            }
        });
    }

    private void updateArtistImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            artistImage.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
            artistImage.setIcon(null);
            artistImage.setText("NO ARTIST IMAGE");
        }
    }
    private void handleTrackSelection() {
        int selectedIndex = tracksList.getSelectedIndex();
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
}
