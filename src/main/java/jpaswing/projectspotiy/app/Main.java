package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.utilities.SearchMethods;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        new SpringApplicationBuilder(Main.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}