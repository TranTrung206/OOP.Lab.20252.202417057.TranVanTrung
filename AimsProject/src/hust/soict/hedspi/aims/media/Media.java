package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Media)) return false;
        return ((Media) obj).title.equalsIgnoreCase(this.title);
    }

    @Override
    public String toString() {
        return id + ". Media: " + title + " - Category: " + category + " - Cost: " + cost + "$";
    }
}