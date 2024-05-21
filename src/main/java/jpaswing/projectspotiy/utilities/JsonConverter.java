package jpaswing.projectspotiy.utilities;

import jpaswing.projectspotiy.entityContent.SpotifyResponse.AlbumIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.ArtistIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.PlaylistIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;

import java.io.IOException;
import java.util.List;

public class JsonConverter {
    public static String artistIdConverter(List<ArtistIdSearch> artists) throws IOException {
        String artistIds = "";
        for (ArtistIdSearch artist : artists) {
            String id = artist.getArtists().getArtists().get(0).getId();
            if(artistIds.isEmpty()){
                artistIds += id;
            } else {
                if (!id.isBlank()) {
                    artistIds += ",";
                } else return artistIds;
            }
        }
        return artistIds;
    }
    public static String albumIdConverter(List<AlbumIdSearch> albums) throws IOException {
        String albumsIds = "";
        for (AlbumIdSearch album : albums) {
            String id = album.getAlbums().getAlbums().get(0).getId();
            if(albumsIds.isEmpty()){
                albumsIds += id;
            } else {
                if (!id.isBlank()) {
                    albumsIds += ",";
                } else return albumsIds;
            }
        }
        return albumsIds;
    }
    public static String trackIdConverter(List<TrackIdSearch> tracks) throws IOException {
        String tracksIds = "";
        for (TrackIdSearch track : tracks) {
            String id = track.getTracks().getTracks().get(0).getId();
            if(tracksIds.isEmpty()){
                tracksIds += id;
            } else {
                if (!id.isBlank()) {
                    tracksIds += ",";
                } else return tracksIds;
            }
        }
        return tracksIds;
    }
    public static String playlistIdConverter(List<PlaylistIdSearch> playlists) throws IOException {
        String playlistIds = "";
        for (PlaylistIdSearch playlist : playlists) {
            String id = playlist.getPlaylists().get(0).getId();
            if(playlistIds.isEmpty()){
                playlistIds += id;
            } else {
                if (!id.isBlank()) {
                    playlistIds += ",";
                } else return playlistIds;
            }
        }
        return playlistIds;
    }
}
