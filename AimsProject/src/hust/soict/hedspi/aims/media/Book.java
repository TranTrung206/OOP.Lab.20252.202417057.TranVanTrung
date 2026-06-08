package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    @Override
    public void play() throws PlayerException {
        throw new PlayerException("ERROR: Book cannot be played!");
    }

    @Override
    public String toString() {
        return "Book: "
                + title
                + " - Category: "
                + category
                + " - Authors: "
                + authors
                + " - Cost: "
                + cost
                + "$";
    }
}