package model.reports;

import com.lynden.gmapsfx.javascript.object.LatLong;

import java.time.LocalDateTime;

public class WaterReport {
    private final LocalDateTime timestamp;
    private final int number;
    private final String name;
    private final String address;
    private final LatLong coordinates;

    public WaterReport(int number,
                       String name,
                       String address,
                       LatLong coordinates) {
        timestamp = LocalDateTime.now();
        this.number = number;
        this.name = name;
        this.address = address;
        this.coordinates = coordinates;
    }

    /**
     * Retrieves the date and time of the report
     * @return      date and time of report
     */
    public String getDateAndTime() { return timestamp.getMonth().getValue() +
            "/" + timestamp.getDayOfMonth() +
            "/" + timestamp.getYear() +
            ", " + timestamp.getHour() +
            ":" + String.format("%02d", timestamp.getMinute()); }

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
    public LatLong getCoordinates() { return coordinates; }
}
