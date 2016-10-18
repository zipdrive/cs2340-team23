package model.service;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import fxapp.MainApplication;

public class GeocodeManager {
    private static GeocodingService geocoding;
    private static GeocodeProgress progress;

    private static GeocodeCallback callback;
    private static GeocodingResult[] results;
    private static String address;
    private static LatLong coordinates;

    /**
     * Initializes the GeocodingService
     */
    public static void init() {
        GeocodeManager.geocoding = null;
        GeocodeManager.geocoding = new GeocodingService();
    }

    /**
     * Retrieves the current status of geocoding
     * @return      GeocodeProgress object representing the current progress or result of geocoding
     */
    public static GeocodeProgress getStatus() {
        return GeocodeManager.progress;
    }

    /**
     * Retrieves the callback function
     * @return      GeocodeCallback object with the callback function
     */
    public static GeocodeCallback getCallback() { return GeocodeManager.callback; }

    /**
     * Retrieves an array of results gained from the geocoding
     * @return      GeocodingResult[] of results from the geocoding request
     */
    public static GeocodingResult[] getResults() { return GeocodeManager.results; }

    /**
     * Retrieves the formatted address of the last request
     * @return      String of the formatted address
     */
    public static String getAddress() {
        return GeocodeManager.address;
    }

    /**
     * Retrieves the coordinates of the last request
     * @return      LatLong representing the coordinates
     */
    public static LatLong getCoordinates() {
        return GeocodeManager.coordinates;
    }

    /**
     * Cancels the current geocoding request
     */
    public static void cancel() { GeocodeManager.progress = GeocodeProgress.CANCELLED; }

    /**
     * Sends a geocoding request for the given address
     * @param address       String of the address for request
     * @param callback      essentially, a function for what to do when a success state is reached
     */
    public static void geocode(String address, GeocodeCallback callback) {
        GeocodeManager.address = null;
        GeocodeManager.coordinates = null;
        GeocodeManager.callback = callback;

        if (GeocodeManager.geocoding == null) { GeocodeManager.init(); }

        GeocodeManager.progress = GeocodeProgress.IN_PROGRESS;
        GeocodeManager.geocoding.geocode(address, (results, status) -> {
            GeocodeManager.results = results;
            if (GeocodeManager.progress != GeocodeProgress.CANCELLED) {
                if (status == GeocoderStatus.ZERO_RESULTS) {
                    GeocodeManager.progress = GeocodeProgress.NO_RESULTS;
                } else if (results.length > 1) {
                    GeocodeManager.progress = GeocodeProgress.MULTIPLE_RESULTS;
                } else {
                    GeocodeManager.setResult(results[0]);
                }
                callback.callback();
            }
        });
    }

    /**
     * Sets the final result of the geocoding search
     * @param result        the result selected
     */
    public static void setResult(GeocodingResult result) {
        GeocodeManager.address = result.getFormattedAddress();
        GeocodeManager.coordinates = result.getGeometry().getLocation();
        GeocodeManager.progress = GeocodeProgress.SUCCESS;
    }
}
