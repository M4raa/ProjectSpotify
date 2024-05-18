package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.utilities.NameConverter;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.entityContent.entity.Album;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Scanner;

@Component
public class AlbumController {
    public static String albumIdSearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter album name: ");
        String albumName = NameConverter.spaceEraser(sc.nextLine());
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + albumName + "&type=album&limit=1";
        String uri = apiUrl + query;
        JsonObject jsonObject = UrlConnection.getUrlConnection(uri);
        //ID return
        String id = JsonConverter.albumIdConverter(jsonObject);
        if (id==null){
            return "That album does not exist";
        } return id;
    }
    public static Album albumSearch() throws IOException {
        String id = albumIdSearch();
        Album album;
        String apiUrl = "https://api.spotify.com/v1/albums/";
        String query = id;
        String uri = apiUrl + query;
        JsonObject jsonObject = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        album = gson.fromJson(jsonObject, Album.class);
        return album;
    }
}


