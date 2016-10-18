package controller;

public class MainManagerScreenController extends MainWorkerScreenController {

    /**
     * Handles when the "View Availability Reports (List)" button is pressed
     */
    public void handleViewAvailabilityReportsListPressed() {
        getMainApplication().initDialogScreen("View Availability Reports", "viewReportsScreen.fxml");
    }

    /**
     * Handles when the "View Historical Reports" button is pressed
     */
    public void handleViewHistoricalReportsPressed() {

    }
}
