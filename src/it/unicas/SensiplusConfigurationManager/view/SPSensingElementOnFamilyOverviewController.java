package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPSensingelementOnFamily;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPSensingElementDAOMySQLImpl;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPSensingelementOnFamilyDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class SPSensingElementOnFamilyOverviewController {

    @FXML
    private TableView<SPSensingelementOnFamily> spSensingelementOnFamilyTableView;
    @FXML
    private TableColumn<SPSensingelementOnFamily, String> idSPSensingElementOnFamilyColumn;
    @FXML
    private TableColumn<SPSensingelementOnFamily, String> SPSensingElement_idSPSensingElementColumn;
    @FXML
    private TableColumn<SPSensingelementOnFamily, String> SPFamilyTemplate_idSPFamilyTemplateColumn;
    @FXML
    private TableColumn<SPSensingelementOnFamily, String> nameColumn;

    @FXML
    private Label idSPSensingElementOnFamilyLabel;
    @FXML
    private Label SPSensingElement_idSPSensingElementLabel;
    @FXML
    private Label SPFamilyTemplate_idSPFamilyTemplateLabel;
    @FXML
    private Label hwVersionLabel;
    @FXML
    private Label nameLabel;

    public MainApp mainApp;

    public SPSensingElementOnFamilyOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        idSPSensingElementOnFamilyColumn.setCellValueFactory(cellData->cellData.getValue().idSPSensingElementOnFamilyProperty());

        nameColumn.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        showSPSensingelementOnFamilyDetails(null);

        spSensingelementOnFamilyTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPSensingelementOnFamilyDetails(newValue)
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
        spSensingelementOnFamilyTableView.setItems(mainApp.getSPSensingelementOnFamilyData());
    }

    /**
     */
    private void showSPSensingelementOnFamilyDetails(SPSensingelementOnFamily spSensingelementOnFamily) {
        if (spSensingelementOnFamily != null) {
            // Fill the labels with info from the spSensingelementOnFamily object.
            idSPSensingElementOnFamilyLabel.setText(spSensingelementOnFamily.getidSPSensingElementOnFamily());
            SPSensingElement_idSPSensingElementLabel.setText(spSensingelementOnFamily.getSPSensingElement_idSPSensingElement());
            SPFamilyTemplate_idSPFamilyTemplateLabel.setText(String.valueOf(spSensingelementOnFamily.getSPFamilyTemplate_idSPFamilyTemplate()));
            nameLabel.setText(String.valueOf(spSensingelementOnFamily.getName()));
           }
           else {
            idSPSensingElementOnFamilyLabel.setText("");
            SPSensingElement_idSPSensingElementLabel.setText("");
            SPFamilyTemplate_idSPFamilyTemplateLabel.setText("");
            nameLabel.setText("");

        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSPSensingelementOnFamily() {
        int selectedIndex = spSensingelementOnFamilyTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            SPSensingelementOnFamily spSensingelementOnFamily = spSensingelementOnFamilyTableView.getItems().get(selectedIndex);
            try {
                SPSensingElementDAOMySQLImpl.getInstance().delete(spSensingelementOnFamily);
                spSensingelementOnFamilyTableView.getItems().remove(selectedIndex);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No SensingelementOnFamily Selected");
            alert.setContentText("Please select a SensingelementOnFamily in the table.");

            alert.showAndWait();
        }
    }



    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new SPSensingelementOnFamily.
     */
    @FXML
    private void handleNewSPSensingelementOnFamily() {
        SPSensingelementOnFamily tempSPSensingelementOnFamily = new SPSensingelementOnFamily("","","","");
        boolean okClicked = mainApp.showSPSensingelementOnFamilyEditDialog(tempSPSensingelementOnFamily, true);
        Stage dialog=new Stage();

        if (okClicked) {
            try {
                SPSensingelementOnFamilyDAOMySQLImpl.getInstance().insert(tempSPSensingelementOnFamily);
                mainApp.getSPSensingelementOnFamilyData().add(tempSPSensingelementOnFamily);
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
     * details for a new SPSensingelementOnFamily.
     */
    @FXML
    private void handleSearchSPSensingelementOnFamily() {
        SPSensingelementOnFamily tempSPSensingelementOnFamily = new SPSensingelementOnFamily("","","","");
        boolean okClicked = mainApp.showSPSensingelementOnFamilySearchDialog(tempSPSensingelementOnFamily,false);
        if (okClicked) {
            try {
                List<SPSensingelementOnFamily> list = SPSensingelementOnFamilyDAOMySQLImpl.getInstance().select(tempSPSensingelementOnFamily);
                mainApp.getSPSensingelementOnFamilyData().clear();
                mainApp.getSPSensingelementOnFamilyData().addAll(list);
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
     * details for the selected SPSensingelementOnFamily.
     */
    @FXML
    private void handleEditSPSensingelementOnFamily() {
        SPSensingelementOnFamily selectedSPSensingelementOnFamily=spSensingelementOnFamilyTableView.getSelectionModel().getSelectedItem();
        if (selectedSPSensingelementOnFamily != null) {
            boolean okClicked = mainApp.showSPSensingelementOnFamilyEditDialog(selectedSPSensingelementOnFamily,true);
            if (okClicked) {
                try {
                    SPSensingelementOnFamilyDAOMySQLImpl.getInstance().update(selectedSPSensingelementOnFamily);
                    showSPSensingelementOnFamilyDetails(selectedSPSensingelementOnFamily);
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


}
