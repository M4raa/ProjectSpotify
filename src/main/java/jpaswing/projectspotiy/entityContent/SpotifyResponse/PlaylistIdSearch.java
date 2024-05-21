package jpaswing.projectspotiy.entityContent.SpotifyResponse;

import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.Playlist;

import java.util.List;

public class PlaylistIdSearch {

    @SerializedName("href")
    private String href;

    @SerializedName("limit")
    private int limit;

    @SerializedName("next")
    private String next;

    @SerializedName("offset")
    private int offset;

    @SerializedName("previous")
    private String previous;

    @SerializedName("total")
    private int total;

    @SerializedName("playlists")
    private List<Playlist> playlists;

    // Getters and setters
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

}
