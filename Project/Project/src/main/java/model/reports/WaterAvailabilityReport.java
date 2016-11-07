package model.reports;

import com.lynden.gmapsfx.javascript.object.LatLong;

public final class WaterAvailabilityReport extends WaterReport {
    private final WaterType type;
    private final WaterCondition condition;

    /**
     * Generates a new WaterAvailabilityReport
     * @param number            the number of the report
     * @param name              the name of the reporter
     * @param address           the formatted address of the water source
     * @param coordinates       the coordinates of the water source
     * @param t                 the type of water source
     * @param c                 the condition of the water source
     */
    public WaterAvailabilityReport(int number,
                                   String name,
                                   String address,
                                   LatLong coordinates,
                                   WaterType t,
                                   WaterCondition c) {
        super(number, name, address, coordinates);
        type = t;
        condition = c;
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
