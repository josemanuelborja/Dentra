package com.example.dentra;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EditPatientController {

    @FXML private Label breadcrumbUsernameLabel;
    @FXML private Label usernameLabel;
    @FXML private Label addressLabel;
    @FXML private Label ageLabel;
    @FXML private Label phoneNumberLabel;
    @FXML private Label genderLabel;
    @FXML private Label emailLabel;
    @FXML private Label dateLabel;
    @FXML private Label procedureLabel;
    @FXML private Label emergencyLabel;
    @FXML private Label recalLabel;

    @FXML private Label remainingBalanceLabel;
    @FXML private Label totalAmountLabel;

    @FXML private ChoiceBox<String> transactionTypeChoiceBox;
    @FXML private Button saveButton;
    @FXML private Button balanceEditBtn;

    private Patient patient;

    public void setPatient(Patient patient) {
        this.patient = patient;
        updateView();
    }

    private void updateView() {
        if (patient != null) {
            usernameLabel.setText(patient.getFullName());
            addressLabel.setText(patient.getAddress());
            ageLabel.setText(patient.getAge());
            phoneNumberLabel.setText(patient.getContact());
            genderLabel.setText(patient.getGender());
            emailLabel.setText(patient.getEmail());
            breadcrumbUsernameLabel.setText(patient.getFullName());
            dateLabel.setText(patient.getDate());
            procedureLabel.setText(patient.getProcedure());
            emergencyLabel.setText(patient.getEmergencyContact());
            recalLabel.setText(patient.getDate());

            remainingBalanceLabel.setText("₱" + String.format("%,.2f", patient.getRemainingBalance()));
            totalAmountLabel.setText("₱" + String.format("%,.2f", patient.getTotalAmount()));

            transactionTypeChoiceBox.setValue(patient.getTransactionType());
        }
    }

    @FXML
    private void handleBalanceEdit() {
        // Edit Remaining Balance
        TextInputDialog remainingDialog = new TextInputDialog(
                String.valueOf(patient.getRemainingBalance())
        );
        remainingDialog.setTitle("Edit Remaining Balance");
        remainingDialog.setHeaderText(null);
        remainingDialog.setContentText("Enter Remaining Balance:");

        remainingDialog.showAndWait().ifPresent(input -> {
            if (input.matches("\\d+(\\.\\d+)?")) {
                double remaining = Double.parseDouble(input);
                remainingBalanceLabel.setText("₱" + String.format("%,.2f", remaining));
                patient.setRemainingBalance(remaining);
            } else {
                showAlert("Please enter a valid number for Remaining Balance!");
            }
        });

        // Edit Total Amount
        TextInputDialog totalDialog = new TextInputDialog(
                String.valueOf(patient.getTotalAmount())
        );
        totalDialog.setTitle("Edit Total Amount");
        totalDialog.setHeaderText(null);
        totalDialog.setContentText("Enter Total Amount:");

        totalDialog.showAndWait().ifPresent(input -> {
            if (input.matches("\\d+(\\.\\d+)?")) {
                double total = Double.parseDouble(input);
                totalAmountLabel.setText("₱" + String.format("%,.2f", total));
                patient.setTotalAmount(total);
            } else {
                showAlert("Please enter a valid number for Total Amount!");
            }
        });
    }

    @FXML
    private void handleSave() {
        if (patient != null) {
            patient.setTransactionType(transactionTypeChoiceBox.getValue());
        }
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCancel() {
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
