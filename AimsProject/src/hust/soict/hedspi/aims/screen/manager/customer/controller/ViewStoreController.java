package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class ViewStoreController {
    @FXML private GridPane gridPane;
    private Store store;

    public ViewStoreController(Store store) {
        this.store = store;
    }

    @FXML
    public void initialize() {
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/manager/customer/view/Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(store.getItemsInStore().get(i));
                
                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}