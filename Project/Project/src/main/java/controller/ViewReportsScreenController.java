package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.reports.ReportList;
import model.reports.WaterAvailabilityReport;

public final class ViewReportsScreenController extends DialogScreenController {

    @FXML
    private Label reportNumberLabel;
    @FXML
    private Label dateAndTimeLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label conditionLabel;

    @Override
    public void init() {
        ReportList reportList = getMainApplication().getReports();
        String doubleNewline = "\n\n";
        for (WaterAvailabilityReport report : reportList.getReports()) {
            reportNumberLabel.setText(reportNumberLabel.getText() + report.getReportNumber() + doubleNewline);
            dateAndTimeLabel.setText(dateAndTimeLabel.getText() + report.getDateAndTime() + doubleNewline);
            nameLabel.setText(nameLabel.getText() + report.getNameOfReporter() + doubleNewline);
            locationLabel.setText(locationLabel.getText() + report.getLocationOfReport() + doubleNewline);
            typeLabel.setText(typeLabel.getText() + report.getWaterType() + doubleNewline);
            conditionLabel.setText(conditionLabel.getText() + report.getWaterCondition() + doubleNewline);
        }
    }
}
