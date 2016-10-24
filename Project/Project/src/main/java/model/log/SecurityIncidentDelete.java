package model.log;

public class SecurityIncidentDelete extends SecurityIncident {
    private String deletedUsername;

    public SecurityIncidentDelete(String admin, String deleted) {
        super(admin);
        deletedUsername = deleted;
    }

    public String toString() {
        return "Account deleted at " + timestamp.toString() +
                " -- adminID:" + username +
                ", deletedID:" + deletedUsername;
    }
}
