package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.*;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPClusterDAOMySQLImpl;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPConfigurationDAOMySQLImpl;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPFamilyDAOMySQLImpl;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPSensingElementDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class SPConfigurationOverviewController {

    @FXML
    private TableView<SPConfiguration> spConfigurationTableView;
    @FXML
    private TableColumn<SPConfiguration,String> idClusterColumn;
    @FXML
    private  TableColumn<SPConfiguration,String> idSPConfigurationColumn;

    @FXML
    private Label idSPConfigurationLabel;
    @FXML
    private Label idClusterLabel;
    @FXML
    private Label driverLabel;
    @FXML
    private Label hostcontrollerLabel;
    @FXML
    private Label apiOwnerLabel;
    @FXML
    private Label mcuLabel;
    @FXML
    private Label protocolLabel;
    @FXML
    private Label addressTypeLabel;


    public MainApp mainApp;

    @FXML
    private void initialize() {


        idClusterColumn.setCellValueFactory(cellData->cellData.getValue().idClusterProperty());
        idSPConfigurationColumn.setCellValueFactory(cellData->cellData.getValue().idSPConfigurationProperty());

        showSPConfigurationDetails(null);


        spConfigurationTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPConfigurationDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        spConfigurationTableView.setItems(mainApp.getSPConfigurationData());
    }

    private void showSPConfigurationDetails(SPConfiguration spConfiguration) {
        if (spConfiguration != null) {
            idSPConfigurationLabel.setText(spConfiguration.getidSPConfiguration());
            driverLabel.setText(spConfiguration.getDriver());
            hostcontrollerLabel.setText(spConfiguration.getHostController());
            apiOwnerLabel.setText(spConfiguration.getApiOwner());
            mcuLabel.setText(spConfiguration.getMcu());
            protocolLabel.setText(spConfiguration.getProtocol());
            addressTypeLabel.setText(spConfiguration.getAddressingType());
            idClusterLabel.setText(spConfiguration.getIdCluster());

        } else {
            idSPConfigurationLabel.setText("");
            driverLabel.setText("");
            hostcontrollerLabel.setText("");
            apiOwnerLabel.setText("");
            mcuLabel.setText("");
            protocolLabel.setText("");
            addressTypeLabel.setText("");
            idClusterLabel.setText("");
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSPConfiguration() {
        int selectedIndex = spConfigurationTableView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setContentText("Are you sure?");
            ButtonType buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                SPConfiguration spConfiguration = spConfigurationTableView.getItems().get(selectedIndex);
                try {
                    SPConfigurationDAOMySQLImpl.getInstance().delete(spConfiguration);
                    spConfigurationTableView.getItems().remove(selectedIndex);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No SPConfiguration Selected");
            alert.setContentText("Please select a SPConfiguration in the table.");

            alert.showAndWait();
        }
    }
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new SPConfiguration.
     */
    @FXML
    private void handleNewSPConfiguration() {
        SPConfiguration tempSPConfiguration = new SPConfiguration("","","","","","","","");
        boolean okClicked = mainApp.showSPConfigurationEditDialog(tempSPConfiguration, true);
        Stage dialog=new Stage();

        if (okClicked) {
            try {
                SPConfigurationDAOMySQLImpl.getInstance().insert(tempSPConfiguration);
                mainApp.getSPConfigurationData().add(tempSPConfiguration);
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
     * details for a new SPConfiguration.
     */
    @FXML
    private void handleSearchSPConfiguration() {
        SPConfiguration tempSPConfiguration = new SPConfiguration("","","","","","","","");
        boolean okClicked = mainApp.showSPConfigurationSearchDialog(tempSPConfiguration,false);
        if (okClicked) {
            try {
                List<SPConfiguration> list = SPConfigurationDAOMySQLImpl.getInstance().select(tempSPConfiguration);
                mainApp.getSPConfigurationData().clear();
                mainApp.getSPConfigurationData().addAll(list);
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
    private void handleEditSPConfiguration() {
        SPConfiguration selectedSPConfiguration=spConfigurationTableView.getSelectionModel().getSelectedItem();
        if (selectedSPConfiguration != null) {
            boolean okClicked = mainApp.showSPConfigurationEditDialog(selectedSPConfiguration,true);
            if (okClicked) {
                try {
                    SPConfigurationDAOMySQLImpl.getInstance().update(selectedSPConfiguration);
                    showSPConfigurationDetails(selectedSPConfiguration);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No SPConfiguration Selected");
            alert.setContentText("Please select a SPConfiguration in the table.");

            alert.showAndWait();
        }
    }


    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveSensichipsToFile(file);
        }
    }

    @FXML
    private void xmlGenerator(){
        String selConf=spConfigurationTableView.getSelectionModel().getSelectedItem().getidSPConfiguration();

        try {
            List<SPConfiguration> listConf = SPConfigurationDAOMySQLImpl.getInstance().selectConf(selConf);
            mainApp.getSPConfigurationData().clear();
            mainApp.getSPConfigurationData().addAll(listConf);

            List<SPCluster> listCluster= SPClusterDAOMySQLImpl.getInstance().selectCluster(selConf);
            mainApp.getSPClusterData().clear();
            mainApp.getSPClusterData().addAll(listCluster);

            List<SPFamily> listFamily = SPFamilyDAOMySQLImpl.getInstance().selectFamily(selConf);
            mainApp.getSPFamilyData().clear();
            mainApp.getSPFamilyData().addAll(listFamily);

            List<SPSensingElement> listSensingElement = SPSensingElementDAOMySQLImpl.getInstance().selectSensingElement(selConf);
            mainApp.getSPSensingElementOnChipData().clear();
            mainApp.getSPSensingElementData().addAll(listSensingElement);

            List<SPPort> listPort = SPPortDAOMySQLImpl.getInstance().selectPort(selConf);
            mainApp.getSPPortData().clear();
            mainApp.getSPPortData().addAll(listPort);



        } catch (DAOException e) {
            e.printStackTrace();
        }
        handleSaveAs();
    }


}


}
