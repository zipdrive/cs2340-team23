package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.ReportList;
import model.WaterAvailabilityReport;

public class ViewReportsScreenController extends DialogScreenController {

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
        for (WaterAvailabilityReport report : reportList.getReports()) {
            reportNumberLabel.setText(reportNumberLabel.getText() + report.getReportNumber() + "\n\n");
            dateAndTimeLabel.setText(dateAndTimeLabel.getText() + report.getDateAndTime() + "\n\n");
            nameLabel.setText(nameLabel.getText() + report.getNameOfReporter() + "\n\n");
            locationLabel.setText(locationLabel.getText() + report.getLocationOfReport() + "\n\n");
            typeLabel.setText(typeLabel.getText() + report.getWaterType() + "\n\n");
            conditionLabel.setText(conditionLabel.getText() + report.getWaterCondition() + "\n\n");
        }
    }
}
