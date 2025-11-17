package com.example.dentra;

import data.users.CurrentUser;
import data.users.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardSettingsController {

    @FXML
    private Button staffBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button dashboardBtn;

    @FXML
    private Button patientsBtn;

    @FXML
    private Button salesBtn;

    @FXML
    private Button purchasesBtn;

    @FXML
    private Button balanceBtn;

    @FXML
    private Button notificationBtn;

    @FXML
    private Button securityBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField emailField;

    @FXML
    private TextField fullNameField;

    @FXML
    private Button saveBtn;

    // ------------------------------
    // NEW CODE: Load user information
    // ------------------------------
    @FXML
    private void initialize() {

        System.out.println("DEBUG: CurrentUser.loggedInUser = " + CurrentUser.loggedInUser);

        if (CurrentUser.loggedInUser != null) {
            User user = CurrentUser.loggedInUser;

            emailField.setText(user.getEmail());
            fullNameField.setText(user.getUserFirstName() + " " + user.getUserLastName());
        }
    }

    @FXML
    private void handleLogOutClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleStaffClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-staff-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) staffBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleDashboardClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) dashboardBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handlePatientsClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-patients-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) patientsBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSalesClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-sales-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) salesBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handlePurchasesClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-purchases-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) purchasesBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleBalanceClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-balance-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) balanceBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleNotificationClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings-notification-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) notificationBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSecurityClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings-security-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) securityBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleCancelClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSaveAccountClick() {
        if (CurrentUser.loggedInUser != null) {
            String newFullName = fullNameField.getText().trim();
            String newEmail = emailField.getText().trim();

            if (newFullName.isEmpty() || newEmail.isEmpty()) {
                showAlert("Error", "Full name and email cannot be empty!");
                return;
            }

            // Split full name into first and last name
            String[] nameParts = newFullName.split(" ", 2);
            String firstName = nameParts[0];
            String lastName = nameParts.length > 1 ? nameParts[1] : "";

            // Update the CurrentUser object
            CurrentUser.loggedInUser.setUserFirstName(firstName);
            CurrentUser.loggedInUser.setUserLastName(lastName);
            CurrentUser.loggedInUser.setEmail(newEmail);


            showAlert("Success", "Account updated successfully!");
        } else {
            showAlert("Error", "No user is currently logged in!");
        }
    }

    private void showAlert(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
