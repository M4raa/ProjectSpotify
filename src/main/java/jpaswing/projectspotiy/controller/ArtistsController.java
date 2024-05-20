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
    public static String artistIdSearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter artist name: ");
        String artistName = NameConverter.spaceEraser(sc.nextLine());
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + artistName + "&type=artist&limit=15";
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<ArtistIdSearch> artists = Collections.singletonList(gson.fromJson(js, ArtistIdSearch.class));
        //ID return
        return JsonConverter.artistIdConverter(artists);
    }
    public static List<Artist> artistSearch() throws IOException {
        List<Artist> artists = new ArrayList<>();
        String artistsIds = artistIdSearch();
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
