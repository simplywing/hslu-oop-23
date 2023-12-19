package ch.hslu.oop.sw13ex;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class TempGuiController {

    private Logger LOG = LoggerFactory.getLogger(TempGuiController.class);

    @FXML
    public Button clearButton;

    @FXML
    private TextField textInputField;

    @FXML
    private Button addButton;

    @FXML
    private TableView<TemperatureMeasurement> measurementTableView;
    private final ObservableList<TemperatureMeasurement> measurementsList = FXCollections.observableArrayList();


    private void initializeTableView() {
        this.measurementTableView.setItems(this.measurementsList);

        TableColumn<TemperatureMeasurement, String> column1 = new TableColumn<>("Local Time");
        TableColumn<TemperatureMeasurement, String> column2 = new TableColumn<>("Temperature");

        column1.setMinWidth(180.0);
        column2.setMinWidth(100.0);

        column1.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().timestamp().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
                )
        );

        column2.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().measurement().getCelsius())));

        column1.setComparator((e, f) -> {
            var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            return LocalDateTime.parse(e, formatter).compareTo(LocalDateTime.parse(f, formatter));
        });

        column2.setComparator(Comparator.comparing(Float::valueOf));

        this.measurementTableView.getColumns().add(column1);
        this.measurementTableView.getColumns().add(column2);

    }

    private void showUserInfoMessage(final String title, final String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.setHeaderText(title);
        alert.showAndWait();
    }

    private void showUserErrorMessage(final String title, final String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.setHeaderText(title);
        alert.showAndWait();
    }

    private void btnAddTempValueAction() {
        var inputData = textInputField.getText();
        LOG.info(String.format("Button action! input was: [%s]", inputData));

        if (inputData.isEmpty()) {
            return;
        }

        try {
            measurementsList.add(
                    new TemperatureMeasurement(
                            LocalDateTime.now(),
                            Temperature.fromCelsius(Float.parseFloat(inputData))
                    )
            );

            // Sort measurement List after adding a new TemperatureMeasurement
            // this.measurementsList.sort((e, f) -> Float.compare(e.measurement().getCelsius(), f.measurement().getCelsius()));

            textInputField.clear();
        } catch (NumberFormatException e) {
            LOG.error(e.toString());
            showUserErrorMessage("Invalid Input", "Your input could not be converted to a number.");
        } catch (IllegalArgumentException e) {
            LOG.error(e.toString());
            showUserErrorMessage("Invalid Temperature", String.format("You entered an invalid Temperature: \n%s", e.getMessage()));
        }

    }

    private void btnClearAction() {
        LOG.info("Clear button was pressed.");
        measurementsList.clear();
        textInputField.clear();
    }

    @FXML
    public void initialize() {
        textInputField.setOnKeyPressed(evt -> {
            if (evt.getCode().equals(KeyCode.ENTER)) {
                btnAddTempValueAction();
            }
        });

        addButton.setOnAction(e -> {
            btnAddTempValueAction();
        });

        clearButton.setOnAction(e -> {
            btnClearAction();
        });

        this.initializeTableView();

    }

}