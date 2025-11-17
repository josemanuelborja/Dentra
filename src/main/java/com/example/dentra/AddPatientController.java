package com.example.dentra;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddPatientController implements Initializable {

    @FXML private TextField fullNameField;
    @FXML private ComboBox<String> genderComboBox;
    @FXML private TextField ageField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;
    @FXML private TextField emergencyContactField;
    @FXML private Button cancelButton;
    @FXML private TextField emailField;
    @FXML private TextField procedureField;

    private DashboardPatientsController dashboardController;

    public void setDashboardController(DashboardPatientsController controller) {
        this.dashboardController = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderComboBox.setItems(FXCollections.observableArrayList("Male", "Female"));

        ageField.setTextFormatter(onlyNumbers());
        phoneField.setTextFormatter(onlyNumbers());
        emergencyContactField.setTextFormatter(onlyNumbers());
    }

    private TextFormatter<String> onlyNumbers() {
        return new TextFormatter<>(change -> {
            if (change.getText().matches("[0-9]*")) {
                return change;
            }
            return null;
        });
    }

    @FXML
    private void handleAddPatient() {
        String fullName = fullNameField.getText();
        String gender = genderComboBox.getValue();
        String age = ageField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String emergency = emergencyContactField.getText();
        String email = emailField.getText(); // get email input
        String procedure = procedureField.getText();

        // Basic validation: check all fields are filled
        if (fullName.isEmpty() || gender == null || age.isEmpty() || phone.isEmpty()
                || address.isEmpty() || emergency.isEmpty() || email.isEmpty()) {
            showAlert("Please fill in all fields!");
            return;
        }

        // Simple email validation
        if (!email.contains("@")) {
            showAlert("Please enter a valid email containing '@'.");
            return;
        }

        String transactionType = "Cash";
        double remainingBalance = 0.0;
        double totalAmount = 0.0;

// Create today's date as string
        String date = LocalDate.now().toString();

        Patient newPatient = new Patient(
                date,
                fullName,
                age,
                address,
                phone,
                gender,
                email,
                procedure,
                emergency,
                remainingBalance,
                totalAmount,
                transactionType
        );
        if (dashboardController != null) {
            dashboardController.addPatientToTable(newPatient);
        }

        closeWindow();
    }

    @FXML
    private void handleCancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    // Simple popup alert
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
