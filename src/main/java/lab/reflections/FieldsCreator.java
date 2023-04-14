package lab.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldsCreator {

    private Class<?> aClass;
    private List<Field> fieldsList;
    private List<Method> methodsList;
    private List<String> listOfFieldsName;
    private List<String> listOfSettersName;

    public FieldsCreator(Class<?> aClass) {
        this.aClass = aClass;
    }

    public void getFields() {
        methodsList = getClassParams();

        fieldsList = new ArrayList<>();
        listOfFieldsName.forEach((elem)->{
            try {
                Field declaredField = aClass.getDeclaredField(elem);
                declaredField.setAccessible(true);
                fieldsList.add(declaredField);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private List<Method> getClassParams() {
        Method[] methods = aClass.getMethods();
        List<Method> allMethods = Arrays.asList(methods);

        listOfSettersName = allMethods.stream()
                .map(Method::getName)
                .filter(s -> s.contains("set")).toList();

        listOfFieldsName = listOfSettersName.stream()
                .map(s -> s.replace("set", ""))
                .map(String::trim)
                .map(s -> Character.toLowerCase(s.charAt(0)) + s.substring(1)).toList();

        System.out.println("Fields Creator Line: 49");
        System.out.println(listOfSettersName);
        System.out.println(listOfFieldsName);

        return allMethods.stream()
                .filter(method -> method.getName().contains("set")).toList();
    }

    public Class<?> getaClass() {
        return aClass;
    }

    public List<Field> getFieldsList() {
        return fieldsList;
    }

    public List<String> getListOfFieldsName() {
        return listOfFieldsName;
    }

    public List<String> getListOfSettersName() {
        return listOfSettersName;
    }

    public List<Method> getMethodsList() {
        return methodsList;
    }
}
