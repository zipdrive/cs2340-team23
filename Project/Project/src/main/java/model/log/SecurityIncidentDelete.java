package model.log;

/**
 * SecurityIncident for when an admin deletes an account
 */
final class SecurityIncidentDelete extends SecurityIncident {
    private final String deletedUsername;

    public SecurityIncidentDelete(String admin, String deleted) {
        super(admin);
        deletedUsername = deleted;
    }

    public String toString() {
        return "Account deleted at " + getTimestamp().toString() +
                " -- adminID:" + getUsername() +
                ", deletedID:" + deletedUsername;
    }
}
