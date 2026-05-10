package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 89, 18.99f);

        System.out.println("--- Test them 2 DVD roi ---");
        cart.addDigitalVideoDisc(dvd1, dvd2);

        System.out.println("\n--- Test them mot mang DVD ---");
        DigitalVideoDisc[] dvdList = {dvd3, new DigitalVideoDisc("Cinderella", "Animation", 15.5f)};
        cart.addDigitalVideoDisc(dvdList);

        System.out.println("\n--- Ket qua cuoi cung ---");
        System.out.println("Total Cost: " + cart.totalCost());
    }
}