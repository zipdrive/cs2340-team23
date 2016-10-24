package model.log;

public class SecurityIncidentBanned extends SecurityIncident {
    private String bannedUsername;

    public SecurityIncidentBanned(String admin, String banned) {
        super(admin);
        bannedUsername = banned;
    }
}
