package jpaswing.projectspotiy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.PlaylistIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.service.UrlConnection;
import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.utilities.NameConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlaylistController {
    public static String playlistIdSearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter playlist name: ");
        String playlistName = NameConverter.spaceEraser(sc.nextLine());
        String apiUrl = "https://api.spotify.com/v1/search";
        String query = "?q=" + playlistName + "&type=playlist&limit=10";
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<PlaylistIdSearch> playlists = Collections.singletonList(gson.fromJson(js, PlaylistIdSearch.class));
        //ID return
        return JsonConverter.playlistIdConverter(playlists);
    }
    public static List<Playlist> playlistsSearch() throws IOException {
        List<Playlist> playlists = new ArrayList<>();
        String id = playlistIdSearch();
        String apiUrl = "https://api.spotify.com/v1/playlists/";
        String query = id;
        String uri = apiUrl + query;
        JsonObject js = UrlConnection.getUrlConnection(uri);
        Gson gson = new Gson();
        List<Playlist> playlistList = Collections.singletonList(gson.fromJson(js, Playlist.class));
        for (Playlist playlist : playlistList) {
            playlists.add(playlist);
        }
        return playlists;
    }
}
