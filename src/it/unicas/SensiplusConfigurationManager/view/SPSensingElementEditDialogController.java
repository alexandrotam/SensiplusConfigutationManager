package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


    /**
     * Dialog to edit details of a spSensingElement.
     *
     * @author Gruppo #7
     */
    public class SPSensingElementEditDialogController {

        @FXML
        private TextField idSPSensingElementField;
        @FXML
        private TextField rSenseField;
        @FXML
        private TextField inGainField;
        @FXML
        private TextField outGainField;
        @FXML
        private TextField contactsField;
        @FXML
        private TextField frequencyField;
        @FXML
        private TextField harmonicField;
        @FXML
        private TextField DCBiasField;
        @FXML
        private TextField modeVIField;
        @FXML
        private TextField measureTechniqueField;
        @FXML
        private TextField measureTypeField;
        @FXML
        private TextField filterField;
        @FXML
        private TextField phaseShiftModeField;
        @FXML
        private TextField phaseShiftField;
        @FXML
        private TextField IQField;
        @FXML
        private TextField conversionRateField;
        @FXML
        private TextField inPortADCField;
        @FXML
        private TextField nDataField;
        @FXML
        private TextField nameField;
        @FXML
        private TextField rangeMinField;
        @FXML
        private TextField rangeMaxField;
        @FXML
        private TextField defaultAlarmThresholdField;
        @FXML
        private TextField multiplierField;
        @FXML
        private TextField measureUnitField;


        private Stage dialogStage;
        private SPSensingElement spSensingElement;
        private boolean okClicked = false;
        private boolean verifyLen = true;

        /**
         * Initializes the controller class. This method is automatically called
         * after the fxml file has been loaded.
         */
        @FXML
        private void initialize() {
        }

        /**
         * Sets the stage of this dialog.
         *
         * @param dialogStage
         */
        public void setDialogStage(Stage dialogStage, boolean verifyLen) {
            this.dialogStage = dialogStage;
            this.verifyLen = verifyLen;

        }

        /**
         * Sets the spSensingElement to be edited in the dialog.
         *
         * @param spSensingElement
         */
        public void setSpSensingElement(SPSensingElement spSensingElement) {
            this.spSensingElement = spSensingElement;

            idSPSensingElementField.setText(spSensingElement.getIdSPSensingElement());
            rSenseField.setText(String.valueOf(spSensingElement.getrSense()));
            inGainField.setText(String.valueOf(spSensingElement.getInGain()));
            outGainField.setText(String.valueOf(spSensingElement.getOutGain()));
            contactsField.setText(spSensingElement.getContacts());
            frequencyField.setText(String.valueOf(spSensingElement.getFrequency()));
            harmonicField.setText(spSensingElement.getHarmonic());
            DCBiasField.setText(String.valueOf(spSensingElement.getDCBias()));
            modeVIField.setText(spSensingElement.getModeVI());
            measureTechniqueField.setText(spSensingElement.getMeasureTechnique());
            measureTypeField.setText(spSensingElement.getMeasureType());
            filterField.setText(String.valueOf(spSensingElement.getFilter()));
            phaseShiftModeField.setText(spSensingElement.getPhaseShiftMode());
            phaseShiftField.setText(String.valueOf(spSensingElement.getPhaseShift()));
            IQField.setText(spSensingElement.getIQ());
            conversionRateField.setText(String.valueOf(spSensingElement.getConversionRate()));
            inPortADCField.setText(spSensingElement.getInPortADC());
            nDataField.setText(String.valueOf(spSensingElement.getnData()));
            nameField.setText(spSensingElement.getName());
            rangeMinField.setText(String.valueOf(spSensingElement.getRangeMin()));
            rangeMaxField.setText(String.valueOf(spSensingElement.getRangeMax()));
            defaultAlarmThresholdField.setText(String.valueOf(spSensingElement.getDefaultAlarmThreshold()));
            multiplierField.setText(String.valueOf(spSensingElement.getMultiplier()));
            measureUnitField.setText(spSensingElement.getMeasureUnit());
        }

        /**
         * Returns true if the user clicked OK, false otherwise.
         *
         * @return
         */
        public boolean isOkClicked() {
            return okClicked;
        }

        /**
         * Called when the user clicks ok.
         */
        @FXML
        private void handleOk() {
            if (isInputValid(verifyLen)) {
                spSensingElement.setIdSPSensingElement(idSPSensingElementField.getText());
                spSensingElement.setrSense(Integer.parseInt(rSenseField.getText()));
                spSensingElement.setInGain(Integer.parseInt(inGainField.getText()));
                spSensingElement.setOutGain(Integer.parseInt(outGainField.getText()));
                spSensingElement.setContacts(contactsField.getText());
                spSensingElement.setFrequency(Double.parseDouble(frequencyField.getText()));
                spSensingElement.setHarmonic(harmonicField.getText());
                spSensingElement.setDCBias(Integer.parseInt(DCBiasField.getText()));
                spSensingElement.setModeVI(modeVIField.getText());
                spSensingElement.setMeasureTechnique(measureTechniqueField.getText());
                spSensingElement.setMeasureType(measureTypeField.getText());
                spSensingElement.setFilter(Integer.parseInt(filterField.getText()));
                spSensingElement.setPhaseShiftMode(phaseShiftModeField.getText());
                spSensingElement.setPhaseShift(Integer.parseInt(phaseShiftField.getText()));
                spSensingElement.setIQ(IQField.getText());
                spSensingElement.setConversionRate(Integer.parseInt(conversionRateField.getText()));
                spSensingElement.setInPortADC(inPortADCField.getText());
                spSensingElement.setnData(Integer.parseInt(nDataField.getText()));
                spSensingElement.setName(nameField.getText());
                spSensingElement.setRangeMin(Double.parseDouble(rangeMinField.getText()));
                spSensingElement.setRangeMax(Double.parseDouble(rangeMaxField.getText()));
                spSensingElement.setDefaultAlarmThreshold(Double.parseDouble(defaultAlarmThresholdField.getText()));
                spSensingElement.setMultiplier(Integer.parseInt(multiplierField.getText()));
                spSensingElement.setMeasureUnit(measureUnitField.getText());

                okClicked = true;
                dialogStage.close();
            }
        }

        /**
         * Called when the user clicks cancel.
         */
        @FXML
        private void handleCancel() {
            dialogStage.close();
        }

        /**
         * Validates the user input in the text fields.
         *
         * @return true if the input is valid
         */
        private boolean isInputValid(boolean verifyLen) {
            String errorMessage = "";

            if (idSPSensingElementField.getText() == null || (verifyLen && idSPSensingElementField.getText().length() == 0)) {
                errorMessage += "No valid id!\n";
            }

            if (rSenseField.getText() == null && verifyLen) {
                errorMessage += "No valid rSense!\n";
            }

            if (rSenseField.getText() != null && !rSenseField.getText().matches("50|500|5000|50000")){
                    errorMessage+= "No valid rSense!\n";
            }

            if (inGainField.getText() == null && verifyLen) {
                errorMessage += "No valid In Gain!\n";
            }

            if (inGainField.getText() != null && !inGainField.getText().matches("1|12|20|40")){
                errorMessage+= "No valid In Gain!\n";
            }

            if (outGainField.getText() == null && verifyLen) {
                errorMessage += "No valid Out Gain!\n";
            }

            if (outGainField.getText() != null && !outGainField.getText().matches("0||1||2||3||4||5||6||7")){
                errorMessage+= "No valid Out Gain!\n";
            }
            if (contactsField.getText() != null && !contactsField.getText().matches("(?i)TWO||(?i)FOUR")){

            }

            if (contactsField.getText() == null && verifyLen) {
                errorMessage += "No valid Contacts!\n";
            }

            if (outGainField.getText() != null && !outGainField.getText().matches("(?i)TWO||(?i)FOUR")){
                errorMessage+= "No valid Contacts!\n";
            }

            if (frequencyField.getText() == null && verifyLen) {
                errorMessage += "No valid Frequency!\n";
            }

            if (frequencyField.getText() != null &&
                    (Double.parseDouble(frequencyField.getText())<0 || Double.parseDouble(frequencyField.getText())>5000000)){
                errorMessage+= "No valid Frequency!\n";
            }

            if (harmonicField.getText() == null && verifyLen) {
                errorMessage += "No valid Harmonic!\n";
            }

            if (harmonicField.getText() != null &&
                    !harmonicField.getText().matches("(?i)FIRST HARMONIC||(?i)SECOND HARMONIC||(?i)THIRD HARMONIC")){
                errorMessage+= "No valid Harmonic!\n";
            }

            if (DCBiasField.getText() == null && verifyLen) {
                errorMessage += "No valid DC Bias!\n";
            }

            if (DCBiasField.getText() != null &&
                    (Double.parseDouble(DCBiasField.getText())<(-2048) || Double.parseDouble(DCBiasField.getText())>2048)){
                errorMessage+= "No valid DC Bias!\n";
            }

            if (modeVIField.getText() == null && verifyLen) {
                errorMessage += "No valid Mode VI!\n";
            }

            if (modeVIField.getText() != null &&
                    !modeVIField.getText().matches("(?i)VOUT IIN||(?i)VIN IIN||(?i)VOUT VIN||(?i)VOUT VOUT")){
                errorMessage+= "No valid Mode VI!\n";
            }

            if (measureTechniqueField.getText() == null && verifyLen) {
                errorMessage += "No valid Measure Technique!\n";
            }

            if (measureTechniqueField.getText() != null &&
                    !measureTechniqueField.getText().matches("(?i)DIRECT||(?i)EIS||(?i)POT||(?i)ENERGY SPECTROSCOPY||(?i)ULTRASOUND")){
                errorMessage+= "No valid Measure Technique!\n";
            }

            if (measureTypeField.getText() == null && verifyLen) {
                errorMessage += "No valid Measure Type!\n";
            }

            if (measureTypeField.getText() != null &&
                    !measureTypeField.getText().matches("(?i)IN PHASE||(?i)QUADRATURE||(?i)MODULE||(?i)PHASE||" +
                            "(?i)RESISTANCE||(?i)CAPACITANCE||(?i)INDUCTANCE")){
                errorMessage+= "No valid Measure Type!\n";
            }

            if (filterField.getText() == null && verifyLen) {
                errorMessage += "No valid Filter!\n";
            }

            if (filterField.getText() != null &&
                    (Integer.parseInt(filterField.getText())<0 || Integer.parseInt(filterField.getText())>256)){
                errorMessage+= "No valid filter!\n";
            }

            if (phaseShiftModeField.getText() == null && verifyLen) {
                errorMessage += "No valid Phase Shift!\n";
            }

            if (phaseShiftModeField.getText() != null &&
                    !phaseShiftModeField.getText().matches("(?i)QUADRANTS||(?i)COARSE||(?i)FINE")){
                errorMessage+= "No valid Phase Shift!\n";
            }


            if (phaseShiftField.getText() == null && verifyLen) {
                errorMessage += "No valid Phase Shift!\n";
            }

            if (phaseShiftField.getText() != null &&
                    (Integer.parseInt(phaseShiftField.getText())<0 || Integer.parseInt(phaseShiftField.getText())>360)){
                errorMessage+= "No valid Phase Shift!\n";
            }

            if (IQField.getText() == null && verifyLen) {
                errorMessage += "No valid IQ!\n";
            }

            if (IQField.getText() != null &&
                    !phaseShiftField.getText().matches("(?i)IN PHASE||(?i)QUADRATURE")){
                errorMessage+= "No valid IQ!\n";
            }

            if (conversionRateField.getText() == null && verifyLen) {
                errorMessage += "No valid Conversion Rate!\n";
            }

            if (conversionRateField.getText() != null &&
                    (Double.parseDouble(conversionRateField.getText())<1 || Double.parseDouble(conversionRateField.getText())>100000)){
                errorMessage+= "No valid Conversion Rate!\n";
            }

            if (inPortADCField.getText() == null && verifyLen) {
                errorMessage += "No valid In Port ADC!\n";
            }

            if (inPortADCField.getText() != null &&
                    !inPortADCField.getText().matches("(?i)IA||(?i)VA")){
                errorMessage+= "No valid In Port Rate!\n";
            }

            if (nDataField.getText() == null && verifyLen) {
                errorMessage += "No valid nData!\n";
            }

            if (nDataField.getText() != null &&
                    (Integer.parseInt(nDataField.getText())<1 || Integer.parseInt(nDataField.getText())>16)){
                errorMessage+= "No valid nData!\n";
            }

            if (rangeMinField.getText() == null && verifyLen) {
                errorMessage += "No valid Range Min!\n";
            }

            if (rangeMinField.getText() != null &&
                    (Double.parseDouble(rangeMinField.getText())<(-10E-21) || Double.parseDouble(rangeMinField.getText())>(10E21))){
                errorMessage+= "No valid Range Min!\n";
            }

            if (rangeMaxField.getText() == null && verifyLen) {
                errorMessage += "No valid Range Max!\n";
            }

            if (rangeMaxField.getText() != null &&
                    (Double.parseDouble(rangeMaxField.getText())<(-10E-21) || Double.parseDouble(rangeMaxField.getText())>(10E21))){
                errorMessage+= "No valid Range Max!\n";
            }

            if (defaultAlarmThresholdField.getText() == null && verifyLen) {
                errorMessage += "No valid Default Alarm Threshold!\n";
            }

            if (defaultAlarmThresholdField.getText() != null &&
                    (Double.parseDouble(defaultAlarmThresholdField.getText())<(-10E-21) || Double.parseDouble(defaultAlarmThresholdField.getText())>(10E21))
                    && (Double.parseDouble(defaultAlarmThresholdField.getText())<Double.parseDouble(rangeMinField.getText())
                    || Double.parseDouble(defaultAlarmThresholdField.getText())>Double.parseDouble(rangeMaxField.getText()))){
                errorMessage+= "No valid Default Alarm Threshold!\n";
            }

            if (multiplierField.getText() == null && verifyLen) {
                errorMessage += "No valid Multiplier!\n";
            }

            if (multiplierField.getText() != null &&
                    (Integer.parseInt(multiplierField.getText())<(-21) || Integer.parseInt(multiplierField.getText())>21)){
                errorMessage+= "No valid Multiplier!\n";
            }

            if (measureUnitField.getText() == null && verifyLen) {
                errorMessage += "No valid Measure Unit!\n";
            }

            if (measureUnitField.getText() != null &&
                    !measureUnitField.getText().matches("(?i)O||(?i)F||(?i)H||(?i)C||%||(?i)V||(?i)A||(?i)L||(?i)T")){
                errorMessage+= "No valid Measure Unit!\n";
            }

            if (errorMessage.length() == 0) {
                return true;
            } else {
                // Show the error message.
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

