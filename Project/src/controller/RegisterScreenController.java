package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Profile;

public class RegisterScreenController {

    private MainApplication mainApplication;
    private Stage dialogStage;

    @FXML
    private TextField nameField;

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
    public void handleRegisterPressed() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (name.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Name Field");
            alert.setHeaderText("No Name");
            alert.setContentText("Please input a name and try again.");

            alert.showAndWait();
        } else if (username.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Username Field");
            alert.setHeaderText("No Username");
            alert.setContentText("Please input a username and try again.");

            alert.showAndWait();
        } else if (password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Password Field");
            alert.setHeaderText("No Password");
            alert.setContentText("Please input a password and try again.");

            alert.showAndWait();
        } else if (mainApplication.getProfiles().findProfile(username) != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Username Taken");
            alert.setHeaderText("That Username Is Already Possessed");
            alert.setContentText("Please input a new username and try again.");

            alert.showAndWait();
        } else {
            Profile newProfile = new Profile(name, username, password);
            mainApplication.getProfiles().addProfile(newProfile);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Registration Complete");
            alert.setHeaderText("Registration Complete");
            alert.setContentText("Thank you for registering with us, " + name + "!");

            alert.showAndWait();
            dialogStage.close();
        }
    }
    @FXML
    public void handleCancelPressed() {
        dialogStage.close();
    }
}
