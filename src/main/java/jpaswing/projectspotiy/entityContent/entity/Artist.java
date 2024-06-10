package jpaswing.projectspotiy.entityContent.entity;

import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.several.ExternalUrls;
import jpaswing.projectspotiy.entityContent.entity.several.Followers;
import jpaswing.projectspotiy.entityContent.entity.several.Image;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public  class Artist implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("external_urls")
    private ExternalUrls externalUrls;

    @SerializedName("followers")
    private Followers followers;

    @SerializedName("genres")
    private List<String> genres;

    @SerializedName("href")
    private String href;

    @SerializedName("id")
    private String id;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("name")
    private String name;

    @SerializedName("popularity")
    private int popularity;

    @SerializedName("type")
    private String type;

    @SerializedName("uri")
    private String uri;

    //Constructor
    public Artist() {}

    public Artist(ExternalUrls externalUrls, Followers followers, List<String> genres, String href, String id, List<Image> images, String name, int popularity, String type, String uri) {
        this.externalUrls = externalUrls;
        this.followers = followers;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }

    // Getters and Setters
    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}