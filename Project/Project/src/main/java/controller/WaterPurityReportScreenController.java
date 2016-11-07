package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.reports.ReportCreator;
import model.reports.WaterPurityCondition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WaterPurityReportScreenController extends DialogScreenController {
    @FXML
    private TextField locationField;

    @FXML
    private ComboBox<WaterPurityCondition> conditionComboBox;

    @FXML
    private TextField virusField;

    @FXML
    private TextField contaminantField;

    @Override
    public void init() {
        conditionComboBox.setValue(WaterPurityCondition.SAFE);
    }

    /**
     * Handles when the "Submit Report" button is pressed
     */
    public void handleSubmitReportPressed() {
        String address = locationField.getText();
        Pattern pattern = Pattern.compile("^\\d*\\.?\\d*$");
        double virusPPM;
        double contaminantPPM;
        Matcher virusMatcher = pattern.matcher(virusField.getText());
        if (!virusField.getText().equals("") && virusMatcher.find()) {
            virusPPM = Double.parseDouble(virusMatcher.group(0));
        } else {
            generateErrorWarning("No Value Entered For Virus PPM", "Please enter a decimal value for virus PPM and try again.");
            return;
        }
        Matcher contaminantMatcher = pattern.matcher(contaminantField.getText());
        if (!contaminantField.getText().equals("") && contaminantMatcher.find()) {
            contaminantPPM = Double.parseDouble(contaminantMatcher.group(0));
        } else {
            generateErrorWarning("No Value Entered For Contaminant PPM", "Please enter a decimal value for contaminant PPM and try again.");
            return;
        }
        if (address.equals("")) {
            generateErrorWarning("No Location Entered", "Please enter a location and try again.");
        } else {
            ReportCreator.createWaterPurityReport(address, conditionComboBox.getValue(), virusPPM, contaminantPPM);
            closeDialogStage();
        }
    }
}
