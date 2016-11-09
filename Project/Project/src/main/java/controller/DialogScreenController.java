package controller;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class DialogScreenController extends ScreenController {

    private Stage dialogStage;

    /**
     * Sets a pointer to the dialog stage
     * @param s       Stage representing the dialog window
     */
    public final void setDialogStage(Stage s) {
        dialogStage = s;
    }

    /**
     * Closes the dialog stage
     */
    public final void closeDialogStage() { dialogStage.close(); }

    /**
     * Generates an error dialog popup
     * @param header        String for the title and header of the popup message
     * @param body          String for the body of the popup message
     */
    final void generateErrorWarning(String header, String body) {
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
    final void generateInformationPopup(String header, String body) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);

        alert.setTitle(header);
        alert.setHeaderText(header);
        alert.setContentText(body);

        alert.showAndWait();
    }
}
