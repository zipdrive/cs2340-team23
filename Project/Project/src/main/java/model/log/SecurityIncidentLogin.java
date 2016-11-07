package model.log;

import model.profiles.LoginAttemptResult;

/**
 * SecurityIncident for when a login attempt is made
 */
public final class SecurityIncidentLogin extends SecurityIncident {
    private final LoginAttemptResult result;

    public SecurityIncidentLogin(String username, LoginAttemptResult r) {
        super(username);
        result = r;
    }

    public String toString() {
        return "Attempted login at " + getTimestamp().toString() +
                " -- userID:" + getUsername() +
                ", result:'" + result.toString() + "'";
    }
}
