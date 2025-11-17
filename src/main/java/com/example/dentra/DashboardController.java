package com.example.dentra;

import data.users.User;
import data.users.UsersData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button staffBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button patientsBtn;

    @FXML
    private Button salesBtn;

    @FXML
    private Button purchasesBtn;

    @FXML
    private Button balanceBtn;

    @FXML
    private Button settingsBtn;

    @FXML
    private Label usernameLabel;

    @FXML
    private void initialize() {
        if (UsersData.currentUser != null) {
            String fullName = UsersData.currentUser.getUserFirstName() + " " + UsersData.currentUser.getUserLastName();
            usernameLabel.setText(fullName);
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
    private void handleSettingsClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-settings-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) settingsBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
