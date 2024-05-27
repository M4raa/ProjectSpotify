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

@Component
public class SearchMethods {
    final PlaylistController playlistController = new PlaylistController();
    final ArtistsController artistsController = new ArtistsController();
    final AlbumController albumController = new AlbumController();
    final TrackController trackController = new TrackController();
    public void grandSearch(String textSearch) throws IOException {
        //ArtistSearch
        ArrayList<Artist> artists = new ArrayList<>();
        artistsController.artistSearch(textSearch).forEach(artists::add);

        //PlaylistSearch
        ArrayList<Playlist> playlists = new ArrayList<>();
        playlistController.playlistsSearch(textSearch).forEach(playlists::add);

        //TrackSearch
        ArrayList<Track> tracks = new ArrayList<>();
        trackController.trackSearch(textSearch).forEach(tracks::add);

        //AlbumSearch
        ArrayList<Album> albums = new ArrayList<>();
        albumController.albumSearch(textSearch).forEach(albums::add);

        //Group
        ArrayList<ArrayList> group = new ArrayList<>();
        group.add(artists);
        group.add(playlists);
        group.add(tracks);
        group.add(albums);
        for (ArrayList arrayList : group) {
            for (Object object : arrayList) {
                System.out.println(object);
            }
        }
    }

}
