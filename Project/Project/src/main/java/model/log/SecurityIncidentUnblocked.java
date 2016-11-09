package model.log;

/**
 * SecurityIncident for when an account is unblocked
 */
final class SecurityIncidentUnblocked extends SecurityIncident {
    private final String unblockedUsername;

    public SecurityIncidentUnblocked(String admin, String unblocked) {
        super(admin);
        unblockedUsername = unblocked;
    }

    public String toString() {
        return "Account unblocked at " + getTimestamp().toString() +
                " -- adminID:" + getUsername() +
                ", unblockedID:" + unblockedUsername;
    }
}
