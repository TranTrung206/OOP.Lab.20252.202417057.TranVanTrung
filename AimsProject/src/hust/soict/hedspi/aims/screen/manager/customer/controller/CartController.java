package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CartController {

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colId;

    @FXML
    private TableColumn<Media, String> colTitle;

    @FXML
    private TableColumn<Media, String> colCategory;

    @FXML
    private TableColumn<Media, Float> colCost;

    @FXML
    private Label lblTotalCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void initialize() {

        tblMedia.setItems(cart.getItemsOrdered());

        colId.setCellValueFactory(cell ->
                new SimpleObjectProperty<>(cell.getValue().getId()));

        colTitle.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getTitle()));

        colCategory.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getCategory()));

        colCost.setCellValueFactory(cell ->
                new SimpleObjectProperty<>(cell.getValue().getCost()));

        updateTotal();

        btnPlay.setDisable(true);
        btnRemove.setDisable(true);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, selectedMedia) -> {

                    if (selectedMedia == null) {
                        btnPlay.setDisable(true);
                        btnRemove.setDisable(true);
                        return;
                    }

                    btnRemove.setDisable(false);

                    btnPlay.setDisable(!(selectedMedia instanceof Playable));
                });
    }

    @FXML
    private void btnPlayPressed() {

        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (!(media instanceof Playable)) {
            return;
        }

        try {
            ((Playable) media).play();
        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void btnRemovePressed() {

        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media == null) {
            return;
        }

        cart.removeMedia(media);

        updateTotal();
    }

    @FXML
    private void btnPlaceOrderPressed() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText(null);
        alert.setContentText("Order placed successfully!");
        alert.showAndWait();

        cart.empty();

        updateTotal();
    }

    private void updateTotal() {
        lblTotalCost.setText(cart.totalCost() + " $");
    }
}