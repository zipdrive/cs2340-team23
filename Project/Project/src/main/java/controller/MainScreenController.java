package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Class to handle the main screen of the application
 */
public class MainScreenController extends ScreenController {

    @FXML
    private Label userLabel;

    @Override
    public void setMainApplication(MainApplication mainApplication) {
        super.setMainApplication(mainApplication);
        userLabel.setText(mainApplication.getUser().getName() + " (" + mainApplication.getUser().getUsername() + ")");
    }

    /**
     * Handle the "Options" button being pressed
     */
    public void handleOptionsPressed() {
        getMainApplication().initDialogScreen("Edit Profile", "profileEditScreen.fxml");
    }

    /**
     * Handle the "Logout" button being pressed
     */
    public void handleLogoutPressed() {
        getMainApplication().logout();
        getMainApplication().initScreen("Welcome Screen", "welcomeScreen.fxml");
    }
}
