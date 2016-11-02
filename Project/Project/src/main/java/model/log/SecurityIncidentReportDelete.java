package model.log;

/**
 * SecurityIncident for when a report is deleted
 */
public class SecurityIncidentReportDelete extends SecurityIncident {
    private final String deletedReport;

    public SecurityIncidentReportDelete(String admin, String deleted) {
        super(admin);
        deletedReport = deleted;
    }

    public String toString() {
        return "Account unblocked at " + timestamp.toString() +
                " -- adminID:" + username +
                ", reportID:" + deletedReport;
    }
}