package com.example.dentra;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardSalesController implements Initializable {

    @FXML
    private Button staffBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button dashboardBtn;

    @FXML
    private Button patientsBtn;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private Button purchasesBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populate the Gender ComboBox
        typeComboBox.setItems(FXCollections.observableArrayList(
                "Child", "Teen", "Adult", "Senior"
        ));

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
