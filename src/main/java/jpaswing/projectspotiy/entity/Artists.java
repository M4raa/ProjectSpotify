package jpaswing.projectspotiy.entity;
import jpaswing.projectspotiy.entity.artist.Item;
import java.util.ArrayList;

public class Artists{
    public String href;
    public int limit;
    public String next;
    public int offset;
    public String previous;
    public int total;
    public ArrayList<Item> items;

    public Artists(String href, int limit, String next, int offset, String previous, int total, ArrayList<Item> items) {
        this.href = href;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
        this.items = items;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
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





