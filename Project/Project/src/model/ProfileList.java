package model;

import java.util.Set;

/**
 * Class to manage all Profiles
 */
public class ProfileList {
    private Set<Profile> profileSet = new java.util.HashSet();

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
}
