package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPFamily_has_SPMeasureType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SPFamily_has_SPMeasureTypeSearchDialogController {




    @FXML
    private TextField idSPFamilyField;
    @FXML
    private TextField idSPMeasureTypeField;
    @FXML
    private TextField Name_FamilyField;
    @FXML
    private TextField Name_TypeField;
    @FXML
    private CheckBox idSPFamilyCheck;
    @FXML
    private CheckBox idSPMeasureTypeCheck;
    @FXML
    private CheckBox Name_FamilyCheck;
    @FXML
    private CheckBox Name_TypeCheck;


    private Stage dialogStage;
    private SPFamily_has_SPMeasureType Family_has_SPMeasureType;
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

    public void setSPFamily_has_SPMeasureType(SPFamily_has_SPMeasureType spFamily_has_SPMeasureType) {
        this.Family_has_SPMeasureType = spFamily_has_SPMeasureType;

        idSPFamilyField.setText(Family_has_SPMeasureType.getSPFamily_idSPFamily());
        idSPMeasureTypeField.setText(Family_has_SPMeasureType.getName_Family());
        Name_FamilyField.setText(Family_has_SPMeasureType.getSPMeasureType_idSPMeasureType());
        Name_TypeField.setText(Family_has_SPMeasureType.getName_Measure_Type());
    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            Family_has_SPMeasureType.setSPFamily_idSPFamily(idSPFamilyField.getText());
            Family_has_SPMeasureType.setName_Family(Name_FamilyField.getText());
            Family_has_SPMeasureType.setSPMeasureType_idSPMeasureType(idSPMeasureTypeField.getText());
            Family_has_SPMeasureType.setName_Measure_Type(Name_TypeField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void disableTextboxidSPFamily(){
        if (idSPFamilyCheck.isSelected())
            idSPFamilyField.setDisable(false);
        else
            idSPFamilyField.setDisable(true);

    }

    public void disableTextboxName_Family(){
        if (Name_FamilyCheck.isSelected())
            Name_FamilyField.setDisable(false);
        else
            Name_FamilyField.setDisable(true);

    }

    public void disableTextboxidSPMeasureType(){
        if (idSPMeasureTypeCheck.isSelected())
            idSPMeasureTypeField.setDisable(false);
        else
            idSPMeasureTypeField.setDisable(true);

    }

    public void disableTextboxName_Type(){
        if (Name_TypeCheck.isSelected())
            Name_TypeField.setDisable(false);
        else
            Name_TypeField.setDisable(true);

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
