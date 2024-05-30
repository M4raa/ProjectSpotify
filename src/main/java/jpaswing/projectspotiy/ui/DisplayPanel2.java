package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DisplayPanel2 extends JPanel {
    private JList<String> resultsList;
    private DefaultListModel<String> listModel;

    public DisplayPanel2() {
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        resultsList = new JList<>(listModel);
        resultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultsList.setForeground(Color.BLACK);
        resultsList.setBackground(new Color(138, 138, 138));
        resultsList.setBorder(BorderFactory.createEmptyBorder());

        add(new JScrollPane(resultsList), BorderLayout.CENTER);
    }

    public void displayResults(List<Object> results) {
        listModel.clear();
        for (Object result : results) {
            if (result instanceof Artist) {
                Artist artist = (Artist) result;
                listModel.addElement("Artist - " + artist.getName());
            } else if (result instanceof Album) {
                Album album = (Album) result;
                listModel.addElement("Album - " + album.getName());
            } else if (result instanceof Track) {
                Track track = (Track) result;
                listModel.addElement("Track - " + track.getName());
            } else if (result instanceof Playlist) {
                Playlist playlist = (Playlist) result;
                listModel.addElement("Playlist - " + playlist.getName());
            }
        }
    }
}
