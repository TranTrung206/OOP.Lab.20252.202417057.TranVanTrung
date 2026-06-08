package hust.soict.hedspi.test.screen;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.manager.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    private static Store store = new Store();
    private static Cart cart = new Cart();

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource(
                                "/hust/soict/hedspi/aims/screen/manager/customer/view/Store.fxml"
                        )
                );

        Parent root = loader.load();

        ViewStoreController controller =
                loader.getController();

        controller.initData(store, cart);

        primaryStage.setScene(
                new Scene(root)
        );

        primaryStage.show();
    }

    public static void main(String[] args) {

    store.addMedia(
            new DigitalVideoDisc(
                    1,
                    "The Lion King",
                    "Animation",
                    19.95f,
                    "Roger Allers",
                    87));

    store.addMedia(
            new DigitalVideoDisc(
                    2,
                    "Aladdin",
                    "Animation",
                    18.99f,
                    "Guy Ritchie",
                    128));

    store.addMedia(
            new DigitalVideoDisc(
                    3,
                    "Avengers Endgame",
                    "Action",
                    24.99f,
                    "Anthony Russo",
                    181));

    store.addMedia(
            new DigitalVideoDisc(
                    4,
                    "Spider Man No Way Home",
                    "Action",
                    22.99f,
                    "Jon Watts",
                    148));

    store.addMedia(
            new DigitalVideoDisc(
                    5,
                    "Interstellar",
                    "Sci-Fi",
                    20.99f,
                    "Christopher Nolan",
                    169));

    store.addMedia(
            new DigitalVideoDisc(
                    6,
                    "Inception",
                    "Sci-Fi",
                    21.99f,
                    "Christopher Nolan",
                    148));

    launch(args);
    }
}