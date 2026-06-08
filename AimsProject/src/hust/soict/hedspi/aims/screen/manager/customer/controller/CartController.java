package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;  
import javafx.beans.value.ChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    private Cart cart;
    private Store store;

    public void initData(Store store,Cart cart) {
        this.store = store;
        this.cart = cart;

        ToggleGroup filterGroup = new ToggleGroup();
        radioBtnFilterId.setToggleGroup(filterGroup);
        radioBtnFilterTitle.setToggleGroup(filterGroup);

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        colCategory.setCellValueFactory(
                new PropertyValueFactory<>("category"));

        colCost.setCellValueFactory(
                new PropertyValueFactory<>("cost"));

        FilteredList<Media> filteredMedia =
                new FilteredList<>(
                        cart.getItemsOrdered(),
                        p -> true);

        tblMedia.setItems(filteredMedia);

        lblTotalCost.setText(
                cart.totalCost() + " $");

        cart.getItemsOrdered().addListener(
        (ListChangeListener<Media>) c ->
                lblTotalCost.setText(
                        cart.totalCost() + " $"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ChangeListener<Media>)
                                (observable,
                                 oldValue,
                                 newValue) -> {

                                    if (newValue != null) {
                                        updateButtonBar(newValue);
                                    }
                                });

        tfFilter.textProperty()
                .addListener(
                        (observable,
                         oldValue,
                         newValue) -> {

                            filteredMedia.setPredicate(media -> {

                                if (newValue == null
                                        || newValue.isEmpty()) {
                                    return true;
                                }

                                String filter =
                                        newValue.toLowerCase();

                                if (radioBtnFilterId.isSelected()) {

                                    return String.valueOf(
                                            media.getId())
                                            .contains(filter);
                                }

                                return media.getTitle()
                                        .toLowerCase()
                                        .contains(filter);
                            });
                        });
    }

    private void updateButtonBar(Media media) {

        btnRemove.setVisible(true);

        btnPlay.setVisible(
                media instanceof Playable);
    }

    @FXML
    void btnRemovePressed() {

        Media media =
                tblMedia.getSelectionModel()
                        .getSelectedItem();

        if (media != null) {

            cart.removeMedia(media);

            lblTotalCost.setText(
                    cart.totalCost() + " $");
        }
    }

    @FXML
    void btnPlayPressed() {

        Media media =
                tblMedia.getSelectionModel()
                        .getSelectedItem();

        if (media == null)
            return;

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

    @FXML
    void btnPlaceOrderPressed() {

        Alert alert =
            new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Order");
        alert.setHeaderText(null);
        alert.setContentText(
            "Order placed successfully!");

        alert.showAndWait();

        cart.empty();
    }

    @FXML
    void btnViewStorePressed() {

    try {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource(
                                "/hust/soict/hedspi/aims/screen/manager/customer/view/store.fxml"
                        ));

        Parent root = loader.load();

        ViewStoreController controller =
                loader.getController();

        controller.initData(
                store,
                cart
        );

        Stage stage =
                (Stage) tblMedia
                        .getScene()
                        .getWindow();

        stage.setScene(
                new Scene(root));

        stage.show();

    } catch (Exception e) {

        e.printStackTrace();
    }
}
}