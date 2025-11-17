package com.example.dentra;

import data.users.User;
import data.users.UsersData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPasswordController {

    @FXML
    private Button backToLoginBtn;

    @FXML
    private Button newpasswordBtn;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField newConfirmField;

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
    private void handleNewPasswordClick() throws IOException {
        String newPassword = newPasswordField.getText().trim();
        String confirmPassword = newConfirmField.getText().trim();

        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Missing Information", "Both fields are required!");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Mismatch", "New password and Confirm password do not match!");
            return;
        }

        User currentUser = UsersData.currentUser;
        if (currentUser == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "No user selected!");
            return;
        }

        if (currentUser.getPassword().equals(newPassword)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Password", "Your new password must be different from the previous password!");
            return;
        }

        // Update password
        currentUser.password = newPassword;


        FXMLLoader loader = new FXMLLoader(getClass().getResource("success-password-view.fxml"));
        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());

        Stage stage = (Stage) newpasswordBtn.getScene().getWindow();
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


