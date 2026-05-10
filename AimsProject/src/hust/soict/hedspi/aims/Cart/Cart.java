package hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) itemsOrdered.add(media);
    }

    public void print() {
        System.out.println("\n***********************CART***********************");
        for (Media m : itemsOrdered) {
            System.out.println(m.toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }
    
    public void empty() { itemsOrdered.clear(); }
}