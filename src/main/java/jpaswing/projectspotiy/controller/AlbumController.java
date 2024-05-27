package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.AlbumIdSearch;
import jpaswing.projectspotiy.utilities.NameConverter;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.entityContent.entity.Album;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class AlbumController {
    public  String albumIdSearch(String inputText) throws IOException {
        String albumName = NameConverter.spaceEraser(inputText);
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + albumName + "&type=album&limit=15";
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<AlbumIdSearch> albums = Collections.singletonList(gson.fromJson(js, AlbumIdSearch.class));
        //ID return
        return JsonConverter.albumIdConverter(albums);
    }
    public  List<Album> albumSearch(String inputText) throws IOException {
        List<Album> albums = new ArrayList<>();
        String id = albumIdSearch(inputText);
        String apiUrl = "https://api.spotify.com/v1/albums/";
        String query = id;
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<Album> albumList = Collections.singletonList(gson.fromJson(js, Album.class));
        for (Album album : albumList) {
            albums.add(album);
        }
        return albums;
    }
}


