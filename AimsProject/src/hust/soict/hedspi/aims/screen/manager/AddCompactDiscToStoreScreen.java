package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId, tfTitle, tfCategory, tfCost, tfDirector, tfLength, tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD to Store");
    }

    @Override
    protected void addFormFields() {
        tfId = addTextField("Enter ID:");
        tfTitle = addTextField("Enter Title:");
        tfCategory = addTextField("Enter Category:");
        tfCost = addTextField("Enter Cost ($):");
        tfDirector = addTextField("Enter Director:");
        tfLength = addTextField("Enter Length:");
        tfArtist = addTextField("Enter Artist:");
    }
}