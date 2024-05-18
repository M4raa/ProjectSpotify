package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
       /* new SpringApplicationBuilder(Main.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);*/
        System.out.println(ArtistsController.artistSearch().getName());
        System.out.println(AlbumController.albumSearch().getArtists().getFirst().getName());
        System.out.println(TrackController.trackSearch().getArtists().getFirst().getName());
    }
}
