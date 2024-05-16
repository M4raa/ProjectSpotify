package jpaswing.projectspotiy.entity.artist;

public class Followers{
    public String href;
    public int total;

    public Followers(){}
    public Followers(String href, int total) {
        this.href = href;
        this.total = total;
    }

    @Override
    public String toString() {
        return "followers: " + total;
    }
}
