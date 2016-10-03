package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;

public class WelcomeScreenController {

    private MainApplication mainApplication;

    /**
     * Sets a pointer to the main application
     * @param mainApplication   pointer to the main application
     */
    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    /**
     * Handle the "Login" button being pressed
     */
    @FXML
    public void handleLoginPressed() {
        mainApplication.initLoginDialog();
    }

    /**
     * Handle the "Register" button being pressed
     */
    @FXML
    public void handleRegisterPressed() {
        mainApplication.initRegisterDialog();
    }

    /**
     * Handle the "Quit" button being pressed
     */
    @FXML
    public void handleQuitPressed() {
        System.exit(0);
    }
}
