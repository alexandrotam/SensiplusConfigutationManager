package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPSensingElementOnChip;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPSensingElementOnChipDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class SPSensingElementOnChipOverviewController {
    @FXML
    private TableView<SPSensingElementOnChip> spSensingElementOnChipTableView;
    @FXML
    private TableColumn<SPSensingElementOnChip, String> idChipColumn;
    @FXML
    private TableColumn<SPSensingElementOnChip, String> nameSPSensingElementOnFamilyColumn;

    @FXML
    private Label idChipLabel;
    @FXML
    private Label mLabel;
    @FXML
    private Label nLabel;
    @FXML
    private Label nameSPSensingElementOnFamilyLabel;
    @FXML
    private Label nameCalibrationLabel;

    public MainApp mainApp;

    public SPSensingElementOnChipOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        idChipColumn.setCellValueFactory(cellData->cellData.getValue().SPChip_idSPChipProperty());

        nameSPSensingElementOnFamilyColumn.setCellValueFactory(cellData->cellData.getValue().SPSensingElementOnFamily_NameProperty());
        showSPSensingElementOnChipDetails(null);

        spSensingElementOnChipTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPSensingElementOnChipDetails(newValue)
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
        spSensingElementOnChipTableView.setItems(mainApp.getSPSensingElementOnChipData());
    }

    /**
     */
    private void showSPSensingElementOnChipDetails(SPSensingElementOnChip spSensingElementOnChip) {
        if (spSensingElementOnChip != null) {
            // Fill the labels with info from the spSensingelementOnChip object.
            idChipLabel.setText(spSensingElementOnChip.getSPChip_idSPChip());
            mLabel.setText(spSensingElementOnChip.getM());
            nLabel.setText(String.valueOf(spSensingElementOnChip.getN()));
            nameSPSensingElementOnFamilyLabel.setText(spSensingElementOnChip.getSPSensingElementOnFamily_Name());
            nameCalibrationLabel.setText(spSensingElementOnChip.getSPCalibration_Name());
        }
        else {
            idChipLabel.setText("");
            mLabel.setText("");
            nLabel.setText("");
            nameSPSensingElementOnFamilyLabel.setText("");
            nameCalibrationLabel.setText("");
        }
    }

    @FXML
    private void handleSearchSPSensingElementOnChip() {
        SPSensingElementOnChip tempSPSensingElementOnChip = new SPSensingElementOnChip("","","",
                "","");
        boolean okClicked = mainApp.showSPSensingElementOnChipSearchDialog(tempSPSensingElementOnChip,false);
        if (okClicked) {
            try {
                List<SPSensingElementOnChip> list = SPSensingElementOnChipDAOMySQLImpl.getInstance().select(tempSPSensingElementOnChip);
                mainApp.getSPSensingElementOnChipData().clear();
                mainApp.getSPSensingElementOnChipData().addAll(list);
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
