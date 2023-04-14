package lab.reflections;

import javafx.scene.layout.Pane;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ClassModifier {
    private Pane pane;

    private Handler handler;

    private Map<String, String> parametersMap;


    public ClassModifier(Handler handler, Pane pane) {
        this.handler = handler;
        parametersMap = new HashMap<>();

    }

    public void changeParameters() {
        createParametersMap();
        List<Method> methodsList = handler.getFieldsCreator().getMethodsList();

        Object object = handler.getFieldsCreator().getaClass();
        System.out.println("Class modifier Line: 27, object");
        System.out.println(object.toString());

        methodsList.forEach(method -> {

        });

        System.out.println("Class modifier Line: 34, list of methods: ");
        System.out.println(methodsList.toString());

        System.out.println("Line 39: list of methods type: ");
        methodsList.forEach((method) -> {
            System.out.println("Method: " + method.getName() + " Params: " + Arrays.toString(method.getParameterTypes()));
        });

    }

    private void createParametersMap() {
        handler.getFieldsMap().forEach((key, value)-> {
            parametersMap.put(key, value.getText());
        });
        System.out.println("Class Modifier 26, Captured parameters Map: ");
        System.out.println(parametersMap);
    }
}
