package jpaswing.projectspotiy.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.AlbumIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.ArtistIdSearch;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;

import java.io.IOException;

public class JsonConverter {
    public static String artistIdConverter(JsonObject jsonObject) throws IOException {
        Gson gson = new Gson();
        ArtistIdSearch artist = gson.fromJson(jsonObject.getAsJsonObject(), ArtistIdSearch.class);
        return artist.getArtists().getItems().getFirst().getId();
    }
    public static String albumIdConverter(JsonObject jsonObject) throws IOException {
        Gson gson = new Gson();
        AlbumIdSearch album = gson.fromJson(jsonObject.getAsJsonObject(), AlbumIdSearch.class);
        return album.getAlbums().getItems().getFirst().getId();
    }
    public static String trackIdConverter(JsonObject jsonObject) throws IOException {
        Gson gson = new Gson();
        TrackIdSearch track = gson.fromJson(jsonObject.getAsJsonObject(), TrackIdSearch.class);
        return track.getTracks().getItems().getFirst().getId();
    }
    /*public static String nextArtist(JsonObject jsonObject) throws IOException {
        Gson gson = new Gson();
        ArtistIdSearch artist = gson.fromJson(jsonObject.getAsJsonObject(), ArtistIdSearch.class);
        return artist.getArtists().getNext();
    }*/
}
