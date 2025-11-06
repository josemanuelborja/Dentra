package com.example.dentra; // Use your package name

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPatientController implements Initializable {

    // --- Form Fields ---
    @FXML private TextField fullNameField;
    @FXML private ComboBox<String> genderComboBox;
    @FXML private TextField ageField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private TextField emergencyContactField;
    @FXML private TextField procedureField;
    @FXML private TextArea addressArea;

    // --- Buttons ---
    @FXML private Button cancelButton;
    @FXML private Button addPatientButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populate the Gender ComboBox
        genderComboBox.setItems(FXCollections.observableArrayList(
                "Male", "Female"
        ));
    }

    @FXML
    private void handleAddPatient(ActionEvent event) {

        String fullName = fullNameField.getText();
        String gender = genderComboBox.getValue();
        String age = ageField.getText();

        System.out.println("Adding New Patient:");
        System.out.println("Full Name: " + fullName);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);

        closeWindow();
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        // Just close the window
        closeWindow();
    }

    /**
     * Helper method to get the current stage and close it.
     */
    private void closeWindow() {
        // Get the stage from any of the buttons
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}