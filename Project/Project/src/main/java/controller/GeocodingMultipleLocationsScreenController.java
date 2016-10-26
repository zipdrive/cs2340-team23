package controller;

import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import model.service.GeocodeCallback;
import model.service.GeocodeManager;

import java.util.Collections;

public class GeocodingMultipleLocationsScreenController extends DialogScreenController {

    private GeocodeCallback callback;

    @FXML
    private ComboBox<GeocodingResult> locationsComboBox;

    @Override
    public void init() {
        callback = GeocodeManager.getCallback();

        ObservableList<GeocodingResult> list = new ReadOnlyListWrapper<>();
        Collections.addAll(list, GeocodeManager.getResults());
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
