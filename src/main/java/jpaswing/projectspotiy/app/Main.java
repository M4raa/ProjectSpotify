package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.controller.*;
import jpaswing.projectspotiy.entityContent.SpotifyResponse.TrackIdSearch;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import jpaswing.projectspotiy.ui.PlayerUI;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

import static jpaswing.projectspotiy.controller.AlbumController.*;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        //new SpringApplicationBuilder(Main.class)
        //        .headless(false)
        //        .web(WebApplicationType.NONE)
        //        .run(args);
        Scanner sc = new Scanner(System.in);

        System.out.println("playlist:");
        String playlist = sc.nextLine();
        PlaylistController playlistController = new PlaylistController();
        System.out.println("------------Playlists-----------");
        System.out.println(playlistController.playlistsSearch(playlist).getName());
    }
}