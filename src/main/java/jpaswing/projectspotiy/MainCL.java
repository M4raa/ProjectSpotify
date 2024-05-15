package jpaswing.projectspotiy;

import jpaswing.projectspotiy.controller.SpotifyController;
import jpaswing.projectspotiy.ui.mainUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.awt.*;


public class MainCL implements CommandLineRunner {
    private SpotifyController spotifyController;
    @Autowired
    public MainCL(SpotifyController spotifyController) {
        this.spotifyController = spotifyController;
    }
    @Override
    public void run(String... args) throws Exception {
        EventQueue.invokeLater(()  ->  new mainUI(spotifyController).setVisible(true));
    }
}
