package jpaswing.projectspotiy.entityContent.SpotifyResponse;

import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.Playlist;

import java.util.List;

public class PlaylistIdSearch {
    public class Playlists {
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

        @SerializedName("items")
        private List<Playlist> items;

        //Contructor
        public Playlists() {
        }

        public Playlists(String href, int limit, String next, int offset, String previous, int total, List<Playlist> items) {
            this.href = href;
            this.limit = limit;
            this.next = next;
            this.offset = offset;
            this.previous = previous;
            this.total = total;
            this.items = items;
        }

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
            return items;
        }

        public void setPlaylists(List<Playlist> items) {
            this.items = items;
        }
    }
    @SerializedName("playlists")
    private Playlists playlists;

    //Constructor
    public PlaylistIdSearch(){}

    public PlaylistIdSearch(Playlists playlists) {
        this.playlists = playlists;
    }

    // Getters and Setters
    public Playlists getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlists playlists) {
        this.playlists = playlists;
    }
}
