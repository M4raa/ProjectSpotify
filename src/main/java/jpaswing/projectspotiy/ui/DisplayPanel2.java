package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.*;
import jpaswing.projectspotiy.entityContent.entity.several.Image;
import jpaswing.projectspotiy.utilities.SearchMethods;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPanel2 extends JPanel {
    private JList<DisplayItem> resultsList;
    private DefaultListModel<DisplayItem> listModel;
    private SearchMethods searchMethods;
    private AlbumPanels albumPanels;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public DisplayPanel2() {
        setLayout(new BorderLayout());
        searchMethods = new SearchMethods();
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

        resultsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = resultsList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        DisplayItem selectedItem = listModel.getElementAt(selectedIndex);
                        Object originalObject = selectedItem.getOriginalObject();

                        if (originalObject instanceof Artist) {
                            Image image = ((Artist) originalObject).getImages().getFirst();
                            String name = ((Artist) originalObject).getName();
                            // Acción específica para Artist
                            JOptionPane.showMessageDialog(DisplayPanel2.this, "Seleccionaste el Artista: " + name);

                        } else if (originalObject instanceof Album) {
                            Album album = (Album) originalObject;
                            Image image = album.getImages().getFirst();
                            String name = album.getName();
                            List<Track> tracks = new ArrayList<>(album.getTracks().getItems());

                            //Accion con albums
                            showAlbumPanels(name,image,tracks);

                        } else if (originalObject instanceof Track) {
                            Image image = ((Track) originalObject).getAlbum().getImages().getFirst();
                            String name = ((Track) originalObject).getName();
                            // Acción específica para Track
                            ((MusicPlayerUI) SwingUtilities.getWindowAncestor(DisplayPanel2.this)).startPlayerControlsPanel();

                        } else if (originalObject instanceof Playlist) {
                            Playlist playlist = (Playlist) originalObject;
                            Image image = playlist.getImages().getFirst();
                            String name = playlist.getName();
                            List<Track> tracks = new ArrayList<>();
                            playlist.getPlaylistTracks().getItems().forEach(trackItem -> tracks.add(trackItem.getTrack()));

                            // Acción específica para Playlist
                            JOptionPane.showMessageDialog(DisplayPanel2.this, "Seleccionaste la Lista de Reproducción: " + name);
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

    private void showAlbumPanels(String albumName,Image image, List<Track> tracks) {
        albumPanels.updateContent(albumName, tracks, image);
        cardLayout.show(mainPanel, "AlbumPanels");
    }
}
