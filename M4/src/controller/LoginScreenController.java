package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {

    private MainApplication mainApplication;
    private Stage dialogStage;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void handleLoginPressed() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.equals("user") && password.equals("pass")) {
            dialogStage.close();
            mainApplication.login(username);
            mainApplication.initMainScreen();
        } else if (username.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Username");
            alert.setHeaderText("No Username");
            alert.setContentText("Please input a username and try again.");

            alert.showAndWait();
        } else if (password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Password");
            alert.setHeaderText("No Password");
            alert.setContentText("Please input a password and try again.");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Incorrect Username or Password");
            alert.setHeaderText("Incorrect Username or Password");
            alert.setContentText("Please try again.");

            alert.showAndWait();
        }
    }
    @FXML
    public void handleCancelPressed() {
        dialogStage.close();
    }
}
