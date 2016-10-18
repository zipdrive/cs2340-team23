package controller;

import com.lynden.gmapsfx.GoogleMapView;
import fxapp.MainApplication;

public interface MapScreenInitializer {
    public void initializeMap(GoogleMapView googleMapView, MainApplication mainApplication);
}
