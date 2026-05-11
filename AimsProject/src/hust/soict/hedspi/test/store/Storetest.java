package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class Storetest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, "John Musker", 90);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        System.out.println("\n--- Current Store State ---");
        store.print();

        System.out.println("\n--- Testing Removal ---");
        store.removeMedia(dvd2);
        
        DigitalVideoDisc dvdNonExistent = new DigitalVideoDisc(99, "Non-existent DVD", "None", 0f, "None", 0);
        store.removeMedia(dvdNonExistent);

        System.out.println("\n--- Final Store State ---");
        store.print();
    }
}