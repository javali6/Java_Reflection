module lab.reflections {
    requires javafx.controls;
    requires javafx.fxml;



    opens lab.reflections to javafx.fxml;
    exports lab.reflections;
}