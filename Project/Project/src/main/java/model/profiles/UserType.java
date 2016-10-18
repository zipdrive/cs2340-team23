package model.profiles;

/**
 * Defines access privileges of a Profile
 *  USER:
 *      create water availability report
 *      view water availability
 *  WORKER:
 *      privileges of USER
 *      create water purity report
 *  MANAGER:
 *      privileges of WORKER
 *      view historical reports
 *      view water purity trends
 *      delete individual reports
 *  ADMIN:
 *      ban user from submitting reports
 *      unblock an account which has been blocked due to inaccurate login attempts
 *      delete individual accounts
 *      view security log
 */
public enum UserType {
    USER("User"), WORKER("Worker"), MANAGER("Manager"), ADMIN("Admin");

    private String stringRepresent;

    UserType(String s) {
        stringRepresent = s;
    }

    public String toString() { return stringRepresent; }
}
