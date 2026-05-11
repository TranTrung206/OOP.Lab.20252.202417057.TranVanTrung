package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class Aims {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc(1, "Greatest Hits", "Music", 15.0f, "Unknown", 0, "Queen");
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "The Lion King", "Animation", 20.0f, "Roger Allers", 89);
        
        Book book = new Book(3, "Java Programming", "Education", 50.0f);

        cd.addTrack(new Track("Bohemian Rhapsody", 6));
        cd.addTrack(new Track("Don't Stop Me Now", 4));

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        System.out.println("--- Media Information ---");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }

        System.out.println("\n--- Testing Play Method ---");
        for (Media m : mediae) {
            if (m instanceof Playable) {
                ((Playable) m).play();
                System.out.println("--------------------");
            } else {
                System.out.println("The media: " + m.getTitle() + " is not playable (it's a Book).");
            }
        }
    }
}