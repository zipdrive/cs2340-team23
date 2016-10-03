package fxapp;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Profile;
import model.ProfileList;

import java.io.IOException;

public class MainApplication extends Application {

    private Stage mainScreen;
    private GridPane layout;

    private ProfileList profiles;
    private Profile user;

    /**
     * Attempts a login with the given username and password
     * @param username      String representing the username of the login attempt
     * @param password      String representing the password of the login attempt
     * @return      True if a Profile exists with the given username and password, False otherwise
     */
    public Boolean login(String username, String password) {
        Profile p = profiles.findProfile(username);
        if (p != null) {
            if (p.getPassword().equals(password)) {
                this.user = p;
                return true;
            }
        }
        return false;
    }

    /**
     * Logs out of the current Profile, and returns to the welcome screen
     */
    public void logout() {
        user = null;
        initWelcomeScreen();
    }

    /**
     * Retrieve the current Profile
     * @return      Profile representing the user currently logged-in
     */
    public Profile getUser() { return user; }

    /**
     * Retrieves a list of all Profiles
     * @return      ProfileList of all Profiles in system
     */
    public ProfileList getProfiles() { return profiles; }

    /**
     * Begin the JavaFX application
     * @param primaryStage      the Stage of the application
     */
    @Override
    public void start(Stage primaryStage) {
        profiles = new ProfileList();
        mainScreen = primaryStage;
        initWelcomeScreen();
    }

    /**
     * Sets the current screen to the welcome screen
     */
    public void initWelcomeScreen() {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/welcomeScreen.fxml"));
            layout = loader.load();

            // Give the controller access to the main app.
            WelcomeScreenController controller = loader.getController();
            controller.setMainApplication(this);

            // Set the Main App title
            mainScreen.setTitle("Welcome Screen");

            // Show the scene containing the layout.
            Scene scene = new Scene(layout);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            e.printStackTrace();
        }
    }

    /**
     * Pulls up a dialog window for logging in
     */
    public void initLoginDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/loginScreen.fxml"));
            GridPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Login");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            LoginScreenController controller = loader.getController();
            controller.setMainApplication(this);
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pulls up a dialog window for registering a new Profile
     */
    public void initRegisterDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/registerScreen.fxml"));
            GridPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Register");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            RegisterScreenController controller = loader.getController();
            controller.setMainApplication(this);
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the current screen to the main screen of the application
     */
    public void initMainScreen() {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/mainScreen.fxml"));
            layout = loader.load();

            // Give the controller access to the main app.
            MainScreenController controller = loader.getController();
            controller.setMainApplication(this);

            // Set the Main App title
            mainScreen.setTitle("Main Screen");

            // Show the scene containing the layout.
            Scene scene = new Scene(layout);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            e.printStackTrace();
        }
    }

    /**
     * Pulls up a dialog window for editing the current user Profile
     */
    public void initProfileEditDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/profileEditScreen.fxml"));
            GridPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Profile");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ProfileEditScreenController controller = loader.getController();
            controller.setMainApplication(this);
            controller.setDialogStage(dialogStage);
            controller.setValues();

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The main function
     * @param args      command-line arguments
     */
    public static void main(String[] args) { launch(args); }
}
