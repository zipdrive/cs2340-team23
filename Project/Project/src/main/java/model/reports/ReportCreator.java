package model.reports;

import fxapp.MainApplication;
import model.log.ErrorLog;
import model.log.IncidentPriority;
import model.service.GeocodeCallback;
import model.service.GeocodeManager;

public class ReportCreator {

    private static MainApplication mainApplication;

    /**
     * Sets a reference to the MainApplication object
     * @param mainApplication       the MainApplication object
     */
    public static void setMainApplication(MainApplication mainApplication) {
        ReportCreator.mainApplication = mainApplication;
    }

    /**
     * Sends a geocode request for the address
     * @param address       the location to search for, as an address (etc.)
     * @param callback      GeocodeCallback with a callback function when it finishes
     */
    private static void geocode(String address, GeocodeCallback callback) {
        try {
            GeocodeManager.geocode(address, callback);
        } catch (Exception e) {
            ReportCreator.mainApplication.generateErrorAlert("Unexpected Error",
                    "Your report could not be filed because the program encountered an unexpected error. " +
                            "Please try again or contact an admin for assistance.");
            ErrorLog.log(e, IncidentPriority.URGENT);
            GeocodeManager.cancel();
        }
    }

    /**
     * Creates a new WaterAvailabilityReport
     * @param address       the address or location of the report
     * @param type          the type of water source
     * @param condition     the condition of the water
     */
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
                    case MULTIPLE_RESULTS:
                        ReportCreator.mainApplication.initDialogScreen("Multiple Locations Found", "geocodingMultipleLocationsScreen.fxml");
                        break;
                    default:
                        break;
                }
            });
    }

    public static void createWaterPurityReport(String address, WaterPurityCondition condition, double virusPPM, double contaminantPPM) {
        ReportCreator.geocode(address, () -> {
                switch (GeocodeManager.getStatus()) {
                    case SUCCESS:
                        WaterPurityReport report = new WaterPurityReport(
                                ReportCreator.mainApplication.getReports().getNextReportNumber(),
                                ReportCreator.mainApplication.getUser().getName(),
                                GeocodeManager.getAddress(), GeocodeManager.getCoordinates(), condition, virusPPM, contaminantPPM);
                        ReportCreator.mainApplication.getReports().addNewReport(report);
                        ReportCreator.mainApplication.generateInformationAlert("Report Submitted Successfully",
                                "Thank you for submitting a report!");
                        break;
                    case NO_RESULTS:
                        ReportCreator.mainApplication.generateErrorAlert("No Locations Found",
                                "We could not find any locations that matched your submission. " +
                                        "Please try again.");
                        break;
                    case MULTIPLE_RESULTS:
                        ReportCreator.mainApplication.initDialogScreen("Multiple Locations Found", "geocodingMultipleLocationsScreen.fxml");
                        break;
                    default:
                        break;
                }
            });
    }
}
