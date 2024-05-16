package jpaswing.projectspotiy;

import jpaswing.projectspotiy.controller.ItemSearch;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
       /* new SpringApplicationBuilder(Main.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);*/
        System.out.println(ItemSearch.artistIdSearch());
    }
}