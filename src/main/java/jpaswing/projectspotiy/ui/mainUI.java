package jpaswing.projectspotiy.ui;

import jpaswing.projectspotiy.conn.JsonConverter;
import jpaswing.projectspotiy.conn.TokenRequest;
import jpaswing.projectspotiy.controller.SpotifyController;
import javax.swing.*;

public class mainUI  extends JFrame {
    private JPanel mainPanel;
    private JTextField txtNombre;
    private JTextField txtNota;
    private JButton btnFirst;
    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnLast;
    private SpotifyController spotifyController;
    private TokenRequest tokenRequest;
    private JsonConverter jsonConverter;
    public mainUI(TokenRequest tokenRequest, JsonConverter jsonConverter)  {
        this.tokenRequest = tokenRequest;
        this.jsonConverter = jsonConverter;
        setTitle("Notas Alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        initComponents();
        //updateData();
    }
    /*private void updateData(){
        txtNota.setText(Long.toString(this.alumno.getNotaMedia()));
        txtNombre.setText(this.spotifyController.getNombre());
    }*/
    private void initComponents(){
        mainPanel = new JPanel();
        txtNombre = new JTextField(10);
        txtNota= new JTextField(10);
        JLabel l;

        this.setLayout(null);
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 500, 650);

        l = new JLabel("Name:");
        l.setBounds(10, 40, 70, 20);
        mainPanel.add(l);
        txtNombre.setBounds(10 + 80, 40, 200, 20 );
        mainPanel.add(txtNombre);

        l = new JLabel("ID:");
        l.setBounds(10, 10, 70, 20);
        mainPanel.add(l);
        txtNota.setEnabled(false);
        txtNota.setBounds(10 + 80, 10, 200, 20);
        mainPanel.add(txtNota);
/*
        btnFirst = new JButton("<<");
        btnFirst.addActionListener(e -> first());
        btnPrevious = new JButton("<");
        btnPrevious.addActionListener(e -> previous());
        btnNext = new JButton(">");
        btnNext.addActionListener(e -> next());
        btnLast = new JButton(">>");
        btnLast.addActionListener(e -> last());
        btnFirst.setBounds(20, 260, 60,40);
        mainPanel.add(btnFirst);

        btnPrevious.setBounds(100, 260, 60,40);
        mainPanel.add(btnPrevious);

        btnNext.setBounds(180, 260, 60,40);
        mainPanel.add(btnNext);

        btnLast.setBounds(260, 260, 60,40);
        mainPanel.add(btnLast);

        this.add(mainPanel);

    }
    private void next(){
        this.alumno = SpotifyController.next().orElse(null);
        updateData();
    }
    private void previous(){
        this.alumno = SpotifyController.previous().orElse(null);
        updateData();
    }
    private void last(){
        this.alumno = SpotifyController.last().orElse(null);
        updateData();
    }
    private void first(){
        this.alumno = SpotifyController.first().orElse(null);
        updateData();
    }*/
    }
}
