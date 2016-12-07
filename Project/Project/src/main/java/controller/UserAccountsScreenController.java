package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import model.log.SecurityLog;
import model.profiles.Profile;
import model.profiles.ProfileList;

public class UserAccountsScreenController extends DialogScreenController {
    @FXML
    private VBox accountsBox;

    private ToggleGroup accounts;

    public void init() {
        accounts = new ToggleGroup();

        ProfileList profiles = getMainApplication().getProfiles();
        for (Profile p : profiles.getProfiles()) {
            RadioButton b = new RadioButton(p.getUsername());
            b.setToggleGroup(accounts);
            b.setSelected(true);
            accountsBox.getChildren().add(b);
        }
    }

    public void handleBanPressed() {
        String username = ((RadioButton)accounts.getSelectedToggle()).getText();
        if (getMainApplication().askForLoginCredentials("Are you sure you want to ban user " + username
                + "? If so, please enter your login credentials to confirm.")) {
            Profile p = getMainApplication().getProfiles().findProfile(username);
            if (p != null) {
                p.setBanned(true);
                SecurityLog.logAccountBanned(getMainApplication().getUser().getUsername(), username);
                generateInformationPopup("Account Banned", "You successfully banned " + username + ".");
            } else {
                generateErrorWarning("User Not Found", "Was not able to ban " + username + " because they could not be found in the system.");
            }
        }
    }

    public void handleUnblockPressed() {
        String username = ((RadioButton)accounts.getSelectedToggle()).getText();
        if (getMainApplication().askForLoginCredentials("Are you sure you want to unblock user " + username
                + "? If so, please enter your login credentials to confirm.")) {
            Profile p = getMainApplication().getProfiles().findProfile(username);
            if (p != null) {
                p.setBlocked(false);
                SecurityLog.logAccountUnblocked(getMainApplication().getUser().getUsername(), username);
                generateInformationPopup("Account Unblocked", "You successfully unblocked " + username + ".");
            } else {
                generateErrorWarning("User Not Found", "Was not able to unblock " + username + " because they could not be found in the system.");
            }
        }
    }

    public void handleDeletePressed() {
        String username = ((RadioButton)accounts.getSelectedToggle()).getText();
        if (getMainApplication().askForLoginCredentials("Are you sure you want to delete user " + username
                + "? This action will be permanent. If you are sure, please enter your login credentials to confirm.")) {
            if (getMainApplication().getProfiles().removeProfile(username)) {
                SecurityLog.logAccountDeleted(getMainApplication().getUser().getUsername(), username);
                generateInformationPopup("Account Deleted", "You successfully deleted " + username + ".");
            } else {
                generateErrorWarning("User Not Found", "Was not able to delete " + username + " because they could not be found in the system.");
            }
        }
    }
}
