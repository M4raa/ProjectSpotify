package jpaswing.projectspotiy.entity.artist;

public class ExternalUrls{
    public String spotify;

    public ExternalUrls(){}
    public ExternalUrls(String spotify) {
        this.spotify = spotify;
    }


    @Override
    public String toString() {
        return "ExternalUrls: " +spotify;
    }
}