package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.*;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

import java.util.List;

public class RootLayoutController {





    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleSettings() {
        DAOMySQLSettings daoMySQLSettings = DAOMySQLSettings.getCurrentDAOMySQLSettings();
        if (mainApp.showSettingsEditDialog(daoMySQLSettings)){
            DAOMySQLSettings.setCurrentDAOMySQLSettings(daoMySQLSettings);
        }

    }

    public void handleSPSensingElement(){
        mainApp.showSPSensingElementOverview();
        SPSensingElement tempSPSensingElement = new SPSensingElement("","","","","",
                "","","","","","","","","",
                "","","","","","","","","","");
            try {
                List<SPSensingElement> list = SPSensingElementDAOMySQLImpl.getInstance().select(tempSPSensingElement);
                mainApp.getSPSensingElementData().clear();
                mainApp.getSPSensingElementData().addAll(list);
            } catch (DAOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Error during DB interaction");
                alert.setHeaderText("Error during search ...");
                alert.setContentText(e.getMessage());

                alert.showAndWait();
            }
    }

    public void handleSPFamily(){
        mainApp.showSPFamilyOverview();
        SPFamily tempSPFamily = new SPFamily("","","","","","");
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

    public void handleSPSensingElementOnFamily()
    {
        mainApp.showSPSensingelementOnFamilyOverview();
        SPSensingelementOnFamily tempSPSensingelementOnFamily = new SPSensingelementOnFamily("",
                "","","","","");
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

    public void handleSPChip(){
        mainApp.showSPChipOverview();
        SPChip tempSPChip = new SPChip("","");
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

    public void handleSPSensingElementOnChip() {
        mainApp.showSPSensingElementOnChipOverview();
        SPSensingElementOnChip tempSPSensingElementOnChip = new SPSensingElementOnChip("","","",
                "","");
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

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Tarallo & Fusco");
        alert.setContentText("Author: Gruppo 7\nVersione 1.0");

        alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {

        mainApp.handleExit();

    }


    /**
     *
     */

}
