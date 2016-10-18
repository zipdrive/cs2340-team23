package model.service;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import fxapp.MainApplication;

public class GeocodeManager {
    private static GeocodingService geocoding;
    private static GeocodeProgress progress;

    private static String address;
    private static LatLong coordinates;

    public static void init() {
        GeocodeManager.geocoding = null;
        GeocodeManager.geocoding = new GeocodingService();
    }

    public static GeocodeProgress getStatus() {
        return GeocodeManager.progress;
    }

    public static String getAddress() {
        return GeocodeManager.address;
    }

    public static LatLong getCoordinates() {
        return GeocodeManager.coordinates;
    }

    public static void cancel() { GeocodeManager.progress = GeocodeProgress.CANCELLED; }

    public static void geocode(String address, GeocodeCallback callback) {
        GeocodeManager.address = null;
        GeocodeManager.coordinates = null;

        if (GeocodeManager.geocoding == null) { GeocodeManager.init(); }

        GeocodeManager.progress = GeocodeProgress.IN_PROGRESS;
        GeocodeManager.geocoding.geocode(address, (results, status) -> {
            if (GeocodeManager.progress != GeocodeProgress.CANCELLED) {
                if (status == GeocoderStatus.ZERO_RESULTS) {
                    GeocodeManager.progress = GeocodeProgress.NO_RESULTS;
                } else if (results.length > 1) {
                    // create dialog pane showing choices
                    GeocodeManager.progress = GeocodeProgress.CANCELLED;
                } else {
                    GeocodeManager.address = results[0].getFormattedAddress();
                    GeocodeManager.coordinates = results[0].getGeometry().getLocation();
                    GeocodeManager.progress = GeocodeProgress.SUCCESS;
                }
                callback.callback();
            }
        });
    }
}
