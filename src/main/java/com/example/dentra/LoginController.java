package com.example.dentra;

import data.users.CurrentUser; // <-- import this
import data.users.User;
import data.users.UsersData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button signInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button forgotPasswordBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField loginEmailField;

    @FXML
    private PasswordField loginPasswordField;


    @FXML
    private void handleSignInClick() {
        setActiveButton(signInBtn, signUpBtn);
    }

    @FXML
    private void handleSignUpClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) signUpBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleLoginClick() throws IOException {
        String email = loginEmailField.getText();
        String password = loginPasswordField.getText();

        // Check if fields are empty
        if (email.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please enter email and password!");
            return;
        }

        // Find user by email
        User userFound = null;
        for (User u : UsersData.userList) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                userFound = u;
                break;
            }
        }

        // Check if user exists
        if (userFound == null) {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Account does not exist!");
            return;
        }

        // Check if password matches
        if (!userFound.getPassword().equals(password)) {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Incorrect password!");
            return;
        }

        // ✅ Set current user in both UsersData and CurrentUser
        UsersData.currentUser = userFound;
        CurrentUser.loggedInUser = userFound; // <-- This is the key line

        // Go to dashboard
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        Stage stage = (Stage) loginBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
    }

    // Helper method to show alert
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleForgotPasswordClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("forgot-password-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) forgotPasswordBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void setActiveButton(Button active, Button inactive) {
        active.getStyleClass().removeAll("toggle-button-inactive");
        active.getStyleClass().add("toggle-button-active");

        inactive.getStyleClass().removeAll("toggle-button-active");
        inactive.getStyleClass().add("toggle-button-inactive");
    }

    @FXML
    private void initialize() {
        setActiveButton(signInBtn, signUpBtn);
    }
}
