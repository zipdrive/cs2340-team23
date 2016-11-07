package controller;

import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import model.service.GeocodeCallback;
import model.service.GeocodeManager;

public final class GeocodingMultipleLocationsScreenController extends DialogScreenController {

    private GeocodeCallback callback;

    @FXML
    private ComboBox<GeocodingResult> locationsComboBox;

    @Override
    public void init() {
        callback = GeocodeManager.getCallback();

        ObservableList<GeocodingResult> list = new ReadOnlyListWrapper<>();
        for (int i = 0; i < GeocodeManager.getNumResults(); i++) {
            list.add(GeocodeManager.getResult(i));
        }
        locationsComboBox.setItems(list);
    }

    /**
     * Handles when the "Confirm" button is pressed
     */
    public void handleConfirmPressed() {
        GeocodeManager.setResult(locationsComboBox.getValue());
        callback.callback();
        closeDialogStage();
    }
}
