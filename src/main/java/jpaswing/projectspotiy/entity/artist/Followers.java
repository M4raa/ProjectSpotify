package jpaswing.projectspotiy.entity.artist;

public class Followers{
    public String href;
    public int total;

    public Followers(String href, int total) {
        this.href = href;
        this.total = total;
    }

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

    @Override
    public String toString() {
        return "followers: " + total;
    }
}
