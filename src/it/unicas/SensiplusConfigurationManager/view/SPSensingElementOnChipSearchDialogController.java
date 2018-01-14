package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElementOnChip;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SPSensingElementOnChipSearchDialogController {
    @FXML
    private TextField idChipField;
    @FXML
    private TextField mField;
    @FXML
    private TextField nField;
    @FXML
    private TextField nameSensingElementOnFamilyField;
    @FXML
    private TextField nameCalibrationField;
    @FXML
    private CheckBox idChipCheck;
    @FXML
    private CheckBox mCheck;
    @FXML
    private CheckBox nCheck;
    @FXML
    private CheckBox nameSensingElementOnFamilyCheck;
    @FXML
    private CheckBox nameCalibrationCheck;


    private Stage dialogStage;
    private SPSensingElementOnChip SensingElementOnChip;
    private boolean okClicked = false;
    private boolean verifyLen = true;

    @FXML
    private void initialize(){
    }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;

        // Set the dialog icon.

    }

    public void setSPSensingElementOnChip(SPSensingElementOnChip spSensingElementOnChip) {
        this.SensingElementOnChip = spSensingElementOnChip;

        idChipField.setText(SensingElementOnChip.getSPChip_idSPChip());
        mField.setText(SensingElementOnChip.getM());
        nField.setText(SensingElementOnChip.getN());
        nameSensingElementOnFamilyField.setText(SensingElementOnChip.getSPSensingElementOnFamily_Name());
        nameCalibrationField.setText(SensingElementOnChip.getSPCalibration_Name());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            SensingElementOnChip.setSPChip_idSPChip(idChipField.getText());
            SensingElementOnChip.setM(mField.getText());
            SensingElementOnChip.setN(nField.getText());
            SensingElementOnChip.setSPSensingElementOnFamily_Name(nameSensingElementOnFamilyField.getText());
            SensingElementOnChip.setSPCalibration_Name(nameCalibrationField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void disableTextboxidChip(){
        if (idChipCheck.isSelected())
            idChipField.setDisable(false);
        else
            idChipField.setDisable(true);

    }

    public void disableTextboxM(){
        if (mCheck.isSelected())
            mField.setDisable(false);
        else
            mField.setDisable(true);

    }

    public void disableTextboxN(){
        if (nCheck.isSelected())
            nField.setDisable(false);
        else
            nField.setDisable(true);

    }

    public void disableTextboxNameSensingElementOnFamily(){
        if (nameSensingElementOnFamilyCheck.isSelected())
            nameSensingElementOnFamilyField.setDisable(false);
        else
            nameSensingElementOnFamilyField.setDisable(true);

    }

    public void disableTextboxNameCalibration(){
        if (nameCalibrationCheck.isSelected())
            nameCalibrationField.setDisable(false);
        else
            nameCalibrationField.setDisable(true);

    }

    private boolean isInputValid() {
        String errorMessage = "";




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
