package model.reports;

import java.util.ArrayList;
import java.util.List;

public class ReportList {
    private List<WaterAvailabilityReport> availabilityReports;
    private List<WaterPurityReport> purityReports;

    public ReportList() {
        availabilityReports = new ArrayList<>();
        purityReports = new ArrayList<>();
    }

    /**
     * Retrieves all Water Availability Reports
     * @return      a list of all water availability reports
     */
    public List<WaterAvailabilityReport> getReports() { return availabilityReports; }

    /**
     * Retrieves all Water Purity Reports
     * @return      a list of all water purity reports
     */
    public List<WaterPurityReport> getPurityReports() { return purityReports; }

    /**
     * Returns the next number for a new report
     * @return      int, representing the maximum report number so far +1
     */
    public int getNextReportNumber() {
        return availabilityReports.size() + purityReports.size();
    }

    /**
     * Adds a new report to the list
     * @param report        report to add to the list
     */
    public void addNewReport(WaterAvailabilityReport report) {
        availabilityReports.add(report);
    }

    /**
     * Adds a new report to the list
     * @param report        report to add to the list
     */
    public void addNewReport(WaterPurityReport report) {
        purityReports.add(report);
    }
}
