package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // THÊM HÀM NÀY VÀO ĐỂ STORE SCREEN GỌI ĐƯỢC DANH SÁCH
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public void print() {
        System.out.println("\n***********************STORE***********************");
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
        System.out.println("***************************************************");
    }

    public Media search(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }
}