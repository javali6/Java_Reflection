package lab.reflections;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Handler {

    private TextField classNameTextField;
    private VBox vBox;
    private FieldsCreator fieldsCreator;
    private Object object;
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

            Constructor<?> constructor = aClass.getConstructor();
            object = constructor.newInstance();
            generateGraphicFields();

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateGraphicFields() throws InvocationTargetException, IllegalAccessException {

        fieldsMap = new HashMap<>();

        for (String label : fieldsCreator.getListOfFieldsName()) {
            if(label.contains("text")) {
                TextArea textArea = new TextArea();
                textArea.setMaxSize(150, 80);
                fieldsMap.put(label, textArea);
                vBox.getChildren().addAll(new HBox(textArea, new Label(" <- " + label)));

                Optional<Method> method = fieldsCreator.getGetterMethodsList().stream()
                        .filter(m -> m.getName().toLowerCase().contains(label.toLowerCase())).findFirst();
                textArea.setText(method.get().invoke(object).toString());
            }
            else {
                TextField textField = new TextField();
                fieldsMap.put(label, textField);
                vBox.getChildren().addAll(new HBox(textField, new Label(" <- " + label)));

                Optional<Method> method = fieldsCreator.getGetterMethodsList().stream()
                        .filter(m -> m.getName().toLowerCase().contains(label.toLowerCase())).findAny();
                textField.setText(method.get().invoke(object).toString());
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

    public Object getObject() {
        return object;
    }
}
