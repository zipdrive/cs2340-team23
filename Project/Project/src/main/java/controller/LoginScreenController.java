package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Class handling the screen for logging in
 */
public final class LoginScreenController extends DialogScreenController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    /**
     * Handle the "Login" button being pressed
     */
    @FXML
    public void handleLoginPressed() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.equals("")) {
            generateErrorWarning("No Username", "Please input a username and try again.");
        } else if (password.equals("")) {
            generateErrorWarning("No Password", "Please input a password and try again.");
        } else {
            if (getMainApplication().login(username, password)) {
                closeDialogStage();
                switch (getMainApplication().getUser().getUserType()) {
                    case USER:
                        getMainApplication().initScreen("Main Screen", "mainUserScreen.fxml");
                        break;
                    case WORKER:
                        getMainApplication().initScreen("Main Screen", "mainWorkerScreen.fxml");
                        break;
                    case MANAGER:
                        getMainApplication().initScreen("Main Screen", "mainManagerScreen.fxml");
                        break;
                    case ADMIN:
                        getMainApplication().initScreen("Main Screen", "mainAdminScreen.fxml");
                        break;
                    default:
                        generateErrorWarning("Main Screen Not Yet Implemented For That User Account Type", "Please choose another account and try again.");
                        break;
                }
            } else {
                generateErrorWarning("Incorrect Username or Password", "Please try again.");
            }
        }
    }
}
