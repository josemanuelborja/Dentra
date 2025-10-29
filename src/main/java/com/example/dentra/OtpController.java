package com.example.dentra;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OtpController {

    @FXML private TextField code1, code2, code3, code4;
    @FXML private Button nextButton;
    @FXML private Hyperlink resendLink, backToLoginLink;

    @FXML
    private void handleNextClick() throws IOException {
        String code = code1.getText() + code2.getText() + code3.getText() + code4.getText();
        System.out.println("Entered code: " + code);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("new-password-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) backToLoginLink.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        // TODO: verify code logic or navigate to reset password view
    }

    @FXML
    private void handleResendClick() {
        System.out.println("Resend code clicked");
    }

    @FXML
    private void handleBackToLoginClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());

        String styleCss = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(styleCss);

        Stage stage = (Stage) backToLoginLink.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
