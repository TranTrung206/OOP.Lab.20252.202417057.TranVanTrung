package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    @FXML
    private GridPane gridPane;

    @FXML
    private Button btnViewCart;

    private Store store;
    private Cart cart;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {

        int column = 0;
        int row = 1;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {

            try {

                FXMLLoader fxmlLoader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/hust/soict/hedspi/aims/screen/manager/customer/view/Item.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController =
                        fxmlLoader.getController();

                itemController.setData(
                        store.getItemsInStore().get(i),
                        cart);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);

                GridPane.setMargin(
                        anchorPane,
                        new Insets(10));

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
                                    "/hust/soict/hedspi/aims/screen/manager/customer/view/Cart.fxml"));

            loader.setController(
                    new CartController(cart));

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setTitle("Cart");

            stage.setScene(
                    new Scene(root));

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}