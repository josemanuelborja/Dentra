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

    // These are the 4 boxes where the user types the OTP
    @FXML private TextField code1, code2, code3, code4;

    @FXML private Button nextButton;
    @FXML private Hyperlink resendLink, backToLoginLink;

    @FXML
    public void initialize() {

        // Set simple behavior for each OTP box
        setupOtpBox(code1, code2);
        setupOtpBox(code2, code3);
        setupOtpBox(code3, code4);
        setupOtpBox(code4, null); // last box has no next box
    }

    private void setupOtpBox(TextField currentBox, TextField nextBox) {

        // When text changes
        currentBox.textProperty().addListener((obs, oldValue, newValue) -> {

            // Accept only 1 character
            if (newValue.length() > 1) {
                currentBox.setText(newValue.substring(0, 1));
            }

            // Accept only numbers
            if (!newValue.matches("\\d*")) {
                currentBox.setText(newValue.replaceAll("[^0-9]", ""));
            }

            // If 1 number is typed, go to next box
            if (newValue.length() == 1 && nextBox != null) {
                nextBox.requestFocus();
            }
        });
    }

    @FXML
    private void handleNextClick() throws IOException {

        String otp = code1.getText() + code2.getText() + code3.getText() + code4.getText();

        if (otp.length() < 4) {
            System.out.println("Please enter the complete 4-digit code.");
            return;
        }

        System.out.println("OTP entered: " + otp);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("new-password-view.fxml"));
        Scene scene = new Scene(loader.load());


        String style = getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(style);

        Stage stage = (Stage) nextButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleResendClick() {
        System.out.println("Resend code clicked.");
        // Here you would send a new OTP from backend
    }

    @FXML
    private void handleBackToLoginClick() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());

        String style = getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(style);

        Stage stage = (Stage) backToLoginLink.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
