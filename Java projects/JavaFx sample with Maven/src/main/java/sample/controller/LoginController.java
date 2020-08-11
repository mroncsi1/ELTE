package sample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import sample.model.User;
import sample.model.UserSession;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.ResourceBundle;

public class LoginController implements Initializable, AlertsInterface {

    private HttpClient httpClient;

    @FXML
    private JFXTextField usernameTF;

    @FXML
    private JFXPasswordField passwordPF;

    @FXML
    private void handleExitBtnEvent(ActionEvent event) {
        exitAlert();
    }

    @FXML
    private void handleLoginBtnEvent(ActionEvent event) {
        String username = usernameTF.getText();
        String password = passwordPF.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> map = Map.of("username", username, "password", password);
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/login"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(map)))
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (!response.body().isEmpty()) {
                    User user = objectMapper.readValue(response.body(), User.class);
                    UserSession.getInstance(user.getUsername(), user.getRoles());
                    new WindowOpener().open(new Stage(), "/view/fxml/MainPane.fxml", "Main Panel");
                    System.out.println(UserSession.getInstance());
                    Stage stage = (Stage) usernameTF.getScene().getWindow();
                    stage.close();
                } else {
                    errorAlert("Incorrect username or password.");
                }
            } catch (InterruptedException | IOException e) {
                errorAlert(String.format("Internal server error.%nError message: %s", e.getMessage()));
            }
        } else {
            errorAlert("You must enter your username and password.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    }
}
