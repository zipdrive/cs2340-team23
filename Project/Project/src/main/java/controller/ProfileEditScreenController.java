package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.profiles.Profile;

public class ProfileEditScreenController extends DialogScreenController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField addressField;

    /**
     * Sets the default values for the text fields
     */
    @Override
    public void init() {
        Profile user = getMainApplication().getUser();
        nameField.setText(user.getName());
        titleField.setText(user.getTitle());
        usernameField.setText(user.getUsername());
        passwordField.setText(user.getPassword());
        emailField.setText(user.getEmailAddress());
        phoneNumberField.setText(user.getPhoneNumber());
        addressField.setText(user.getHomeAddress());
    }

    /**
     * Handle the "Save Changes" button being pressed
     */
    @FXML
    public void handleSaveChangesPressed() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        if (name.equals("")) {
            generateErrorWarning("No Name Entered", "Please enter a name and try again.");
        } else if (username.equals("")) {
            generateErrorWarning("No Username Entered", "Please enter a username and try again.");
        } else if (password.equals("")) {
            generateErrorWarning("No Password Entered", "Please enter a password and try again.");
        } else if (!email.equals("") && !Profile.matchEmailFormat(email)) {
            generateErrorWarning("Invalid Email", "Please enter a valid email address and try again.");
        } else if (!phoneNumber.equals("") && !Profile.matchPhoneNumberFormat(phoneNumber)) {
            generateErrorWarning("Invalid Phone Number", "Please enter a valid phone number and try again.");
        } else if (getMainApplication().getProfiles().findProfile(username) != null) {
            generateErrorWarning("Username Already Taken", "Please enter another username and try again.");
        } else {
            Profile user = getMainApplication().getUser();
            user.setName(name);
            user.setTitle(titleField.getText());
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setHomeAddress(addressField.getText());

            generateInformationPopup("Changes Saved", "Your profile has been edited!");
            closeDialogStage();
        }
    }
}
