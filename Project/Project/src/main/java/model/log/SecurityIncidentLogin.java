package model.log;

import model.profiles.LoginAttemptResult;

/**
 * SecurityIncident for when a login attempt is made
 */
class SecurityIncidentLogin extends SecurityIncident {
    private final LoginAttemptResult result;

    public SecurityIncidentLogin(String username, LoginAttemptResult result) {
        super(username);
        this.result = result;
    }

    public String toString() {
        return "Attempted login at " + timestamp.toString() +
                " -- userID:" + username +
                ", result:'" + result.toString() + "'";
    }
}
