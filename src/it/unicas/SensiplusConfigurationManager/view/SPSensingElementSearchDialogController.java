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

import static it.unicas.SensiplusConfigurationManager.view.SPSensingElementEditDialogController.isDouble;
import static it.unicas.SensiplusConfigurationManager.view.SPSensingElementEditDialogController.isInt;


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
    private void initialize() {
        rSenseField.getItems().addAll("50", "500", "5000", "50000");
        inGainField.getItems().addAll("1", "12", "20", "40");
        outGainField.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
        contactsField.getItems().addAll("TWO", "FOUR");
        harmonicField.getItems().addAll("FIRST_HARMONIC", "SECOND_HARMONIC", "THIRD_HARMONIC");
        modeVIField.getItems().addAll("VOUT_IIN", "VIN_IIN", "VOUT_VIN", "VOUT_VOUT");
        measureTypeField.getItems().addAll("IN-PHASE", "QUADRATURE", "MODULE", "PHASE", "RESISTANCE", "CAPACITANCE", "INDUCTANCE");
        phaseShiftModeField.getItems().addAll("QUADRANTS", "COARSE", "FINE");
        IQField.getItems().addAll("IN_PHASE", "QUADRATURE");
        inPortADCField.getItems().addAll("IA", "VA");
        nDataField.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16");
        multiplierField.getItems().addAll("-21", "-18", "-15", "-14", "-13", "-12", "-11", "-10", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1", "0", "3", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "21");
        measureUnitField.getItems().addAll("O", "F", "H", "C", "%", "V", "A", "L", "t");
        measureTechniqueField.getItems().addAll("DIRECT", "EIS", "POT", "ENERGY_SPECTROSCOPY", "ULTRASOUND");
    }

    public void disableTextboxidSPSenginElement() {
        if (idSPSensingElementCheck.isSelected())
            idSPSensingElementField.setDisable(false);
        else
            idSPSensingElementField.setDisable(true);

    }

    public void disableTextboxrSense() {
        if (rSenseCheck.isSelected())
            rSenseField.setDisable(false);
        else
            rSenseField.setDisable(true);

    }

    public void disableTextboxinGain() {
        if (inGainCheck.isSelected())
            inGainField.setDisable(false);
        else
            inGainField.setDisable(true);

    }

    public void disableTextboxoutGain() {
        if (outGainCheck.isSelected())
            outGainField.setDisable(false);
        else
            outGainField.setDisable(true);
    }

    public void disableTextboxContacts() {
        if (contactsCheck.isSelected())
            contactsField.setDisable(false);
        else
            contactsField.setDisable(true);

    }

    public void disableTextboxfrequency() {
        if (frequencyCheck.isSelected())
            frequencyField.setDisable(false);
        else
            frequencyField.setDisable(true);

    }

    public void disableTextboxHarmonic() {
        if (harmonicCheck.isSelected())
            harmonicField.setDisable(false);
        else
            harmonicField.setDisable(true);

    }

    public void disableTextboxDCBias() {
        if (DCBiasCheck.isSelected())
            DCBiasField.setDisable(false);
        else
            DCBiasField.setDisable(true);

    }

    public void disableTextBoxModeVI() {
        if (modeVICheck.isSelected())
            modeVIField.setDisable(false);
        else
            modeVIField.setDisable(true);
    }

    public void disableTextBoxMeasureTechnique() {
        if (measureTechniqueCheck.isSelected())
            measureTechniqueField.setDisable(false);
        else
            measureTechniqueField.setDisable(true);

    }

    public void disableTextBoxMeasureType() {
        if (measureTypeCheck.isSelected())
            measureTypeField.setDisable(false);
        else
            measureTypeField.setDisable(true);

    }

    public void disableTextboxfilter() {
        if (filterCheck.isSelected()) {
            filterField.setDisable(false);

        } else
            filterField.setDisable(true);

    }

    public void disableTextboxPhaseShiftMode() {
        if (phaseShiftModeCheck.isSelected())
            phaseShiftModeField.setDisable(false);
        else
            phaseShiftModeField.setDisable(true);

    }

    public void disableTextboxPhaseShift() {
        if (phaseShiftCheck.isSelected())
            phaseShiftField.setDisable(false);
        else
            phaseShiftField.setDisable(true);

    }

    public void disableTextboxIQ() {
        if (IQCheck.isSelected())
            IQField.setDisable(false);
        else
            IQField.setDisable(true);

    }

    public void disableTextboxConversionRate() {
        if (conversionRateCheck.isSelected())
            conversionRateField.setDisable(false);
        else
            conversionRateField.setDisable(true);

    }

    public void disableTextboxinPortADC() {
        if (inPortADCCheck.isSelected())
            inPortADCField.setDisable(false);
        else
            inPortADCField.setDisable(true);

    }

    public void disableTextboxnData() {
        if (nDataCheck.isSelected())
            nDataField.setDisable(false);
        else
            nDataField.setDisable(true);

    }

    public void disableTextboxName() {
        if (nameCheck.isSelected())
            nameField.setDisable(false);
        else
            nameField.setDisable(true);

    }

    public void disableTextboxRangeMin() {
        if (rangeMinCheck.isSelected())
            rangeMinField.setDisable(false);
        else
            rangeMinField.setDisable(true);

    }

    public void disableTextboxRangeMax() {
        if (rangeMaxCheck.isSelected())
            rangeMaxField.setDisable(false);
        else
            rangeMaxField.setDisable(true);

    }

    public void disableTextboxDefaultAlarmThreshold() {
        if (defaultAlarmThresholdCheck.isSelected())
            defaultAlarmThresholdField.setDisable(false);
        else
            defaultAlarmThresholdField.setDisable(true);

    }

    public void disableTextboxMultiplier() {
        if (multiplierCheck.isSelected())
            multiplierField.setDisable(false);
        else
            multiplierField.setDisable(true);

    }

    public void disableTextboxMeasureUnit() {
        if (measureUnitCheck.isSelected())
            measureUnitField.setDisable(false);
        else
            measureUnitField.setDisable(true);

    }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;


    }

    public void setSPSensingElement(SPSensingElement SensingElement) {
        this.SensingElement = SensingElement;

        idSPSensingElementField.setText(SensingElement.getIdSPSensingElement());
        rSenseField.setValue(SensingElement.getrSense());
        inGainField.setValue(SensingElement.getInGain());
        outGainField.setValue(SensingElement.getOutGain());
        contactsField.setValue(SensingElement.getContacts());
        frequencyField.setText(SensingElement.getFrequency());
        harmonicField.setValue(SensingElement.getHarmonic());
        DCBiasField.setText(SensingElement.getDCBias());
        modeVIField.setValue(SensingElement.getModeVI());
        measureTypeField.setValue(SensingElement.getMeasureType());
        measureTechniqueField.setValue(SensingElement.getMeasureTechnique());
        filterField.setText(SensingElement.getFilter());
        phaseShiftModeField.setValue(SensingElement.getPhaseShiftMode());
        phaseShiftField.setText(SensingElement.getPhaseShift());
        IQField.setValue(SensingElement.getIQ());
        conversionRateField.setText(SensingElement.getConversionRate());
        inPortADCField.setValue(SensingElement.getInPortADC());
        nDataField.setValue(SensingElement.getnData());
        measureUnitField.setValue(SensingElement.getMeasureUnit());
        nameField.setText(SensingElement.getName());
        rangeMinField.setText(SensingElement.getRangeMin());
        rangeMaxField.setText(SensingElement.getRangeMax());
        defaultAlarmThresholdField.setText(SensingElement.getDefaultAlarmThreshold());
        multiplierField.setValue(SensingElement.getMultiplier());

        if (SensingElement.getIdSPSensingElement() != null) {
            disableParameter();
        }
    }

    public void disableParameter() {

    }


    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            SensingElement.setIdSPSensingElement(idSPSensingElementField.getText());
            SensingElement.setrSense(rSenseField.getValue().toString());
            SensingElement.setInGain(inGainField.getValue().toString());
            SensingElement.setOutGain(outGainField.getValue().toString());
            SensingElement.setContacts(contactsField.getValue().toString());
            SensingElement.setFrequency(frequencyField.getText());
            SensingElement.setHarmonic(harmonicField.getValue().toString());
            SensingElement.setDCBias(DCBiasField.getText());
            SensingElement.setModeVI(modeVIField.getValue().toString());
            SensingElement.setMeasureType(measureTypeField.getValue().toString());
            SensingElement.setMeasureTechnique(measureTechniqueField.getValue().toString());
            SensingElement.setFilter(filterField.getText());
            SensingElement.setPhaseShiftMode(phaseShiftModeField.getValue().toString());
            SensingElement.setPhaseShift(phaseShiftField.getText());
            SensingElement.setIQ(IQField.getValue().toString());
            SensingElement.setConversionRate(conversionRateField.getText());
            SensingElement.setInPortADC(inPortADCField.getValue().toString());
            SensingElement.setnData(nDataField.getValue().toString());
            SensingElement.setMeasureUnit(measureUnitField.getValue().toString());
            SensingElement.setName(nameField.getText());
            SensingElement.setRangeMin(rangeMinField.getText());
            SensingElement.setRangeMax(rangeMaxField.getText());
            SensingElement.setDefaultAlarmThreshold(defaultAlarmThresholdField.getText());
            SensingElement.setMultiplier(multiplierField.getValue().toString());

            okClicked = true;
            dialogStage.close();
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";
        boolean intero;
        boolean dble;

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