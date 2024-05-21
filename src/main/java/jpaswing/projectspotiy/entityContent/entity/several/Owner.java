package jpaswing.projectspotiy.entityContent.entity.several;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("external_urls")
    private ExternalUrls externalUrls;

    @SerializedName("followers")
    private Followers followers;

    @SerializedName("href")
    private String href;

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("uri")
    private String uri;

    @SerializedName("display_name")
    private String displayName;

    // Getters and setters
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
