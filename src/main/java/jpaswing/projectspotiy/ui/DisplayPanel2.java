package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.*;
import jpaswing.projectspotiy.entityContent.entity.several.Image;
import jpaswing.projectspotiy.service.Globals;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPanel2 extends JPanel {
    private JList<DisplayItem> resultsList;
    private DefaultListModel<DisplayItem> listModel;
    private AlbumPanels albumPanels;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Globals globals;

    public DisplayPanel2(Globals globals) {
        this.globals = globals;
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

        resultsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = resultsList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        DisplayItem selectedItem = listModel.getElementAt(selectedIndex);
                        Object originalObject = selectedItem.getOriginalObject();

                        if (originalObject instanceof Artist) {
                            globals.setCurrentArtist((Artist) originalObject);

                            // Acción específica para Artist


                        } else if (originalObject instanceof Album) {
                            globals.setCurrentAlbum((Album) originalObject);

                            //Accion con albums
                            showAlbumPanels();

                        } else if (originalObject instanceof Track) {
                            globals.setCurrentTrack((Track) originalObject);

                            // Acción específica para Track
                            ((MusicPlayerUI) SwingUtilities.getWindowAncestor(DisplayPanel2.this)).startPlayerControlsPanel();

                        } else if (originalObject instanceof Playlist) {
                            globals.setCurrentPlaylist((Playlist) originalObject);

                            // Acción específica para Playlist

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

    private void showAlbumPanels(Album album) {
        albumPanels.updateContent(album);
        cardLayout.show(mainPanel, "AlbumPanels");
    }
}
