package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.utilities.NameConverter;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class TrackController {
    public String trackIdSearch(String inputText) throws IOException {
        String trackName = NameConverter.spaceEraser(inputText);
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + trackName + "&type=track&limit=1";
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<TrackIdSearch> tracks = Collections.singletonList(gson.fromJson(js, TrackIdSearch.class));
        //ID return
        return JsonConverter.trackIdConverter(tracks);
    }
    public List<Track> trackSearch(String inputText) throws IOException {
        List<Track> tracks = new ArrayList<>();
        String id = trackIdSearch(inputText);
        String apiUrl = "https://api.spotify.com/v1/tracks/";
        String query = id;
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<Track> tracksList = Collections.singletonList(gson.fromJson(js, Track.class));
        for (Track track : tracksList) {
            tracks.add(track);
        }
        return tracks;
    }
}
