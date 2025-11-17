package com.example.dentra;

import data.users.User;
import data.users.UsersData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class ForgotPasswordController {

    @FXML
    private Button backToLoginBtn;

    @FXML
    private Button resetpasswordBtn;

    @FXML
    private TextField forgotEmailField;

    @FXML
    private void handleBackToLoginClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) backToLoginBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleresetpasswordClick() throws IOException {
        String email = forgotEmailField.getText().trim();

        // Validate empty
        if (email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Email", "Email field cannot be empty!");
            return;
        }

        // Validate format
        if (!email.contains("@") || !email.contains(".")) {
            showAlert(Alert.AlertType.ERROR, "Invalid Email", "Please enter a valid email address!");
            return;
        }

        // Search for user
        User userFound = null;
        for (User u : UsersData.userList) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                userFound = u;
                break;
            }
        }

        if (userFound == null) {
            showAlert(Alert.AlertType.ERROR, "Not Found", "No account found with that email!");
            return;
        }

        UsersData.currentUser = userFound;

        // Load OTP screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Otp-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) resetpasswordBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


