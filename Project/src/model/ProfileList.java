package model;

import java.util.Set;

public class ProfileList {
    private Set<Profile> profileSet = new java.util.HashSet();

    public void addProfile(Profile p) {
        profileSet.add(p);
    }

    public Profile removeProfile(Profile p) {
        profileSet.remove(p);
        return p;
    }

    public Profile findProfile(String username) {
        for (Profile p : profileSet) {
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }
}
