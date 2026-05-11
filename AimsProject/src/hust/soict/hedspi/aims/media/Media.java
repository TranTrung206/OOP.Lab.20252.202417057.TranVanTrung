package hust.soict.hedspi.aims.media;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

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
        return "Media: " + title + " - Category: " + category + " - Cost: " + cost + "$";
    }
}