package com.example.dentra;

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

public class SignupController {

    @FXML
    private Button signInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button createaccountBtn;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void initialize() {
        setActiveButton(signUpBtn, signInBtn);
    }

    @FXML
    private void handleSignUpClick() {
        setActiveButton(signUpBtn, signInBtn);
    }

    @FXML
    private void handleSignInClick() throws IOException {
        setActiveButton(signInBtn, signUpBtn);
        loadScene("login-view.fxml", signInBtn);
    }

    @FXML
    private void handleCreateAccountClick() throws IOException {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        //Check if any field is empty
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill in all fields!");
            return;
        }

        //Check if email contains '@
        if (!email.contains("@")) {
            showAlert(Alert.AlertType.ERROR, "Invalid Email", "Email must contain '@'!");
            return;
        }

        // Check if email already exists
        for (User user : UsersData.userList) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                showAlert(Alert.AlertType.ERROR, "Duplicate Email", "Email is already registered!");
                return;
            }
        }

        //Create user ID and add new user to list
        String userId = "U" + System.currentTimeMillis();
        User newUser = new User(userId, email, firstName, lastName, password);
        UsersData.userList.add(newUser);

        //Print user info in console (for debugging)
        System.out.println("User saved:");
        System.out.println("ID: " + userId);
        System.out.println("Email: " + email);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Password: " + password);
        System.out.println("Total users: " + UsersData.userList.size());

        //Show success message
        showAlert(Alert.AlertType.INFORMATION, "Success", "Account created successfully!");

        //Load login page
        loadScene("login-view.fxml", createaccountBtn);
    }

    // Simple function to show alerts
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void setActiveButton(Button active, Button inactive) {
        active.getStyleClass().removeAll("toggle-button-inactive");
        active.getStyleClass().add("toggle-button-active");

        inactive.getStyleClass().removeAll("toggle-button-active");
        inactive.getStyleClass().add("toggle-button-inactive");
    }

    private void loadScene(String fxmlFile, Button button) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());

        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
