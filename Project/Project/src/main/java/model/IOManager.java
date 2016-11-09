package model;

import model.profiles.ProfileList;
import model.reports.ReportList;

import java.io.*;

public final class IOManager {

    private IOManager() {}

    /**
     * Saves all Profiles in session
     * @param profiles      ProfileList of all Profiles
     */
    public static void saveProfiles(ProfileList profiles) {
        try {
            File file = new File("persist/profiles.sav");
            if (file.getParentFile().mkdirs()) {
                FileOutputStream fileStream = new FileOutputStream(file, false);
                ObjectOutputStream output = new ObjectOutputStream(fileStream);
                output.writeObject(profiles);
                output.close();
            }
        } catch (java.io.IOException ignored) {
        }
    }

    /**
     * Loads ProfileList from file
     * @return      ProfileList stored, or new ProfileList if none exists
     */
    public static ProfileList loadProfiles() {
        try {
            FileInputStream fileStream = new FileInputStream("persist/profiles.sav");
            ObjectInputStream input = new ObjectInputStream(fileStream);
            ProfileList profiles = (ProfileList)input.readObject();
            input.close();
            if (profiles != null) { return profiles; }
        } catch (IOException | ClassNotFoundException ignored) {
        }
        return new ProfileList();
    }

    /**
     * Saves ReportList from session
     * @param reports       ReportList of all Reports in session
     */
    public static void saveReports(ReportList reports) {
        try {
            File file = new File("persist/reports.sav");
            if (file.getParentFile().mkdirs()) {
                FileOutputStream fileStream = new FileOutputStream(file, false);
                ObjectOutputStream output = new ObjectOutputStream(fileStream);
                output.writeObject(reports);
                output.close();
            }
        } catch (java.io.IOException ignored) {
        }
    }

    /**
     * Loads ReportList from file
     * @return      ReportList stored, or new ReportList if none found
     */
    public static ReportList loadReports() {
        try {
            FileInputStream fileStream = new FileInputStream("persist/reports.sav");
            ObjectInputStream input = new ObjectInputStream(fileStream);
            ReportList reports = (ReportList)input.readObject();
            input.close();
            if (reports != null) { return reports; }
        } catch (ClassNotFoundException | IOException ignored) {
        }
        return new ReportList();
    }

    /**
     * Saves ErrorLog and SecurityLog to file (NOT YET IMPLEMENTED)
     */
    public static void saveLogs() {

    }

    /**
     * Loads ErrorLog and SecurityLog from file (NOT YET IMPLEMENTED)
     */
    public static void loadLogs() {

    }
}
