package jpaswing.projectspotiy.conn;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenRequest {
    static String client_id = "";
    static String client_secret = "";

    public static void getCred() throws IOException {
        InputStream is = getFileFromResourceAsStream("application.properties");
        Properties prop = new Properties();

        // load a properties file
        prop.load(is);

        // get the property value and print it out
        client_id = prop.getProperty("spotify.client_id");
        client_secret = prop.getProperty("spotify.client_secret");
    }

    private static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = TokenRequest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public static String getToken() throws IOException {
        getCred();
        String auth_string = client_id + ":" + client_secret;
        byte[] auth_bytes = auth_string.getBytes(StandardCharsets.UTF_8);
        String auth_base64 = Base64.getEncoder().encodeToString(auth_bytes);
        String apiUrl = "https://accounts.spotify.com/api/token";
        String token = null;
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
            System.out.println("Token request succsesfull!\n");
            // Close con
            conn.disconnect();
            return token;
        }
    }
}
