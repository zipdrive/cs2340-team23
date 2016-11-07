package model.log;

/**
 * SecurityIncident for when a report is deleted
 */
public final class SecurityIncidentReportDelete extends SecurityIncident {
    private final String deletedReport;

    public SecurityIncidentReportDelete(String admin, String deleted) {
        super(admin);
        deletedReport = deleted;
    }

    public String toString() {
        return "Account unblocked at " + getTimestamp().toString() +
                " -- adminID:" + getUsername() +
                ", reportID:" + deletedReport;
    }
}