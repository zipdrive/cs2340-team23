package model.profiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing a user account
 */
public class Profile {
    private UserType userType;
    private String name;
    private String title;
    private String username;
    private String password;
    private String emailAddress;
    private String homeAddress;
    private int[] phoneNumber = new int[3];

    /**
     * Initializer for a new Profile
     * @param name          the actual name of the user
     * @param username      the username of the user
     * @param password      the password for the Profile
     * @param userType      UserType representing the access privileges of the Profile
     */
    public Profile(String name, String username, String password, UserType userType) {
        this.name = name;
        this.username = username;
        this.password = password;
        emailAddress = "";
        homeAddress = "";
        this.userType = userType;
    }

    /**
     * Returns the type of Profile
     * @return      UserType representing the Profile account privileges
     */
    public UserType getUserType() { return userType; }

    /**
     * Sets the type of Profile
     * @param userType      UserType representing the new privileges of the Profile
     */
    public void setUserType(UserType userType) { this.userType = userType; }

    /**
     * Returns the name of the Profile user
     * @return      String representing the name of the Profile user
     */
    public String getName() { return name; }

    /**
     * Sets the name of the Profile user
     * @param name      String representing the new name to set for the Profile
     */
    public void setName(String name) { this.name = name; }

    /**
     * Returns the title of the Profile user (Mr, Miss, etc.)
     * @return      String representing the title of the Profile user
     */
    public String getTitle() { return title; }

    /**
     * Sets the title of the Profile user
     * @param title     String representing the new title to set for the Profile user
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Returns the username of the Profile
     * @return      String of the Profile username
     */
    public String getUsername() { return username; }

    /**
     * Sets the username of the Profile
     * @param username      String representing the new username
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * Returns the password of the Profile
     * @return      String of the Profile password
     */
    public String getPassword() { return password; }

    /**
     * Sets the password of the Profile
     * @param password      String representing the new password
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Returns the home address of the Profile user
     * @return      String of the Profile user's home address
     */
    public String getHomeAddress() { return homeAddress; }

    /**
     * Sets the home address of the Profile user
     * @param homeAddress       String representing the new home address of the Profile user
     */
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

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
        return Pattern.compile("\\(?(\\d{3})\\)?-? ?(\\d{3})\\-?(\\d{4})").matcher(phoneNumber).find();
    }

    /**
     * Sets the email address of the Profile user
     * @param emailAddress      String representing the new email address of the Profile user
     */
    public void setEmail(String emailAddress) {
        if (matchEmailFormat(emailAddress)) {
            this.emailAddress = emailAddress;
        }
    }

    /**
     * Sets the phone number of the Profile user
     * @param phoneNumber       String representing the new phone number of the Profile user
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.equals("")) {
            for (int i = 0; i < 3; i++) {
                this.phoneNumber[i] = 0;
            }
            return;
        } else {
            Pattern pattern = Pattern.compile("\\(?(\\d{3})\\)?\\-?(\\d{3})\\-?(\\d{4})");
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.find()) {
                for (int i = 0; i < 3; i++) {
                    this.phoneNumber[i] = Integer.parseInt(matcher.group(i+1));
                }
                return;
            }
            return;
        }
    }
}
