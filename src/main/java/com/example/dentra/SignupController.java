package com.example.dentra;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private void handleSignUpClick() {
        setActiveButton(signUpBtn, signInBtn);

    }

    @FXML
    private void handlecreateaccountClick() throws IOException {
        // Load login-view.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) createaccountBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSignInClick() throws IOException {
        // Load login-view.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) signInBtn.getScene().getWindow();
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
        // Default: Sign Up active
        setActiveButton(signUpBtn, signInBtn);
    }
}
