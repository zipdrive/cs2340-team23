package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.log.SecurityIncident;
import model.log.SecurityLog;

public class SecurityLogScreenController extends DialogScreenController {
    @FXML
    private Label incidentsLabel;

    public void init() {
        incidentsLabel.setText("");
        for (SecurityIncident s : SecurityLog.getLog()) {
            incidentsLabel.setText(incidentsLabel.getText() + s.toString() + "\n");
        }
    }
}
