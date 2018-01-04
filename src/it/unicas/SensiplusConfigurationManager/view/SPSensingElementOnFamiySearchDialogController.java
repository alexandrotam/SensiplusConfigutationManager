package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingelementOnFamily;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static it.unicas.SensiplusConfigurationManager.view.SPSensingElementEditDialogController.isInt;

public class SPSensingElementOnFamiySearchDialogController {



    @FXML
    private TextField idSPSensingElementOnFamilyField;
    @FXML
    private TextField SPSensingElement_idSPSensingElementField;
    @FXML
    private TextField SPFamilyTemplate_idSPFamilyTemplateField;
    @FXML
    private TextField nameField;
    @FXML
    private CheckBox idSPSensingElementOnFamilyCheck;
    @FXML
    private CheckBox SPSensingElement_idSPSensingElementCheck;
    @FXML
    private CheckBox SPFamilyTemplate_idSPFamilyTemplateCheck;
    @FXML
    private CheckBox nameCheck;


    private Stage dialogStage;
    private SPSensingelementOnFamily SensingelementOnFamily;
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

    public void setSPSensingelementOnFamily(SPSensingelementOnFamily spSensingelementOnFamily) {
        this.SensingelementOnFamily = spSensingelementOnFamily;

        idSPSensingElementOnFamilyField.setText(SensingelementOnFamily.getidSPSensingElementOnFamily());
        SPSensingElement_idSPSensingElementField.setText(SensingelementOnFamily.getSPSensingElement_idSPSensingElement());
        SPFamilyTemplate_idSPFamilyTemplateField.setText(SensingelementOnFamily.getSPFamilyTemplate_idSPFamilyTemplate());
        nameField.setText(SensingelementOnFamily.getName());
    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            SensingelementOnFamily.setidSPSensingElementOnFamily(idSPSensingElementOnFamilyField.getText());
            SensingelementOnFamily.setSPSensingElement_idSPSensingElement(nameField.getText());
            SensingelementOnFamily.setSPFamilyTemplate_idSPFamilyTemplate(SPFamilyTemplate_idSPFamilyTemplateField.getText());
            SensingelementOnFamily.setName(nameField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void disableTextboxidSPSensingElementOnFamily(){
        if (idSPSensingElementOnFamilyCheck.isSelected())
            idSPSensingElementOnFamilyField.setDisable(false);
        else
            idSPSensingElementOnFamilyField.setDisable(true);

    }

    public void disableTextboxName(){
        if (nameCheck.isSelected())
            nameField.setDisable(false);
        else
            nameField.setDisable(true);

    }

    public void disableTextboxSPSensingElement_idSPSensingElement(){
        if (SPSensingElement_idSPSensingElementCheck.isSelected())
            SPSensingElement_idSPSensingElementField.setDisable(false);
        else
            SPSensingElement_idSPSensingElementField.setDisable(true);

    }

    public void disableTextboxSPFamilyTemplate_idSPFamilyTemplate(){
        if (SPFamilyTemplate_idSPFamilyTemplateCheck.isSelected())
            SPFamilyTemplate_idSPFamilyTemplateField.setDisable(false);
        else
            SPFamilyTemplate_idSPFamilyTemplateField.setDisable(true);

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
