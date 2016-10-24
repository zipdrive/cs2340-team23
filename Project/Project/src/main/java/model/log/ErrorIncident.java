package model.log;

class ErrorIncident {
    private final Exception error;
    private final IncidentPriority priority;

    public ErrorIncident(Exception error, IncidentPriority priority) {
        this.error = error;
        this.priority = priority;
    }
}
