package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Class to handle the main screen of the application
 */
public class MainScreenController extends ScreenController {

    @FXML
    private Label userLabel;

    @Override
    public void init() {
        userLabel.setText(getMainApplication().getUser().getName() + " (" + getMainApplication().getUser().getUsername() + ")");
    }

    /**
     * Handle the "Options" button being pressed
     */
    public final void handleOptionsPressed() {
        getMainApplication().initDialogScreen("Edit Profile", "profileEditScreen.fxml");
    }

    /**
     * Handle the "Logout" button being pressed
     */
    public final void handleLogoutPressed() {
        getMainApplication().logout();
        getMainApplication().initScreen("Welcome Screen", "welcomeScreen.fxml");
    }
}
