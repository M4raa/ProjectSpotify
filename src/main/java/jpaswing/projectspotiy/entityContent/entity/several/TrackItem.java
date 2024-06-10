package jpaswing.projectspotiy.entityContent.entity.several;

import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.Track;

import java.io.Serial;
import java.io.Serializable;

public class TrackItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("added_at")
    private String addedAt;

    @SerializedName("added_by")
    private User addedBy;

    @SerializedName("is_local")
    private boolean isLocal;

    @SerializedName("track")
    private Track track;

    //Constructor

    public TrackItem() {
    }

    public TrackItem(String addedAt, User addedBy, boolean isLocal, Track track) {
        this.addedAt = addedAt;
        this.addedBy = addedBy;
        this.isLocal = isLocal;
        this.track = track;
    }
    // Getters and setters

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}