package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.utilities.NameConverter;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Scanner;

@Component
public class TrackController {
    /*public static String trackIdSearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter track name: ");
        String trackName = NameConverter.spaceEraser(sc.nextLine());
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + trackName + "&type=track&limit=1";
        String uri = apiUrl + query;
        JsonObject jsonObject = UrlConnection.getUrlConnection(uri);
        //ID return
        String id = JsonConverter.trackIdConverter(jsonObject);
        if (id==null){
            return "That track does not exist";
        } return id;
    }
    public static Track trackSearch() throws IOException {
        String id = trackIdSearch();
        Track track;
        String apiUrl = "https://api.spotify.com/v1/tracks/";
        String query = id;
        String uri = apiUrl + query;
        JsonObject jsonObject = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        track = gson.fromJson(jsonObject, Track.class);
        return track;
    }*/
}
