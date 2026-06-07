package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.Cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;
    @FXML private Label lblCost;
    @FXML private Label lblTitle;

    private Media media;
    private Cart cart;

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnAddToCartPressed(ActionEvent event) {
        cart.addMedia(media);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Cart Update");
        alert.setHeaderText(null);
        alert.setContentText(media.getTitle() + " has been added to your cart!");
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Playing Media");
        alert.setHeaderText("Media Preview");
        alert.setContentText("Playing: " + media.getTitle() + "\nCost: " + media.getCost() + " $");
        alert.showAndWait();
    }
}