package model.reports;

/**
 * Enum for the type of water source
 */
public enum WaterType {
    BOTTLED("Bottled Water"), WELL("Well"), STREAM("Stream"), LAKE("Lake"), SPRING("Spring"), OTHER("Other");

    private String stringRepresent;

    WaterType(String s) {
        stringRepresent = s;
    }

    public String toString() { return stringRepresent; }
}
