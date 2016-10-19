package model.log;

public class ErrorIncident {
    private Exception error;
    private IncidentPriority priority;

    public ErrorIncident(Exception error, IncidentPriority priority) {
        this.error = error;
        this.priority = priority;
    }
}
