package jpaswing.projectspotiy.entity;
import jpaswing.projectspotiy.entity.artist.Item;
import java.util.ArrayList;

public class Artist {
    public String href;
    public int limit;
    public String next;
    public int offset;
    public String previous;
    public int total;
    public ArrayList<Item> items;

    public Artist(){}
    public Artist(String href, int limit, String next, int offset, String previous, int total, ArrayList<Item> items) {
        this.href = href;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
        this.items = items;
    }
    @Override
    public String toString() {
        return "Artists:" + "\n" +
                " href=" + href + "\n" +
                " limit=" + limit + "\n" +
                " next='" + next + "\n" +
                " offset=" + offset + "\n" +
                " previous='" + previous + "\n" +
                " total=" + total + "\n" +
                " items=" + items;
    }
}





