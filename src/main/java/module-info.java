module org.example.lr3_model {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lr3_model to javafx.fxml;
    exports org.example.lr3_model;
}