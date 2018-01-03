package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPFamily;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SPFamilySearchDialogController {



    @FXML
    private TextField idSPFamilyField;
    @FXML
    private CheckBox idSPFamilyCheck;
    @FXML
    private TextField nameField;
    @FXML
    private CheckBox nameCheck;
    @FXML
    private TextField idField;
    @FXML
    private CheckBox idCheck;
    @FXML
    private TextField hwVersionField;
    @FXML
    private CheckBox hwVersionCheck;
    @FXML
    private TextField sysclockField;
    @FXML
    private CheckBox sysclockCheck;
    @FXML
    private TextField oscrtimField;
    @FXML
    private CheckBox oscrtimCheck;

    private Stage dialogStage;
    private SPFamily Family;
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

    public void setSPFamily(SPFamily Family) {
        this.Family = Family;

        idSPFamilyField.setText(String.valueOf(Family.getidSPFamily()));
        nameField.setText(Family.getName());
        idField.setText(Family.getId());
        hwVersionField.setText(Family.getHwVersion());
        sysclockField.setText(Family.getSysclock());
        oscrtimField.setText(Family.getOsctrim());


    }

    public void disableTextboxIdSpFamily(){
        if (idSPFamilyCheck.isSelected())
            idSPFamilyField.setDisable(false);
        else
            idSPFamilyField.setDisable(true);

    }

    public void disableTextboxName(){
        if (nameCheck.isSelected())
            nameField.setDisable(false);
        else
            nameField.setDisable(true);

    }

    public void disableTextboxId(){
        if (idCheck.isSelected())
            idField.setDisable(false);
        else
            idField.setDisable(true);

    }

    public void disableTextboxHwVersion(){
        if (hwVersionCheck.isSelected())
            hwVersionField.setDisable(false);
        else
            hwVersionField.setDisable(true);

    }

    public void disableTextboxSysClock(){
        if (sysclockCheck.isSelected())
            sysclockField.setDisable(false);
        else
            sysclockField.setDisable(true);

    }

    public void disableTextboxOsctrim(){
        if (oscrtimCheck.isSelected())
            oscrtimField.setDisable(false);
        else
            oscrtimField.setDisable(true);

    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            Family.setIdSPFamily(idSPFamilyField.getText());
            Family.setName(nameField.getText());
            Family.setId(idField.getText());
            Family.setHwVersion(hwVersionField.getText());
            Family.setSysclock(sysclockField.getText());
            Family.setOsctrim(oscrtimField.getText());

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

        if (Integer.parseInt(idSPFamilyField.getText())<-2E31 || Integer.parseInt(idSPFamilyField.getText())>(2E31-1))
            errorMessage += "No valid Id Sp Sensing Element!\n";





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
