package fxapp;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.IOManager;
import model.log.ErrorLog;
import model.log.SecurityLog;
import model.profiles.Profile;
import model.profiles.ProfileList;
import model.reports.ReportCreator;
import model.reports.ReportList;
import model.service.GeocodeManager;

import java.io.IOException;
import java.util.Optional;

public final class MainApplication extends Application implements MapComponentInitializedListener {

    private Stage mainScreen;

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
     * Retrieves a reference to the main window
     * @return      Stage representing the main window
     */
    public Stage getMainScreen() { return mainScreen; }

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
        reports = IOManager.loadReports();
        profiles = IOManager.loadProfiles();
        IOManager.loadLogs();
        mainScreen = primaryStage;

        googleMapView = new GoogleMapView();

        ReportCreator.setMainApplication(this);
        try { GeocodeManager.init(); } catch (Exception ignored) {}
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
            Pane layout = loader.load();

            // Give the controller access to the main app.
            ScreenController controller = loader.getController();
            controller.setMainApplication(this);
            controller.init();

            // Set the Main App title
            mainScreen.setTitle(title);

            // Show the scene containing the layout.
            Scene scene = new Scene(layout);
            mainScreen.setScene(scene);
            scene.getWindow().setOnCloseRequest(event -> {
                if (generateSaveAndQuitMessage()) {
                    System.exit(0);
                } else {
                    event.consume();
                }
            });
            mainScreen.show();

        } catch (IOException e) {
            ErrorLog.log(e);
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
            ErrorLog.log(e);
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

            googleMapView = new GoogleMapView();
            googleMapView.addMapInializedListener(() -> {
                initializer.initializeMap(googleMapView, this);

                Scene scene = new Scene(googleMapView);
                mapStage.setScene(scene);
            });

            mapStage.showAndWait();

        } catch (Exception e) {
            ErrorLog.log(e);
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
     * Generates a message asking if the user wants to save and quit, and saves if the user directs the program to do so
     * @return      true if the program should close, false otherwise
     */
    public boolean generateSaveAndQuitMessage() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(mainScreen);

        alert.setTitle("Save Before Closing");
        alert.setHeaderText("Save Before Closing");
        alert.setContentText("Do you want to save before closing?");

        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yesButton, noButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) {
            return false;
        } else {
            if (result.get() == yesButton) {
                // save
                IOManager.saveProfiles(profiles);
                IOManager.saveReports(reports);
                IOManager.saveLogs();
                return true;
            } else return result.get() == noButton;
        }
    }

    /**
     * The main function
     * @param args      command-line arguments
     */
    public static void main(String[] args) { launch(args); }
}
