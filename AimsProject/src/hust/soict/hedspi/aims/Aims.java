package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.media.*;
import java.util.Scanner;

public class Aims {
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: seeCart(); break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: \n1. View store\n2. Update store\n3. See current cart\n0. Exit");
    }

    public static void seeCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            switch (choice) {
                case 3:
                    System.out.print("Title: ");
                    String t = scanner.nextLine();
                    Media m = cart.searchByTitle(t);
                    if (m != null) cart.removeMedia(m);
                    break;
                case 5:
                    System.out.println("Order created.");
                    cart.empty();
                    return;
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: \n1. Filter\n2. Sort\n3. Remove\n4. Play\n5. Place order\n0. Back");
    }

    public static void viewStore() { System.out.println("Store logic here"); }
    public static void updateStore() { System.out.println("Update logic here"); }
}