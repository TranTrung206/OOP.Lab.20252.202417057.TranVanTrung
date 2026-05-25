package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

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

    @Override
    protected void setupAddButtonAction() {
        btnAdd.addActionListener(e -> {
            int id = Integer.parseInt(tfId.getText().trim());
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());
            String director = tfDirector.getText().trim();
            int length = Integer.parseInt(tfLength.getText().trim());

            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, director, length);
            store.addMedia(dvd);

            dispose();
            new StoreManagerScreen(store);
        });
    }
}