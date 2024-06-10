package jpaswing.projectspotiy.entityContent.entity.several;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class ExternalUrls implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
