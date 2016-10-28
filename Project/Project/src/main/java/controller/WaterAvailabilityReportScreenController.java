package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.reports.ReportCreator;
import model.reports.WaterCondition;
import model.reports.WaterType;

public class WaterAvailabilityReportScreenController extends DialogScreenController {

    @FXML
    private TextField locationField;

    @FXML
    private ComboBox<WaterType> typeComboBox;

    @FXML
    private ComboBox<WaterCondition> conditionComboBox;

    /**
     * Initializes the screen
     */
    public void init() {
        typeComboBox.setValue(WaterType.BOTTLED);
        conditionComboBox.setValue(WaterCondition.WASTE);
    }

    /**
     * Handles when the "Submit Report" button is pressed
     */
    public void handleSubmitReportPressed() {
        String address = locationField.getText();
        if (address.equals("")) {
            generateErrorWarning("No Location Entered", "Please enter a location and try again.");
        } else {
            ReportCreator.createWaterAvailabilityReport(address, typeComboBox.getValue(), conditionComboBox.getValue());
            closeDialogStage();
        }
    }
}
