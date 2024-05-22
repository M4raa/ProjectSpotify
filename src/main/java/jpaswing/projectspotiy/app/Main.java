package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.controller.*;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        new SpringApplicationBuilder(Main.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
        //ArtistsController.artistSearch().forEach(artist -> System.out.println(artist.getGenres()));
        //AlbumController.albumSearch().forEach(album -> album.getTracks().getItems().forEach(track -> System.out.println(track.getName())));
        //TrackController.trackSearch().forEach(track -> System.out.println(track.getArtists().getFirst().getName()));
        //PlaylistController.playlistsSearch().forEach(playlist -> playlist.getPlaylistTracks().getItems().forEach(trackItem -> System.out.println(trackItem.getTrack().getName())));
    }
}