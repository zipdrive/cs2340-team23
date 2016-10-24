package model.log;

public class SecurityIncidentReportDelete extends SecurityIncident {
    private String deletedReport;

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