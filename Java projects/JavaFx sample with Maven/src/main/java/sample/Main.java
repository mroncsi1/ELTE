package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.controller.WindowOpener;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        new WindowOpener().open(primaryStage, "/view/fxml/LoginPane.fxml", "Login Panel");
    }

    public static void main(String[] args) {
        launch(args);
    }
}