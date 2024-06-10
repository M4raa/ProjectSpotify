package jpaswing.projectspotiy.entityContent.SpotifyResponse;
import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.Artist;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class ArtistIdSearch implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static class Artists implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        @SerializedName("href")
        private String href;

        @SerializedName("items")
        private List<Artist> items;

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

        //Constructor


        public Artists() {
        }

        public Artists(String href, List<Artist> items, int limit, String next, int offset, String previous, int total) {
            this.href = href;
            this.items = items;
            this.limit = limit;
            this.next = next;
            this.offset = offset;
            this.previous = previous;
            this.total = total;
        }

        // Getters and Setters
        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public List<Artist> getItems() {
            return items;
        }

        public void setItems(List<Artist> items) {
            this.items = items;
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
    }

    @SerializedName("artists")
    private Artists artists;

    //Contructor

    public ArtistIdSearch() {
    }

    public ArtistIdSearch(Artists artists) {
        this.artists = artists;
    }

    // Getters and Setters
    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}
