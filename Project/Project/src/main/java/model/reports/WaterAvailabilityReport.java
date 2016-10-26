package model.reports;

import com.lynden.gmapsfx.javascript.object.LatLong;

public class WaterAvailabilityReport extends WaterReport {
    private final WaterType type;
    private final WaterCondition condition;

    /**
     * Generates a new WaterAvailabilityReport
     * @param number            the number of the report
     * @param name              the name of the reporter
     * @param address           the formatted address of the water source
     * @param coordinates       the coordinates of the water source
     * @param type              the type of water source
     * @param condition         the condition of the water source
     */
    public WaterAvailabilityReport(int number,
                                   String name,
                                   String address,
                                   LatLong coordinates,
                                   WaterType type,
                                   WaterCondition condition) {
        super(number, name, address, coordinates);
        this.type = type;
        this.condition = condition;
    }

    /**
     * Retrieves the water source type
     * @return      type of water source
     */
    public String getWaterType() { return type.toString(); }

    /**
     * Retrieves the condition of the water
     * @return      condition of the water
     */
    public String getWaterCondition() { return condition.toString(); }
}
