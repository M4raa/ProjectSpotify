package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.controller.*;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
       /* new SpringApplicationBuilder(Main.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);*/
        //System.out.println(ArtistsController.artistSearch().getName());
        ArtistsController.artistSearch().forEach(artist -> System.out.println(artist.getGenres()));
        AlbumController.albumSearch().forEach(album -> System.out.println(album.getTracks().toString()));
        TrackController.trackSearch().forEach(track -> System.out.println(track.getArtists()));
        PlaylistController.playlistsSearch().forEach(playlist -> System.out.println(playlist.getTracks()));

        //System.out.println(TrackController.trackSearch().getArtists().getFirst().getName());
    }
}
