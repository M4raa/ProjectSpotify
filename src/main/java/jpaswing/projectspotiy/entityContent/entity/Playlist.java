package jpaswing.projectspotiy.entityContent.entity;

import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.several.ExternalUrls;
import jpaswing.projectspotiy.entityContent.entity.several.Image;
import jpaswing.projectspotiy.entityContent.entity.several.Owner;
import jpaswing.projectspotiy.entityContent.entity.several.PlaylistTrack.Tracks;

import java.util.List;

public class Playlist {

    @SerializedName("collaborative")
    private boolean collaborative;

    @SerializedName("description")
    private String description;

    @SerializedName("external_urls")
    private ExternalUrls externalUrls;

    @SerializedName("href")
    private String href;

    @SerializedName("id")
    private String id;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("name")
    private String name;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("public")
    private boolean isPublic;

    @SerializedName("snapshot_id")
    private String snapshotId;

    @SerializedName("tracks")
    private Tracks tracks;

    @SerializedName("type")
    private String type;

    @SerializedName("uri")
    private String uri;

    // Getters and setters
    public boolean isCollaborative() {
        return collaborative;
    }

    public void setCollaborative(boolean collaborative) {
        this.collaborative = collaborative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public Tracks getPlaylistTracks() {
        return tracks;
    }

    public void setPlaylistTracks(Tracks tracks) {
        this.tracks = tracks;
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
