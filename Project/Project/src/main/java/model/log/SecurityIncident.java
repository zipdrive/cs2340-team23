package model.log;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecurityIncident implements Serializable {
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
    final LocalDateTime getTimestamp() { return timestamp; }

    /**
     * Gets the username of the inciter of the SecurityIncident
     * @return      username of the user who caused the SecurityIncident
     */
    final String getUsername() { return username; }
}
