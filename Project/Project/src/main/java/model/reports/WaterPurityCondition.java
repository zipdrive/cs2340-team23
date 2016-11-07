package model.reports;

public enum WaterPurityCondition {
    SAFE("Safe"),
    TREATABLE("Treatable"),
    UNSAFE("Unsafe");

    private final String text;

    WaterPurityCondition(String s) { text = s; }

    public String toString() { return text; }
}
