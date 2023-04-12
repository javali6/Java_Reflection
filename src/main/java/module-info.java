module com.example.refleksje {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.refleksje to javafx.fxml;
    exports com.example.refleksje;
}