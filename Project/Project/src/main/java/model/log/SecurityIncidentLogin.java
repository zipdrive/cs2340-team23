package model.log;

import model.profiles.LoginAttemptResult;

public class SecurityIncidentLogin extends SecurityIncident {
    LoginAttemptResult result;

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
