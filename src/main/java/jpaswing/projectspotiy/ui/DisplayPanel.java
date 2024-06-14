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

public class DisplayPanel extends JPanel{
    private JList<DisplayItem> resultsList;
    private DefaultListModel<DisplayItem> listModel;
    private JScrollPane resultsPanel;
    private AlbumPanels albumPanel;
    private PlaylistPanels playlistPanel;
    private ArtistPanels artistPanel;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private PlayerUI playerUI;

    public DisplayPanel(Globals globals) {
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        resultsList = new JList<>(listModel);
        resultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultsList.setForeground(new Color(43,58,103));//Text color
        resultsList.setBackground(new Color(232,241,250));
        resultsList.setBorder(BorderFactory.createEmptyBorder());

        //Panels initialitation
        playlistPanel = new PlaylistPanels();
        artistPanel = new ArtistPanels();
        albumPanel = new AlbumPanels(globals);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        resultsPanel = new JScrollPane(resultsList);
        mainPanel.add(resultsPanel, "Results");
        mainPanel.add(albumPanel, "AlbumPanels");
        mainPanel.add(playlistPanel, "PlaylistPanel");
        mainPanel.add(artistPanel, "ArtistPanels");

        add(mainPanel, BorderLayout.CENTER);

        resultsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = resultsList.getSelectedIndex();
                if (selectedIndex != -1) {
                    DisplayItem selectedItem = listModel.getElementAt(selectedIndex);
                    Object originalObject = selectedItem.getOriginalObject();

                    if (originalObject instanceof Artist) {
                        globals.setCurrentArtist((Artist) originalObject);

                        // Actions for artist
                        try {
                            showArtistPanels(globals.getCurrentArtist());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else if (originalObject instanceof Album) {
                        globals.setCurrentAlbum((Album) originalObject);

                        // Actions for album
                        try {
                            showAlbumPanels(globals.getCurrentAlbum());
                        } catch (MalformedURLException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else if (originalObject instanceof Track) {

                        Track selectedTrack = (Track) originalObject;
                        globals.setCurrentTrack(selectedTrack);

                        // Actualizar PlayerUI con la nueva canción
                        /*PlayerUI playerUI = getPlayerUIInstance();
                        if (playerUI != null) {
                            playerUI.updateSong(selectedTrack, selectedTrack.getPreviewUrl());
                        } else {*/
                            Thread thread = new Thread(() -> {
                                ((MusicPlayerUI) SwingUtilities.getWindowAncestor(DisplayPanel.this)).startPlayerUi(globals, selectedTrack.getPreviewUrl());
                            });
                            thread.start();
                        /*}*/

                        /*globals.setCurrentTrack((Track) originalObject);

                        String url = globals.getCurrentTrack().getPreviewUrl();
                        if (url == null){
                            JOptionPane.showMessageDialog(DisplayPanel.this, "No preview available for this track.", "Information", JOptionPane.INFORMATION_MESSAGE
                            );
                        } else {
                            Thread thread = new Thread(() -> {
                                ((MusicPlayerUI) SwingUtilities.getWindowAncestor(DisplayPanel.this)).startPlayerUi(globals,url);
                            });
                            thread.start();
                        }*/

                    } else if (originalObject instanceof Playlist) {
                        globals.setCurrentPlaylist((Playlist) originalObject);

                        // Actions for playlist
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

    public void clearPanel() throws MalformedURLException{
        listModel.clear();
        cardLayout.show(mainPanel, "Results");
        if (!(playerUI == null)){
            playerUI.stopPlayback();
        }
    }


    private void showAlbumPanels(Album album) throws MalformedURLException {
        albumPanel.updateContent(album);
        cardLayout.show(mainPanel, "AlbumPanels");
    }

    private void showPlaylistPanels(Playlist playlist) throws MalformedURLException {
        playlistPanel.updateContent(playlist);
        cardLayout.show(mainPanel, "PlaylistPanels");
    }

    private void showArtistPanels(Artist artist) throws IOException {
        artistPanel.updateContent(artist);
        cardLayout.show(mainPanel, "ArtistPanels");
    }
    private PlayerUI getPlayerUIInstance() {
        Component[] components = mainPanel.getComponents();
        for (Component component : components) {
            if (component instanceof PlayerUI) {
                return (PlayerUI) component;
            }
        }
        return null;
    }

    public void lastPanel() {
        cardLayout.previous(mainPanel);
    }

    public void nextPanel() {
        cardLayout.next(mainPanel);
    }
}
