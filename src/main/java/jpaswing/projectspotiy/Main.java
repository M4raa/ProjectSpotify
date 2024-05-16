package jpaswing.projectspotiy;

import jpaswing.projectspotiy.conn.Authorization;
import jpaswing.projectspotiy.conn.JsonConverter;
import jpaswing.projectspotiy.controller.ItemSearch;
import jpaswing.projectspotiy.entity.Artist;
import jpaswing.projectspotiy.entity.artist.Item;
import org.json.JSONObject;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
       /* new SpringApplicationBuilder(Main.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);*/
        Artist artist = JsonConverter.artistConverter();
    }
}
