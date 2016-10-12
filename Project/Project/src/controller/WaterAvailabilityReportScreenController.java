package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.WaterAvailabilityReport;
import model.WaterCondition;
import model.WaterType;

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
        String location = locationField.getText();
        if (location.equals("")) {
            generateErrorWarning("No Location Entered", "Please enter a location and try again.");
        } else {
            WaterAvailabilityReport report = new WaterAvailabilityReport(getMainApplication().getReports().getNextReportNumber(), getMainApplication().getUser().getName(), location, typeComboBox.getValue(), conditionComboBox.getValue());
            getMainApplication().getReports().addNewReport(report);
            generateInformationPopup("Report Submitted", "Thank you for submitting a report!");
            closeDialogStage();
        }
    }
}
