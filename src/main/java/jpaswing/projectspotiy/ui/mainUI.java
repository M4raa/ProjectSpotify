package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.service.TokenRequest;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class mainUI  extends JFrame {
    private JPanel mainPanel;
    private JTextField txtNombre;
    private JTextField txtNota;
    private JButton btnFirst;
    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnLast;
    private TokenRequest tokenRequest;
    private JsonConverter jsonConverter;
    private InfoTrack infoTrack;
    public mainUI(TokenRequest tokenRequest, JsonConverter jsonConverter) throws IOException {
        this.tokenRequest = tokenRequest;
        this.jsonConverter = jsonConverter;
        initComponents();
        //updateData();
    }

    public mainUI() {

    }

    private void initComponents() throws IOException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Music Info");
        this.setSize(600, 600);
        this.setResizable(false);

        Track track = new Track();
        track.setName("Example Track");

        Album album = new Album();
        infoTrack.setTrackInfo(track);
        this.setVisible(true);

        infoTrack = new InfoTrack();
        this.add(infoTrack, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainUI mainUI = new mainUI();
                mainUI.setVisible(true);
            }
        });
    }

    /*private void updateData(){
        txtNota.setText(Long.toString(this.alumno.getNotaMedia()));
        txtNombre.setText(this.spotifyController.getNombre());
    }*/
//    private void initComponents(){
//        mainPanel = new JPanel();
//        txtNombre = new JTextField(10);
//        txtNota= new JTextField(10);
//        JLabel l;
//
//        this.setLayout(null);
//        mainPanel.setLayout(null);
//        mainPanel.setBounds(0, 0, 500, 650);
//
//        l = new JLabel("Name:");
//        l.setBounds(10, 40, 70, 20);
//        mainPanel.add(l);
//        txtNombre.setBounds(10 + 80, 40, 200, 20 );
//        mainPanel.add(txtNombre);
//
//        l = new JLabel("ID:");
//        l.setBounds(10, 10, 70, 20);
//        mainPanel.add(l);
//        txtNota.setEnabled(false);
//        txtNota.setBounds(10 + 80, 10, 200, 20);
//        mainPanel.add(txtNota);
//
//
//        /*
//        btnFirst = new JButton("<<");
//        btnFirst.addActionListener(e -> first());
//        btnPrevious = new JButton("<");
//        btnPrevious.addActionListener(e -> previous());
//        btnNext = new JButton(">");
//        btnNext.addActionListener(e -> next());
//        btnLast = new JButton(">>");
//        btnLast.addActionListener(e -> last());
//        btnFirst.setBounds(20, 260, 60,40);
//        mainPanel.add(btnFirst);
//
//        btnPrevious.setBounds(100, 260, 60,40);
//        mainPanel.add(btnPrevious);
//
//        btnNext.setBounds(180, 260, 60,40);
//        mainPanel.add(btnNext);
//
//        btnLast.setBounds(260, 260, 60,40);
//        mainPanel.add(btnLast);
//
//        this.add(mainPanel);
//
//    }
//    private void next(){
//        this.alumno = SpotifyController.next().orElse(null);
//        updateData();
//    }
//    private void previous(){
//        this.alumno = SpotifyController.previous().orElse(null);
//        updateData();
//    }
//    private void last(){
//        this.alumno = SpotifyController.last().orElse(null);
//        updateData();
//    }
//    private void first(){
//        this.alumno = SpotifyController.first().orElse(null);
//        updateData();
//    }*/
//    }
}
