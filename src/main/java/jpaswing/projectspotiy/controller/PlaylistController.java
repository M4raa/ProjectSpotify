package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.PlaylistIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.utilities.NameConverter;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class PlaylistController {
    public String playlistIdSearch(String inputText) throws IOException {
        String playlistName = NameConverter.spaceEraser(inputText);
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + playlistName + "&type=playlist&limit=1";
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<PlaylistIdSearch> playlists = Collections.singletonList(gson.fromJson(js, PlaylistIdSearch.class));
        //ID return
        return JsonConverter.playlistIdConverter(playlists);
    }
    public Playlist playlistsSearch(String inputText) throws IOException {
        String id = playlistIdSearch(inputText);
        String apiUrl = "https://api.spotify.com/v1/playlists/";
        String query = id;
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        Playlist playlist = gson.fromJson(js, Playlist.class);
        return playlist;
    }
}
