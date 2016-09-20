package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainScreenController {

    private MainApplication mainApplication;

    @FXML
    private Label userLabel;

    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
        userLabel.setText("User: " + mainApplication.getUser());
    }

    public void handleLogoutPressed() {
        mainApplication.logout();
        mainApplication.initWelcomeScreen();
    }
}
