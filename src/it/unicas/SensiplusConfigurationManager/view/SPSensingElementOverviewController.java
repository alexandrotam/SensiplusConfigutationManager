package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElement;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPSensingElementDAOMySQLImpl;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import it.unicas.SensiplusConfigurationManager.MainApp;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

public class SPSensingElementOverviewController {

    @FXML
    private TableView<SPSensingElement> spSensingElementTableView;
    @FXML
    private TableColumn<SPSensingElement, String> idSPSensingElementColumn;
    @FXML
    private TableColumn<SPSensingElement, String> rSenseColumn;
    @FXML
    private TableColumn<SPSensingElement, String> inGainColumn;
    @FXML
    private TableColumn<SPSensingElement, String> outGainColumn;
    @FXML
    private TableColumn<SPSensingElement, String> contactsColumn;
    @FXML
    private TableColumn<SPSensingElement, String> frequencyColumn;
    @FXML
    private TableColumn<SPSensingElement, String> harmonicColumn;
    @FXML
    private TableColumn<SPSensingElement, String> DCBiasColumn;
    @FXML
    private TableColumn<SPSensingElement, String> modeVIColumn;
    @FXML
    private TableColumn<SPSensingElement, String> measureTecniqueColumn;
    @FXML
    private TableColumn<SPSensingElement, String> measureTypeColumn;
    @FXML
    private TableColumn<SPSensingElement, String> filterColumn;
    @FXML
    private TableColumn<SPSensingElement, String> phaseShiftModeColumn;
    @FXML
    private TableColumn<SPSensingElement, String> phaseShiftColumn;
    @FXML
    private TableColumn<SPSensingElement, String> IQColumn;
    @FXML
    private TableColumn<SPSensingElement, String> conversionRateColumn;
    @FXML
    private TableColumn<SPSensingElement, String> inPortADCColumn;
    @FXML
    private TableColumn<SPSensingElement, String> nDataColumn;
    @FXML
    private TableColumn<SPSensingElement, String> nameColumn;
    @FXML
    private TableColumn<SPSensingElement, String> rangeMinColumn;
    @FXML
    private TableColumn<SPSensingElement, String> rangeMaxColumn;
    @FXML
    private TableColumn<SPSensingElement, String> defaultAlarmThresholdColumn;
    @FXML
    private TableColumn<SPSensingElement, String> multiplierColumn;
    @FXML
    private TableColumn<SPSensingElement, String> measureUnitColumn;


    @FXML
    private Label idSPSensingElementLabel;
    @FXML
    private Label rSenseLabel;
    @FXML
    private Label inGainLabel;
    @FXML
    private Label outGainLabel;
    @FXML
    private Label contactslabel;
    @FXML
    private Label frequencyLabel;
    @FXML
    private Label harmonicLabel;
    @FXML
    private Label DCBiasLabel;
    @FXML
    private Label modeVILabel;
    @FXML
    private Label measureTechniqueLabel;
    @FXML
    private Label measureTypeLabel;
    @FXML
    private Label filterLabel;
    @FXML
    private Label phaseShiftModeLabel;
    @FXML
    private Label phaseShiftLabel;
    @FXML
    private Label IQLabel;
    @FXML
    private Label conversionRateLabel;
    @FXML
    private Label inPortADCLabel;
    @FXML
    private Label nDataLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label rangeMinLabel;
    @FXML
    private Label rangeMaxLabel;
    @FXML
    private Label defaultAlarmThresholdLabel;
    @FXML
    private Label multiplierLabel;
    @FXML
    private Label measureUnitLabel;
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public SPSensingElementOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        idSPSensingElementColumn.setCellValueFactory(cellData -> cellData.getValue().IdSPSensingElementProperty());

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        showSPSensingElementDetails(null);

        spSensingElementTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSPSensingElementDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        spSensingElementTableView.setItems(mainApp.getSPSensingElementData());
    }

    /**
      */
    private void showSPSensingElementDetails(SPSensingElement spSensingElement) {
        if (spSensingElement != null) {
            // Fill the labels with info from the spSensingElement object.
            idSPSensingElementLabel.setText(spSensingElement.getIdSPSensingElement());
            rSenseLabel.setText(String.valueOf(spSensingElement.getrSense()));
            inGainLabel.setText(String.valueOf(spSensingElement.getInGain()));
            outGainLabel.setText(String.valueOf(spSensingElement.getOutGain()));
            contactslabel.setText(spSensingElement.getContacts());
            frequencyLabel.setText(String.valueOf(spSensingElement.getFrequency()));
            harmonicLabel.setText(spSensingElement.getHarmonic());
            DCBiasLabel.setText(String.valueOf(spSensingElement.getDCBias()));
            modeVILabel.setText(spSensingElement.getModeVI());
            measureTechniqueLabel.setText(spSensingElement.getMeasureTechnique());
            measureTypeLabel.setText(spSensingElement.getMeasureType());
            filterLabel.setText(String.valueOf(spSensingElement.getFilter()));
            phaseShiftModeLabel.setText(spSensingElement.getPhaseShiftMode());
            phaseShiftLabel.setText(String.valueOf(spSensingElement.getPhaseShift()));
            IQLabel.setText(spSensingElement.getIQ());
            conversionRateLabel.setText(String.valueOf(spSensingElement.getConversionRate()));
            inPortADCLabel.setText(spSensingElement.getInPortADC());
            nDataLabel.setText(String.valueOf(spSensingElement.getnData()));
            nameLabel.setText(spSensingElement.getName());
            rangeMinLabel.setText(String.valueOf(spSensingElement.getRangeMin()));
            rangeMaxLabel.setText(String.valueOf(spSensingElement.getRangeMax()));
            defaultAlarmThresholdLabel.setText(String.valueOf(spSensingElement.getDefaultAlarmThreshold()));
            multiplierLabel.setText(String.valueOf(spSensingElement.getMultiplier()));
            measureUnitLabel.setText(spSensingElement.getMeasureUnit());
        } else {
            idSPSensingElementLabel.setText("");
            rSenseLabel.setText("");
            inGainLabel.setText("");
            outGainLabel.setText("");
            contactslabel.setText("");
            frequencyLabel.setText("");
            harmonicLabel.setText("");
            DCBiasLabel.setText("");
            modeVILabel.setText("");
            measureTechniqueLabel.setText("");
            measureTypeLabel.setText("");
            filterLabel.setText("");
            phaseShiftModeLabel.setText("");
            phaseShiftLabel.setText("");
            IQLabel.setText("");
            conversionRateLabel.setText("");
            inPortADCLabel.setText("");
            nDataLabel.setText("");
            nDataLabel.setText("");
            nameLabel.setText("");
            rangeMinLabel.setText("");
            rangeMaxLabel.setText("");
            defaultAlarmThresholdLabel.setText("");
            multiplierLabel.setText("");
            measureUnitLabel.setText("");

        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSPSensingELement() {
        int selectedIndex = spSensingElementTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            SPSensingElement spSensingElement = spSensingElementTableView.getItems().get(selectedIndex);
            try {
                SPSensingElementDAOMySQLImpl.getInstance().delete(spSensingElement);
                spSensingElementTableView.getItems().remove(selectedIndex);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Sensig Element Selected");
            alert.setContentText("Please select a Sensing Element in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new SPSensingElement.
     */
    @FXML
    private void handleNewSPSensingElement() {
        SPSensingElement tempSPSensingElement = new SPSensingElement("50","1","0","TWO","78125",
                "FIRST HARMONIC","0","VOUT IIN","EIS","IN PHASE","1",
                "QUADRANTS","0","IN PHASE","50","IA","1","","0",
                "100","50","0","O","");
        boolean okClicked = mainApp.showSPSensingElementEditDialog(tempSPSensingElement, true);
        Stage dialog=new Stage();

        if (okClicked) {
            try {
                SPSensingElementDAOMySQLImpl.getInstance().insert(tempSPSensingElement);
                mainApp.getSPSensingElementData().add(tempSPSensingElement);
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
     * details for a new SPSensingElement.
     */
    @FXML
    private void handleSearchSPSensingElement() {
        SPSensingElement tempSPSensingElement = new SPSensingElement("","","","","",
                "","","","","","","","","",
                "","","","","","","","","","");
        boolean okClicked = mainApp.showSPSensingElementSearchDialog(tempSPSensingElement,false);
        if (okClicked) {
            //mainApp.getSPSensingElementData().add(tempSPSensingElement);
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
    }



    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected SPSensingElement.
     */
    @FXML
    private void handleEditSPSensingElement() {
        SPSensingElement selectedSPSensingElement = spSensingElementTableView.getSelectionModel().getSelectedItem();

        if (selectedSPSensingElement != null) {
            boolean okClicked = mainApp.showSPSensingElementEditDialog(selectedSPSensingElement,true);
            if (okClicked) {
                try {
                    SPSensingElementDAOMySQLImpl.getInstance().update(selectedSPSensingElement);
                    showSPSensingElementDetails(selectedSPSensingElement);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No SPSensingElement Selected");
            alert.setContentText("Please select a SPSensingElement in the table.");

            alert.showAndWait();
        }
    }


}
