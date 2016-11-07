package model.reports;

import com.lynden.gmapsfx.javascript.object.LatLong;

public final class WaterPurityReport extends WaterReport {
    private final WaterPurityCondition condition;
    private final double virusPPM;
    private final double contaminantPPM;

    public WaterPurityReport(int number,
                             String name,
                             String address,
                             LatLong coordinates,
                             WaterPurityCondition c,
                             double vPPM,
                             double cPPM) {
        super(number, name, address, coordinates);
        condition = c;
        virusPPM = vPPM;
        contaminantPPM = cPPM;
    }

    /**
     * Retrieves the overall condition of the water
     * @return      String representing the overall condition of the water (Safe, Treatable, Unsafe)
     */
    public String getOverallCondition() { return condition.toString(); }

    /**
     * Retrieves the virus PPM of the water
     * @return      double representing the virus PPM of the water
     */
    public double getVirusPPM() { return virusPPM; }

    /**
     * Retrieves the contaminant PPM of the water
     * @return      double representing the contaminant PPM of the water
     */
    public double getContaminantPPM() { return contaminantPPM; }
}
