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
    private TableColumn<SPSensingelementOnFamily, String> NameSPSensingElementColumn;
    @FXML
    private TableColumn<SPSensingelementOnFamily, String> NameSPFamilyColumn;

    @FXML
    private Label idSPSensingElementLabel;
    @FXML
    private Label idSPFamilyLabel;
    @FXML
    private Label idSPPortLabel;
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

        NameSPSensingElementColumn.setCellValueFactory(cellData->cellData.getValue().name_SPSensingElementProperty());

        NameSPFamilyColumn.setCellValueFactory(cellData->cellData.getValue().name_SPFamilyProperty());
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
            idSPSensingElementLabel.setText(spSensingelementOnFamily.getSPSensingElement_idSPSensingElement());
            idSPFamilyLabel.setText(spSensingelementOnFamily.getSPFamily_idSPFamily());
            idSPPortLabel.setText(String.valueOf(spSensingelementOnFamily.getSPPort_idSPPort()));
            nameLabel.setText(String.valueOf(spSensingelementOnFamily.getName()));
           }
           else {
            idSPSensingElementLabel.setText("");
            idSPFamilyLabel.setText("");
            idSPPortLabel.setText("");
            nameLabel.setText("");

        }
    }


    @FXML
    private void handleSearchSPSensingelementOnFamily() {
        SPSensingelementOnFamily tempSPSensingelementOnFamily = new SPSensingelementOnFamily("",
                "","","","","");
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








}
