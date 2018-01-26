package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPCluster;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPClusterDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class SPClusterOverviewController {
    @FXML
    private TableView<SPCluster> spClusterTableView;
    @FXML
    private TableColumn<SPCluster, String> idSPClusterColumn;
    @FXML
    private TableColumn<SPCluster, String> Name_SPCalibrationColumn;

    public MainApp mainApp;

    @FXML
    private void initialize() {


        idSPClusterColumn.setCellValueFactory(cellData -> cellData.getValue().idClusterProperty());
        Name_SPCalibrationColumn.setCellValueFactory(cellData->cellData.getValue().SPCalibration_NameSPCalibrationProperty());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        spClusterTableView.setItems(mainApp.getSPClusterData());
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSPCluster() {
        int selectedIndex = spClusterTableView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setContentText("Are you sure?");
            ButtonType buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                SPCluster spCluster = spClusterTableView.getItems().get(selectedIndex);
                try {
                    SPClusterDAOMySQLImpl.getInstance().delete(spCluster);
                    spClusterTableView.getItems().remove(selectedIndex);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Cluster Selected");
            alert.setContentText("Please select a Cluster in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new SPCluster.
     */
    @FXML
    private void handleNewSPCluster() {
        SPCluster tempSPCluster = new SPCluster("","");
        boolean okClicked = mainApp.showSPClusterEditDialog(tempSPCluster, true);
        Stage dialog=new Stage();

        if (okClicked) {
            try {
                SPClusterDAOMySQLImpl.getInstance().insert(tempSPCluster);
                mainApp.getSPClusterData().add(tempSPCluster);
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
     * details for a new SPCluster.
     */
    @FXML
    private void handleSearchSPCluster() {
        SPCluster tempSPCluster = new SPCluster("","");
        boolean okClicked = mainApp.showSPClusterSearchDialog(tempSPCluster,false);
        if (okClicked) {
            try {
                List<SPCluster> list = SPClusterDAOMySQLImpl.getInstance().select(tempSPCluster);
                mainApp.getSPClusterData().clear();
                mainApp.getSPClusterData().addAll(list);
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
    private void handleEditSPCluster() {
        SPCluster selectedSpCluster=spClusterTableView.getSelectionModel().getSelectedItem();
        String temp = selectedSpCluster.getIdCluster();
        if (selectedSpCluster != null) {
            boolean okClicked = mainApp.showSPClusterEditDialog(selectedSpCluster,true);
            if (okClicked) {
                try {
                    SPClusterDAOMySQLImpl.getInstance().update(selectedSpCluster, temp);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Cluster Selected");
            alert.setContentText("Please select a Cluster in the table.");

            alert.showAndWait();
        }
    }

}
