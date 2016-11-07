package controller;

public class MainUserScreenController extends MainScreenController {
    /**
     * Handles when the "Submit Availability Report" button is pressed
     */
    public final void handleAvailabilityReportPressed() {
        getMainApplication().initDialogScreen("Create Water Availability Report", "waterAvailabilityReportScreen.fxml");
    }

    /**
     * Handles when the "View Availability Reports" button is pressed
     */
    public final void handleViewAvailabilityReportsPressed() {
        getMainApplication().initMapScreen("View Water Reports", new ViewReportsMapScreenInitializer());
        //getMainApplication().initDialogScreen("View Water Reports", "viewReportsMapScreen.fxml");
    }
}
