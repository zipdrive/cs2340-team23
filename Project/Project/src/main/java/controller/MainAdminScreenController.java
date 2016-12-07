package controller;

public class MainAdminScreenController extends MainManagerScreenController {
    public void handleViewAccountsPressed() {
        getMainApplication().initDialogScreen("User Accounts", "userAccountsScreen.fxml");
    }

    public void handleViewSecurityLogPressed() {
        getMainApplication().initDialogScreen("Security Log", "securityLogScreen.fxml");
    }
}
