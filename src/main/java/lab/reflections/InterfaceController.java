package lab.reflections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

public class InterfaceController implements Initializable {

    @FXML
    private TextField classNameTextField;

    @FXML
    private Button createButton;

    @FXML
    private Pane pane;

    @FXML
    private Button saveButton;

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Handler handler = new Handler(classNameTextField, vBox, pane);
    }

    @FXML
    void createObject(ActionEvent event) {

    }

    @FXML
    void saveChanges(ActionEvent event) {

    }
}