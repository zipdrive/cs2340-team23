package model.reports;

import com.lynden.gmapsfx.javascript.object.LatLong;

import java.io.Serializable;
import java.time.LocalDateTime;

public class WaterReport implements Serializable {
    private final LocalDateTime timestamp;
    private final int number;
    private final String name;
    private final String address;
    private final double lat;
    private final double lon;

    WaterReport(int number,
                String name,
                String address,
                LatLong coordinates) {
        timestamp = LocalDateTime.now();
        this.number = number;
        this.name = name;
        this.address = address;
        this.lat = coordinates.getLatitude();
        this.lon = coordinates.getLongitude();
    }

    /**
     * Retrieves the date and time of the report
     * @return      String date and time of report
     */
    public String getDateAndTime() { return timestamp.getMonth().getValue() +
            "/" + timestamp.getDayOfMonth() +
            "/" + timestamp.getYear() +
            ", " + timestamp.getHour() +
            ":" + String.format("%02d", timestamp.getMinute()); }

    /**
     * Retrieves the timestamp of the report
     * @return      LocalDateTime timestamp of the report
     */
    public LocalDateTime getTimestamp() { return timestamp; }

    /**
     * Retrieves the report number
     * @return      number of report
     */
    public int getReportNumber() { return number; }

    /**
     * Retrieves the name of the person who made the report
     * @return      name of report creator
     */
    public String getNameOfReporter() { return name; }

    /**
     * Retrieves the location of the report
     * @return      location of report, in address form
     */
    public String getLocationOfReport() { return address; }

    /**
     * Retrieves the location of the report, in coordinates
     * @return      location of report, in coordinates
     */
    public LatLong getCoordinates() { return new LatLong(lat, lon); }
}
