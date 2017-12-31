package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ItemEvent;


/**
 * Dialog to search details of a spSensingElement.
 *
 * @author Gruppo #7
 */
public class SPSensingElementSearchDialogController {

    @FXML
    private TextField idSPSensingElementField;
    @FXML
    private ComboBox rSenseField;
    @FXML
    private ComboBox inGainField;
    @FXML
    private ComboBox outGainField;
    @FXML
    private ComboBox contactsField;
    @FXML
    private TextField frequencyField;
    @FXML
    private ComboBox harmonicField;
    @FXML
    private TextField DCBiasField;
    @FXML
    private ComboBox modeVIField;
    @FXML
    private ComboBox measureTypeField;
    @FXML
    private TextField filterField;
    @FXML
    private ComboBox phaseShiftModeField;
    @FXML
    private TextField phaseShiftField;
    @FXML
    private ComboBox IQField;
    @FXML
    private TextField conversionRateField;
    @FXML
    private ComboBox inPortADCField;
    @FXML
    private ComboBox nDataField;
    @FXML
    private ComboBox measureUnitField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField rangeMinField;
    @FXML
    private TextField rangeMaxField;
    @FXML
    private TextField defaultAlarmThresholdField;
    @FXML
    private ComboBox multiplierField;
    @FXML
    private ComboBox measureTechniqueField;
    @FXML
    private CheckBox idSPSensingElementCheck;
    @FXML
    public CheckBox rSenseCheck;
    @FXML
    private CheckBox inGainCheck;
    @FXML
    private CheckBox outGainCheck;
    @FXML
    private CheckBox contactsCheck;
    @FXML
    private CheckBox frequencyCheck;
    @FXML
    private CheckBox harmonicCheck;
    @FXML
    private CheckBox DCBiasCheck;
    @FXML
    private CheckBox modeVICheck;
    @FXML
    private CheckBox measureTypeCheck;
    @FXML
    private CheckBox filterCheck;
    @FXML
    private CheckBox phaseShiftModeCheck;
    @FXML
    private CheckBox phaseShiftCheck;
    @FXML
    private CheckBox IQCheck;
    @FXML
    private CheckBox conversionRateCheck;
    @FXML
    private CheckBox inPortADCCheck;
    @FXML
    private CheckBox nDataCheck;
    @FXML
    private CheckBox measureUnitCheck;
    @FXML
    private CheckBox nameCheck;
    @FXML
    private CheckBox rangeMinCheck;
    @FXML
    private CheckBox rangeMaxCheck;
    @FXML
    private CheckBox defaultAlarmThresholdCheck;
    @FXML
    private CheckBox multiplierCheck;
    @FXML
    private CheckBox measureTechniqueCheck;


    private Stage dialogStage;
    private SPSensingElement SensingElement;
    private boolean okClicked = false;
    private boolean verifyLen = true;


    @FXML
    private void initialize(){
        rSenseField.getItems().addAll("50", "500","5000","50000");
        inGainField.getItems().addAll("1","12","20","40");
        outGainField.getItems().addAll("1","2","3","4","5","6","7");
        contactsField.getItems().addAll("TWO","FOUR");
        harmonicField.getItems().addAll("FIRST_HARMONIC","SECOND_HARMONIC","THIRD_HARMONIC");
        modeVIField.getItems().addAll("VOUT_IIN","VIN_IIN","VOUT_VIN","VOUT_VOUT");
        measureTypeField.getItems().addAll("IN-PHASE","QUADRATURE","MODULE","PHASE","RESISTANCE","CAPACITANCE","INDUCTANCE");
        phaseShiftModeField.getItems().addAll("QUADRANTS","COARSE","FINE");
        IQField.getItems().addAll("IN_PHASE","QUADRATURE");
        inPortADCField.getItems().addAll("IA","VA");
        nDataField.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16");
        multiplierField.getItems().addAll("-21","-18","-15","-14","-13","-12","-11","-10","-9","-8","-7","-6","-5","-4","-3","-2","-1","0","3","6","7","8","9","10","11","12","13","14","15","16","17","18","21");
        measureUnitField.getItems().addAll("O","F","H","C","%","V","A","L","t");
        measureTechniqueField.getItems().addAll("DIRECT","EIS","POT","ENERGY_SPECTROSCOPY","ULTRASOUND");
        idSPSensingElementCheck.setSelected(false);
        rSenseCheck.setSelected(false);
        inGainCheck.setSelected(false);
        outGainCheck.setSelected(false);
        contactsCheck.setSelected(false);
        frequencyCheck.setSelected(false);
        harmonicCheck.setSelected(false);
        DCBiasCheck.setSelected(false);
        modeVICheck.setSelected(false);
        measureTypeCheck.setSelected(false);
        filterCheck.setSelected(false);
        phaseShiftModeCheck.setSelected(false);
        phaseShiftCheck.setSelected(false);
        IQCheck.setSelected(false);

    }



    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;

