package jpaswing.projectspotiy.utilities;

import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.controller.PlaylistController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.entityContent.entity.several.ExternalUrls;
import jpaswing.projectspotiy.entityContent.entity.several.Followers;
import jpaswing.projectspotiy.entityContent.entity.several.Image;
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
    //GENERAL
    public void grandSearch(String inputText) throws IOException {
        //ArtistSearch
        List<Artist> artists = new ArrayList<>(artistsController.artistSearch(inputText));
        //PlaylistSearch
        List<Playlist> playlist = Collections.singletonList(playlistController.playlistsSearch(inputText));
        //TrackSearch
        List<Track> tracks = new ArrayList<>(trackController.trackSearch(inputText));
        //AlbumSearch
        List<Album> albums = new ArrayList<>(albumController.albumSearch(inputText));
        //Group
        ArrayList<List> group = new ArrayList<>();
        group.add(artists);
        group.add(playlist);
        group.add(tracks);
        group.add(albums);
        for (List list : group) {
            for (Object object : list) {
                if (object instanceof Artist) {
                    System.out.println("Artist - " + ((Artist) object).getName());
                } else if (object instanceof Album) {
                    System.out.println("Album - " + ((Album) object).getName());
                } else if (object instanceof Track) {
                    System.out.println("Track - " + ((Track) object).getName());
                } else if (object instanceof Playlist) {
                    System.out.println("Playlist - " + ((Playlist) object).getName());
                }
            }
        }
    }

    //ARTISTS
    public String artistHref(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getHref();
    }
    public int artistId(String inputText) throws IOException {
        return Integer.parseInt(artistsController.artistSearch(inputText).getFirst().getId());
    }
    public String artistName(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getName();
    }
    public String artistType(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getType();
    }
    public String artistUri(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getUri();
    }
    public Followers artistFollowers(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getFollowers();
    }
    public List<String> artistGeneres(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public List<Image> artistImages(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public ExternalUrls artistExternalUrls(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public int artistPopularity(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }

    //TRACKS
    public String trackPreviewUrl(String inputText) throws IOException {
        return Integer.parseInt(artistsController.artistSearch(inputText).getFirst().getId());
    }
    public List<Artist> trackArtists(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getName();
    }
    public String trackName(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getType();
    }
    public int trackId(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getUri();
    }
    public String trackHref(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getFollowers();
    }
    public List<String> artistGeneres(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public List<Image> artistImages(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public ExternalUrls artistExternalUrls(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public int artistPopularity(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    //ALBUMS
    public String artistHref(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getHref();
    }
    public int artistId(String inputText) throws IOException {
        return Integer.parseInt(artistsController.artistSearch(inputText).getFirst().getId());
    }
    public String artistName(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getName();
    }
    public String artistType(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getType();
    }
    public String artistUri(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getUri();
    }
    public Followers artistFollowers(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getFollowers();
    }
    public List<String> artistGeneres(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public List<Image> artistImages(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public ExternalUrls artistExternalUrls(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public int artistPopularity(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    //PLAYLISTS

}
