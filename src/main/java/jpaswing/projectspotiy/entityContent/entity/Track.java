package jpaswing.projectspotiy.entityContent.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import jpaswing.projectspotiy.entityContent.entity.several.ExternalIds;
import jpaswing.projectspotiy.entityContent.entity.several.ExternalUrls;
import org.hibernate.sql.Restriction;

import java.util.List;

public class Track {
    @SerializedName("album")
    private Album album;

    @SerializedName("artists")
    private List<Artist> artists;

    @SerializedName("available_markets")
    private List<String> availableMarkets;

    @SerializedName("disc_number")
    private int discNumber;

    @SerializedName("duration_ms")
    private int durationMs;

    @SerializedName("explicit")
    private boolean explicit;

    @SerializedName("external_ids")
    private ExternalIds externalIds;

    @SerializedName("external_urls")
    private ExternalUrls externalUrls;

    @SerializedName("href")
    private String href;

    @SerializedName("id")
    private String id;

    @SerializedName("is_playable")
    private boolean isPlayable;

    @SerializedName("linked_from")
    private JsonObject linkedFrom;

    @SerializedName("restrictions")
    private Restriction restrictions;

    @SerializedName("name")
    private String name;

    @SerializedName("popularity")
    private int popularity;

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName("track_number")
    private int trackNumber;

    @SerializedName("type")
    private String type;

    @SerializedName("uri")
    private String uri;

    @SerializedName("is_local")
    private boolean isLocal;

    //Constructor
    public Track(){}

    public Track(Album album, List<Artist> artists, List<String> availableMarkets, int discNumber, int durationMs, boolean explicit, ExternalIds externalIds, ExternalUrls externalUrls, String href, String id, boolean isPlayable, JsonObject linkedFrom, Restriction restrictions, String name, int popularity, String previewUrl, int trackNumber, String type, String uri, boolean isLocal) {
        this.album = album;
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.explicit = explicit;
        this.externalIds = externalIds;
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.isPlayable = isPlayable;
        this.linkedFrom = linkedFrom;
        this.restrictions = restrictions;
        this.name = name;
        this.popularity = popularity;
        this.previewUrl = previewUrl;
        this.trackNumber = trackNumber;
        this.type = type;
        this.uri = uri;
        this.isLocal = isLocal;
    }

    // Getters and Setters
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public ExternalIds getExternalIds() {
        return externalIds;
    }

    public void setExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
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

    public boolean isPlayable() {
        return isPlayable;
    }

    public void setPlayable(boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

    public JsonObject getLinkedFrom() {
        return linkedFrom;
    }

    public void setLinkedFrom(JsonObject linkedFrom) {
        this.linkedFrom = linkedFrom;
    }

    public Restriction getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restriction restrictions) {
        this.restrictions = restrictions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
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

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }
}