package lab.reflections;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lab.reflections.classes.FootballClub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handler {

    private TextField classNameTextField;
    private VBox vBox;
    private FieldsCreator fieldsCreator;
    private Map<String, TextInputControl> fieldsMap;

    public Handler(TextField classNameTextField, VBox vBox) {
        this.classNameTextField = classNameTextField;
        this.vBox = vBox;
    }

    public void createObject() {
        String className = classNameTextField.getText();
        //lab.reflections.classes.FootballClub

        try {
            Class<?> aClass = Class.forName(className);
            fieldsCreator = new FieldsCreator(aClass);
            fieldsCreator.getFields();
            generateGraphicFields();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateGraphicFields() {

        fieldsMap = new HashMap<>();

        for (String label : fieldsCreator.getListOfFieldsName()) {
            if(label.contains("text")) {
                TextArea textArea = new TextArea();
                textArea.setMaxSize(150, 80);
                fieldsMap.put(label, textArea);
                vBox.getChildren().addAll(new HBox(textArea, new Label(" <- " + label)));
            }
            else {
                TextField textField = new TextField();
                fieldsMap.put(label, textField);
                vBox.getChildren().addAll(new HBox(textField, new Label(" <- " + label)));
            }

        }

    }

    public TextField getClassNameTextField() {
        return classNameTextField;
    }

    public VBox getvBox() {
        return vBox;
    }

    public FieldsCreator getFieldsCreator() {
        return fieldsCreator;
    }

    public Map<String, TextInputControl> getFieldsMap() {
        return fieldsMap;
    }
}
