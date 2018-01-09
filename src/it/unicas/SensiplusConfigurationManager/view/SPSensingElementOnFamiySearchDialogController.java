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
    private TextField idSPSensingElementField;
    @FXML
    private TextField idSPFamilyField;
    @FXML
    private TextField idSPPortField;
    @FXML
    private TextField nameField;
    @FXML
    private CheckBox idSPSensingElementCheck;
    @FXML
    private CheckBox idSPFamilyCheck;
    @FXML
    private CheckBox idSPPortCheck;
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

        idSPSensingElementField.setText(SensingelementOnFamily.getSPSensingElement_idSPSensingElement());
        idSPFamilyField.setText(SensingelementOnFamily.getSPFamily_idSPFamily());
        idSPPortField.setText(SensingelementOnFamily.getSPPort_idSPPort());
        nameField.setText(SensingelementOnFamily.getName());
    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            SensingelementOnFamily.setSPSensingElement_idSPSensingElement(idSPSensingElementField.getText());
            SensingelementOnFamily.setSPFamily_idSPFamily(idSPFamilyField.getText());
            SensingelementOnFamily.setSPPort_idSPPort(idSPPortField.getText());
            SensingelementOnFamily.setName(nameField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void disableTextboxidSPSensingElement(){
        if (idSPSensingElementCheck.isSelected())
            idSPSensingElementField.setDisable(false);
        else
            idSPSensingElementField.setDisable(true);

    }

    public void disableTextboxName(){
        if (nameCheck.isSelected())
            nameField.setDisable(false);
        else
            nameField.setDisable(true);

    }

    public void disableTextboxSPidSPFamily(){
        if (idSPFamilyCheck.isSelected())
            idSPFamilyField.setDisable(false);
        else
            idSPFamilyField.setDisable(true);

    }

    public void disableTextboxidSPPort(){
        if (idSPPortCheck.isSelected())
            idSPPortField.setDisable(false);
        else
            idSPPortField.setDisable(true);

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
