package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class DialogScreenController extends ScreenController {

    private Stage dialogStage;

    /**
     * Sets a pointer to the dialog stage
     * @param dialogStage       Stage representing the dialog window
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Closes the dialog stage
     */
    public void closeDialogStage() { dialogStage.close(); }

    /**
     * Generates an error dialog popup
     * @param header        String for the title and header of the popup message
     * @param body          String for the body of the popup message
     */
    public void generateErrorWarning(String header, String body) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(dialogStage);

        alert.setTitle(header);
        alert.setHeaderText(header);
        alert.setContentText(body);

        alert.showAndWait();
    }

    /**
     * Generates an informational/confirmation dialog popup
     * @param header        String for the title and header of the popup message
     * @param body          String for the body of the popup message
     */
    public void generateInformationPopup(String header, String body) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);

        alert.setTitle(header);
        alert.setHeaderText(header);
        alert.setContentText(body);

        alert.showAndWait();
    }
}
