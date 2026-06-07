package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/manager/customer/view/Store.fxml"));
            
            ViewStoreController viewStoreController = new ViewStoreController(store);
            fxmlLoader.setController(viewStoreController);
            
            Parent root = fxmlLoader.load();
            primaryStage.setTitle("AIMS Store Screen");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        store = new Store();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124);
        
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        
        launch(args);
    }
}