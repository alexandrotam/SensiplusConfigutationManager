package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPChip;
import it.unicas.SensiplusConfigurationManager.model.SPSensingElementOnChip;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPChipDAOMySQLImpl;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPSensingElementOnChipDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class SPChipOverviewController {
    @FXML
    private TableView<SPChip> spChipTableView;
    @FXML
    private TableColumn<SPChip, String> idSPChipColumn;

    @FXML
    private Label idSPChipLabel;
    @FXML
    private Label idSPFamilyLabel;

    public MainApp mainApp;

    @FXML
    private void initialize() {


        idSPChipColumn.setCellValueFactory(cellData -> cellData.getValue().idSPChipProperty());
        idSPChipColumn.setCellValueFactory(cellData->cellData.getValue().idSPChipProperty());

        showSPChipDetails(null);


        spChipTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPChipDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        spChipTableView.setItems(mainApp.getSPChipData());
}

    private void showSPChipDetails(SPChip spChip) {
        if (spChip != null) {
            idSPChipLabel.setText(spChip.getidSPChip());
            idSPFamilyLabel.setText(spChip.getSPFamily_idSPFamily());
        } else {
            idSPChipLabel.setText("");
            idSPFamilyLabel.setText("");
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSPChip() {
        int selectedIndex = spChipTableView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setContentText("Are you sure?");
            ButtonType buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                SPChip spChip = spChipTableView.getItems().get(selectedIndex);
                try {
                    SPChipDAOMySQLImpl.getInstance().delete(spChip);
                    spChipTableView.getItems().remove(selectedIndex);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Chip Selected");
            alert.setContentText("Please select a Chip in the table.");

            alert.showAndWait();
        }
    }
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new SPChip.
     */
    @FXML
    private void handleNewSPChip() {
        SPChip tempSPChip = new SPChip("","");
        boolean okClicked = mainApp.showSPChipEditDialog(tempSPChip, true);
        Stage dialog=new Stage();

        if (okClicked) {
            try {
                SPChipDAOMySQLImpl.getInstance().insert(tempSPChip);
                mainApp.getSPChipData().add(tempSPChip);
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
    private void handleSearchSPChip() {
        SPChip tempSPChip = new SPChip("","");
        boolean okClicked = mainApp.showSPChipSearchDialog(tempSPChip,false);
        if (okClicked) {
            try {
                List<SPChip> list = SPChipDAOMySQLImpl.getInstance().select(tempSPChip);
                mainApp.getSPChipData().clear();
                mainApp.getSPChipData().addAll(list);
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

    @FXML
    private void handleEditSPChip() {
        SPChip selectedSpChip=spChipTableView.getSelectionModel().getSelectedItem();
        if (selectedSpChip != null) {
            boolean okClicked = mainApp.showSPChipEditDialog(selectedSpChip,true);
            if (okClicked) {
                try {
                    SPChipDAOMySQLImpl.getInstance().update(selectedSpChip);
                    showSPChipDetails(selectedSpChip);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No SPChip Selected");
            alert.setContentText("Please select a SPChip in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewSPSensingElementOnChip() {
        SPSensingElementOnChip tempSPSensingElementOnChip = new SPSensingElementOnChip("","","","","");
        boolean okClicked = mainApp.showSPSensingElementOnChipEditDialog(tempSPSensingElementOnChip, true);
        Stage dialog=new Stage();

        if (okClicked) {
            try {
                SPSensingElementOnChipDAOMySQLImpl.getInstance().insert(tempSPSensingElementOnChip);
                mainApp.getSPSensingElementOnChipData().add(tempSPSensingElementOnChip);
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


}

