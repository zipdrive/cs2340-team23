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
    public WaterAvailabilityReport(String name, String location, WaterType waterType, WaterCondition waterCondition) {
        dateAndTime = LocalDateTime.now();
        reportNumber = 0; // TODO edit later
        nameOfReporter = name;
        locationOfReport = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
    }

    public String getDateAndTime() { return dateAndTime.toString(); }
    public int getReportNumber() { return reportNumber; }
    public String getNameOfReporter() { return nameOfReporter; }
    public String getLocationOfReport() { return locationOfReport; }
    public String getWaterType() { return waterType.toString(); }
    public String getWaterCondition() { return waterCondition.toString(); }
}
