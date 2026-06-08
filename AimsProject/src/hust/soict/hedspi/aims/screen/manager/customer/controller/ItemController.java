package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    private Media media;
    private Cart cart;

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void btnAddToCartPressed() {

        cart.addMedia(media);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Media");
        alert.setHeaderText(null);
        alert.setContentText(
                media.getTitle() + " has been added to cart!"
        );
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed() {

        try {

            media.play();

            Alert alert =
                    new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Play Media");
            alert.setHeaderText("Now Playing");
            alert.setContentText(media.toString());

            alert.showAndWait();

        } catch (PlayerException e) {

            Alert alert =
                    new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Player Exception");
            alert.setHeaderText("Cannot play media");
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }
}