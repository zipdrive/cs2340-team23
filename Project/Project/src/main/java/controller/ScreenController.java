package controller;

import fxapp.MainApplication;

public class ScreenController {

    private MainApplication mainApplication;

    /**
     * Function to be overridden in subclasses, to be called after passing in references to mainApplication and dialogStage (if applicable)
     */
    public void init() {}

    /**
     * Returns a pointer to the main application
     * @return      pointer to the MainApplication object
     */
    protected final MainApplication getMainApplication() { return mainApplication; }

    /**
     * Sets a pointer to the main application
     * @param m   pointer to the main application
     */
    public final void setMainApplication(MainApplication m) {
        mainApplication = m;
    }


}
