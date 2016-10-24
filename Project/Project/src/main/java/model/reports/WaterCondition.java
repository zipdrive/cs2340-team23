package model.reports;

/**
 * Enum for the condition of the water
 */
public enum WaterCondition {
    WASTE("Waste"), TREATABLE_CLEAR("Treatable (Clear)"), TREATABLE_MUDDY("Treatable (Muddy)"), POTABLE("Potable");

    private final String stringRepresent;

    WaterCondition(String s) {
        stringRepresent = s;
    }

    public String toString() { return stringRepresent; }
}
