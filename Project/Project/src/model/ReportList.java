package model;

import java.util.ArrayList;
import java.util.List;

public class ReportList {
    private List<WaterAvailabilityReport> availabilityReports;

    public ReportList() {
        availabilityReports = new ArrayList<>();
    }

    /**
     * Retrieves all Water Availability Reports
     * @return      a list of all water availability reports
     */
    public List<WaterAvailabilityReport> getReports() { return availabilityReports; }

    /**
     * Returns the next number for a new report
     * @return      int, representing the maximum report number so far +1
     */
    public int getNextReportNumber() {
        return availabilityReports.size();
    }

    /**
     * Adds a new report to the list
     * @param report        report to add to the list
     */
    public void addNewReport(WaterAvailabilityReport report) {
        availabilityReports.add(report);
    }
}
