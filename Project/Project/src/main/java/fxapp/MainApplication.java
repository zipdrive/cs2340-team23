package fxapp;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.log.ErrorLog;
import model.log.IncidentPriority;
import model.log.SecurityLog;
import model.profiles.Profile;
import model.profiles.ProfileList;
import model.reports.ReportCreator;
import model.reports.ReportList;
import model.service.GeocodeManager;

import java.io.IOException;

public class MainApplication extends Application implements MapComponentInitializedListener {

    private Stage mainScreen;
    private Pane layout;

    private GoogleMapView googleMapView;

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
        Profile p = profiles.login(username, password);
        if (p != null) { this.user = p; }
        return (p != null);
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
        googleMapView = new GoogleMapView();

        ReportCreator.setMainApplication(this);
        try { GeocodeManager.init(); } catch (Exception e) {}
        ErrorLog.init();
        SecurityLog.init();

        initScreen("Welcome Screen", "welcomeScreen.fxml");
    }

    public void mapInitialized() {}

    /**
     * Initializes a new layout in window
     * @param title     the title of the window
     * @param filename  the xml file in view
     */
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
            ErrorLog.log(e, IncidentPriority.LOCAL);
        }
    }

    /**
     * Initializes a dialog popup
     * @param title         the title of the window
     * @param filename      the xml file in view
     */
    public void initDialogScreen(String title, String filename) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/" + filename));
            Pane page = loader.load();

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
            ErrorLog.log(e, IncidentPriority.LOCAL);
        }
    }

    /**
     * Initializes a map dialog popup
     * @param title             the title of the dialog window
     * @param initializer       the initializer for the map window
     */
    public void initMapScreen(String title, MapScreenInitializer initializer) {
        try {
            Stage mapStage = new Stage();
            mapStage.setTitle(title);
            mapStage.initModality(Modality.WINDOW_MODAL);
            mapStage.initOwner(mainScreen);

            GoogleMapView mapView = new GoogleMapView();
            Scene scene = new Scene(mapView);
            mapStage.setScene(scene);

            initializer.initializeMap(mapView, this);

            mapStage.showAndWait();
        } catch (Exception e) {
            ErrorLog.log(e, IncidentPriority.LOCAL);
        }
    }

    /**
     * Generates an error alert popup
     * @param header        the title for the popup window
     * @param body          the message of the popup
     */
    public void generateErrorAlert(String header, String body) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(mainScreen);

        alert.setTitle(header);
        alert.setHeaderText(header);
        alert.setContentText(body);

        alert.showAndWait();
    }

    /**
     * Generates an information alert popup
     * @param header        the title for the popup window
     * @param body          the message of the popup
     */
    public void generateInformationAlert(String header, String body) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainScreen);

        alert.setTitle(header);
        alert.setHeaderText(header);
        alert.setContentText(body);

        alert.showAndWait();
    }

    /**
     * The main function
     * @param args      command-line arguments
     */
    public static void main(String[] args) { launch(args); }
}
