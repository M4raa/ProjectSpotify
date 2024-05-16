package jpaswing.projectspotiy.entity.varios;

import com.google.gson.annotations.SerializedName;

public class ExternalUrls {
    @SerializedName("spotify")
    private String spotify;

    // Getters and Setters
    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }
}
