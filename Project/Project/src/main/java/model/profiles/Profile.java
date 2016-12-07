package model.profiles;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing a user account
 */
public final class Profile implements Serializable {
    private static final int PHONE_NUMBER_DIVISIONS = 3;

    private UserType userType;
    private boolean blocked;
    private boolean banned;

    private String name;
    private String title;
    private String username;
    private String password;
    private String emailAddress;
    private String homeAddress;
    private final int[] phoneNumber = new int[PHONE_NUMBER_DIVISIONS];

    /**
     * Initializer for a new Profile
     * @param n          the actual name of the user
     * @param u          the username of the user
     * @param p          the password for the Profile
     * @param t          UserType representing the access privileges of the Profile
     */
    public Profile(String n, String u, String p, UserType t) {
        name = n;
        username = u;
        password = p;
        emailAddress = "";
        homeAddress = "";
        userType = t;
    }

    /**
     * Returns the type of Profile
     * @return      UserType representing the Profile account privileges
     */
    public UserType getUserType() { return userType; }

    /**
     * Sets the type of Profile
     * @param t      UserType representing the new privileges of the Profile
     */
    public void setUserType(UserType t) { userType = t; }

    public boolean getBlocked() { return blocked; }
    public void setBlocked(boolean b) { blocked = b; }
    public boolean getBanned() { return banned; }
    public void setBanned(boolean b) { banned = b; }

    /**
     * Returns the name of the Profile user
     * @return      String representing the name of the Profile user
     */
    public String getName() { return name; }

    /**
     * Sets the name of the Profile user
     * @param n      String representing the new name to set for the Profile
     */
    public void setName(String n) { name = n; }

    /**
     * Returns the title of the Profile user (Mr, Miss, etc.)
     * @return      String representing the title of the Profile user
     */
    public String getTitle() { return title; }

    /**
     * Sets the title of the Profile user
     * @param t     String representing the new title to set for the Profile user
     */
    public void setTitle(String t) { title = t; }

    /**
     * Returns the username of the Profile
     * @return      String of the Profile username
     */
    public String getUsername() { return username; }

    /**
     * Sets the username of the Profile
     * @param u      String representing the new username
     */
    public void setUsername(String u) { username = u; }

    /**
     * Returns the password of the Profile
     * @return      String of the Profile password
     */
    public String getPassword() { return password; }

    /**
     * Sets the password of the Profile
     * @param p      String representing the new password
     */
    public void setPassword(String p) { password = p; }

    /**
     * Returns the home address of the Profile user
     * @return      String of the Profile user's home address
     */
    public String getHomeAddress() { return homeAddress; }

    /**
     * Sets the home address of the Profile user
     * @param h       String representing the new home address of the Profile user
     */
    public void setHomeAddress(String h) { homeAddress = h; }

    /**
     * Returns the email address of the Profile user
     * @return      String of the Profile user's email address
     */
    public String getEmailAddress() { return emailAddress; }

    /**
     * Returns the phone number of the Profile user
     * @return      String representing the phone number of the Profile user
     */
    public String getPhoneNumber() {
        if (phoneNumber[0] == 0 && phoneNumber[1] == 0 && phoneNumber[2] == 0) {
            return "";
        } else {
            return String.format("(%03d) %03d-%04d", phoneNumber[0], phoneNumber[1], phoneNumber[2]);
        }
    }

    /**
     * Checks to see if the given parameter matches the format of an email address (something@something.smth)
     * @param emailAddress      String to check format of
     * @return          True if it matches the proper format, False otherwise
     */
    public static Boolean matchEmailFormat(String emailAddress) {
        return Pattern.compile(".+@.+\\..+").matcher(emailAddress).find();
    }

    /**
     * Checks to see if the given parameter matches the format of a phone number
     * @param phoneNumber       String to check format of
     * @return          True if it matches the proper format (has 3-3-4 digits), False otherwise
     */
    public static Boolean matchPhoneNumberFormat(String phoneNumber) {
        return Pattern.compile("\\(?(\\d{3})\\)?[\\s\\-]*(\\d{3})[\\s\\-]*(\\d{4})").matcher(phoneNumber).find();
    }

    /**
     * Sets the email address of the Profile user
     * @param e      String representing the new email address of the Profile user
     */
    public void setEmail(String e) {
        if (matchEmailFormat(e)) {
            emailAddress = e;
        }
    }

    /**
     * Sets the phone number of the Profile user
     * @param p       String representing the new phone number of the Profile user
     */
    public void setPhoneNumber(String p) {
        if (p.isEmpty()) {
            for (int i = 0; i < PHONE_NUMBER_DIVISIONS; i++) {
                phoneNumber[i] = 0;
            }
        } else {
            Pattern pattern = Pattern.compile("\\(?(\\d{3})\\)?[\\s\\-]*(\\d{3})[\\s\\-]*(\\d{4})");
            Matcher matcher = pattern.matcher(p);
            if (matcher.find()) {
                for (int i = 0; i < PHONE_NUMBER_DIVISIONS; i++) {
                    phoneNumber[i] = Integer.parseInt(matcher.group(i+1));
                }
            }
        }
    }
}
