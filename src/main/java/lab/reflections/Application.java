package lab.reflections;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("reflectAppGui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 538);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(windowEvent -> Platform.exit());
    }

    public static void main(String[] args) {
        launch();
    }
}