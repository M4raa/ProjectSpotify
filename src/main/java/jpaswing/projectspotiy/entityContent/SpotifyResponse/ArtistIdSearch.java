package jpaswing.projectspotiy.entityContent.SpotifyResponse;
import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.Artist;

import java.util.List;

public class ArtistIdSearch {
    public static class Artists {
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

    // Getters and Setters
    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}
