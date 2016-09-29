package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;

public class WelcomeScreenController {

    private MainApplication mainApplication;

    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @FXML
    public void handleLoginPressed() {
        mainApplication.initLoginDialog();
    }
    @FXML
    public void handleRegisterPressed() {
        mainApplication.initRegisterDialog();
    }
    @FXML
    public void handleQuitPressed() {
        System.exit(0);
    }
}
