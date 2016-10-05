package fxapp;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Profile;
import model.ProfileList;
import model.ReportList;
import model.UserType;

import java.io.IOException;

public class MainApplication extends Application {

    private Stage mainScreen;
    private GridPane layout;

    private ReportList reports;
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
        initScreen("Welcome Screen", "welcomeScreen.fxml");
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
     * Retrieves a list of all water reports
     * @return      ReportList containing all reports in system
     */
    public ReportList getReports() { return reports; }

    /**
     * Begin the JavaFX application
     * @param primaryStage      the Stage of the application
     */
    @Override
    public void start(Stage primaryStage) {
        reports = new ReportList();
        profiles = new ProfileList();
        mainScreen = primaryStage;
        initScreen("Welcome Screen", "welcomeScreen.fxml");
    }

    public void initScreen(String title, String filename) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/" + filename));
            layout = loader.load();

            // Give the controller access to the main app.
            ScreenController controller = loader.getController();
            controller.setMainApplication(this);
            controller.init();

            // Set the Main App title
            mainScreen.setTitle(title);

            // Show the scene containing the layout.
            Scene scene = new Scene(layout);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            e.printStackTrace();
        }
    }

    public void initDialogScreen(String title, String filename) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/" + filename));
            GridPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            DialogScreenController controller = loader.getController();
            controller.setMainApplication(this);
            controller.setDialogStage(dialogStage);
            controller.init();

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
