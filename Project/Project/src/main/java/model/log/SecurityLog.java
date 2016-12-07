package model.log;

import model.profiles.LoginAttemptResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class SecurityLog implements Serializable {
    private static List<SecurityIncident> log;

    private SecurityLog() {}

    public static void init() {
        log = new ArrayList<>();
    }

    /**
     * Log when a login attempt is made
     * @param username      the username entered for login
     * @param result        the result of the login attempt
     */
    public static void logLoginAttempt(String username, LoginAttemptResult result) {
        log.add(new SecurityIncidentLogin(username, result));
    }

    /**
     * Log when an account is deleted by an admin
     * @param admin         the username of the admin account
     * @param deleted       the username of the deleted account
     */
    public static void logAccountDeleted(String admin, String deleted) {
        log.add(new SecurityIncidentDelete(admin, deleted));
    }

    /**
     * Log when an account is banned from submitting reports by an admin
     * @param admin         the username of the admin account
     * @param banned        the username of the banned account
     */
    public static void logAccountBanned(String admin, String banned) {
        log.add(new SecurityIncidentBanned(admin, banned));
    }

    /**
     * Log when an account is unblocked by an admin
     * @param admin         the username of the admin account
     * @param unblocked     the username of the unblocked account
     */
    public static void logAccountUnblocked(String admin, String unblocked) {
        log.add(new SecurityIncidentUnblocked(admin, unblocked));
    }

    /**
     * Log when a report is deleted by a manager
     * @param manager       the username of the manager
     * @param reportNumber  the number of the deleted report (as a String)
     */
    public static void logReportDeleted(String manager, String reportNumber) {
        log.add(new SecurityIncidentReportDelete(manager, reportNumber));
    }

    public static List<SecurityIncident> getLog() { return log; }
    public static void setLog(List<SecurityIncident> l) { log = l; }

}
