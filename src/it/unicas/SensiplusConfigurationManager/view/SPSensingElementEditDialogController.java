package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElement;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;


/**
     * Dialog to edit details of a spSensingElement.
     *
     * @author Gruppo #7
     */
    public class SPSensingElementEditDialogController {

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


        private Stage dialogStage;
        private SPSensingElement SensingElement;
        private boolean okClicked = false;
        private boolean verifyLen = true;


        @FXML
        private void initialize(){
            rSenseField.getItems().addAll("50", "500","5000","50000");
            inGainField.getItems().addAll("1","12","20","40");
            outGainField.getItems().addAll("0","1","2","3","4","5","6","7");
            contactsField.getItems().addAll("TWO","FOUR");
            harmonicField.getItems().addAll("FIRST HARMONIC","SECOND HARMONIC","THIRD HARMONIC");
            modeVIField.getItems().addAll("VOUT IIN","VIN IIN","VOUT VIN","VOUT VOUT");
            measureTypeField.getItems().addAll("IN PHASE","QUADRATURE","MODULE","PHASE","RESISTANCE","CAPACITANCE","INDUCTANCE");
            phaseShiftModeField.getItems().addAll("QUADRANTS","COARSE","FINE");
            IQField.getItems().addAll("IN PHASE","QUADRATURE");
            inPortADCField.getItems().addAll("IA","VA");
            nDataField.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16");
            multiplierField.getItems().addAll("-21","-18","-15","-14","-13","-12","-11","-10","-9","-8","-7","-6","-5","-4","-3","-2","-1","0","3","6","7","8","9","10","11","12","13","14","15","16","17","18","21");
            measureUnitField.getItems().addAll("O","F","H","C","%","V","A","L","t");
            measureTechniqueField.getItems().addAll("DIRECT","EIS","POT","ENERGY SPECTROSCOPY","ULTRASOUND");

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
            frequencyField.setText(SensingElement.getFrequency());
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
            if(measureTechniqueField.getValue().equals("DIRECT")){
                rSenseField.getItems().clear();
                inGainField.getItems().clear();
                outGainField.getItems().clear();
                contactsField.getItems().clear();
                frequencyField.clear();
                harmonicField.getItems().clear();
                DCBiasField.clear();
                modeVIField.getItems().clear();
                measureTypeField.getItems().clear();
                phaseShiftModeField.getItems().clear();
                phaseShiftField.clear();
                IQField.getItems().clear();
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
            if (isInputValid()) {
                SensingElement.setIdSPSensingElement(idSPSensingElementField.getText());
                if(measureTechniqueField.getValue().equals("DIRECT")) {
                    SensingElement.setrSense("");
                    SensingElement.setInGain("");
                    SensingElement.setOutGain("");
                    SensingElement.setContacts("");
                    SensingElement.setFrequency("");
                    SensingElement.setHarmonic("");
                    SensingElement.setDCBias("");
                    SensingElement.setModeVI("");
                    SensingElement.setMeasureType("");
                    SensingElement.setPhaseShift("");
                    SensingElement.setPhaseShiftMode("");
                    SensingElement.setIQ("");
                }
                else{
                SensingElement.setrSense(rSenseField.getValue().toString());
                SensingElement.setInGain(inGainField.getValue().toString());
                SensingElement.setOutGain(outGainField.getValue().toString());
                SensingElement.setContacts(contactsField.getValue().toString());
                SensingElement.setFrequency(frequencyField.getText());
                SensingElement.setHarmonic(harmonicField.getValue().toString());
                SensingElement.setDCBias(DCBiasField.getText());
                SensingElement.setModeVI(modeVIField.getValue().toString());
                SensingElement.setMeasureType(measureTypeField.getValue().toString());
                    SensingElement.setPhaseShiftMode(phaseShiftModeField.getValue().toString());
                    SensingElement.setPhaseShift(phaseShiftField.getText());
                    SensingElement.setIQ(IQField.getValue().toString());}
                SensingElement.setMeasureTechnique(measureTechniqueField.getValue().toString());
                SensingElement.setFilter(filterField.getText());
                SensingElement.setConversionRate(conversionRateField.getText().toString());
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

        if(idSPSensingElementField.getText() == null || idSPSensingElementField.getText().length() == 0){
            errorMessage += "No valid Id Sp Sensing Element!\n";
        }

        if(!measureTechniqueField.getValue().equals("DIRECT"))
            if( intero=isInt(frequencyField.getText())==false ||(Double.parseDouble(frequencyField.getText()) < 0.0 || (Double.parseDouble(frequencyField.getText()) > 5000000.0))) {
            errorMessage += "No valid frequency!\n";
        }

        if(!measureTechniqueField.getValue().equals("DIRECT"))
        if(intero=isInt(DCBiasField.getText())==false || Integer.parseInt(DCBiasField.getText()) < -2048 || (Integer.parseInt(DCBiasField.getText()) > 2048)) {
            errorMessage += "No valid DCBias!\n";
        }

        if(!measureTechniqueField.getValue().equals("DIRECT"))
        if(intero=isInt(filterField.getText())==false || Integer.parseInt(filterField.getText()) < 0 || (Integer.parseInt(filterField.getText()) > 256))  {
            errorMessage += "No valid filter!\n";
        }

        if(!measureTechniqueField.getValue().equals("DIRECT"))
        if(dble=isDouble(phaseShiftField.getText())==false ||Double.parseDouble(phaseShiftField.getText()) < 0.0 || (Double.parseDouble(phaseShiftField.getText()) > 360.0)) {
            errorMessage += "No valid phaseShift!\n";
        }

        if(!measureTechniqueField.getValue().equals("DIRECT"))
        if( dble=isDouble(conversionRateField.getText())==false  || Double.parseDouble(conversionRateField.getText()) < 0.0 || (Double.parseDouble(conversionRateField.getText()) > 100000.0)) {
            errorMessage += "No valid  conversionRate!\n";
        }

        if(nameField.getText() == null || nameField.getText().length() == 0){
            errorMessage += "No valid Name!\n";
        }

        if(!measureTechniqueField.getValue().equals("DIRECT"))
        if(dble=isDouble(rangeMinField.getText())==false){
            errorMessage += "No valid Range Min!\n";
        }

        if(!measureTechniqueField.getValue().equals("DIRECT"))
        if(dble=isDouble(rangeMaxField.getText())==false|| Double.parseDouble(rangeMaxField.getText())<Double.parseDouble(rangeMinField.getText()))
            errorMessage +="No valid range Max!\n";

        if(!measureTechniqueField.getValue().equals("DIRECT"))
       if((dble=isDouble(defaultAlarmThresholdField.getText())==false )
                ) {
            errorMessage += "No valid deafult alarm threshold!\n";
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
    public static boolean isInt(String str) {

        try{
            int iCheck = Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e) { return false; }
     }

     public static boolean isDouble(String str){
         try{
             double iCheck=Double.parseDouble(str);
             return true;
         }
         catch(NumberFormatException e) { return false; }

     }
}
    
