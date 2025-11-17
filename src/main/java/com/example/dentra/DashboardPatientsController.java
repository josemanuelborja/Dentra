package com.example.dentra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class DashboardPatientsController {

    @FXML private Button staffBtn;
    @FXML private Button logoutBtn;
    @FXML private Button dashboardBtn;
    @FXML private Button addPatientBtn;
    @FXML private Button salesBtn;
    @FXML private Button purchasesBtn;
    @FXML private Button balanceBtn;
    @FXML private Button settingsBtn;
    @FXML private TextField searchPatientField;

    // TableView and its columns
    @FXML private TableView<Patient> patientsTable;
    @FXML private TableColumn<Patient, String> patientDateCol;
    @FXML private TableColumn<Patient, String> patientNameCol;
    @FXML private TableColumn<Patient, String> patientAgeCol;
    @FXML private TableColumn<Patient, String> patientAddressCol;
    @FXML private TableColumn<Patient, String> patientContactCol;
    @FXML private TableColumn<Patient, Void> patientActionCol; // <-- IMPORTANT

    private ObservableList<Patient> patientList = FXCollections.observableArrayList();
    private FilteredList<Patient> filteredPatients;

    // ----------------------------------------------------
    // INITIALIZE
    // ----------------------------------------------------
    @FXML
    public void initialize() {

        // Link table columns to Patient fields
        patientDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        patientAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        patientAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        patientContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

        // Wrap patient list in FilteredList
        filteredPatients = new FilteredList<>(patientList, p -> true);
        patientsTable.setItems(filteredPatients);

        // Listen to search field input
        searchPatientField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPatients.setPredicate(patient -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true; // show all if empty
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return patient.getFullName().toLowerCase().contains(lowerCaseFilter);
            });
        });

        // Add action buttons column
        addActionButtons();

        // Message when table is empty
        patientsTable.setPlaceholder(new Label("No patients found."));
    }

    // ----------------------------------------------------
    // ADD PATIENT TO TABLE
    // ----------------------------------------------------
    public void addPatientToTable(Patient patient) {
        if (patient != null) {
            patientList.add(patient);
        }
    }

    // ----------------------------------------------------
    // ACTION COLUMN (Edit + Delete Buttons)
    // ----------------------------------------------------
    private void addActionButtons() {

        patientActionCol.setCellFactory(column -> new TableCell<>() {

            private final Button editButton = new Button();
            private final Button deleteButton = new Button();
            private final HBox container = new HBox(10); // space between buttons

            {
                // --- LOAD ICON IMAGES ---
                ImageView editIcon = new ImageView(
                        new Image(getClass().getResourceAsStream("image/edit.png"))
                );
                ImageView deleteIcon = new ImageView(
                        new Image(getClass().getResourceAsStream("image/trash.png"))
                );

                // --- SET ICON SIZE ---
                editIcon.setFitWidth(20);
                editIcon.setFitHeight(20);

                deleteIcon.setFitWidth(20);
                deleteIcon.setFitHeight(20);

                // --- ASSIGN ICONS TO BUTTONS ---
                editButton.setGraphic(editIcon);
                deleteButton.setGraphic(deleteIcon);

                // --- STYLE BUTTONS (no border, no background) ---
                editButton.setStyle("-fx-background-color: transparent;");
                deleteButton.setStyle("-fx-background-color: transparent;");

                // --- CENTER THE ICONS IN THE CELL ---
                container.setStyle("-fx-alignment: CENTER;");
                container.getChildren().addAll(editButton, deleteButton);

                // --- EDIT ACTION ---
                editButton.setOnAction(event -> {
                    Patient selectedPatient = getTableView().getItems().get(getIndex());
                    if (selectedPatient == null) return;

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-patient-view.fxml"));
                        Parent root = loader.load();

                        EditPatientController controller = loader.getController();
                        controller.setPatient(selectedPatient); // PASS patient

                        Stage popupStage = new Stage();
                        popupStage.initModality(Modality.APPLICATION_MODAL);
                        popupStage.initStyle(StageStyle.UNDECORATED);
                        popupStage.setTitle("Edit Patient");
                        popupStage.setScene(new Scene(root));
                        popupStage.showAndWait();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                // --- DELETE ACTION ---
                deleteButton.setOnAction(event -> {
                    Patient patient = getTableView().getItems().get(getIndex());
                    if (patient != null) {
                        System.out.println("Deleted: " + patient.getFullName());
                        patientList.remove(patient);   // <-- FIXED
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(container);
                }
            }
        });

        // Center the column content
        patientActionCol.setStyle("-fx-alignment: CENTER;");
    }

    // ----------------------------------------------------
    // POPUP: ADD PATIENT
    // ----------------------------------------------------
    @FXML
    private void handleAddPatientClick() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-patient-view.fxml"));
        javafx.scene.Parent root = loader.load();

        AddPatientController popupController = loader.getController();
        popupController.setDashboardController(this);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.UNDECORATED);
        popupStage.setTitle("Add Patient");
        popupStage.setScene(scene);

        popupStage.showAndWait();
    }

    // ----------------------------------------------------
    // PAGE SWITCHER
    // ----------------------------------------------------
    private void switchView(Button sourceButton, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        Stage stage = (Stage) sourceButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // ----------------------------------------------------
    // NAV BUTTONS
    // ----------------------------------------------------
    @FXML private void handleLogOutClick() throws IOException { switchView(logoutBtn, "login-view.fxml"); }
    @FXML private void handleStaffClick() throws IOException { switchView(staffBtn, "dashboard-staff-view.fxml"); }
    @FXML private void handleDashboardClick() throws IOException { switchView(dashboardBtn, "dashboard-view.fxml"); }
    @FXML private void handleSalesClick() throws IOException { switchView(salesBtn, "dashboard-sales-view.fxml"); }
    @FXML private void handlePurchasesClick() throws IOException { switchView(purchasesBtn, "dashboard-purchases-view.fxml"); }
    @FXML private void handleBalanceClick() throws IOException { switchView(balanceBtn, "dashboard-balance-view.fxml"); }
    @FXML private void handleSettingsClick() throws IOException { switchView(settingsBtn, "dashboard-settings-view.fxml"); }
}
