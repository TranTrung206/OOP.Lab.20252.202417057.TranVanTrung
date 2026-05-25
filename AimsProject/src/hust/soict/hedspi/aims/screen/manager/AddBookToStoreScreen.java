package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

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

    @Override
    protected void setupAddButtonAction() {
        btnAdd.addActionListener(e -> {
            int id = Integer.parseInt(tfId.getText().trim());
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());

            Book book = new Book(id, title, category, cost);
            store.addMedia(book);

            dispose();
            new StoreManagerScreen(store);
        });
    }
}