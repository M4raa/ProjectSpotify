package jpaswing.projectspotiy.entity.artist;

public class Image {
    public String url;
    public int height;
    public int width;

    public Image(){}
    public Image(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }


    @Override
    public String toString() {
        return "image: " + url;
    }
}
