package jpaswing.projectspotiy.utilities;

import com.google.gson.JsonObject;
import jpaswing.projectspotiy.controller.AlbumController;
import jpaswing.projectspotiy.controller.ArtistsController;
import jpaswing.projectspotiy.controller.playlistController;
import jpaswing.projectspotiy.controller.PlaylistController;
import jpaswing.projectspotiy.controller.TrackController;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.entityContent.entity.several.*;
import org.hibernate.sql.Restriction;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SearchMethods {
    final PlaylistController playlistController = new PlaylistController();
    final ArtistsController artistsController = new artistsController();
    final AlbumController albumController = new AlbumController();
    final TrackController trackController = new TrackController();
    //GENERAL
    public List<Object> grandSearch(String id) throws IOException {
        //ArtistSearch
        List<Artist> artists = new ArrayList<>(artistsController.artistSearch(id));
        //PlaylistSearch
        List<Playlist> playlist = Collections.singletonList(playlistController.playlistsSearch(id));
        //TrackSearch
        List<Track> tracks = new ArrayList<>(trackController.trackSearch(id));
        //AlbumSearch
        List<Album> albums = new ArrayList<>(albumController.albumSearch(id));
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
    public String artistHref(String id) throws IOException {
        return artistsController.artistById(id).getHref();
    }
    public int artistId(String id) throws IOException {
        return Integer.parseInt(artistsController.artistById(id).getId());
    }
    public String artistName(String id) throws IOException {
        return artistsController.artistById(id).getName();
    }
    public String artistType(String id) throws IOException {
        return artistsController.artistById(id).getType();
    }
    public String artistUri(String id) throws IOException {
        return artistsController.artistById(id).getUri();
    }
    public Followers artistFollowers(String id) throws IOException {
        return artistsController.artistById(id).getFollowers();
    }
    public List<String> artistGeneres(String id) throws IOException {
        return artistsController.artistById(id).getGenres();
    }
    public List<Image> artistImages(String id) throws IOException {
        return artistsController.artistById(id).getImages();
    }
    public ExternalUrls artistExternalUrls(String id) throws IOException {
        return artistsController.artistById(id).getExternalUrls();
    }
    public int artistPopularity(String id) throws IOException {
        return artistsController.artistById(id).getPopularity();
    }

    //TRACKS
    public String trackPreviewUrl(String id) throws IOException {
        return trackController.trackById(id)
    }
    public List<Artist> trackArtists(String id) throws IOException {
        return trackController.trackById(id)
    }
    public String trackName(String id) throws IOException {
        return trackController.trackById(id)
    }
    public int trackId(String id) throws IOException {
        return trackController.trackById(id)
    }
    public String trackHref(String id) throws IOException {
        return trackController.trackById(id)
    }
    public Album trackAlbum(String id) throws IOException {
        return trackController.trackById(id)
    }
    public List<String> trackAvailableMarkets(String id) throws IOException {
        return trackController.trackById(id)
    }
    public int trackDiscNumbre(String id) throws IOException {
        trackController.trackById(id).getDiscNumber()
    }
    public double trackDurationMs(String id) throws IOException {
        return trackController.trackById(id).getDurationMs();
    }
    public ExternalIds trackExternalIds(String id) throws IOException {
        return trackController.trackById(id).getExternalIds();
    }
    public ExternalUrls trackExternalUrls(String id) throws IOException {
        return trackController.trackById(id).getExternalUrls();
    }
    public JsonObject trackLinkedFrom(String id) throws IOException {
        return trackController.trackById(id).getLinkedFrom();
    }
    public int trackPopularity(String id) throws IOException {
        return trackController.trackById(id).getPopularity();
    }
    public Restrictions trackRestrictions(String id) throws IOException {
        return (Restrictions) trackController.trackById(id).getRestrictions();
    }
    public int trackNumber(String id) throws IOException {
        return trackController.trackById(id).getTrackNumber();
    }
    public String trackType(String id) throws IOException {
        return trackController.trackById(id).getType();
    }
    public String trackUri(String id) throws IOException {
        return trackController.trackById(id).getUri();
    }

    //ALBUMS
    public int albumId(String id) throws IOException {
        return Integer.parseInt(albumController.albumById(id).getId());
    }
    public List<Artist> albumArtists(String id) throws IOException {
        return albumController.albumById(id).getArtists();
    }
    public List<Image> albumImages(String id) throws IOException {
        return albumController.albumById(id).getImages();
    }
    public String albumAlbumType(String id) throws IOException {
        return albumController.albumById(id).getAlbumType();
    }
    public String albumName(String id) throws IOException {
        return albumController.albumById(id).getName();
    }
    public List<String> albumAvailableMarkets(String id) throws IOException {
        return albumController.albumById(id).getAvailableMarkets();
    }
    public List<Copyright> albumCopyright(String id) throws IOException {
        return albumController.albumById(id).getCopyrights();
    }
    public ExternalIds albumExternalIds(String id) throws IOException {
        return albumController.albumById(id).getExternalIds();
    }
    public ExternalUrls albumExternalUrls(String id) throws IOException {
        return albumController.albumById(id).getExternalUrls();
    }
    public List<String> albumGeneres(String id) throws IOException {
        return albumController.albumById(id).getGenres();
    }
    public String albumHref(String id) throws IOException {
        return albumController.albumById(id).getHref();
    }
    public String albumLabel(String id) throws IOException {
        return albumController.albumById(id).getLabel();
    }
    public int albumPopularity(String id) throws IOException {
        return albumController.albumById(id).getPopularity();
    }
    public String albumReleaseDate(String id) throws IOException {
        return albumController.albumById(id).getReleaseDate();
    }
    public String albumReleaseDatePrecision(String id) throws IOException {
        return albumController.albumById(id).getReleaseDatePrecision();
    }
    public Restrictions albumRestrictions(String id) throws IOException {
        return (Restrictions) albumController.albumById(id).getRestrictions();
    }
    public int albumTotalTracks(String id) throws IOException {
        return albumController.albumById(id).getTotalTracks();
    }
    public TrackIdSearch.Tracks albumTracks(String id) throws IOException {
        return albumController.albumById(id).getTracks();
    }
    public String albumType(String id) throws IOException {
        return albumController.albumById(id).getType();
    }
    public String albumUri (String id) throws IOException {
        return albumController.albumById(id).getUri();
    }
    //PLAYLISTS
    public PlaylistTrack.Tracks playlistTracks(String id) throws IOException {
        return playlistController.playlistById(id).getPlaylistTracks();
    }
    public String playlistName(String id) throws IOException {
        return playlistController.playlistById(id).getName();
    }
    public int playlistId(String id) throws IOException {
        return Integer.parseInt(playlistController.playlistById(id).getId());
    }
    public String playlistHref(String id) throws IOException {
        return playlistController.playlistById(id).getHref();
    }
    public List<Image> playlistImages(String id) throws IOException {
        return playlistController.playlistById(id).getImages();
    }
    public String playlistDescription(String id) throws IOException {
        return playlistController.playlistsSearch(id).getDescription();
    }
    public ExternalUrls playlistExternalUrls(String id) throws IOException {
        return playlistController.playlistById(id).getExternalUrls();
    }
    public Owner playlistOwner(String id) throws IOException {
        return playlistController.playlistById(id).getOwner();
    }
    public String playlistSnapshotId(String id) throws IOException {
        return playlistController.playlistById(id).getSnapshotId();
    }
    public String playlistType(String id) throws IOException {
        return playlistController.playlistById(id).getType();
    }
    public String playlistUri(String id) throws IOException {
        return playlistController.playlistById(id).getUri();
    }
}
