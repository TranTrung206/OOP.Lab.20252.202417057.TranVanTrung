package hust.soict.hedspi.aims.screen.manager.customer.controller;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CartScreen {
    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Stage stage = new Stage();
                stage.setTitle("Customer Cart");

                VBox root = new VBox(15);
                root.setPadding(new Insets(20));
                root.setMinWidth(400);

                Label lblHeader = new Label("--- SHOPPING CART ---");
                lblHeader.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

                TextArea txtItems = new TextArea();
                txtItems.setEditable(false);
                txtItems.setPrefHeight(250);

                StringBuilder sb = new StringBuilder();
                if (cart.getItemsOrdered().isEmpty()) {
                    sb.append("Your cart is empty.");
                } else {
                    for (Media m : cart.getItemsOrdered()) {
                        sb.append("- ").append(m.getTitle()).append(": ").append(m.getCost()).append(" $\n");
                    }
                }
                txtItems.setText(sb.toString());

                Label lblTotal = new Label("Total Cost: " + cart.totalCost() + " $");
                lblTotal.setStyle("-fx-font-size: 14px; -fx-text-fill: #009688; -fx-font-weight: bold;");

                Button btnClose = new Button("Close");
                btnClose.setOnAction(e -> stage.close());

                root.getChildren().addAll(lblHeader, txtItems, lblTotal, btnClose);

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
    }
}