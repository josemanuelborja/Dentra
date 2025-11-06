package com.example.dentra;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardPatientsController {

    @FXML
    private Button staffBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button dashboardBtn;

    @FXML
    private Button salesBtn;

    @FXML
    private Button purchasesBtn;

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
    private void handleAddPatientClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-patient-view.fxml"));

        javafx.scene.Parent root = loader.load();

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(styleCss);


        Stage popupStage = new Stage();
        popupStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        popupStage.setTitle("Add Patient");
        popupStage.setScene(scene);
        popupStage.showAndWait();
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


}
