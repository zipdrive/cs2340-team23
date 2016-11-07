package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.FXML;
import model.reports.ReportList;
import model.reports.WaterAvailabilityReport;

public final class ViewReportsMapScreenController extends DialogScreenController implements MapComponentInitializedListener {


    @FXML
    private GoogleMapView googleMapView;

    public void mapInitialized() {
        try {
            ReportList reports = getMainApplication().getReports();

            MapOptions mapOptions = new MapOptions();
            mapOptions.center(new LatLong(0, 0))
                    .zoom(1)
                    .mapType(MapTypeIdEnum.SATELLITE)
                    .streetViewControl(false);
            GoogleMap map = googleMapView.createMap(mapOptions);

            for (WaterAvailabilityReport report : reports.getReports()) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(report.getCoordinates())
                        .visible(true)
                        .title(report.getNameOfReporter() + "\n" +
                                report.getDateAndTime() + "\n" +
                                report.getWaterType() + "\n" +
                                report.getWaterCondition());
                Marker marker = new Marker(markerOptions);
                map.addMarker(marker);
            }
        } catch (Exception e) {
            generateErrorWarning("Error showing map.", "Unable to show map at this time. Please try again later.");
        }
    }

}
