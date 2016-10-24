package controller;

public class MainWorkerScreenController extends MainUserScreenController {
    /**
     * Handles when the "Submit Purity Report" button is pressed
     */
    public void handlePurityReportPressed() {
        getMainApplication().initDialogScreen("Create Purity Report", "waterPurityReportScreen.fxml");
    }
}
