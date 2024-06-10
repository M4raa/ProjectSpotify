package jpaswing.projectspotiy.entityContent.entity.several;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class ExternalIds implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("isrc")
    private String isrc;

    @SerializedName("ean")
    private String ean;

    @SerializedName("upc")
    private String upc;

    // Getters and Setters
    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }
}