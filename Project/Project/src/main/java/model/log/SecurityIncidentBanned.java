package model.log;

/**
 * SecurityIncident for when an admin bans an account
 */
public final class SecurityIncidentBanned extends SecurityIncident {
    private final String bannedUsername;

    public SecurityIncidentBanned(String admin, String banned) {
        super(admin);
        bannedUsername = banned;
    }

    public String toString() {
        return "Account banned at " + getTimestamp().toString() +
                " -- adminID:" + getUsername() +
                ", bannedID:" + bannedUsername;
    }
}
