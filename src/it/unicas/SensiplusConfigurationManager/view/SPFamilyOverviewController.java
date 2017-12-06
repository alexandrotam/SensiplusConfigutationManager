package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPFamily;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SPFamilyOverviewController {
    @FXML
    private TableView<SPFamily> spFamilyTableView;
    @FXML
    private TableColumn<SPFamily, String> idSPFamilyColumn;
    @FXML
    private TableColumn<SPFamily, String> nameColumn;
    @FXML
    private TableColumn<SPFamily, String> idColumn;
    @FXML
    private TableColumn<SPFamily, String> hwVersionColumn;
    @FXML
    private TableColumn<SPFamily, String> sysclockColumn;
    @FXML
    private TableColumn<SPFamily, String> osctrimColumn;

    @FXML
    private Label idSPFamilyLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label hwVersionLabel;
    @FXML
    private Label sysclockLabel;
    @FXML
    private Label osctrimLabel;

    public MainApp mainApp;

    public SPFamilyOverviewController() {
    }
    /*
    private void initialize() {
        idSPFamilyColumn.setCellValueFactory(cellData->toString(cellData.getValue().idspfamilyProperty));
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        idColumn.setCellValueFactory(cellData->cellData.getValue().idProperty());
        showSPFamilyElementDetails(null);

        spFamilyTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPFamilyElementDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        spFamilyTableView.setItems(mainApp.getSPFamilyData());
    }
*/
}

