package hust.soict.hedspi.aims.Cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added to cart.");
        } else {
            System.out.println("Already in cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed from cart.");
        } else {
            System.out.println("Not found.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void empty() {
        itemsOrdered.clear();
    }

    public void print() {
        System.out.println("***********************CART***********************");
        for (Media m : itemsOrdered) System.out.println(m.toString());
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    
    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }
}