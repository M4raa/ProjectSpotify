package jpaswing.projectspotiy.service;

import jpaswing.projectspotiy.entityContent.entity.Album;
import jpaswing.projectspotiy.entityContent.entity.Artist;
import jpaswing.projectspotiy.entityContent.entity.Playlist;
import jpaswing.projectspotiy.entityContent.entity.Track;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class Globals {
    private Album currentAlbum;
    private Artist currentArtist;
    private Track currentTrack;
    private Playlist currentPlaylist;
    private Stack<String> viewStack;
    private Stack<String> forwardStack;


    public Stack<String> getViewStack() {
        return viewStack;
    }

    public void setViewStack(Stack<String> viewStack) {
        this.viewStack = viewStack;
    }

    public Stack<String> getForwardStack() {
        return forwardStack;
    }

    public void setForwardStack(Stack<String> forwardStack) {
        this.forwardStack = forwardStack;
    }

    public Album getCurrentAlbum() {
        return currentAlbum;
    }

    public void setCurrentAlbum(Album currentAlbum) {
        this.currentAlbum = currentAlbum;
    }

    public Artist getCurrentArtist() {
        return currentArtist;
    }

    public void setCurrentArtist(Artist currentArtist) {
        this.currentArtist = currentArtist;
    }

    public Track getCurrentTrack() {
        return currentTrack;
    }

    public void setCurrentTrack(Track currentTrack) {
        this.currentTrack = currentTrack;
    }

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    public void setCurrentPlaylist(Playlist currentPlaylist) {
        this.currentPlaylist = currentPlaylist;
    }

}

