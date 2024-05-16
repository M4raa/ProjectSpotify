package jpaswing.projectspotiy.entity.varios;

import com.google.gson.annotations.SerializedName;

public class Followers {
    @SerializedName("href")
    private String href;

    @SerializedName("total")
    private int total;

    // Getters and Setters
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
