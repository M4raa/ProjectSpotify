package jpaswing.projectspotiy.conn;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jpaswing.projectspotiy.controller.ItemSearch;
import jpaswing.projectspotiy.entity.Artist;

import java.io.IOException;

public class JsonConverter {
    public static Artist artistConverter(JsonObject jsonObject) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, Artist.class);
    }
}
