package model.log;

/**
 * SecurityIncident for when an admin bans an account
 */
class SecurityIncidentBanned extends SecurityIncident {
    private final String bannedUsername;

    public SecurityIncidentBanned(String admin, String banned) {
        super(admin);
        bannedUsername = banned;
    }

    public String toString() {
        return "Account banned at " + timestamp.toString() +
                " -- adminID:" + username +
                ", bannedID:" + bannedUsername;
    }
}
