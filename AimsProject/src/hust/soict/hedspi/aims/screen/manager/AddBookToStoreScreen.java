package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId, tfTitle, tfCategory, tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
    }

    @Override
    protected void addFormFields() {
        tfId = addTextField("Enter ID:");
        tfTitle = addTextField("Enter Title:");
        tfCategory = addTextField("Enter Category:");
        tfCost = addTextField("Enter Cost ($):");
    }
}