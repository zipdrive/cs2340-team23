package controller;

import javafx.fxml.FXML;

public final class WelcomeScreenController extends ScreenController {

    /**
     * Handle the "Login" button being pressed
     */
    @FXML
    public void handleLoginPressed() { getMainApplication().initDialogScreen("Login", "loginScreen.fxml"); }

    /**
     * Handle the "Register" button being pressed
     */
    @FXML
    public void handleRegisterPressed() {
        getMainApplication().initDialogScreen("Register", "registerScreen.fxml");
    }

    /**
     * Handle the "Quit" button being pressed
     */
    @FXML
    public void handleQuitPressed() {
        if (getMainApplication().generateSaveAndQuitMessage()) {
            getMainApplication().getMainScreen().close();
        }
    }
}
