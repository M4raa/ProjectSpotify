package jpaswing.projectspotiy.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class UrlConnection {
    public static JsonObject getUrlConnection(String uri) throws IOException {
        String bearer = Authorization.getBearer();
        URL url = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization",bearer);
        // Response code
        int responseCode = conn.getResponseCode();

        // Read response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line = "";
            StringBuilder json = new StringBuilder();
            json.append(line);
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            // Close con
            conn.disconnect();
            return JsonParser.parseString(json.toString()).getAsJsonObject();
        }
    }
}
