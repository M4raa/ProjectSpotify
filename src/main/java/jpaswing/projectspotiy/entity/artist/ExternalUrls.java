package jpaswing.projectspotiy.entity.artist;

public class ExternalUrls{
    public String spotify;

    public ExternalUrls(String spotify) {
        this.spotify = spotify;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    @Override
    public String toString() {
        return "ExternalUrls: " +spotify;
    }
}