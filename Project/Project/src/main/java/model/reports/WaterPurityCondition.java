package model.reports;

public enum WaterPurityCondition {
    SAFE("Safe"),
    TREATABLE("Treatable"),
    UNSAFE("Unsafe");

    private String text;

    WaterPurityCondition(String text) { this.text = text; }

    public String toString() { return text; }
}
