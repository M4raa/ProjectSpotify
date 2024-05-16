package jpaswing.projectspotiy.conn;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.entity.ArtistIdSearch;

import java.io.IOException;

public class JsonConverter {
    public static String artistConverter(JsonObject jsonObject) throws IOException {
        Gson gson = new Gson();
        ArtistIdSearch artist = gson.fromJson(jsonObject.getAsJsonObject(), ArtistIdSearch.class);
        return artist.getArtists().getItems().getFirst().getId();
    }
}
