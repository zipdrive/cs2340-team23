package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Class handling the screen for logging in
 */
public class LoginScreenController {

    private MainApplication mainApplication;
    private Stage dialogStage;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    /**
     * Sets a pointer to the main application
     * @param mainApplication   pointer to the main application
     */
    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    /**
     * Sets a pointer to the dialog stage
     * @param dialogStage       Stage representing the dialog window
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Handle the "Login" button being pressed
     */
    @FXML
    public void handleLoginPressed() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.equals("")) {
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
            if (mainApplication.login(username, password)) {
                dialogStage.close();
                mainApplication.initMainScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Incorrect Username or Password");
                alert.setHeaderText("Incorrect Username or Password");
                alert.setContentText("Please try again.");

                alert.showAndWait();
            }
        }
    }

    /**
     * Handle the "Cancel" button being pressed
     */
    @FXML
    public void handleCancelPressed() {
        dialogStage.close();
    }
}
