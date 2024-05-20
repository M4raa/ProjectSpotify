package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.utilities.NameConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class ArtistsControllerPrueba {
    public static List<String> artistIdSearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter artist name: ");
        String artistName = NameConverter.spaceEraser(sc.nextLine());
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + artistName + "&type=artist&limit=1";
        String uri = apiUrl + query;
        JsonObject jsonObject = UrlConnection.getUrlConnection(uri);
        //ID return
        String id = JsonConverter.artistIdConverter(jsonObject);
        if (id==null){
            return "That artist does not exist";
        } return id;
    }
    public static Artist artistSearch() throws IOException {
        String id = artistIdSearch();
        Artist artist;
        String apiUrl = "https://api.spotify.com/v1/artists/";
        String query = id;
        String uri = apiUrl + query;
        JsonObject jsonObject = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        artist = gson.fromJson(jsonObject, Artist.class);
        return artist;
    }
}
