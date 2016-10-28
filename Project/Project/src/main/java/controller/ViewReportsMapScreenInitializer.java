package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.IJavascriptRuntime;
import com.lynden.gmapsfx.javascript.JavascriptRuntime;
import com.lynden.gmapsfx.javascript.object.*;
import fxapp.MainApplication;
import model.log.ErrorLog;
import model.reports.ReportList;
import model.reports.WaterAvailabilityReport;

public class ViewReportsMapScreenInitializer implements MapScreenInitializer {

    /**
     * Initializes the map with markers representing report locations
     * @param googleMapView         the GoogleMapView object
     * @param mainApplication       reference to the MainApplication object
     */
    public void initializeMap(GoogleMapView googleMapView, MainApplication mainApplication) {
        try {
            ReportList reports = mainApplication.getReports();

            MapOptions mapOptions = new MapOptions();
            mapOptions.center(new LatLong(0.0, 0.0))
                    .zoom(1)
                    .mapType(MapTypeIdEnum.SATELLITE)
                    .streetViewControl(false);
            GoogleMap map = googleMapView.createMap(mapOptions);

            IJavascriptRuntime runtime;

            for (WaterAvailabilityReport report : reports.getReports()) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(report.getCoordinates())
                        .visible(true)
                        .title(report.getWaterType() + " (Condition: " +
                                report.getWaterCondition() + ")\n" +
                                "(Submitted on " + report.getDateAndTime() + " by " + report.getNameOfReporter() + ")");
                Marker marker = new Marker(markerOptions);

                runtime = JavascriptRuntime.getInstance();
                String varName = marker.getVariableName();
                runtime.execute("google.maps.event.addListener(" + varName + ", 'click', function(){ " +
                        "var infoWindow = new google.maps.InfoWindow({ " +
                        "content:" + varName + ".title, " +
                        "position:" + report.getCoordinates().getVariableName() +
                        "}); " +
                        "infoWindow.open(" + map.getVariableName() + "); " +
                        "});");

                map.addMarker(marker);
            }
        } catch (Exception e) {
            mainApplication.generateErrorAlert("Error showing map.",
                    "Unable to show map at this time. Please try again later.");
            ErrorLog.log(e, true);
        }
    }
}
