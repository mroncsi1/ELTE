package sample.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class WindowOpener {

    private double x, y;

    public void open(Stage stage, String path, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            stage.setTitle(title);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);

            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
                stage.setOpacity(0.7f);
            });
            root.setOnDragDone(e -> stage.setOpacity(1.0f));
            root.setOnMouseReleased(e -> stage.setOpacity(1.0f));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
