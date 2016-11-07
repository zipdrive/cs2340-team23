package controller;

public class MainManagerScreenController extends MainWorkerScreenController {

    /**
     * Handles when the "View Availability Reports (List)" button is pressed
     */
    public final void handleViewAvailabilityReportsListPressed() {
        getMainApplication().initDialogScreen("View Availability Reports", "viewReportsScreen.fxml");
    }

    /**
     * Handles when the "View Purity Reports (List)" button is pressed
     */
    public final void handleViewPurityReportsPressed() {
        getMainApplication().initDialogScreen("View Purity Reports", "viewPurityReportsScreen.fxml");
    }

    /**
     * Handles when the "View Purity Reports (Historical)" button is pressed
     */
    public final void handleViewHistoricalReportsPressed() {
        getMainApplication().initDialogScreen("View Historical Reports", "viewHistoricalReportsScreen.fxml");
    }
}
