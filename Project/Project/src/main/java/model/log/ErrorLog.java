package model.log;

import java.util.ArrayList;
import java.util.List;

public final class ErrorLog {
    private static List<Exception> log;

    private ErrorLog() {}

    public static void init() {
        ErrorLog.log = new ArrayList<>();
    }

    public static void log(Exception e) {
        ErrorLog.log.add(e);
    }

}
