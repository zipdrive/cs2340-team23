package model.log;

import java.util.ArrayList;
import java.util.List;

public class SecurityLog {
    private static List<String> log;

    public static void init() {
        log = new ArrayList<>();
    }

    public static void log() {
        // do stuff
    }
}
