package com.example.shopping;

import com.example.shopping.Utilities.AlertUtilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShoppingController {


    private final ObservableList<Cart> cartData = FXCollections.observableArrayList();

    @FXML
    public TextField name_field;
    @FXML
    public TextField product_field;
    @FXML
    public TextField quantity_field;
    @FXML
    public TextField price_field;
    @FXML
    public Button btn_add;
    @FXML
    public TableView<Cart> shopping_table_view;
    @FXML
    public TableColumn<Cart, String> product_column;
    @FXML
    public TableColumn<Cart, Double> price_column;
    @FXML
    public TableColumn<Cart, String> name_column;
    @FXML
    public TableColumn<Cart, Integer> quantity_column;
    @FXML
    public TableColumn<Cart, Double> total_column;

    @FXML

    private void initialize() {
        name_column.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        product_column.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantity_column.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("pricePerItem"));
        total_column.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));


        shopping_table_view.setItems(cartData);

        btn_add.setOnAction(event -> onBtn_add());
    }

    @FXML
    private void onBtn_add() {
        if (name_field.getText().isEmpty() || product_field.getText().isEmpty() || quantity_field.getText().isEmpty() || price_field.getText().isEmpty()) {
            AlertUtilities.displayError("Fill all the fields.");
        } else {
            String name = name_field.getText();
            String productName = product_field.getText();
            if (!isNumeric(quantity_field.getText()) || !isNumeric(price_field.getText())) {
                AlertUtilities.displayError("Enter a valid number for quantity and price.");
            } else {
                int quantity = Integer.parseInt(quantity_field.getText());
                double pricePerItem = Double.parseDouble(price_field.getText());
                double totalAmount = quantity * pricePerItem;

                cartData.add(new Cart(name, productName, quantity, pricePerItem, totalAmount));
            }
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
