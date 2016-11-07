package model.profiles;

public enum LoginAttemptResult {
    UNKNOWN_ID("Unknown ID"), BAD_PASSWORD("Bad Password"), SUCCESS("Success");

    private final String text;
    LoginAttemptResult(String s) { text = s; }

    public String toString() { return text; }
}
