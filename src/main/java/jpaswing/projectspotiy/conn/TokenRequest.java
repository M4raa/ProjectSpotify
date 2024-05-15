package jpaswing.projectspotiy.conn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.*;

public class TokenRequest {
//    public static void main(String[] args) throws IOException {
//        final String client_id= "3997a7d851b941d9bd66c90548816d04";
//        final String client_secret= "621de2aa072547bf98e46269daa0f062";
//        getToken(client_id,client_secret);
//    }

    public void getToken(/*String client_id, String client_secret*/) throws IOException {
        final String client_id= "3997a7d851b941d9bd66c90548816d04";
        final String client_secret= "621de2aa072547bf98e46269daa0f062";
        String auth_string = client_id + ":" + client_secret;
        byte[] auth_bytes = auth_string.getBytes(StandardCharsets.UTF_8);
        String auth_base64 = Base64.getEncoder().encodeToString(auth_bytes);
        String apiUrl = "https://accounts.spotify.com/api/token";
        String token=null;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Basic " + auth_base64);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);
        String postData = "grant_type=client_credentials";

        try (DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream())) {
            outputStream.write(postData.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }

        // Response code
        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JSONTokener tokener = new JSONTokener(line);
                JSONObject json = new JSONObject(tokener);
                // Extract access_token
                token = json.getString("access_token");
            }
            System.out.println("Successfull!");
            System.out.println("Extracting token from response...");

            System.out.println("Token: " + token);
        }

        // Close con
        conn.disconnect();
    }
}
