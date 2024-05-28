package jpaswing.projectspotiy.utilities;

import com.google.gson.JsonObject;
import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.controller.PlaylistController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.entityContent.entity.several.*;
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
    public List<Object> grandSearch(String inputText) throws IOException {
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
        List<Object> result = new ArrayList<>();
        for (List list : group) {
            for (Object object : list) {
                result.add(object);
            }
        }
        return result;
    }
    /*if (object instanceof Artist) {
        System.out.println("Artist - " + ((Artist) object).getName());
    } else if (object instanceof Album) {
        System.out.println("Album - " + ((Album) object).getName());
    } else if (object instanceof Track) {
        System.out.println("Track - " + ((Track) object).getName());
    } else if (object instanceof Playlist) {
        System.out.println("Playlist - " + ((Playlist) object).getName());
    }*/
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
    public Album trackAlbum(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public List<String> trackAvailableMarkets(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public int trackDiscNumbre(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public double trackDurationMs(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    public ExternalIds trackExternalIds(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public ExternalUrls trackExternalUrls(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public JsonObject trackLinkedFrom(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public int trackPopularity(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    public Restrictions trackRestrictions(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public int trackNumber(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public String trackType(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public String trackUri(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }

    //ALBUMS
    public int albumId(String inputText) throws IOException {
        return Integer.parseInt(artistsController.artistSearch(inputText).getFirst().getId());
    }
    public List<Artist> albumArtists(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getName();
    }
    public List<Image> albumImages(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getType();
    }
    public String albumType(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getUri();
    }
    public String albumName(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getFollowers();
    }
    public List<String> albumAvailableMarkets(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public List<Copyright> albumCopyright(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public ExternalIds albumExternalIds(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public ExternalUrls albumExternalUrls(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    public List<String> albumGeneres(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public String albumHref(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public String albumLabel(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public int albumPopularity(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    public String albumReleaseDate(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public String albumReleaseDatePrecision(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public Restrictions albumRestrictions(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public int albumTotalTracks(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    public Track albumTracks(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public String albumType(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public String albumUri (String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    //PLAYLISTS
    public PlaylistTrack.Tracks playlistTracks(String inputText) throws IOException {
        return playlistController.playlistsSearch(inputText).getId();
    }
    public String playlistName(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getName();
    }
    public int playlistId(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getType();
    }
    public String playlistHref(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getUri();
    }
    public List<Image> playlistImages(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getFollowers();
    }
    public String playlistDescription(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public ExternalUrls playlistExternalUrls(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
    public Owner playlistOwner(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getExternalUrls();
    }
    public String playlistSnapshotId(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getPopularity();
    }
    public String playlistType(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getGenres();
    }
    public String playlistUri(String inputText) throws IOException {
        return artistsController.artistSearch(inputText).getFirst().getImages();
    }
}
