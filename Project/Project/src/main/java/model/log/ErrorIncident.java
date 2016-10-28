package model.log;

class ErrorIncident {
    private final Exception error;
    private final boolean highPriority;

    public ErrorIncident(Exception error, boolean highPriority) {
        this.error = error;
        this.highPriority = highPriority;
    }
}
