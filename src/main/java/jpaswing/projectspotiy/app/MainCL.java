package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.controller.PlaylistController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.service.Globals;
import jpaswing.projectspotiy.ui.MusicPlayerUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.awt.*;
@Component
@ComponentScan(basePackages = "jpaswing")
public class MainCL implements CommandLineRunner {
    private final AlbumController albumController;
    private final ArtistsController artistsController;
    private final PlaylistController playlistController;
    private final TrackController trackController;
    private final Globals globals;
    @Autowired
    public MainCL(AlbumController albumController, ArtistsController artistsController, PlaylistController playlistController,
                  TrackController trackController,
                  Globals globals) {
        this.albumController = albumController;
        this.artistsController = artistsController;
        this.playlistController = playlistController;
        this.trackController = trackController;
        this.globals = globals;
    }
    @Override
    public void run(String... args) {
        EventQueue.invokeLater(()  -> {
                new MusicPlayerUI(globals).setVisible(true);
        });
    }

}
