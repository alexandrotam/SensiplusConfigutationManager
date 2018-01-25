package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPFamily;
import it.unicas.SensiplusConfigurationManager.model.SPFamily_has_SPMeasureType;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPFamilyDAOMySQLImpl;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPFamily_has_SPMeasureTypeDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class SPFamilyOverviewController {
    @FXML
    private TableView<SPFamily> spFamilyTableView;
    @FXML
    private TableColumn<SPFamily, String> idColumn;
    @FXML
    private TableColumn<SPFamily, String> nameColumn;

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

        /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {


        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        idColumn.setCellValueFactory(cellData->cellData.getValue().idProperty());

        showSPFamilyDetails(null);


        spFamilyTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPFamilyDetails(newValue));



    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        spFamilyTableView.setItems(mainApp.getSPFamilyData());


    }

    /**
     */
    private void showSPFamilyDetails(SPFamily spFamily) {
        if (spFamily != null) {
            // Fill the labels with info from the spFamily object.
            idSPFamilyLabel.setText(spFamily.getidSPFamily());
            nameLabel.setText(spFamily.getName());
            idLabel.setText(String.valueOf(spFamily.getId()));
            hwVersionLabel.setText(String.valueOf(spFamily.getHwVersion()));
            sysclockLabel.setText(spFamily.getSysclock());
            osctrimLabel.setText(spFamily.getOsctrim());
        } else {
            idSPFamilyLabel.setText("");
            nameLabel.setText("");
            idLabel.setText("");
            hwVersionLabel.setText("");
            sysclockLabel.setText("");
            osctrimLabel.setText("");

        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSPFamily() {
        int selectedIndex = spFamilyTableView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setContentText("Are you sure?");
            ButtonType buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                SPFamily spFamily = spFamilyTableView.getItems().get(selectedIndex);
                try {
                    SPFamilyDAOMySQLImpl.getInstance().delete(spFamily);
                    spFamilyTableView.getItems().remove(selectedIndex);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Family Selected");
            alert.setContentText("Please select a Family in the table.");

            alert.showAndWait();
        }
    }



    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new SPFamily.
     */
    @FXML
    private void handleNewSPFamily() {
        SPFamily tempSPFamily = new SPFamily("","","","","","");
        boolean okClicked = mainApp.showSPFamilyEditDialog(tempSPFamily, true);
        Stage dialog=new Stage();

        if (okClicked) {
            try {
                SPFamilyDAOMySQLImpl.getInstance().insert(tempSPFamily);
                mainApp.getSPFamilyData().add(tempSPFamily);
            } catch (DAOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Error during DB interaction");
                alert.setHeaderText("Error during insert ...");
                alert.setContentText(e.getMessage());

                alert.showAndWait();
            }
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new SPFamily.
     */
    @FXML
    private void handleSearchSPFamily() {
        SPFamily tempSPFamily = new SPFamily("","","","","","");
        boolean okClicked = mainApp.showSPFamilySearchDialog(tempSPFamily,false);
        if (okClicked) {
            try {
                List<SPFamily> list = SPFamilyDAOMySQLImpl.getInstance().select(tempSPFamily);
                mainApp.getSPFamilyData().clear();
                mainApp.getSPFamilyData().addAll(list);
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

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected SPFamily.
     */
   @FXML
    private void handleEditSPFamily() {
       SPFamily selectedSpFamily=spFamilyTableView.getSelectionModel().getSelectedItem();
        if (selectedSpFamily != null) {
            boolean okClicked = mainApp.showSPFamilyEditDialog(selectedSpFamily,true);
            if (okClicked) {
                try {
                    SPFamilyDAOMySQLImpl.getInstance().update(selectedSpFamily);
                    showSPFamilyDetails(selectedSpFamily);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No SPFamily Selected");
            alert.setContentText("Please select a SPFamily in the table.");

            alert.showAndWait();
        }
   }

    @FXML
    private void handleMeasureSPFamily() {
        SPFamily_has_SPMeasureType tempSPFamily_has_SPMeasureType= new SPFamily_has_SPMeasureType();
        boolean okClicked = mainApp.showSPFamily_has_SPMeasureType(tempSPFamily_has_SPMeasureType, true);
        Stage dialog=new Stage();
        boolean error=false;
        if (okClicked) {
            try {
                SPFamily_has_SPMeasureTypeDAOMySQLImpl.getInstance().insert(tempSPFamily_has_SPMeasureType);
                mainApp.getSPFamily_has_SPMeasureTypeData().add(tempSPFamily_has_SPMeasureType);

            } catch (DAOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Error during DB interaction");
                alert.setHeaderText("Error during insert ...");
                alert.setContentText(e.getMessage());

                alert.showAndWait();
                error=true;
            }
            if (error==false){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Measure Completed");
                alert.showAndWait();
            }

        }
    }

    @FXML
    private void handleSPMeasureOverview() {
       mainApp.showSPFamily_has_SPMeasureTypeOverview();
        SPFamily_has_SPMeasureType tempSPFamily_has_SPMeasureType = new SPFamily_has_SPMeasureType("",
                "","","");
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



