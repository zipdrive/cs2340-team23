package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Class to handle the main screen of the application
 */
public class MainScreenController {

    private MainApplication mainApplication;

    @FXML
    private Label userLabel;

    /**
     * Sets a pointer to the main application
     * @param mainApplication       pointer to the main application
     */
    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
        userLabel.setText("User: " + mainApplication.getUser().getUsername());
    }

    /**
     * Handle the "Options" button being pressed
     */
    public void handleOptionsPressed() {
        mainApplication.initProfileEditDialog();
    }

    /**
     * Handle the "Logout" button being pressed
     */
    public void handleLogoutPressed() {
        mainApplication.logout();
        mainApplication.initWelcomeScreen();
    }
}
