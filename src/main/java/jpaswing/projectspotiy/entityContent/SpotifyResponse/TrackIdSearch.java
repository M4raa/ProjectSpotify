package jpaswing.projectspotiy.entityContent.SpotifyResponse;

import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.Track;

import java.util.List;

public class TrackIdSearch {
    public static class Tracks {
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

        @SerializedName("tracks")
        private List<Track> tracks;
        //Construtor
        public Tracks(){}

        public Tracks(String href, int limit, String next, int offset, String previous, int total, List<Track> tracks) {
            this.href = href;
            this.limit = limit;
            this.next = next;
            this.offset = offset;
            this.previous = previous;
            this.total = total;
            this.tracks = tracks;
        }


        // Getters and Setters

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

        public List<Track> getTracks() {
            return tracks;
        }

        public void setTracks(List<Track> tracks) {
            this.tracks = tracks;
        }
    }
    @SerializedName("tracks")
    private Tracks tracks;

    //Constructor
    public TrackIdSearch(){}

    public TrackIdSearch(Tracks tracks) {
        this.tracks = tracks;
    }

    // Getters and Setters
    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }
}
