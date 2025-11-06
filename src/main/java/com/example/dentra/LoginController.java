package com.example.dentra;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
        Scene scene = new Scene(loader.load());
        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) loginBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
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
