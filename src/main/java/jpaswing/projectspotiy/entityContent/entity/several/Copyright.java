package jpaswing.projectspotiy.entityContent.entity.several;

import com.google.gson.annotations.SerializedName;

public class Copyright {
    @SerializedName("text")
    private String text;

    @SerializedName("type")
    private String type;

    // Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}