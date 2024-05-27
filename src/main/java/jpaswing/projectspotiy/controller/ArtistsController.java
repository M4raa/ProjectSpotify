package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.ArtistIdSearch;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.utilities.NameConverter;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class ArtistsController {
    public String artistIdSearch(String inputText) throws IOException {
        String artistName = NameConverter.spaceEraser(inputText);
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + artistName + "&type=artist&limit=15";
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<ArtistIdSearch> artists = Collections.singletonList(gson.fromJson(js, ArtistIdSearch.class));
        //ID return
        return JsonConverter.artistIdConverter(artists);
    }
    public List<Artist> artistSearch(String inputText) throws IOException {
        List<Artist> artists = new ArrayList<>();
        String artistsIds = artistIdSearch(inputText);
        String apiUrl = "https://api.spotify.com/v1/artists/";
        String query = artistsIds;
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<Artist> artistList = Collections.singletonList(gson.fromJson(js, Artist.class));
        for (Artist artist : artistList) {
            artists.add(artist);
        }
        return artists;
    }
}
