package model.log;

import java.util.ArrayList;
import java.util.List;

public class ErrorLog {
    private static List<ErrorIncident> log;

    public static void init() {
        ErrorLog.log = new ArrayList<>();
    }

    public static void log(Exception e, IncidentPriority p) {
        ErrorLog.log.add(new ErrorIncident(e, p));
        System.out.println("Error logged: " + e.toString() + ", priority " + p.toString());
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (int i = 0; i < 8 || i < stackTrace.length; i++) {
            System.out.println("\t" + stackTrace[i].toString());
        }
        if (stackTrace.length - 8 > 0) {
            System.out.println("\t... " + stackTrace.length + " more ...");
        }
    }
}
