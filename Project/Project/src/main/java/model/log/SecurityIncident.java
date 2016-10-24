package model.log;

import java.time.LocalDateTime;

public class SecurityIncident {
    protected LocalDateTime timestamp;
    protected String username;

    public SecurityIncident(String username) {
        timestamp = LocalDateTime.now();
        this.username = username;
    }
}
