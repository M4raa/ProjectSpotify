package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

public class DisplayPanel2 extends JPanel {
    private JList<String> resultsList;
    private DefaultListModel<DisplayItem> listModel;

    public DisplayPanel2() {
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        resultsList = new JList<>(listModel);
        resultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultsList.setForeground(Color.BLACK);
        resultsList.setBackground(new Color(138, 138, 138));
        resultsList.setBorder(BorderFactory.createEmptyBorder());

        resultsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = resultsList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        DisplayItem selectedItem = listModel.getElementAt(selectedIndex);
                        Object originalObject = selectedItem.getOriginalObject();

                        if (originalObject instanceof Artist) {

                        } else if (originalObject instanceof Album) {

                        } else if (originalObject instanceof Track) {

                        } else if (originalObject instanceof Playlist) {

                        }
                    }
                }
            }
        });

        add(new JScrollPane(resultsList), BorderLayout.CENTER);
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
}
