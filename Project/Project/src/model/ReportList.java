package model;

import java.util.ArrayList;
import java.util.List;

public class ReportList {
    private List<WaterAvailabilityReport> availabilityReports;

    public ReportList() {
        availabilityReports = new ArrayList<>();
    }

    public List<WaterAvailabilityReport> getReports() {
        return availabilityReports;
    }

    public int getLastReportNumber() {
        return availabilityReports.size();
    }

    public void addNewReport(WaterAvailabilityReport report) {
        availabilityReports.add(report);
    }
}
