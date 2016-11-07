package model.log;

import java.time.LocalDateTime;

public class SecurityIncident {
    private final LocalDateTime timestamp;
    private final String username;

    SecurityIncident(String u) {
        timestamp = LocalDateTime.now();
        username = u;
    }

    /**
     * Gets the date and time of the SecurityIncident
     * @return      LocalDateTime representing date and time of the SecurityIncident
     */
    public final LocalDateTime getTimestamp() { return timestamp; }

    /**
     * Gets the username of the inciter of the SecurityIncident
     * @return      username of the user who caused the SecurityIncident
     */
    public final String getUsername() { return username; }
}
