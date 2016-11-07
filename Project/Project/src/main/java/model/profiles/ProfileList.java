package model.profiles;

import model.log.SecurityLog;
import model.profiles.Profile;

import java.io.Serializable;
import java.util.Set;

/**
 * Class to manage all Profiles
 */
public final class ProfileList implements Serializable {
    private final Set<Profile> profileSet;

    /**
     * Constructor for ProfileList
     */
    public ProfileList() {
        profileSet = new java.util.HashSet<>();
    }

    /**
     * Adds a new Profile
     * @param p     the Profile to be added
     */
    public void addProfile(Profile p) {
        profileSet.add(p);
    }

    /**
     * Removes a Profile
     * @param p     the Profile to be removed
     * @return      the removed Profile
     */
    public Profile removeProfile(Profile p) {
        profileSet.remove(p);
        return p;
    }

    /**
     * Finds a Profile with the specified username
     * @param username      the username of the Profile to be found
     * @return              the Profile with the specified username,
     *                      null if no such Profile exists
     */
    public Profile findProfile(String username) {
        for (Profile p : profileSet) {
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Checks username and password for correctness
     * @param username      the username to check
     * @param password      the password to check
     * @return              Profile with username and password
     *                      null if username does not exist or has different password
     */
    public Profile login(String username, String password) {
        Profile p = findProfile(username);
        if (p == null) {
            SecurityLog.logLoginAttempt(username, LoginAttemptResult.UNKNOWN_ID);
        } else if (!p.getPassword().equals(password)) {
            SecurityLog.logLoginAttempt(username, LoginAttemptResult.BAD_PASSWORD);
        } else {
            SecurityLog.logLoginAttempt(username, LoginAttemptResult.SUCCESS);
            return p;
        }
        return null;
    }
}
