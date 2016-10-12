package model;

import java.time.LocalDateTime;

public class WaterAvailabilityReport {
    private LocalDateTime dateAndTime;
    private int reportNumber;
    private String nameOfReporter;
    private String locationOfReport; // maybe do something with this later
    private WaterType waterType;
    private WaterCondition waterCondition;

    /**
     * Generates a new WaterAvailabilityReport
     * @param name              the name of the reporter
     * @param location          the location of the water source
     * @param waterType         the type of water source
     * @param waterCondition    the condition of the water source
     */
    public WaterAvailabilityReport(int number, String name, String location, WaterType waterType, WaterCondition waterCondition) {
        dateAndTime = LocalDateTime.now();
        reportNumber = number;
        nameOfReporter = name;
        locationOfReport = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
    }

    /**
     * Retrieves the date and time of the report
     * @return      date and time of report
     */
    public String getDateAndTime() { return dateAndTime.toString(); }

    /**
     * Retrieves the report number
     * @return      number of report
     */
    public int getReportNumber() { return reportNumber; }

    /**
     * Retrieves the name of the person who made the report
     * @return      name of report creator
     */
    public String getNameOfReporter() { return nameOfReporter; }

    /**
     * Retrieves the location of the report
     * @return      location of report
     */
    public String getLocationOfReport() { return locationOfReport; }

    /**
     * Retrieves the water source type
     * @return      type of water source
     */
    public String getWaterType() { return waterType.toString(); }

    /**
     * Retrieves the condition of the water
     * @return      condition of the water
     */
    public String getWaterCondition() { return waterCondition.toString(); }
}
