package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profile {
    private UserType userType;
    private String name;
    private String title;
    private String username;
    private String password;
    private String emailAddress;
    private String homeAddress;
    private int[] phoneNumber = new int[3];

    public Profile(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmailAddress() { return emailAddress; }
    public String getPhoneNumber() {
        if (phoneNumber[0] == 0 && phoneNumber[1] == 0 && phoneNumber[2] == 0) {
            return "";
        } else {
            return String.format("(%03d) %03d-%04d", phoneNumber[0], phoneNumber[1], phoneNumber[2]);
        }
    }

    public Boolean check(String username, String password) {
        return (this.username.equals(username) && this.password.equals(password));
    }

    public static Boolean matchEmailFormat(String emailAddress) {
        return Pattern.compile(".+@.+\\..+").matcher(emailAddress).find();
    }

    public static Boolean matchPhoneNumberFormat(String phoneNumber) {
        return Pattern.compile("\\(?(\\d{3})\\)?-? ?(\\d{3})\\-?(\\d{4})").matcher(phoneNumber).find();
    }

    public Boolean setEmail(String emailAddress) {
        if (matchEmailFormat(emailAddress)) {
            this.emailAddress = emailAddress;
            return true;
        }
        return false;
    }

    public Boolean setPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\(?(\\d{3})\\)?\\-?(\\d{3})\\-?(\\d{4})");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            for (int i = 0; i < 3; i++) {
                this.phoneNumber[i] = Integer.parseInt(matcher.group(i));
            }
            return true;
        }
        return false;
    }
}
