package com.example.dentra;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPasswordController {

    @FXML
    private Button backToLoginBtn;

    @FXML
    private Button newpasswordBtn;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("success-password-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) newpasswordBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}


