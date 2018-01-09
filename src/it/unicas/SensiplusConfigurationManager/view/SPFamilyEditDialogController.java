package it.unicas.SensiplusConfigurationManager.view;

import javafx.scene.control.TextField;
import it.unicas.SensiplusConfigurationManager.model.SPFamily;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.stage.Stage;

import static it.unicas.SensiplusConfigurationManager.view.SPSensingElementEditDialogController.isInt;

public class SPFamilyEditDialogController {


    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField hwVersionField;
    @FXML
    private TextField sysclockField;
    @FXML
    private TextField oscrtimField;


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
        nameField.setText(Family.getName());
        idField.setText(Family.getId());
        hwVersionField.setText(Family.getHwVersion());
        sysclockField.setText(Family.getSysclock());
        oscrtimField.setText(Family.getOsctrim());


    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
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
        boolean intero;


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
