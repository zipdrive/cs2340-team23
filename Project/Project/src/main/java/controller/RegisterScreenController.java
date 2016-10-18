package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.profiles.Profile;
import model.profiles.UserType;

public class RegisterScreenController extends DialogScreenController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<UserType> userTypeBox;

    /**
     * Sets the default value for the userTypeBox
     */
    @Override
    public void init() {
        userTypeBox.setValue(UserType.USER);
    }

    /**
     * Handle the "Register" button being pressed
     */
    @FXML
    public void handleRegisterPressed() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (name.equals("")) {
            generateErrorWarning("No Name Entered", "Please enter a name and try again.");
        } else if (username.equals("")) {
            generateErrorWarning("No Username Entered", "Please enter a username and try again.");
        } else if (password.equals("")) {
            generateErrorWarning("No Password Entered", "Please enter a password and try again.");
        } else if (getMainApplication().getProfiles().findProfile(username) != null) {
            generateErrorWarning("Username Already In Use", "Please enter a new username and try again.");
        } else {
            Profile newProfile = new Profile(name, username, password, userTypeBox.getValue());
            getMainApplication().getProfiles().addProfile(newProfile);
            generateInformationPopup("Profile Created", "Thank you for registering with us, " + name + "!");
            closeDialogStage();
        }
    }
}
