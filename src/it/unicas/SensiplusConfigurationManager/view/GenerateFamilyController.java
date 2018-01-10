package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingelementOnFamily;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.DAOMySQLSettings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GenerateFamilyController {

    @FXML
    private TextField idSPSensingElementField;
    @FXML
    private TextField idSPFamilyField;
    @FXML
    private TextField idSPPortField;
    @FXML
    private TextField nameField;



    private Stage dialogStage;
    private SPSensingelementOnFamily SensingElementOnFamily;
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

    public void setSPSensingElementOnFamily(SPSensingelementOnFamily SensingElementOnFamily) {
        this.SensingElementOnFamily = SensingElementOnFamily;
        nameField.setText(SensingElementOnFamily.getName());
        idSPSensingElementField.setText(SensingElementOnFamily.getSPSensingElement_idSPSensingElement());
        idSPFamilyField.setText(SensingElementOnFamily.getSPFamily_idSPFamily());
        idSPPortField.setText(SensingElementOnFamily.getSPPort_idSPPort());


    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            SensingElementOnFamily.setName(nameField.getText());
            SensingElementOnFamily.setSPSensingElement_idSPSensingElement(idSPSensingElementField.getText());
            SensingElementOnFamily.setSPFamily_idSPFamily(idSPFamilyField.getText());
            SensingElementOnFamily.setSPPort_idSPPort(idSPPortField.getText());

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
