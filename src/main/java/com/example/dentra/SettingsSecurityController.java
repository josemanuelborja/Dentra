package com.example.dentra;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import data.users.UsersData;
import data.users.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsSecurityController {

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
    private Button profileBtn;

    @FXML
    private Button notificationBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private PasswordField currentPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private Button savePasswordBtn;

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
    private void handleProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-settings-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) profileBtn.getScene().getWindow();
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
    private void handleSavePasswordClick() {

        String currentPassword = currentPasswordField.getText();
        String newPassword = newPasswordField.getText();

        //Check kung may naka-log in na user
        if (UsersData.currentUser == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "No user is logged in.");
            return; // STOP execution
        }

        //Check kung may laman ang parehong fields
        if (currentPassword.isEmpty() || newPassword.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Warning", "Please fill in both password fields.");
            return;
        }

        //Check kung tama ang current password
        if (!currentPassword.equals(UsersData.currentUser.getPassword())) {
            showAlert(Alert.AlertType.ERROR, "Error", "Current password is incorrect.");
            return;
        }

        //Check kung iba ang new password sa current password
        if (newPassword.equals(currentPassword)) {
            showAlert(Alert.AlertType.WARNING, "Warning",
                    "New password must be different from current password.");
            return;
        }

        // Update the password of the current user
        UsersData.currentUser.setPassword(newPassword);

        //Update the password inside userList (optional but safe)
        for (User user : UsersData.userList) {
            if (user.getUserId().equals(UsersData.currentUser.getUserId())) {
                user.setPassword(newPassword);
                break; // stop the loop after finding the user
            }
        }

        // Clear input fields after successful update
        currentPasswordField.clear();
        newPasswordField.clear();

        // Success message
        showAlert(Alert.AlertType.INFORMATION, "Success", "Password updated successfully!");

        // Debug print (useful for defense)
        System.out.println("Password changed for: " + UsersData.currentUser.getPassword());
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null); // no header text para mas simple
        alert.setContentText(message);
        alert.showAndWait();
    }

}