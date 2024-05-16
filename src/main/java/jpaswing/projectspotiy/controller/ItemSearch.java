package jpaswing.projectspotiy.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jpaswing.projectspotiy.conn.Authorization;
import jpaswing.projectspotiy.conn.JsonConverter;
import jpaswing.projectspotiy.conn.TokenRequest;
import jpaswing.projectspotiy.entity.Artist;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


@Component
public class ItemSearch {
    public static Artist artistSearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter artist name: ");
        String artistName = sc.nextLine();
        String apiUrl = "https://api.spotify.com/v1/search";
        String bearer = Authorization.getBearer();
        String query = "?q=" + artistName + "&type=artist&limit=1";
        String uri = apiUrl + query;
        URL url = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization",bearer);
        // Response code
        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line="";
            StringBuilder json = new StringBuilder();
            json.append(line);
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            // Close con
            conn.disconnect();
            JsonObject jsonObject = JsonParser.parseString(json.toString()).getAsJsonObject();
            Artist artist = JsonConverter.artistConverter(jsonObject);
            return artist;
        }
    }

}
