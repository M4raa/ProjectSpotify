package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.controller.PlaylistController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.ui.MusicPlayerUI;
import jpaswing.projectspotiy.ui.PlayerUI2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.awt.*;
import java.io.IOException;
@Component
@ComponentScan(basePackages = "jpaswing")
public class MainCL implements CommandLineRunner {
    private final AlbumController albumController;
    private final ArtistsController artistsController;
    private final PlaylistController playlistController;
    private final TrackController trackController;
    @Autowired
    public MainCL(AlbumController albumController, ArtistsController artistsController, PlaylistController playlistController, TrackController trackController) {
        this.albumController = albumController;
        this.artistsController = artistsController;
        this.playlistController = playlistController;
        this.trackController = trackController;
    }
    @Override
    public void run(String... args) throws IOException {
        EventQueue.invokeLater(()  -> {
                new MusicPlayerUI().setVisible(true);
        });
    }

}
