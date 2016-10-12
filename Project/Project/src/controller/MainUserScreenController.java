package controller;

public class MainUserScreenController extends MainScreenController {
    public void handleAvailabilityReportPressed() {
        getMainApplication().initDialogScreen("Create Water Availability Report", "waterAvailabilityReportScreen.fxml");
    }

    public void handleViewAvailabilityReportsPressed() {
        getMainApplication().initDialogScreen("View Water Reports", "viewReportsScreen.fxml");
    }
}
