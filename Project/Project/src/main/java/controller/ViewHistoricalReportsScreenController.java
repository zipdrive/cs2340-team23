package controller;

import com.lynden.gmapsfx.javascript.object.LatLong;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.TextField;
import model.reports.WaterPurityReport;
import model.service.GeocodeManager;

import java.time.LocalDateTime;
import java.time.Month;

public class ViewHistoricalReportsScreenController extends DialogScreenController {

    private int year;
    private LatLong location;

    @FXML
    private TextField yearField;
    @FXML
    private TextField locationField;
    @FXML
    private LineChart<Number, Number> virusPPMChart;
    @FXML
    private NumberAxis virusAxis;
    @FXML
    private LineChart<Number, Number> contaminantPPMChart;
    @FXML
    private NumberAxis contaminantAxis;

    /**
     * Converts from a LocalDateTime to a double
     * @param value     the timestamp, in LocalDateTime
     * @return          value of the timestamp, as a double
     */
    private double convertDateToNumber(LocalDateTime value) {
        double val = (double)value.getDayOfMonth();
        for (int i = 1; i < value.getMonthValue(); i++) {
            val += (year % 4 == 0 ? Month.of(i).maxLength() : Month.of(i).minLength());
        }
        val += (value.getHour()+((value.getMinute()+(value.getSecond()/60.0))/60.0))/24.0;
        return val-1;
    }

    public void init() {
        virusAxis.setAutoRanging(false);
        virusAxis.setTickUnit(30.5);
        virusAxis.setTickLabelsVisible(false);
        virusAxis.setLowerBound(0);
        virusAxis.setUpperBound(365);
        virusAxis.setLabel("Date");
        virusPPMChart.getYAxis().setLabel("Virus PPM");
        contaminantAxis.setAutoRanging(false);
        contaminantAxis.setTickUnit(30.5);
        contaminantAxis.setTickLabelsVisible(false);
        contaminantAxis.setLowerBound(0);
        contaminantAxis.setUpperBound(365);
        contaminantAxis.setLabel("Date");
        contaminantPPMChart.getYAxis().setLabel("Contaminant PPM");
    }

    /**
     * Handles when the "Update" button is pressed
     */
    public void handleUpdatePressed() {
        if (yearField.getText().equals("")) {
            generateErrorWarning("No Year Entered", "Please enter a year and try again.");
        } else if (locationField.getText().equals("")) {
            generateErrorWarning("No Location Entered", "Please enter a location and try again.");
        } else {
            GeocodeManager.geocode(locationField.getText(), () -> {
                year = Integer.parseInt(yearField.getText());
                location = GeocodeManager.getCoordinates();

                virusAxis.setUpperBound(year%4 == 0 ? 366 : 365);
                contaminantAxis.setUpperBound(year%4 == 0 ? 366 : 365);

                XYChart.Series<Number, Number> virusData = new XYChart.Series<>();
                XYChart.Series<Number, Number> contaminantData = new XYChart.Series<>();
                getMainApplication().getReports().getPurityReports().stream().filter(report -> report.getTimestamp().getYear() == year && report.getCoordinates().distanceFrom(location) < 0.000001).forEach(report -> {
                    double timestamp = convertDateToNumber(report.getTimestamp());
                    virusData.getData().add(new XYChart.Data<>(timestamp, report.getVirusPPM()));
                    contaminantData.getData().add(new XYChart.Data<>(timestamp, report.getContaminantPPM()));
                });
                virusPPMChart.getData().clear();
                virusPPMChart.getData().add(virusData);
                contaminantPPMChart.getData().clear();
                contaminantPPMChart.getData().add(contaminantData);
            });
        }
    }
}
