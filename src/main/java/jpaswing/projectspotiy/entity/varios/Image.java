package jpaswing.projectspotiy.entity.varios;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("height")
    private int height;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private int width;

    // Getters and Setters
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
