package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

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

    @Override
    protected void setupAddButtonAction() {
        btnAdd.addActionListener(e -> {
            int id = Integer.parseInt(tfId.getText().trim());
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());
            String director = tfDirector.getText().trim();
            int length = Integer.parseInt(tfLength.getText().trim());
            String artist = tfArtist.getText().trim();

            CompactDisc cd = new CompactDisc(id, title, category, cost, director, length, artist);
            store.addMedia(cd);

            dispose();
            new StoreManagerScreen(store);
        });
    }
}