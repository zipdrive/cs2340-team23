package model.log;

/**
 * SecurityIncident for when an admin deletes an account
 */
class SecurityIncidentDelete extends SecurityIncident {
    private final String deletedUsername;

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
