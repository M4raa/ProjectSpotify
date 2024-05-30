package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPanel extends JPanel {
    private JTextArea resultsArea;

    public DisplayPanel() {
        setLayout(new BorderLayout());
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setForeground(Color.BLACK);
        resultsArea.setBackground(new Color(138, 138, 138));
        resultsArea.setBorder(BorderFactory.createEmptyBorder());
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);
    }

    public void displayResults(List<Object> results) {
        resultsArea.setText("");
        StringBuilder sb = new StringBuilder();
        for (Object result : results){
            if (result instanceof Artist) {
                sb.append("Artist - ").append(((Artist) result).getName()).append("\n");
            } else if (result instanceof Album) {
                sb.append("Album - ").append(((Album) result).getName()).append("\n");
            } else if (result instanceof Track) {
                sb.append("Track - ").append(((Track) result).getName()).append("\n");
            } else if (result instanceof Playlist) {
                sb.append("Playlist - ").append(((Playlist) result).getName()).append("\n");
            }
        }
        resultsArea.setText(sb.toString());
    }
}
