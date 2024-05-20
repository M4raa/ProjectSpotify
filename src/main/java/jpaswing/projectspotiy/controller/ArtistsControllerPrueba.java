package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.utilities.NameConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ArtistsControllerPrueba {
    public static String artistIdSearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter artist name: ");
        String artistName = NameConverter.spaceEraser(sc.nextLine());
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + artistName + "&type=artist&limit=15";
        String uri = apiUrl + query;
        Gson gson = new Gson();
        JsonObject js = gson.fromJson(UrlConnection.getUrlConnection(uri),JsonObject.class);
        JsonArray artistList = js.getAsJsonArray("artists");      //ID return
        String artistIds = "";
       for (JsonElement artist : artistList) {
            String id = JsonConverter.artistIdConverter(artist.getAsJsonObject());
            artistIds += id + ",";
        }
        return artistIds;
    }
    public static List<Artist> artistSearch() throws IOException {
        List<Artist> artists = new ArrayList<Artist>();
        String artistsIds = artistIdSearch();
        Artist artist;
        String apiUrl = "https://api.spotify.com/v1/artists/";
        String query = artistsIds;
        String uri = apiUrl + query;
        /*JsonArray jsonObject = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        for (JsonElement json : jsonObject) {
            artist = gson.fromJson(json, Artist.class);
            artists.add(artist);
        }*/
        return artists;
    }
}
