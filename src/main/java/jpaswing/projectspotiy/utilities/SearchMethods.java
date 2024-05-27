package jpaswing.projectspotiy.utilities;

import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.controller.PlaylistController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SearchMethods {
    final PlaylistController playlistController = new PlaylistController();
    final ArtistsController artistsController = new ArtistsController();
    final AlbumController albumController = new AlbumController();
    final TrackController trackController = new TrackController();
    public void grandSearch(String textSearch) throws IOException {
        //ArtistSearch
        List<Artist> artists = new ArrayList<>(artistsController.artistSearch(textSearch));
        //PlaylistSearch
        List<Playlist> playlist = Collections.singletonList(playlistController.playlistsSearch(textSearch));
        //TrackSearch
        List<Track> tracks = new ArrayList<>(trackController.trackSearch(textSearch));
        //AlbumSearch
        List<Album> albums = new ArrayList<>(albumController.albumSearch(textSearch));
        //Group
        ArrayList<List> group = new ArrayList<>();
        group.add(artists);
        group.add(playlist);
        group.add(tracks);
        group.add(albums);
        for (List list : group) {
            for (Object object : list) {
                System.out.println(object);
            }
        }
    }
    public void seeStats(String inputText) throws IOException {
        albumController.albumSearch(inputText).forEach(song -> System.out.println(song));
    }
}
