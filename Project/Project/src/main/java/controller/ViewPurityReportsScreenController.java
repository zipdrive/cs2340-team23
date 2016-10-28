package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.reports.ReportList;
import model.reports.WaterPurityReport;

public class ViewPurityReportsScreenController extends DialogScreenController {
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
        for (WaterPurityReport report : reportList.getPurityReports()) {
            reportNumberLabel.setText(reportNumberLabel.getText() + report.getReportNumber() + "\n\n");
            dateAndTimeLabel.setText(dateAndTimeLabel.getText() + report.getDateAndTime() + "\n\n");
            nameLabel.setText(nameLabel.getText() + report.getNameOfReporter() + "\n\n");
            locationLabel.setText(locationLabel.getText() + report.getLocationOfReport() + "\n\n");
            conditionLabel.setText(conditionLabel.getText() + report.getOverallCondition() + "\n\n");
            virusPPMLabel.setText(virusPPMLabel.getText() + report.getVirusPPM() + "\n\n");
            contaminantPPMLabel.setText(contaminantPPMLabel.getText() + report.getContaminantPPM() + "\n\n");
        }
    }
}
