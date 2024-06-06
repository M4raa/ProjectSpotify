package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.*;
import jpaswing.projectspotiy.service.Globals;
import jpaswing.projectspotiy.ui.Panels.AlbumPanels;
import jpaswing.projectspotiy.ui.Panels.ArtistPanels;
import jpaswing.projectspotiy.ui.Panels.PlaylistPanels;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class DisplayPanel2 extends JPanel {
    private JList<DisplayItem> resultsList;
    private DefaultListModel<DisplayItem> listModel;
    private AlbumPanels albumPanels;
    private PlaylistPanels playlistPanel;
    private ArtistPanels artistPanels;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Globals globals;
    private String currentScreen = null;

    public DisplayPanel2(Globals globals) {
        this.globals = globals;
        this.currentScreen = currentScreen;
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        resultsList = new JList<>(listModel);
        resultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultsList.setForeground(Color.BLACK);
        resultsList.setBackground(new Color(236, 249, 255));
        resultsList.setBorder(BorderFactory.createEmptyBorder());

        albumPanels = new AlbumPanels(); // Inicialización correcta de albumPanels

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new JScrollPane(resultsList), "Results");
        mainPanel.add(albumPanels, "AlbumPanels");

        add(mainPanel, BorderLayout.CENTER);

        if(currentScreen == null) {
            resultsList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = resultsList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        DisplayItem selectedItem = listModel.getElementAt(selectedIndex);
                        Object originalObject = selectedItem.getOriginalObject();

                        if (originalObject instanceof Artist) {
                            globals.setCurrentArtist((Artist) originalObject);

                            // Acción específica para Artist
                            currentScreen = "artist";
                            try {
                                showArtistPanels(globals.getCurrentArtist());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        } else if (originalObject instanceof Album) {
                            globals.setCurrentAlbum((Album) originalObject);

                            //Accion con albums
                            currentScreen = "album";
                            try {
                                showAlbumPanels(globals.getCurrentAlbum());
                            } catch (MalformedURLException ex) {
                                throw new RuntimeException(ex);
                            }

                        } else if (originalObject instanceof Track) {
                            globals.setCurrentTrack((Track) originalObject);

                            // Acción específica para Track
                            currentScreen = "track";
                            ((MusicPlayerUI) SwingUtilities.getWindowAncestor(DisplayPanel2.this)).startPlayerControlsPanel();

                        } else if (originalObject instanceof Playlist) {
                            globals.setCurrentPlaylist((Playlist) originalObject);

                            // Acción específica para Playlist
                            currentScreen = "playlist";
                            try {
                                showPlaylistPanels(globals.getCurrentPlaylist());
                            } catch (MalformedURLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                    }
                }
            });
        }
    }

    public void displayResults(List<Object> results) {
        listModel.clear();
        for (Object result : results) {
            if (result instanceof Artist) {
                Artist artist = (Artist) result;
                listModel.addElement(new DisplayItem("Artist - " + artist.getName(), artist));
            } else if (result instanceof Album) {
                Album album = (Album) result;
                listModel.addElement(new DisplayItem("Album - " + album.getName(), album));
            } else if (result instanceof Track) {
                Track track = (Track) result;
                listModel.addElement(new DisplayItem("Track - " + track.getName(), track));
            } else if (result instanceof Playlist) {
                Playlist playlist = (Playlist) result;
                listModel.addElement(new DisplayItem("Playlist - " + playlist.getName(), playlist));
            }
        }
    }

    private void showAlbumPanels(Album album) throws MalformedURLException {
        albumPanels.updateContent(album);
        cardLayout.show(mainPanel, "AlbumPanels");
    }
    private void showPlaylistPanels(Playlist playlist) throws MalformedURLException {
        playlistPanel.updateContent(playlist);
        cardLayout.show(mainPanel, "PlaylistPanels");
    }
    private void showArtistPanels(Artist artist) throws IOException {
        artistPanels.updateContent(artist);
        cardLayout.show(mainPanel, "ArtistPanels");
    }
}
