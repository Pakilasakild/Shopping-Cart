module com.example.shopping {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shopping to javafx.fxml;
    exports com.example.shopping;
}