        // Set the dialog icon.

    }

    public void setSPSensingElement(SPSensingElement SensingElement) {
        this.SensingElement = SensingElement;

        idSPSensingElementField.setText(SensingElement.getIdSPSensingElement());
        rSenseField.setValue(SensingElement.getrSense());
        inGainField.setValue(SensingElement.getInGain());
        outGainField.setValue(SensingElement.getOutGain());
        contactsField.setValue(SensingElement.getContacts());
        frequencyField.setText(SensingElement.getFrequency().toString());
        harmonicField.setValue(SensingElement.getHarmonic());
        DCBiasField.setText(SensingElement.getDCBias().toString());
        modeVIField.setValue(SensingElement.getModeVI());
        measureTypeField.setValue(SensingElement.getMeasureType());
        measureTechniqueField.setValue(SensingElement.getMeasureTechnique());
        filterField.setText(SensingElement.getFilter().toString());
        phaseShiftModeField.setValue(SensingElement.getPhaseShiftMode());
        phaseShiftField.setText(SensingElement.getPhaseShift().toString());
        IQField.setValue(SensingElement.getIQ());
        conversionRateField.setText(SensingElement.getConversionRate().toString());
        inPortADCField.setValue(SensingElement.getInPortADC());
        nDataField.setValue(SensingElement.getnData());
        measureUnitField.setValue(SensingElement.getMeasureUnit());
        nameField.setText(SensingElement.getName());
        rangeMinField.setText(SensingElement.getRangeMin().toString());
        rangeMaxField.setText(SensingElement.getRangeMax().toString());
        defaultAlarmThresholdField.setText(SensingElement.getDefaultAlarmThreshold().toString());
        multiplierField.setValue(SensingElement.getMultiplier());

        if(SensingElement.getIdSPSensingElement()!=null){
            disableParameter();
        }
    }

    public void disableParameter(){
        if(measureTechniqueField.getValue().toString()=="DIRECT"){
            rSenseField.setDisable(true);
            inGainField.setDisable(true);
            outGainField.setDisable(true);
            contactsField.setDisable(true);
            frequencyField.setDisable(true);
            harmonicField.setDisable(true);
            DCBiasField.setDisable(true);
            modeVIField.setDisable(true);
            measureTypeField.setDisable(true);
            phaseShiftModeField.setDisable(true);
            phaseShiftField.setDisable(true);
            IQField.setDisable(true);


        }
        else{
            rSenseField.setDisable(false);
            inGainField.setDisable(false);
            outGainField.setDisable(false);
            contactsField.setDisable(false);
            frequencyField.setDisable(false);
            harmonicField.setDisable(false);
            DCBiasField.setDisable(false);
            modeVIField.setDisable(false);
            measureTypeField.setDisable(false);
            phaseShiftModeField.setDisable(false);
            phaseShiftField.setDisable(false);
            IQField.setDisable(false);

        }
    }


    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            SensingElement.setIdSPSensingElement(idSPSensingElementField.getText());
            SensingElement.setrSense(Integer.parseInt(rSenseField.getValue().toString()));
            SensingElement.setInGain(Integer.parseInt(inGainField.getValue().toString()));
            SensingElement.setOutGain(Integer.parseInt(outGainField.getValue().toString()));
            SensingElement.setContacts(contactsField.getValue().toString());
            SensingElement.setFrequency(Double.valueOf(frequencyField.getText()));
            SensingElement.setHarmonic(harmonicField.getValue().toString());
            SensingElement.setDCBias(Integer.valueOf(DCBiasField.getText()));
            SensingElement.setModeVI(modeVIField.getValue().toString());
            SensingElement.setMeasureType(measureTypeField.getValue().toString());
            SensingElement.setMeasureTechnique(measureTechniqueField.getValue().toString());
            SensingElement.setFilter(Integer.valueOf(filterField.getText()));
            SensingElement.setPhaseShiftMode(phaseShiftModeField.getValue().toString());
            SensingElement.setPhaseShift(Integer.parseInt(phaseShiftField.getText().toString()));
            SensingElement.setIQ(IQField.getValue().toString());
            SensingElement.setConversionRate(Integer.parseInt(conversionRateField.getText().toString()));
            SensingElement.setInPortADC(inPortADCField.getValue().toString());
            SensingElement.setnData(Integer.parseInt(nDataField.getValue().toString()));
            SensingElement.setMeasureUnit(measureUnitField.getValue().toString());
            SensingElement.setName(nameField.getText());
            SensingElement.setRangeMin(Double.valueOf(rangeMinField.getText()));
            SensingElement.setRangeMax(Double.valueOf(rangeMaxField.getText()));
            SensingElement.setDefaultAlarmThreshold(Double.valueOf(defaultAlarmThresholdField.getText()));
            SensingElement.setMultiplier(Integer.parseInt(multiplierField.getValue().toString()));

            okClicked = true;
            dialogStage.close();
        }
    }



    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid(boolean verifyLen) {
        String errorMessage = "";

        if(Double.parseDouble(frequencyField.getText()) < 0 || (verifyLen && Double.parseDouble(frequencyField.getText()) > 5000000)) {
            errorMessage += "No valid frequence!\n";
        }

        if(Integer.parseInt(DCBiasField.getText()) < -2048 || (verifyLen && Integer.parseInt(DCBiasField.getText()) > 2048)) {
            errorMessage += "No valid DCBias!\n";
        }

        if(Integer.parseInt(filterField.getText()) < 1 || (verifyLen && Integer.parseInt(filterField.getText()) > 256)) {
            errorMessage += "No valid filter!\n";
        }

        if(Double.parseDouble(phaseShiftField.getText()) < 0 || (verifyLen && Double.parseDouble(phaseShiftField.getText()) > 360)) {
            errorMessage += "No valid phaseShift!\n";
        }

        if(Double.parseDouble(conversionRateField.getText()) < 1 || (verifyLen && Double.parseDouble(conversionRateField.getText()) > 100000)) {
            errorMessage += "No valid  conversionRate!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        }else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}