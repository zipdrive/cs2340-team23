package model.reports;

import fxapp.MainApplication;
import model.service.GeocodeCallback;
import model.service.GeocodeManager;

public class ReportCreator {

    private static MainApplication mainApplication;

    public static void setMainApplication(MainApplication mainApplication) {
        ReportCreator.mainApplication = mainApplication;
    }

    private static boolean geocode(String address, GeocodeCallback callback) {
        try {
            GeocodeManager.geocode(address, callback);
            // while (GeocodeManager.getStatus() == GeocodeProgress.IN_PROGRESS) {}
        } catch (NullPointerException e) {
            ReportCreator.mainApplication.generateErrorAlert("Could Not Connect To Server",
                    "Your report could not be filed because the program could not connect to the server. " +
                            "Please check your internet connection and try again.");
            GeocodeManager.cancel();
            return false;
        } catch (Exception e) {
            // log error
            ReportCreator.mainApplication.generateErrorAlert("Unexpected Error",
                    "Your report could not be filed because the program encountered an unexpected error. " +
                            "Please try again or contact an admin for assistance.");
            GeocodeManager.cancel();
            return false;
        }
        return true;
    }

    public static void createWaterAvailabilityReport(String address, WaterType type, WaterCondition condition) {
        ReportCreator.geocode(address, () -> {
                switch (GeocodeManager.getStatus()) {
                    case SUCCESS:
                        WaterAvailabilityReport report = new WaterAvailabilityReport(
                                ReportCreator.mainApplication.getReports().getNextReportNumber(),
                                ReportCreator.mainApplication.getUser().getName(),
                                GeocodeManager.getAddress(), GeocodeManager.getCoordinates(), type, condition);
                        ReportCreator.mainApplication.getReports().addNewReport(report);
                        ReportCreator.mainApplication.generateInformationAlert("Report Submitted Successfully",
                                "Thank you for submitting your report!");
                        break;
                    case NO_RESULTS:
                        ReportCreator.mainApplication.generateErrorAlert("No Locations Found",
                                "We could not find any locations that matched your submission. " +
                                        "Please try again.");
                        break;
                    default:
                        break;
                }
            });
    }
}
