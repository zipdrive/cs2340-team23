package model.log;

/**
 * SecurityIncident for when an account is unblocked
 */
public class SecurityIncidentUnblocked extends SecurityIncident {
    private final String unblockedUsername;

    public SecurityIncidentUnblocked(String admin, String unblocked) {
        super(admin);
        unblockedUsername = unblocked;
    }

    public String toString() {
        return "Account unblocked at " + timestamp.toString() +
                " -- adminID:" + username +
                ", unblockedID:" + unblockedUsername;
    }
}
