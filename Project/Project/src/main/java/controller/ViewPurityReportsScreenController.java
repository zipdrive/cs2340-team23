package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.reports.ReportList;
import model.reports.WaterPurityReport;

public final class ViewPurityReportsScreenController extends DialogScreenController {
    @FXML
    private Label reportNumberLabel;
    @FXML
    private Label dateAndTimeLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label conditionLabel;
    @FXML
    private Label virusPPMLabel;
    @FXML
    private Label contaminantPPMLabel;

    @Override
    public void init() {
        ReportList reportList = getMainApplication().getReports();
        String doubleNewline = "\n\n";
        for (WaterPurityReport report : reportList.getPurityReports()) {
            reportNumberLabel.setText(reportNumberLabel.getText() + report.getReportNumber() + doubleNewline);
            dateAndTimeLabel.setText(dateAndTimeLabel.getText() + report.getDateAndTime() + doubleNewline);
            nameLabel.setText(nameLabel.getText() + report.getNameOfReporter() + doubleNewline);
            locationLabel.setText(locationLabel.getText() + report.getLocationOfReport() + doubleNewline);
            conditionLabel.setText(conditionLabel.getText() + report.getOverallCondition() + doubleNewline);
            virusPPMLabel.setText(virusPPMLabel.getText() + report.getVirusPPM() + doubleNewline);
            contaminantPPMLabel.setText(contaminantPPMLabel.getText() + report.getContaminantPPM() + doubleNewline);
        }
    }
}
