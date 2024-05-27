package jpaswing.projectspotiy.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.AlbumIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.ArtistIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.PlaylistIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonConverter {
    public static String artistIdConverter(List<ArtistIdSearch> artists) throws IOException {
        String artistIds = "";
        for (int i = 0; i < artists.getFirst().getArtists().getItems().size(); i++) {
            String id = artists.getFirst().getArtists().getItems().get(i).getId();
            if(artistIds.isEmpty()){
                artistIds += id;
            } else {
                if (!id.isBlank()) {
                    artistIds += ","+id;
                } else return artistIds;
            }
        }
        return artistIds;
    }
    public static List<Artist> artistConverter(JsonArray artists) throws IOException {
        List<Artist> artistList = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < artists.size(); i++) {
            artistList.add(gson.fromJson(artists.get(i), Artist.class));
        }
        return artistList;
    }
    public static String albumIdConverter(List<AlbumIdSearch> albums) throws IOException {
        String albumsIds = "";
        for (int i = 0; i < albums.getFirst().getAlbums().getItems().size(); i++) {
            String id = albums.getFirst().getAlbums().getItems().get(i).getId();
            if(albumsIds.isEmpty()){
                albumsIds += id;
            } else {
                if (!id.isBlank()) {
                    albumsIds += ","+id;
                } else return albumsIds;
            }
        }
        return albumsIds;
    }
    public static List<Album> albumConverter(JsonArray albums) throws IOException {
        List<Album> albumList = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < albums.size(); i++) {
            albumList.add(gson.fromJson(albums.get(i), Album.class));
        }
        return albumList;
    }
    public static String trackIdConverter(List<TrackIdSearch> tracks) throws IOException {
        String tracksIds = "";
        for (int i = 0; i < tracks.getFirst().getTracks().getItems().size(); i++) {
            String id = tracks.getFirst().getTracks().getItems().get(i).getId();
            if(tracksIds.isEmpty()){
                tracksIds += id;
            } else {
                if (!id.isBlank()) {
                    tracksIds += ","+id;
                } else return tracksIds;
            }
        }
        return tracksIds;
    }
    public static List<Track> trackConverter(JsonArray tracks) throws IOException {
        List<Track> trackList = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < tracks.size(); i++) {
            trackList.add(gson.fromJson(tracks.get(i), Track.class));
        }
        return trackList;
    }
    public static String playlistIdConverter(List<PlaylistIdSearch> playlists) throws IOException {
        String playlistsIds = "";
        for (int i = 0; i < playlists.getFirst().getPlaylists().getItems().size(); i++) {
            String id = playlists.getFirst().getPlaylists().getItems().get(i).getId();
            if(playlistsIds.isEmpty()){
                playlistsIds += id;
            } else {
                if (!id.isBlank()) {
                    playlistsIds += ","+id;
                } else return playlistsIds;
            }
        }
        return playlistsIds;
    }
    /*public static List<Playlist> playlistConverter(JsonArray playlists) throws IOException {
        List<Playlist> playlistList = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < playlists.size(); i++) {
            playlistList.add(gson.fromJson(playlists.get(i), Playlist.class));
        }
        return playlistList;
    }*/
}
