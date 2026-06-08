package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    @FXML
    private GridPane gridPane;

    private Store store;
    private Cart cart;

    public ViewStoreController() {
    }

    public void initData(Store store, Cart cart) {

        this.store = store;
        this.cart = cart;

        loadStore();
    }

    private void loadStore() {

        final String ITEM_FXML =
                "/hust/soict/hedspi/aims/screen/manager/customer/view/Item.fxml";

        int column = 0;
        int row = 0;

        for (int i = 0;
             i < store.getItemsInStore().size();
             i++) {

            try {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        ITEM_FXML
                                )
                        );

                AnchorPane pane =
                        loader.load();

                ItemController controller =
                        loader.getController();

                controller.setData(
                        store.getItemsInStore().get(i),
                        cart
                );

                gridPane.add(
                        pane,
                        column,
                        row
                );

                GridPane.setMargin(
                        pane,
                        new Insets(20)
                );

                column++;

                if (column == 3) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/hust/soict/hedspi/aims/screen/manager/customer/view/Cart.fxml"
                            )
                    );

            Parent root = loader.load();

            CartController controller =
                    loader.getController();

            controller.initData(store,cart);

            Stage stage =
                    (Stage) gridPane
                            .getScene()
                            .getWindow();

            stage.setScene(
                    new Scene(root)
            );

            stage.setTitle(
                    "Cart Screen"
            );

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}