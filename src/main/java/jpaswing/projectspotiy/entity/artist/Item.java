package jpaswing.projectspotiy.entity.artist;

import java.util.ArrayList;

public class Item{
    public ExternalUrls external_urls;
    public Followers followers;
    public ArrayList<String> genres;
    public String href;
    public String id;
    public ArrayList<Image> images;
    public String name;
    public int popularity;
    public String type;
    public String uri;

    public Item(){}
    public Item(ExternalUrls external_urls, Followers followers, ArrayList<String> genres, String href, String id, ArrayList<Image> images, String name, int popularity, String type, String uri) {
        this.external_urls = external_urls;
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

    @Override
    public String toString() {
        return "itemss";
        /*return "Item{" +
                "external_urls=" + external_urls +
                ", followers=" + followers +
                ", genres=" + genres +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';*/
    }
}
