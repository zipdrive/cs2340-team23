package controller;

import fxapp.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Profile;

public class ProfileEditScreenController {

    private MainApplication mainApplication;
    private Stage dialogStage;

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
     * Sets a pointer to the main application
     * @param mainApplication   pointer to the main application
     */
    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    /**
     * Sets a pointer to the dialog stage
     * @param dialogStage       Stage representing the dialog window
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the default values for the text fields
     */
    public void setValues() {
        Profile user = mainApplication.getUser();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Name Field");
            alert.setHeaderText("No Name");
            alert.setContentText("Please input a name and try again.");

            alert.showAndWait();
        } else if (username.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Username Field");
            alert.setHeaderText("No Username");
            alert.setContentText("Please input a username and try again.");

            alert.showAndWait();
        } else if (password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Null Password Field");
            alert.setHeaderText("No Password");
            alert.setContentText("Please input a password and try again.");

            alert.showAndWait();
        } else if (!email.equals("") && !Profile.matchEmailFormat(email)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Email");
            alert.setHeaderText("Email Not Correct Format");
            alert.setContentText("Please input a valid email address and try again.");

            alert.showAndWait();
        } else if (!phoneNumber.equals("") && !Profile.matchPhoneNumberFormat(phoneNumber)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Phone Number");
            alert.setHeaderText("Incorrect Phone Number Format");
            alert.setContentText("Please input a valid phone number and try again.");

            alert.showAndWait();
        } else {
            Profile user = mainApplication.getUser();
            user.setName(name);
            user.setTitle(titleField.getText());
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setHomeAddress(addressField.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Changes Saved");
            alert.setHeaderText("Changes Saved");

            alert.showAndWait();
            dialogStage.close();
        }
    }

    /**
     * Handle the "Cancel" button being pressed
     */
    @FXML
    public void handleCancelPressed() {
        dialogStage.close();
    }
}
