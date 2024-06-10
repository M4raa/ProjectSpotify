package jpaswing.projectspotiy.entityContent.entity.several;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class Followers implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
