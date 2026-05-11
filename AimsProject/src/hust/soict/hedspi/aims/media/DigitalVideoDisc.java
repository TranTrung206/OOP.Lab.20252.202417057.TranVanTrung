package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + length);
    }

    @Override
    public String toString() {
        return "DVD: " + title + " - Category: " + category + " - Director: " + director + " - Length: " + length + " - Cost: " + cost + "$";
    }
}