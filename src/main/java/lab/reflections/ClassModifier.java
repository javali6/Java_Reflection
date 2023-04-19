package lab.reflections;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ClassModifier {
    private Pane pane;
    private TextArea textArea;
    private Handler handler;

    private Map<String, String> parametersMap;
    private String parameterName;


    public ClassModifier(Handler handler, Pane pane) {
        this.handler = handler;
        this.pane = pane;
        parametersMap = new HashMap<>();

    }

    public void changeParameters() {
        createParametersMap();
        List<Method> methodsList = handler.getFieldsCreator().getSetterMethodsList();
        Map<Method, Class<?>[]> methodClassMap = new HashMap<>();
        methodsList.forEach(method -> {
            methodClassMap.put(method, method.getParameterTypes());
        });

        Object object = handler.getObject();

        methodClassMap.forEach((method, parameter) -> {
            String methodName = method.getName().substring(3).toLowerCase();
            String text = parametersMap.get(methodName);
            if(parameter[0].toString().length() > 16) {
                parameterName = parameter[0].toString().substring(16);
            }
            else {
                parameterName = parameter[0].toString();
            }

            try {
                switch (parameterName) {
                    case "String" -> method.invoke(object, text);
                    case "Boolean", "boolean" -> method.invoke(object, Boolean.getBoolean(text));
                    case "Integer", "int" -> method.invoke(object, Integer.parseInt(text));
                    case "Float", "float" -> method.invoke(object, Float.parseFloat(text));
                    case "Double", "double" -> method.invoke(object, Double.parseDouble(text));
                    case "Long", "long" -> method.invoke(object, Long.parseLong(text));
                    case "Short", "short" -> method.invoke(object, Short.parseShort(text));
                    case "Byte", "byte" -> method.invoke(object, Byte.parseByte(text));
                    case "Character", "char" -> method.invoke(object, text.charAt(0));
                }

            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            textArea = new TextArea(object.toString());
            pane.getChildren().addAll(textArea);

        });
    }

    private void createParametersMap() {
        handler.getFieldsMap().forEach((key, value)-> {
            parametersMap.put(key.toLowerCase(), value.getText());
        });
    }
}
