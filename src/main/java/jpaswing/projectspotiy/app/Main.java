package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.utilities.SearchMethods;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        //new SpringApplicationBuilder(Main.class)
        //        .headless(false)
        //        .web(WebApplicationType.NONE)
        //        .run(args);
        Scanner sc = new Scanner(System.in);

        System.out.println("nombre:");
        String name = sc.nextLine();
        SearchMethods searchMethods = new SearchMethods();
        searchMethods.grandSearch(name);
    }
}