package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.model.Role;
import sample.model.UserSession;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainPaneController implements Initializable, AlertsInterface {

    @FXML
    private Label usernameLabel, rolesLabel, userRoleText, adminRoleText;

    @FXML
    private JFXButton userBtn, adminBtn;

    @FXML
    private void handleExitBtnEvent(ActionEvent event) {
        exitAlert();
    }

    @FXML
    private void handleLogoutBtnEvent(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation!");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you wanna logout?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            UserSession.getInstance().cleanUserSession();
            Stage stage = (Stage) usernameLabel.getScene().getWindow();
            stage.close();
            new WindowOpener().open(new Stage(), "/view/fxml/LoginPane.fxml", "Login Panel");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserSession userSession = UserSession.getInstance();

        if (!userSession.getRoles().contains(new Role("USER"))) {
            userRoleText.setVisible(false);
            userBtn.setVisible(false);
        }

        if (!userSession.getRoles().contains(new Role("ADMIN"))) {
            adminRoleText.setVisible(false);
            adminBtn.setVisible(false);
        }

        usernameLabel.setText(userSession.getUsername());
        rolesLabel.setText(userSession.getRoles().toString());
    }
}
