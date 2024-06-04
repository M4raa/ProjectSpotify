package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.entityContent.entity.several.Image;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AlbumPanels extends JPanel {
    private JPanel albumPanel1;
    private JPanel albumPanel2;

    public AlbumPanels() {
        setLayout(new GridLayout(1, 2)); // Mostrar los paneles lado a lado

        albumPanel1 = new JPanel(new BorderLayout());
        albumPanel1.add(new JLabel("Detalles del Álbum"), BorderLayout.CENTER);

        albumPanel2 = new JPanel(new BorderLayout());
        albumPanel2.add(new JLabel("Más información sobre el Álbum"), BorderLayout.CENTER);

        add(albumPanel1);
        add(albumPanel2);
    }

    public void updateContent(String albumName, List<Track> tracks, Image image) {
        ((JLabel) albumPanel1.getComponent(0)).setText("Panel 1 del álbum: " + albumName);
        ((JLabel) albumPanel2.getComponent(0)).setText("Panel 2 del álbum: " + albumName);
    }
}
