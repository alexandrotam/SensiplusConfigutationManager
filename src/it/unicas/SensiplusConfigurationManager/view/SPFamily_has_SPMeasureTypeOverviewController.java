package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPFamily_has_SPMeasureType;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPFamily_has_SPMeasureTypeDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class SPFamily_has_SPMeasureTypeOverviewController {

    @FXML
    private TableView<SPFamily_has_SPMeasureType> spFamily_has_SPMeasureTypeTableView;
    @FXML
    private TableColumn<SPFamily_has_SPMeasureType, String> NameFamilyColumn;
    @FXML
    private TableColumn<SPFamily_has_SPMeasureType, String> NameTypeColumn;

    @FXML
    private Label idSPFamilyLabel;
    @FXML
    private Label Name_FamilyLabel;
    @FXML
    private Label idSPMeasuretypeLabel;
    @FXML
    private Label Name_TypeLabel;

    public MainApp mainApp;

    public SPFamily_has_SPMeasureTypeOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        NameFamilyColumn.setCellValueFactory(cellData->cellData.getValue().name_FamilyProperty());

        NameTypeColumn.setCellValueFactory(cellData->cellData.getValue().name_Measure_TypeProperty());
        showSPFamily_has_SPMeasureTypeDetails(null);

        spFamily_has_SPMeasureTypeTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPFamily_has_SPMeasureTypeDetails(newValue)
        );
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        spFamily_has_SPMeasureTypeTableView.setItems(mainApp.getSPFamily_has_SPMeasureTypeData());
    }

    /**
     */
    private void showSPFamily_has_SPMeasureTypeDetails(SPFamily_has_SPMeasureType spFamily_has_SPMeasureType) {
        if (spFamily_has_SPMeasureType != null) {
            idSPFamilyLabel.setText(spFamily_has_SPMeasureType.getSPFamily_idSPFamily());
            Name_FamilyLabel.setText(spFamily_has_SPMeasureType.getName_Family());
            idSPMeasuretypeLabel.setText(String.valueOf(spFamily_has_SPMeasureType.getSPMeasureType_idSPMeasureType()));
            Name_FamilyLabel.setText(String.valueOf(spFamily_has_SPMeasureType.getName_Measure_Type()));
        }
        else {
            idSPFamilyLabel.setText("");
            Name_FamilyLabel.setText("");
            idSPMeasuretypeLabel.setText("");
            Name_FamilyLabel.setText("");

        }
    }


    @FXML
    private void handleSearchSPFamily_has_SPMeasureType() {
        SPFamily_has_SPMeasureType tempSPFamily_has_SPMeasureType = new SPFamily_has_SPMeasureType("",
                "","","");
        boolean okClicked = mainApp.showSPFamily_has_SPMeasureTypeSearchDialog(tempSPFamily_has_SPMeasureType,false);
        if (okClicked) {
            try {
                List<SPFamily_has_SPMeasureType> list = SPFamily_has_SPMeasureTypeDAOMySQLImpl.getInstance().select(tempSPFamily_has_SPMeasureType);
                mainApp.getSPFamily_has_SPMeasureTypeData().clear();
                mainApp.getSPFamily_has_SPMeasureTypeData().addAll(list);
            } catch (DAOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Error during DB interaction");
                alert.setHeaderText("Error during search ...");
                alert.setContentText(e.getMessage());

                alert.showAndWait();
            }
        }
    }

}
