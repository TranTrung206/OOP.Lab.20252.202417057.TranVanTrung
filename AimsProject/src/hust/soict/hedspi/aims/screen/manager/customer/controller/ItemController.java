package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;
    @FXML private Label lblCost;
    @FXML private Label lblTitle;

    private Media media;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
}