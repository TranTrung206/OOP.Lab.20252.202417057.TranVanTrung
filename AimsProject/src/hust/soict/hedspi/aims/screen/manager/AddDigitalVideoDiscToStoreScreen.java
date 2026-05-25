package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId, tfTitle, tfCategory, tfCost, tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
    }

    @Override
    protected void addFormFields() {
        tfId = addTextField("Enter ID:");
        tfTitle = addTextField("Enter Title:");
        tfCategory = addTextField("Enter Category:");
        tfCost = addTextField("Enter Cost ($):");
        tfDirector = addTextField("Enter Director:");
        tfLength = addTextField("Enter Length:");
    }
}